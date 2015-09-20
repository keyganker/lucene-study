/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lucene.analysis.standard;


public class Token
{

    public Token()
    {
    }

    public final String toString()
    {
        return image;
    }

    public static final Token newToken(int ofKind)
    {
        switch(ofKind)
        {
        default:
            return new Token();
        }
    }

    public int kind;
    public int beginLine;
    public int beginColumn;
    public int endLine;
    public int endColumn;
    public String image;
    public Token next;
    public Token specialToken;
}


/*
	DECOMPILATION REPORT

	Decompiled from: F:\jdk\lucene-1_00\lucene.jar
	Total time: 128 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/