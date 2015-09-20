/* ExactPhraseScorer.java
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
package com.lucene.search;

import java.io.IOException;
import java.util.Vector;
import com.lucene.util.*;
import com.lucene.index.*;

final class ExactPhraseScorer extends PhraseScorer {

  ExactPhraseScorer(TermPositions[] tps, byte[] n, float w)
       throws IOException {
    super(tps, n, w);
  }

  protected final float phraseFreq() throws IOException {
    // sort list with pq
    for (PhrasePositions pp = first; pp != null; pp = pp.next) {
      pp.firstPosition();
      pq.put(pp);				  // build pq from list
    }
    pqToList();					  // rebuild list from pq

    int freq = 0;
    do {					  // find position w/ all terms
      while (first.position < last.position) {	  // scan forward in first
	do {
	  if (!first.nextPosition())
	    return (float)freq;
	} while (first.position < last.position);
	firstToLast();
      }
      freq++;					  // all equal: a match
    } while (last.nextPosition());
  
    return (float)freq;
  }
}
