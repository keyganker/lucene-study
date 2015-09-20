/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lucene.queryParser;


public interface QueryParserConstants
{

    public static final int EOF = 0;
    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int AND = 3;
    public static final int NOT = 4;
    public static final int OR = 5;
    public static final int TERM = 6;
    public static final int COLON = 7;
    public static final int QUOTE = 8;
    public static final int OPEN = 9;
    public static final int CLOSE = 10;
    public static final String tokenImage[] = {
        "<EOF>", "<PLUS>", "<MINUS>", "<AND>", "<NOT>", "<OR>", "<TERM>", "<COLON>", "<QUOTE>", "<OPEN>", 
        "<CLOSE>"
    };

}


/*
	DECOMPILATION REPORT

	Decompiled from: F:\jdk\workspace\lucene_0.1\lucene.jar
	Total time: 63 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/