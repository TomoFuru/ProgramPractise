package predictive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * main method for ex2
 * @author Tomohiro Furuya
 * @version 7 Feb 2018
 */
public class Sigs2WordsList {

	public static void main(String[] args) {
		ListDictionary ID = new ListDictionary("/Applications/WS2-3/words.txt");
		//ListDictionary ID = new ListDictionary("/usr/share/dict/words");
		for(String s: args) {
			System.out.print(s + " : ");
			
			
			Set<String> col = (HashSet<String>) ID.signatureToWords(s);
			for(String word :col) {
				System.out.print(word + " "); 
			}
			System.out.println();
		}
		
		
	}
	}

