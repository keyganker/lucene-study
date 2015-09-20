/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lucene.queryParser;


public class Token
{

    public Token()
    {
    }

    public static final Token newToken(int ofKind)
    {
        switch(ofKind)
        {
        default:
            return new Token();
        }
    }

    public final String toString()
    {
        return image;
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

	Decompiled from: F:\jdk\workspace\lucene_0.1\lucene.jar
	Total time: 55 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/