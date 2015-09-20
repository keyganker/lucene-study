/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lucene.analysis.standard;

import java.io.IOException;

public interface CharStream
{

    public abstract char readChar()
        throws IOException;

    /**
     * @deprecated Method getColumn is deprecated
     */

    public abstract int getColumn();

    /**
     * @deprecated Method getLine is deprecated
     */

    public abstract int getLine();

    public abstract int getEndColumn();

    public abstract int getEndLine();

    public abstract int getBeginColumn();

    public abstract int getBeginLine();

    public abstract void backup(int i);

    public abstract char BeginToken()
        throws IOException;

    public abstract String GetImage();

    public abstract char[] GetSuffix(int i);

    public abstract void Done();
}


/*
	DECOMPILATION REPORT

	Decompiled from: F:\jdk\lucene-1_00\lucene.jar
	Total time: 92 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/