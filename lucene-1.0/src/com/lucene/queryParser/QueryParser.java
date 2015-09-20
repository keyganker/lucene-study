/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) radix(10) lradix(10) 
// Source File Name:   QueryParser.java

package com.lucene.queryParser;

import com.lucene.analysis.Analyzer;
import com.lucene.index.Term;
import com.lucene.search.*;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package com.lucene.queryParser:
//            ParseException, QueryParserConstants, QueryTokenManager, Token, 
//            TokenManager

public class QueryParser
    implements QueryParserConstants
{
    static final class JJCalls
    {

        int gen;
        Token first;
        int arg;
        JJCalls next;

        JJCalls()
        {
        }
    }


    public QueryParser(TokenManager tm)
    {
        phraseSlop = 0;
        lookingAhead = false;
        jj_la1 = new int[6];
        jj_2_rtns = new JJCalls[2];
        jj_rescan = false;
        jj_gc = 0;
        jj_expentries = new Vector();
        jj_kind = -1;
        jj_lasttokens = new int[100];
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for(int i = 0; i < 6; i++)
            jj_la1[i] = -1;

        for(int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();

    }

    public QueryParser(String f, Analyzer a)
    {
        phraseSlop = 0;
        lookingAhead = false;
        jj_la1 = new int[6];
        jj_2_rtns = new JJCalls[2];
        jj_rescan = false;
        jj_gc = 0;
        jj_expentries = new Vector();
        jj_kind = -1;
        jj_lasttokens = new int[100];
        analyzer = a;
        field = f;
    }

    public final PhraseQuery Phrase(String field)
        throws ParseException
    {
        PhraseQuery phrase = new PhraseQuery();
        phrase.setSlop(phraseSlop);
label0:
        do
            switch(jj_ntk != -1 ? jj_ntk : jj_ntk())
            {
            default:
                jj_la1[5] = jj_gen;
                break label0;

            case 6: // '\006'
                Token term = jj_consume_token(6);
                phrase.add(new Term(field, term.image));
                break;
            }
        while(true);
        return phrase;
    }

    public final Query Query(String field)
        throws ParseException
    {
        Vector clauses = new Vector();
label0:
        do
            switch(jj_ntk != -1 ? jj_ntk : jj_ntk())
            {
            case 7: // '\007'
            default:
                jj_la1[0] = jj_gen;
                break label0;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 8: // '\b'
            case 9: // '\t'
                boolean required = false;
                boolean prohibited = false;
                boolean and = false;
                switch(jj_ntk != -1 ? jj_ntk : jj_ntk())
                {
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                    switch(jj_ntk != -1 ? jj_ntk : jj_ntk())
                    {
                    case 1: // '\001'
                        jj_consume_token(1);
                        required = true;
                        break;

                    case 2: // '\002'
                        jj_consume_token(2);
                        prohibited = true;
                        break;

                    default:
                        jj_la1[1] = jj_gen;
                        if(jj_2_1(2))
                        {
                            jj_consume_token(3);
                            jj_consume_token(4);
                            and = true;
                            prohibited = true;
                        } else
                        {
                            switch(jj_ntk != -1 ? jj_ntk : jj_ntk())
                            {
                            case 3: // '\003'
                                jj_consume_token(3);
                                and = true;
                                required = true;
                                break;

                            case 4: // '\004'
                                jj_consume_token(4);
                                prohibited = true;
                                break;

                            case 5: // '\005'
                                jj_consume_token(5);
                                break;

                            default:
                                jj_la1[2] = jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                        }
                        break;
                    }
                    break;

                default:
                    jj_la1[3] = jj_gen;
                    break;
                }
                Query subQuery = subQuery(field);
                if(and)
                {
                    if(clauses.size() == 0)
                        throw new ParseException("Query can't start with AND.");
                    BooleanClause clause = (BooleanClause)clauses.elementAt(clauses.size() - 1);
                    clause.required = true;
                }
                clauses.addElement(new BooleanClause(subQuery, required, prohibited));
                break;
            }
        while(true);
        BooleanQuery query = new BooleanQuery();
        for(int i = 0; i < clauses.size(); i++)
            query.add((BooleanClause)clauses.elementAt(i));

        return query;
    }

    public void ReInit(TokenManager tm)
    {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for(int i = 0; i < 6; i++)
            jj_la1[i] = -1;

        for(int i = 0; i < jj_2_rtns.length; i++)
            jj_2_rtns[i] = new JJCalls();

    }

    public final TermQuery Term(String field)
        throws ParseException
    {
        Token term = jj_consume_token(6);
        return new TermQuery(new Term(field, term.image));
    }

    public final void disable_tracing()
    {
    }

    public final void enable_tracing()
    {
    }

    public final ParseException generateParseException()
    {
        jj_expentries.removeAllElements();
        boolean la1tokens[] = new boolean[11];
        for(int i = 0; i < 11; i++)
            la1tokens[i] = false;

        if(jj_kind >= 0)
        {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for(int i = 0; i < 6; i++)
            if(jj_la1[i] == jj_gen)
            {
                for(int j = 0; j < 32; j++)
                    if((jj_la1_0[i] & 1 << j) != 0)
                        la1tokens[j] = true;

            }

        for(int i = 0; i < 11; i++)
            if(la1tokens[i])
            {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.addElement(jj_expentry);
            }

        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int exptokseq[][] = new int[jj_expentries.size()][];
        for(int i = 0; i < jj_expentries.size(); i++)
            exptokseq[i] = (int[])jj_expentries.elementAt(i);

        return new ParseException(token, exptokseq, QueryParserConstants.tokenImage);
    }

    public final Token getNextToken()
    {
        if(token.next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    public int getPhraseSlop()
    {
        return phraseSlop;
    }

    public final Token getToken(int index)
    {
        Token t = lookingAhead ? jj_scanpos : token;
        for(int i = 0; i < index; i++)
            if(t.next != null)
                t = t.next;
            else
                t = t.next = token_source.getNextToken();

        return t;
    }

    private final boolean jj_2_1(int xla)
    {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        boolean retval = jj_3_1() ^ true;
        jj_save(0, xla);
        return retval;
    }

    private final boolean jj_2_2(int xla)
    {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        boolean retval = jj_3_2() ^ true;
        jj_save(1, xla);
        return retval;
    }

    private final boolean jj_3_1()
    {
        if(jj_scan_token(3))
            return true;
        if(jj_la == 0 && jj_scanpos == jj_lastpos)
            return false;
        if(jj_scan_token(4))
            return true;
        return jj_la != 0 || jj_scanpos != jj_lastpos ? false : false;
    }

    private final boolean jj_3_2()
    {
        if(jj_scan_token(6))
            return true;
        if(jj_la == 0 && jj_scanpos == jj_lastpos)
            return false;
        if(jj_scan_token(7))
            return true;
        return jj_la != 0 || jj_scanpos != jj_lastpos ? false : false;
    }

    private void jj_add_error_token(int kind, int pos)
    {
        if(pos >= 100)
            return;
        if(pos == jj_endpos + 1)
            jj_lasttokens[jj_endpos++] = kind;
        else
        if(jj_endpos != 0)
        {
            jj_expentry = new int[jj_endpos];
            for(int i = 0; i < jj_endpos; i++)
                jj_expentry[i] = jj_lasttokens[i];

            boolean exists = false;
            Enumeration enumeration = jj_expentries.elements();
            while(enumeration.hasMoreElements()) 
            {
                int oldentry[] = (int[])enumeration.nextElement();
                if(oldentry.length != jj_expentry.length)
                    continue;
                exists = true;
                for(int i = 0; i < jj_expentry.length; i++)
                {
                    if(oldentry[i] == jj_expentry[i])
                        continue;
                    exists = false;
                    break;
                }

                if(exists)
                    break;
            }
            if(!exists)
                jj_expentries.addElement(jj_expentry);
            if(pos != 0)
                jj_lasttokens[(jj_endpos = pos) - 1] = kind;
        }
    }

    private final Token jj_consume_token(int kind)
        throws ParseException
    {
        Token oldToken;
        if((oldToken = token).next != null)
            token = token.next;
        else
            token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if(token.kind == kind)
        {
            jj_gen++;
            if(++jj_gc > 100)
            {
                jj_gc = 0;
                for(int i = 0; i < jj_2_rtns.length; i++)
                {
                    for(JJCalls c = jj_2_rtns[i]; c != null; c = c.next)
                        if(c.gen < jj_gen)
                            c.first = null;

                }

            }
            return token;
        } else
        {
            token = oldToken;
            jj_kind = kind;
            throw generateParseException();
        }
    }

    private final int jj_ntk()
    {
        if((jj_nt = token.next) == null)
            return jj_ntk = (token.next = token_source.getNextToken()).kind;
        else
            return jj_ntk = jj_nt.kind;
    }

    private final void jj_rescan_token()
    {
        jj_rescan = true;
        for(int i = 0; i < 2; i++)
        {
            JJCalls p = jj_2_rtns[i];
            do
            {
                if(p.gen > jj_gen)
                {
                    jj_la = p.arg;
                    jj_lastpos = jj_scanpos = p.first;
                    switch(i)
                    {
                    case 0: // '\0'
                        jj_3_1();
                        break;

                    case 1: // '\001'
                        jj_3_2();
                        break;
                    }
                }
                p = p.next;
            } while(p != null);
        }

        jj_rescan = false;
    }

    private final void jj_save(int index, int xla)
    {
        JJCalls p;
        for(p = jj_2_rtns[index]; p.gen > jj_gen; p = p.next)
        {
            if(p.next != null)
                continue;
            p = p.next = new JJCalls();
            break;
        }

        p.gen = (jj_gen + xla) - jj_la;
        p.first = token;
        p.arg = xla;
    }

    private final boolean jj_scan_token(int kind)
    {
        if(jj_scanpos == jj_lastpos)
        {
            jj_la--;
            if(jj_scanpos.next == null)
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
            else
                jj_lastpos = jj_scanpos = jj_scanpos.next;
        } else
        {
            jj_scanpos = jj_scanpos.next;
        }
        if(jj_rescan)
        {
            int i = 0;
            Token tok;
            for(tok = token; tok != null && tok != jj_scanpos; tok = tok.next)
                i++;

            if(tok != null)
                jj_add_error_token(kind, i);
        }
        return jj_scanpos.kind != kind;
    }

    public Query parse(String query)
        throws ParseException
    {
        ReInit(new QueryTokenManager(query, analyzer));
        return Query(field);
    }

    public static Query parse(String query, String field, Analyzer analyzer)
        throws ParseException
    {
        TokenManager tm = new QueryTokenManager(query, analyzer);
        QueryParser parser = new QueryParser(tm);
        return parser.Query(field);
    }

    public void setPhraseSlop(int s)
    {
        phraseSlop = s;
    }

    public final Query subQuery(String field)
        throws ParseException
    {
        if(jj_2_2(3))
        {
            Token fieldToken = jj_consume_token(6);
            jj_consume_token(7);
            field = fieldToken.image;
        }
        Query subQuery;
        switch(jj_ntk != -1 ? jj_ntk : jj_ntk())
        {
        case 6: // '\006'
            subQuery = Term(field);
            break;

        case 8: // '\b'
            jj_consume_token(8);
            subQuery = Phrase(field);
            jj_consume_token(8);
            break;

        case 9: // '\t'
            jj_consume_token(9);
            subQuery = Query(field);
            jj_consume_token(10);
            break;

        case 7: // '\007'
        default:
            jj_la1[4] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
        }
        return subQuery;
    }

    Analyzer analyzer;
    String field;
    int phraseSlop;
    public TokenManager token_source;
    public Token token;
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos;
    private Token jj_lastpos;
    private int jj_la;
    public boolean lookingAhead;
    private boolean jj_semLA;
    private int jj_gen;
    private final int jj_la1[];
    private final int jj_la1_0[] = {
        894, 6, 56, 62, 832, 64
    };
    private final JJCalls jj_2_rtns[];
    private boolean jj_rescan;
    private int jj_gc;
    private Vector jj_expentries;
    private int jj_expentry[];
    private int jj_kind;
    private int jj_lasttokens[];
    private int jj_endpos;
}


/*
	DECOMPILATION REPORT

	Decompiled from: F:\jdk\workspace\lucene_0.1\lucene.jar
	Total time: 127 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/