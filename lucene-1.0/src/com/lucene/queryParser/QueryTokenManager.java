/* QueryTokenManager.java
 *
 * Copyright (c) 1997, 2000 Douglass R. Cutting.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
 */
package com.lucene.queryParser;
import java.io.StringReader;
import java.io.IOException;
import com.lucene.analysis.TokenStream;
import com.lucene.analysis.Analyzer;

/** Converts a Lucene token stream to a JavaCC TokenManager.
 * Text between Lucene tokens is also examined for special characters which are
 * returned as JavaCC tokens so that they can be used in query parsing.
 */

public class QueryTokenManager implements TokenManager, QueryParserConstants {
  private TokenStream source;
  private String text;

  private com.lucene.analysis.Token token;		  // the Lucene token
  private int offset = 0;

  public QueryTokenManager(String t, Analyzer analyzer) {
    source = analyzer.tokenStream(new StringReader(t));
    text = t;
  }

  public Token getNextToken() {			  // translate from source
    try {
      if (token == null || offset > token.startOffset())
	token = source.next();
      
      // Examine text between tokens for special characters.
      int end = (token == null) ? text.length() : token.startOffset();
      for (; offset < end; offset++) {
	Token t = null;

	switch (text.charAt(offset)) {		  // return special char tokens
	case '+' : t = newToken(PLUS,  offset, offset+1, "+"); break;
	case '-' : t = newToken(MINUS, offset, offset+1, "-"); break;
	case ':' : t = newToken(COLON, offset, offset+1, ":"); break;
	case '(' : t = newToken(OPEN,  offset, offset+1, "("); break;
	case ')' : t = newToken(CLOSE, offset, offset+1, ")"); break;
	case '"' : t = newToken(QUOTE, offset, offset+1, "\""); break;
	}

	// Check for special tokens
	if (tokenTextIs("AND", offset, end))
	  t = newToken(AND, offset, offset+3, "AND");
	else if (tokenTextIs("OR", offset, end))
	  t = newToken(OR, offset, offset+2, "OR");
	else if (tokenTextIs("NOT", offset, end))
	  t = newToken(NOT, offset, offset+3, "NOT");

	if (t != null) {
	  offset = t.endColumn;
	  return t;
	}
      }

      if (token == null)			  // at end of input
	return newToken(EOF, offset, offset, "");
      
      offset = token.endOffset();

      // Not a special token: convert Lucene token
      return newToken(TERM,
		      token.startOffset(), token.endOffset(),
		      token.termText());

    } catch (IOException e) {
      throw new RuntimeException(e.toString());
    }
  }

  private final Token newToken(int ofKind, int begin, int end, String i) {
    Token token = new Token();
    token.kind = ofKind;
    token.beginColumn = begin;
    token.endColumn = end;
    token.image = i;
    return token;
  }


  private boolean tokenTextIs(String s, int offset, int end) {
    // Return true iff the input text at offset matches s.
    if (offset + s.length() >= end)
      return false;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) != text.charAt(offset + i))
	return false;
    return true;
  }
}
