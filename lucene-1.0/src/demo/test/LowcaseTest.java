package demo.test;

import java.io.IOException;
import java.io.StringReader;

import com.lucene.analysis.LowerCaseTokenizer;
import com.lucene.analysis.Token;

public class LowcaseTest {

	public static void main(String[] args) throws IOException {
		StringReader sr = new StringReader("I am Feng Yong");
		LowerCaseTokenizer lct = new LowerCaseTokenizer(sr);
		while (lct.next() != null)
		{
			Token token = lct.next();
			System.out.println(token.termText());
		}
	}
}
