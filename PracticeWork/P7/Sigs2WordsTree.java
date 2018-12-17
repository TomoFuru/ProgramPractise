package predictive;

import java.util.HashSet;
import java.util.Set;

/**
 * main method for ex4
 * @author Tomohiro Furuya
 * @version 14 Feb 2018
 */

public class Sigs2WordsTree {


	public static void main(String[] args) {
		//TreeDictionary ID3 = new TreeDictionary("/Applications/WS2-3/words.txt");
		TreeDictionary ID3 = new TreeDictionary("/usr/share/dict/words");
		for(String s: args) {
			System.out.print(s + " : ");
			
			
			Set<String> col = (HashSet<String>) ID3.signatureToWords(s);
			for(String word :col) {
				System.out.print(word + " "); 
			}
			System.out.println();
		}
		
		
	}
}
