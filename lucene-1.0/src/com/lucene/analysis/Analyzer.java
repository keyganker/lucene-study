/* Analyzer.java
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
package com.lucene.analysis;
import java.io.Reader;

/** An Analyzer builds TokenStreams, which analyze text.  It thus represents a
  policy for extracting index terms from text.
  <p>
  Typical implementations first build a Tokenizer, which breaks the stream of
  characters from the Reader into raw Tokens.  One or more TokenFilters may
  then be applied to the output of the Tokenizer.
  */

abstract public class Analyzer {
  /** Creates a TokenStream which tokenizes all the text in the provided
    Reader. */
  abstract public TokenStream tokenStream(Reader reader);
}

