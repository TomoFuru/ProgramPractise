package predictive;

import java.util.HashSet;
import java.util.Set;
/**
 * main method for ex3
 * @author Tomohiro Furuya
 * @version 12 Feb 2018
 */
public class Sigs2WordsMap {

	public static void main(String[] args) {
		//MapDictionary ID2 = new MapDictionary("/Applications/WS2-3/words.txt");
		MapDictionary ID2 = new MapDictionary("/usr/share/dict/words");
		for(String s: args) {
			System.out.print(s + " : ");
			
			
			Set<String> col = (HashSet<String>) ID2.signatureToWords(s);
			for(String word :col) {
				System.out.print(word + " "); 
			}
			System.out.println();
		}
		
		
	}
}
