/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lucene.analysis.standard;

import com.lucene.analysis.Token;
import com.lucene.analysis.Tokenizer;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

// Referenced classes of package com.lucene.analysis.standard:
//            FastCharStream, ParseException, StandardTokenizerTokenManager, Token, 
//            StandardTokenizerConstants, CharStream

public class StandardTokenizer extends Tokenizer
    implements StandardTokenizerConstants
{

    public StandardTokenizer(Reader reader)
    {
        this(((CharStream) (new FastCharStream(reader))));
        super.input = reader;
    }

    public final Token next()
        throws ParseException, IOException
    {
        com.lucene.analysis.standard.Token token = null;
        switch(jj_ntk != -1 ? jj_ntk : jj_ntk())
        {
        case 1: // '\001'
            token = jj_consume_token(1);
            break;

        case 2: // '\002'
            token = jj_consume_token(2);
            break;

        case 3: // '\003'
            token = jj_consume_token(3);
            break;

        case 4: // '\004'
            token = jj_consume_token(4);
            break;

        case 5: // '\005'
            token = jj_consume_token(5);
            break;

        case 6: // '\006'
            token = jj_consume_token(6);
            break;

        case 7: // '\007'
            token = jj_consume_token(7);
            break;

        case 0: // '\0'
            token = jj_consume_token(0);
            break;

        default:
            jj_la1[0] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
        }
        if(token.kind == 0)
            return null;
        else
            return new Token(token.image, token.beginColumn, token.endColumn, StandardTokenizerConstants.tokenImage[token.kind]);
    }

    public StandardTokenizer(CharStream stream)
    {
        jj_la1 = new int[1];
        jj_expentries = new Vector();
        jj_kind = -1;
        token_source = new StandardTokenizerTokenManager(stream);
        token = new com.lucene.analysis.standard.Token();
        jj_ntk = -1;
        jj_gen = 0;
        for(int i = 0; i < 1; i++)
            jj_la1[i] = -1;

    }

    public void ReInit(CharStream stream)
    {
        token_source.ReInit(stream);
        token = new com.lucene.analysis.standard.Token();
        jj_ntk = -1;
        jj_gen = 0;
        for(int i = 0; i < 1; i++)
            jj_la1[i] = -1;

    }

    public StandardTokenizer(StandardTokenizerTokenManager tm)
    {
        jj_la1 = new int[1];
        jj_expentries = new Vector();
        jj_kind = -1;
        token_source = tm;
        token = new com.lucene.analysis.standard.Token();
        jj_ntk = -1;
        jj_gen = 0;
        for(int i = 0; i < 1; i++)
            jj_la1[i] = -1;

    }

    public void ReInit(StandardTokenizerTokenManager tm)
    {
        token_source = tm;
        token = new com.lucene.analysis.standard.Token();
        jj_ntk = -1;
        jj_gen = 0;
        for(int i = 0; i < 1; i++)
            jj_la1[i] = -1;

    }

    private final com.lucene.analysis.standard.Token jj_consume_token(int kind)
        throws ParseException
    {
        com.lucene.analysis.standard.Token oldToken;
        if((oldToken = token).next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if(token.kind == kind)
        {
            jj_gen++;
            return token;
        } else
        {
            token = oldToken;
            jj_kind = kind;
            throw generateParseException();
        }
    }

    public final com.lucene.analysis.standard.Token getNextToken()
    {
        if(token.next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    public final com.lucene.analysis.standard.Token getToken(int index)
    {
        com.lucene.analysis.standard.Token t = token;
        for(int i = 0; i < index; i++)
            if(t.next != null)
                t = t.next;
            else
                t = t.next = token_source.getNextToken();

        return t;
    }

    private final int jj_ntk()
    {
        if((jj_nt = token.next) == null)
            return jj_ntk = (token.next = token_source.getNextToken()).kind;
        else
            return jj_ntk = jj_nt.kind;
    }

    public final ParseException generateParseException()
    {
        jj_expentries.removeAllElements();
        boolean la1tokens[] = new boolean[14];
        for(int i = 0; i < 14; i++)
            la1tokens[i] = false;

        if(jj_kind >= 0)
        {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for(int i = 0; i < 1; i++)
            if(jj_la1[i] == jj_gen)
            {
                for(int j = 0; j < 32; j++)
                    if((jj_la1_0[i] & 1 << j) != 0)
                        la1tokens[j] = true;

            }

        for(int i = 0; i < 14; i++)
            if(la1tokens[i])
            {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.addElement(jj_expentry);
            }

        int exptokseq[][] = new int[jj_expentries.size()][];
        for(int i = 0; i < jj_expentries.size(); i++)
            exptokseq[i] = (int[])jj_expentries.elementAt(i);

        return new ParseException(token, exptokseq, StandardTokenizerConstants.tokenImage);
    }

    public final void enable_tracing()
    {
    }

    public final void disable_tracing()
    {
    }

    public StandardTokenizerTokenManager token_source;
    public com.lucene.analysis.standard.Token token;
    public com.lucene.analysis.standard.Token jj_nt;
    private int jj_ntk;
    private int jj_gen;
    private final int jj_la1[];
    private final int jj_la1_0[] = {
        255
    };
    private Vector jj_expentries;
    private int jj_expentry[];
    private int jj_kind;
}


/*
	DECOMPILATION REPORT

	Decompiled from: F:\jdk\lucene-1_00\lucene.jar
	Total time: 81 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/