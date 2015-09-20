# GNU make rules for lucene

# determine whether we're on Win32 or Unix
ifeq ($(findstring CYGWIN,$(shell uname)),CYGWIN)
  OS = win32
else
  OS = unix
endif

# DOS compatibility:
# These should be used in variables that end up in CLASSPATH.
ifeq ($(OS),win32)
  SLASH=\\
  COLON=;
else
  SLASH=/
  COLON=:
endif

# ROOT should be set to the root directory of the Lucene package
# hierarchy.  This is typically ../../.., as most packages are of the
# form com.lucene.<package>.
ROOT = ..$(SLASH)..$(SLASH)..

# directories containing java source code
DIRS = store util document analysis analysis/standard index search queryParser
PACKAGES = $(subst /,.,$(patsubst %,com.lucene.%,$(DIRS)))

ifeq ($(JAVAHOME),)
 ifeq ($(OS),win32)
  JAVAHOME = C:/jdk1.3
 else
  JAVAHOME = /usr/local/java/jdk1.3
 endif
endif

# Location of JavaCC
ifeq ($(JAVACC),)
 ifeq ($(OS),win32)
  JAVACC = C:/javacc2_0/bin/lib/JavaCC.zip
 else
  JAVACC = /usr/local/java/javacc2_0/bin/lib/JavaCC.zip
 endif
endif

JAVADIR = $(subst \,/,$(JAVAHOME))

# The compiler executable.
JAVAC = $(JAVADIR)/bin/javac

# The java executable
JAVA = $(JAVADIR)/bin/java

# The jar executable
JAR = $(JAVADIR)/bin/jar

# Options to pass to Java compiler
# Optimize by default.
# Use JFLAGS=-g to generate debuggable code.
JFLAGS = -O -g

# CLASSPATH
# By default include the Lucene root, and Java's builtin classes
export CLASSPATH=$(ROOT)$(COLON)$(JAVAHOME)$(SLASH)lib$(SLASH)classes.zip

## Rules

# Use JAVAC to compile .java files into .class files
%.class : %.java
	$(JAVAC) $(JFLAGS) $<

# Compile .jj files to .java with JavaCC
%.java : %.jj
	$(JAVA) -classpath '$(CLASSPATH)$(COLON)$(JAVACC)' COM.sun.labs.javacc.Main $<

# Add JavaCC generated files to 'classes' and 'clean' targets.
JJFILES = $(wildcard *.jj)
ifneq ($(JJFILES),)
  CLASSES += $(patsubst %.jj,%.class,  $(JJFILES))
  DIRT += $(patsubst %.jj,%.java, $(JJFILES))
  DIRT += $(patsubst %.jj,%Constants.java, $(JJFILES))
  DIRT += $(patsubst %.jj,%TokenManager.java, $(JJFILES))
  DIRT += Token.java TokenMgrError.java TokenManager.java \
          CharStream.java ASCII_CharStream.java ParseException.java
endif


# Don't delete parser's .java file -- it's needed by javadoc.
.PRECIOUS: $(patsubst %.jj,%.java, $(JJFILES))


# Assume all .java files should have a .class file.
CLASSES += $(patsubst %.java,%.class,$(wildcard *.java))

# default rule
classes : $(CLASSES)

jar:	all_classes
	(cd $(ROOT); $(JAR) cvmf com/lucene/manifest lucene.jar \
	 `ls com/lucene/*/*.class` `ls com/lucene/*/*/*.class`)

JAVALINK = http://java.sun.com/products/jdk/1.2/docs/api/
doc:	all_classes
	if [ -d $(ROOT)/doc/api ]; then rm -rf $(ROOT)/doc/api ;fi
	mkdir $(ROOT)/doc/api
	${JAVADIR}/bin/javadoc -classpath '$(CLASSPATH)' -author -version \
	 -d $(ROOT)/doc/api -link $(JAVALINK) $(PACKAGES)

demo: all_classes
	$(MAKE) -C $(ROOT)/demo/HTMLParser -w
	$(MAKE) -C $(ROOT)/demo -w CLASSPATH=..

release: jar demo doc
	(cd $(ROOT); \
	 tar cvf lucene.tar lucene.jar doc/*.html doc/api \
	   demo/*.java demo/*.class demo/*.html demo/*.jhtml \
	   demo/HTMLParser/*.class demo/HTMLParser/*.jj \
	   demo/HTMLParser/*.java )

# make all the Lucene classes 
all_classes :
	(cd $(ROOT)/com/lucene; \
	 for d in $(DIRS); \
	 do $(MAKE) -C $$d -w; done)


# Removes all generated files from the connected src directory.
clean:
	rm -f *.class $(DIRT)

# Removes all generated files from src directories.
src_clean:
	(cd $(ROOT)/com/lucene; \
	 for d in $(DIRS); \
	 do $(MAKE) -C $$d -w clean; done)

# Removes all generated files.
real_clean: src_clean
	(cd $(ROOT); \
	 $(MAKE) -C demo/HTMLParser -w clean; \
	 $(MAKE) -C demo -w clean; \
	 rm -rf lucene.jar lucene.tar doc/api)
