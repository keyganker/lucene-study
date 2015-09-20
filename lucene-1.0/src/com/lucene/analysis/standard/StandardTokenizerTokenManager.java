/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lucene.analysis.standard;

import java.io.IOException;

// Referenced classes of package com.lucene.analysis.standard:
//            TokenMgrError, StandardTokenizerConstants, CharStream, Token

public class StandardTokenizerTokenManager
    implements StandardTokenizerConstants
{

    private final int jjMoveStringLiteralDfa0_0()
    {
        return jjMoveNfa_0(0, 0);
    }

    private final void jjCheckNAdd(int state)
    {
        if(jjrounds[state] != jjround)
        {
            jjstateSet[jjnewStateCnt++] = state;
            jjrounds[state] = jjround;
        }
    }

    private final void jjAddStates(int start, int end)
    {
        do
            jjstateSet[jjnewStateCnt++] = jjnextStates[start];
        while(start++ != end);
    }

    private final void jjCheckNAddTwoStates(int state1, int state2)
    {
        jjCheckNAdd(state1);
        jjCheckNAdd(state2);
    }

    private final void jjCheckNAddStates(int start, int end)
    {
        do
            jjCheckNAdd(jjnextStates[start]);
        while(start++ != end);
    }

    private final void jjCheckNAddStates(int start)
    {
        jjCheckNAdd(jjnextStates[start]);
        jjCheckNAdd(jjnextStates[start + 1]);
    }

    private final int jjMoveNfa_0(int startState, int curPos)
    {
        int startsAt = 0;
        jjnewStateCnt = 70;
        int i = 1;
        jjstateSet[0] = startState;
        int kind = 2147483647;
        do
        {
            if(++jjround == 2147483647)
                ReInitRounds();
            if(curChar < '@')
            {
                long l = 1L << curChar;
                do
                    switch(jjstateSet[--i])
                    {
                    case 0: // '\0'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAddStates(0, 16);
                        }
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddStates(17, 22);
                        break;

                    case 1: // '\001'
                    case 36: // '$'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(1, 2);
                        break;

                    case 2: // '\002'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAdd(3);
                        break;

                    case 3: // '\003'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAdd(3);
                        }
                        break;

                    case 4: // '\004'
                    case 45: // '-'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(4, 5);
                        break;

                    case 5: // '\005'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAdd(6);
                        break;

                    case 6: // '\006'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(6, 7);
                        break;

                    case 7: // '\007'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAddTwoStates(8, 9);
                        break;

                    case 8: // '\b'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(8, 9);
                        break;

                    case 9: // '\t'
                    case 10: // '\n'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(5, 10);
                        }
                        break;

                    case 11: // '\013'
                    case 58: // ':'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(11, 12);
                        break;

                    case 12: // '\f'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAdd(13);
                        break;

                    case 13: // '\r'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(13, 14);
                        break;

                    case 14: // '\016'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAddTwoStates(15, 16);
                        break;

                    case 15: // '\017'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(15, 16);
                        break;

                    case 16: // '\020'
                    case 17: // '\021'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(17, 18);
                        break;

                    case 18: // '\022'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAdd(19);
                        break;

                    case 19: // '\023'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(14, 19);
                        }
                        break;

                    case 20: // '\024'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAddStates(0, 16);
                        }
                        break;

                    case 21: // '\025'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAdd(21);
                        }
                        break;

                    case 22: // '\026'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(22, 23);
                        break;

                    case 24: // '\030'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(24, 25);
                        break;

                    case 25: // '\031'
                        if(curChar == '.')
                            jjCheckNAdd(26);
                        break;

                    case 26: // '\032'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 5)
                                kind = 5;
                            jjCheckNAddTwoStates(25, 26);
                        }
                        break;

                    case 27: // '\033'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(27, 28);
                        break;

                    case 28: // '\034'
                        if(curChar == '.')
                            jjCheckNAdd(29);
                        break;

                    case 29: // '\035'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 6)
                                kind = 6;
                            jjCheckNAddTwoStates(28, 29);
                        }
                        break;

                    case 30: // '\036'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(30, 31);
                        break;

                    case 31: // '\037'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAddTwoStates(32, 33);
                        break;

                    case 32: // ' '
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(32, 33);
                        break;

                    case 33: // '!'
                    case 34: // '"'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAdd(34);
                        }
                        break;

                    case 35: // '#'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(35, 36);
                        break;

                    case 37: // '%'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(37, 38);
                        break;

                    case 38: // '&'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAddTwoStates(39, 40);
                        break;

                    case 39: // '\''
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(39, 40);
                        break;

                    case 40: // '('
                    case 41: // ')'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(41, 42);
                        break;

                    case 42: // '*'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAdd(43);
                        break;

                    case 43: // '+'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(38, 43);
                        }
                        break;

                    case 44: // ','
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(44, 45);
                        break;

                    case 46: // '.'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(46, 47);
                        break;

                    case 47: // '/'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAddTwoStates(48, 49);
                        break;

                    case 48: // '0'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(48, 49);
                        break;

                    case 49: // '1'
                    case 50: // '2'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(50, 51);
                        break;

                    case 51: // '3'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAdd(52);
                        break;

                    case 52: // '4'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(52, 53);
                        break;

                    case 53: // '5'
                        if((263882790666240L & l) != 0L)
                            jjCheckNAddTwoStates(54, 55);
                        break;

                    case 54: // '6'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(54, 55);
                        break;

                    case 55: // '7'
                    case 56: // '8'
                        if((287948901175001088L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(51, 56);
                        }
                        break;

                    case 57: // '9'
                        if((287948901175001088L & l) != 0L)
                            jjCheckNAddTwoStates(57, 58);
                        break;

                    case 61: // '='
                        if(curChar == '\'')
                            jjstateSet[jjnewStateCnt++] = 62;
                        break;

                    case 64: // '@'
                        if(curChar == '.')
                            jjCheckNAdd(65);
                        break;

                    case 66: // 'B'
                        if(curChar == '.')
                        {
                            if(kind > 3)
                                kind = 3;
                            jjCheckNAdd(65);
                        }
                        break;

                    case 68: // 'D'
                        if(curChar == '&')
                            jjstateSet[jjnewStateCnt++] = 69;
                        break;
                    }
                while(i != startsAt);
            } else
            if(curChar < '\200')
            {
                long l = 1L << (curChar & 63);
                do
                    switch(jjstateSet[--i])
                    {
                    case 0: // '\0'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddStates(23, 28);
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAddStates(0, 16);
                        }
                        break;

                    case 1: // '\001'
                        if((576460743847706622L & l) != 0L)
                            jjAddStates(29, 30);
                        break;

                    case 2: // '\002'
                        if(curChar == '_')
                            jjCheckNAdd(3);
                        break;

                    case 3: // '\003'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAdd(3);
                        }
                        break;

                    case 4: // '\004'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(4, 5);
                        break;

                    case 5: // '\005'
                        if(curChar == '_')
                            jjCheckNAdd(6);
                        break;

                    case 6: // '\006'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(6, 7);
                        break;

                    case 7: // '\007'
                        if(curChar == '_')
                            jjCheckNAddTwoStates(8, 9);
                        break;

                    case 8: // '\b'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(8, 9);
                        break;

                    case 10: // '\n'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(5, 10);
                        }
                        break;

                    case 11: // '\013'
                        if((576460743847706622L & l) != 0L)
                            jjAddStates(31, 32);
                        break;

                    case 12: // '\f'
                        if(curChar == '_')
                            jjCheckNAdd(13);
                        break;

                    case 13: // '\r'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(13, 14);
                        break;

                    case 14: // '\016'
                        if(curChar == '_')
                            jjCheckNAddTwoStates(15, 16);
                        break;

                    case 15: // '\017'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(15, 16);
                        break;

                    case 17: // '\021'
                        if((576460743847706622L & l) != 0L)
                            jjAddStates(33, 34);
                        break;

                    case 18: // '\022'
                        if(curChar == '_')
                            jjCheckNAdd(19);
                        break;

                    case 19: // '\023'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(14, 19);
                        }
                        break;

                    case 20: // '\024'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAddStates(0, 16);
                        }
                        break;

                    case 21: // '\025'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAdd(21);
                        }
                        break;

                    case 22: // '\026'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(22, 23);
                        break;

                    case 23: // '\027'
                        if(curChar == '@')
                            jjCheckNAdd(24);
                        break;

                    case 24: // '\030'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(24, 25);
                        break;

                    case 26: // '\032'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 5)
                                kind = 5;
                            jjCheckNAddTwoStates(25, 26);
                        }
                        break;

                    case 27: // '\033'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(27, 28);
                        break;

                    case 29: // '\035'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 6)
                                kind = 6;
                            jjCheckNAddTwoStates(28, 29);
                        }
                        break;

                    case 30: // '\036'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(30, 31);
                        break;

                    case 31: // '\037'
                        if(curChar == '_')
                            jjCheckNAddTwoStates(32, 33);
                        break;

                    case 32: // ' '
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(32, 33);
                        break;

                    case 34: // '"'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjstateSet[jjnewStateCnt++] = 34;
                        }
                        break;

                    case 35: // '#'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(35, 36);
                        break;

                    case 37: // '%'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(37, 38);
                        break;

                    case 38: // '&'
                        if(curChar == '_')
                            jjCheckNAddTwoStates(39, 40);
                        break;

                    case 39: // '\''
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(39, 40);
                        break;

                    case 41: // ')'
                        if((576460743847706622L & l) != 0L)
                            jjAddStates(35, 36);
                        break;

                    case 42: // '*'
                        if(curChar == '_')
                            jjCheckNAdd(43);
                        break;

                    case 43: // '+'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(38, 43);
                        }
                        break;

                    case 44: // ','
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(44, 45);
                        break;

                    case 46: // '.'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(46, 47);
                        break;

                    case 47: // '/'
                        if(curChar == '_')
                            jjCheckNAddTwoStates(48, 49);
                        break;

                    case 48: // '0'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(48, 49);
                        break;

                    case 50: // '2'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(50, 51);
                        break;

                    case 51: // '3'
                        if(curChar == '_')
                            jjCheckNAdd(52);
                        break;

                    case 52: // '4'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(52, 53);
                        break;

                    case 53: // '5'
                        if(curChar == '_')
                            jjCheckNAddTwoStates(54, 55);
                        break;

                    case 54: // '6'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(54, 55);
                        break;

                    case 56: // '8'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(51, 56);
                        }
                        break;

                    case 57: // '9'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(57, 58);
                        break;

                    case 59: // ';'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddStates(23, 28);
                        break;

                    case 60: // '<'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(60, 61);
                        break;

                    case 62: // '>'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 2)
                                kind = 2;
                            jjCheckNAddTwoStates(61, 62);
                        }
                        break;

                    case 63: // '?'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(63, 64);
                        break;

                    case 65: // 'A'
                        if((576460743847706622L & l) != 0L)
                            jjAddStates(37, 38);
                        break;

                    case 67: // 'C'
                        if((576460743847706622L & l) != 0L)
                            jjCheckNAddTwoStates(67, 68);
                        break;

                    case 68: // 'D'
                        if(curChar == '@')
                            jjCheckNAdd(69);
                        break;

                    case 69: // 'E'
                        if((576460743847706622L & l) != 0L)
                        {
                            if(kind > 4)
                                kind = 4;
                            jjCheckNAdd(69);
                        }
                        break;
                    }
                while(i != startsAt);
            } else
            {
                int i2 = (curChar & 255) >> 6;
                long l2 = 1L << (curChar & 63);
                do
                    switch(jjstateSet[--i])
                    {
                    case 0: // '\0'
                        if((jjbitVec2[i2] & l2) != 0L)
                            jjCheckNAddStates(17, 22);
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAddStates(0, 16);
                        }
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddStates(23, 28);
                        break;

                    case 1: // '\001'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(1, 2);
                        break;

                    case 3: // '\003'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjstateSet[jjnewStateCnt++] = 3;
                        }
                        break;

                    case 4: // '\004'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(4, 5);
                        break;

                    case 6: // '\006'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(39, 40);
                        break;

                    case 8: // '\b'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(41, 42);
                        break;

                    case 9: // '\t'
                        if((jjbitVec2[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(5, 10);
                        }
                        break;

                    case 10: // '\n'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(5, 10);
                        }
                        break;

                    case 11: // '\013'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(11, 12);
                        break;

                    case 13: // '\r'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(13, 14);
                        break;

                    case 15: // '\017'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(43, 44);
                        break;

                    case 16: // '\020'
                        if((jjbitVec2[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(17, 18);
                        break;

                    case 17: // '\021'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(17, 18);
                        break;

                    case 19: // '\023'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(14, 19);
                        }
                        break;

                    case 20: // '\024'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAddStates(0, 16);
                        }
                        break;

                    case 21: // '\025'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 1)
                                kind = 1;
                            jjCheckNAdd(21);
                        }
                        break;

                    case 22: // '\026'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(22, 23);
                        break;

                    case 24: // '\030'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(24, 25);
                        break;

                    case 26: // '\032'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 5)
                                kind = 5;
                            jjCheckNAddTwoStates(25, 26);
                        }
                        break;

                    case 27: // '\033'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(27, 28);
                        break;

                    case 29: // '\035'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 6)
                                kind = 6;
                            jjCheckNAddTwoStates(28, 29);
                        }
                        break;

                    case 30: // '\036'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(30, 31);
                        break;

                    case 32: // ' '
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(45, 46);
                        break;

                    case 33: // '!'
                        if((jjbitVec2[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAdd(34);
                        }
                        break;

                    case 34: // '"'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAdd(34);
                        }
                        break;

                    case 35: // '#'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(35, 36);
                        break;

                    case 36: // '$'
                        if((jjbitVec2[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(1, 2);
                        break;

                    case 37: // '%'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(37, 38);
                        break;

                    case 39: // '\''
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(47, 48);
                        break;

                    case 40: // '('
                        if((jjbitVec2[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(41, 42);
                        break;

                    case 41: // ')'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(41, 42);
                        break;

                    case 43: // '+'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(38, 43);
                        }
                        break;

                    case 44: // ','
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(44, 45);
                        break;

                    case 45: // '-'
                        if((jjbitVec2[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(4, 5);
                        break;

                    case 46: // '.'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(46, 47);
                        break;

                    case 48: // '0'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(49, 50);
                        break;

                    case 49: // '1'
                        if((jjbitVec2[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(50, 51);
                        break;

                    case 50: // '2'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(50, 51);
                        break;

                    case 52: // '4'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(51, 52);
                        break;

                    case 54: // '6'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(53, 54);
                        break;

                    case 55: // '7'
                        if((jjbitVec2[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(51, 56);
                        }
                        break;

                    case 56: // '8'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 7)
                                kind = 7;
                            jjCheckNAddTwoStates(51, 56);
                        }
                        break;

                    case 57: // '9'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(57, 58);
                        break;

                    case 58: // ':'
                        if((jjbitVec2[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(11, 12);
                        break;

                    case 59: // ';'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddStates(23, 28);
                        break;

                    case 60: // '<'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(60, 61);
                        break;

                    case 62: // '>'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 2)
                                kind = 2;
                            jjCheckNAddTwoStates(61, 62);
                        }
                        break;

                    case 63: // '?'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(63, 64);
                        break;

                    case 65: // 'A'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjAddStates(37, 38);
                        break;

                    case 67: // 'C'
                        if((jjbitVec9[i2] & l2) != 0L)
                            jjCheckNAddTwoStates(67, 68);
                        break;

                    case 69: // 'E'
                        if((jjbitVec9[i2] & l2) != 0L)
                        {
                            if(kind > 4)
                                kind = 4;
                            jjstateSet[jjnewStateCnt++] = 69;
                        }
                        break;
                    }
                while(i != startsAt);
            }
            if(kind != 2147483647)
            {
                jjmatchedKind = kind;
                jjmatchedPos = curPos;
                kind = 2147483647;
            }
            curPos++;
            if((i = jjnewStateCnt) == (startsAt = 70 - (jjnewStateCnt = startsAt)))
                return curPos;
            try
            {
                curChar = input_stream.readChar();
            }
            catch(IOException ioexception)
            {
                return curPos;
            }
        } while(true);
    }

    public StandardTokenizerTokenManager(CharStream stream)
    {
        jjrounds = new int[70];
        jjstateSet = new int[140];
        curLexState = 0;
        defaultLexState = 0;
        input_stream = stream;
    }

    public StandardTokenizerTokenManager(CharStream stream, int lexState)
    {
        this(stream);
        SwitchTo(lexState);
    }

    public void ReInit(CharStream stream)
    {
        jjmatchedPos = jjnewStateCnt = 0;
        curLexState = defaultLexState;
        input_stream = stream;
        ReInitRounds();
    }

    private final void ReInitRounds()
    {
        jjround = -2147483647;
        for(int i = 70; i-- > 0;)
            jjrounds[i] = -2147483648;

    }

    public void ReInit(CharStream stream, int lexState)
    {
        ReInit(stream);
        SwitchTo(lexState);
    }

    public void SwitchTo(int lexState)
    {
        if(lexState >= 1 || lexState < 0)
        {
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", 2);
        } else
        {
            curLexState = lexState;
            return;
        }
    }

    private final Token jjFillToken()
    {
        Token t = Token.newToken(jjmatchedKind);
        t.kind = jjmatchedKind;
        String im = jjstrLiteralImages[jjmatchedKind];
        t.image = im != null ? im : input_stream.GetImage();
        t.beginLine = input_stream.getBeginLine();
        t.beginColumn = input_stream.getBeginColumn();
        t.endLine = input_stream.getEndLine();
        t.endColumn = input_stream.getEndColumn();
        return t;
    }

    public final Token getNextToken()
    {
        Token specialToken = null;
        int curPos = 0;
        do
        {
            try
            {
                curChar = input_stream.BeginToken();
            }
            catch(IOException ioexception)
            {
                jjmatchedKind = 0;
                Token matchedToken = jjFillToken();
                return matchedToken;
            }
            jjmatchedKind = 2147483647;
            jjmatchedPos = 0;
            curPos = jjMoveStringLiteralDfa0_0();
            if(jjmatchedPos == 0 && jjmatchedKind > 13)
                jjmatchedKind = 13;
            if(jjmatchedKind != 2147483647)
            {
                if(jjmatchedPos + 1 < curPos)
                    input_stream.backup(curPos - jjmatchedPos - 1);
                if((jjtoToken[jjmatchedKind >> 6] & 1L << (jjmatchedKind & 63)) != 0L)
                {
                    Token matchedToken = jjFillToken();
                    return matchedToken;
                }
            } else
            {
                int error_line = input_stream.getEndLine();
                int error_column = input_stream.getEndColumn();
                String error_after = null;
                boolean EOFSeen = false;
                try
                {
                    input_stream.readChar();
                    input_stream.backup(1);
                }
                catch(IOException ioexception1)
                {
                    EOFSeen = true;
                    error_after = curPos > 1 ? input_stream.GetImage() : "";
                    if(curChar == '\n' || curChar == '\r')
                    {
                        error_line++;
                        error_column = 0;
                    } else
                    {
                        error_column++;
                    }
                }
                if(!EOFSeen)
                {
                    input_stream.backup(1);
                    error_after = curPos > 1 ? input_stream.GetImage() : "";
                }
                throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, 0);
            }
        } while(true);
    }

    static final long jjbitVec0[] = {
        5632L, 0L, 0L, 0L
    };
    static final long jjbitVec1[] = {
        0L, 281200098803712L, 0L, 281200098803712L
    };
    static final long jjbitVec2[] = {
        0L, 4393751543808L, 0L, 287948901175001088L
    };
    static final long jjbitVec3[] = {
        0L, 281200098803712L, 0L, 280925220896768L
    };
    static final long jjbitVec4[] = {
        0L, 281200098803712L, 0L, 0L
    };
    static final long jjbitVec5[] = {
        0L, 67043328L, 0L, 67043328L
    };
    static final long jjbitVec6[] = {
        0L, 1023L, 0L, 0L
    };
    static final long jjbitVec7[] = {
        2301339413881290750L, -16384L, 4294967295L, 432345564227567616L
    };
    static final long jjbitVec9[] = {
        0L, 0L, 0L, -36028797027352577L
    };
    static final long jjbitVec10[] = {
        0L, -1L, -1L, -1L
    };
    static final long jjbitVec11[] = {
        -1L, -1L, 65535L, 0L
    };
    static final long jjbitVec12[] = {
        -1L, -1L, 0L, 0L
    };
    static final long jjbitVec13[] = {
        70368744177663L, 0L, 0L, 0L
    };
    static final int jjnextStates[] = {
        21, 22, 23, 27, 28, 30, 31, 35, 36, 37, 
        38, 44, 45, 46, 47, 57, 58, 1, 2, 4, 
        5, 11, 12, 60, 61, 63, 64, 67, 68, 1, 
        2, 11, 12, 17, 18, 41, 42, 65, 66, 6, 
        7, 8, 9, 15, 16, 32, 33, 39, 40, 48, 
        49, 52, 53, 54, 55
    };
    public static final String jjstrLiteralImages[] = {
        "", null, null, null, null, null, null, null, null, null, 
        null, null, null, null
    };
    public static final String lexStateNames[] = {
        "DEFAULT"
    };
    static final long jjtoToken[] = {
        255L
    };
    static final long jjtoSkip[] = {
        8192L
    };
    private CharStream input_stream;
    private final int jjrounds[];
    private final int jjstateSet[];
    protected char curChar;
    int curLexState;
    int defaultLexState;
    int jjnewStateCnt;
    int jjround;
    int jjmatchedPos;
    int jjmatchedKind;

}


/*
	DECOMPILATION REPORT

	Decompiled from: F:\jdk\lucene-1_00\lucene.jar
	Total time: 84 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/