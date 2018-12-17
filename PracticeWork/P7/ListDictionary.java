package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 * WS2-4-part2
 * @author Tomohiro Furuya
 * @version 4 Feb
 */
public class ListDictionary implements Dictionary {

	
	private ArrayList<WordSig> dictionary;

	
	

/**
 * The ListDictionary constructor takes in a file destination and
 * creates a ListDictionary 
 * @param path is the String it will read the text file of word
 */
	  public ListDictionary(String path) {
		 //  this.path = path;
		  // this.dictionary = dictionary;
		 dictionary = new ArrayList<WordSig>();  
		    Scanner scanList;
		    try {
		    	File wordsFile = new File(path);
		    	scanList = new Scanner(wordsFile);
		      while (scanList.hasNext()) {
		        String words = scanList.next().toLowerCase();
		        String signature = wordToSignature(words);
		        if(isValidWord(words)) {
		        	dictionary.add(new WordSig(words, signature));
		        }
		      }
		    } catch (FileNotFoundException e) {
		      System.out.println("No dictionary file found");
		    }
		   Collections.sort(dictionary);
		  }

	  /**
	   * Getter method to retrieve the pairs arrayList
	   * @return the object arrayList of WordSig pairs of ordered words and signatures
	   */
	  public ArrayList<WordSig> getDictionary() {
		return dictionary;
	}

	  /**
	   * this method check the dictionary lines whether it is non-alphabetic characters or not
	   * @param word is String that is given 
	   * @return true when lines is with alphabetic characters
	   */
	  
	 
	   static boolean isValidWord(String word){

			word = word.toLowerCase();

			char checkWord;
			for(int i = 0; i < word.length(); i++){
				checkWord = word.charAt(i);

				if((checkWord < 97 || checkWord > 122)){ 
					return false;
				}

			}

			return true;

		}
	

	   /**
		 * this method takes a word and return a numeric signature
		 * @param word is String that is given 
		 * @return numeric signature that is related to a word which people input
		 */
	public static String wordToSignature(String word) {
		
		StringBuffer numWord = new StringBuffer("");
		word = word.toLowerCase();
		
		for(int i= 0; i < word.length(); i++) {
			
			char cutWord = word.charAt(i);
					
			 if(cutWord=='a'||cutWord=='b'||cutWord=='c') {
				 numWord.append(2); 
			 }   
			 else if(cutWord=='d'||cutWord=='e'||cutWord=='f') {
				 numWord.append(3); 
			 }
			 else if(cutWord=='g'||cutWord=='h'||cutWord=='i'){
				 numWord.append(4); 
			 }
			 else if(cutWord=='j'||cutWord=='k'||cutWord=='l') {
				 numWord.append(5); 
			 }	
			 else if(cutWord=='m'||cutWord=='n'||cutWord=='o') {
				 numWord.append(6); 
			 }
			 else if(cutWord=='p'||cutWord=='q'||cutWord=='r'|| cutWord=='s') {
				 numWord.append(7); 
			 }
			 else if(cutWord=='t'||cutWord=='u'||cutWord=='v') {
				 numWord.append(8); 
			 }
			 else if(cutWord=='w'||cutWord=='x'||cutWord=='y'||cutWord=='z') {
				 numWord.append(9); 
			 }else {
				 numWord.append(" "); 
			 }
				 
			 }
		 return numWord.toString();
	}

	/**
	 * method takes given numeric signature and return a set of possible matching words
	 * @param signature is a String as input signature 
     * @return HashSet containing the signature and all words associated with it  
	  */
	public Set<String> signatureToWords(String signature){
		
		Set<String> signMatch= new HashSet<String>();
		
		WordSig wordMatch = new WordSig("", signature);
		int index = Collections.binarySearch(dictionary, wordMatch);
		int indexCounter = index ;

		if(index < 0) {
			return signMatch;
		}else{
			signMatch.add(dictionary.get(index).getWords());
			 int blowCounter = indexCounter;
			 int aboveCounter = indexCounter;
			 while (signature.equals(dictionary.get(blowCounter).getSignature())) {
				 signMatch.add(dictionary.get(blowCounter).getWords());
	                blowCounter--;
	                if (blowCounter < 0) {
	                    break;
	                    
	                }
	            }
	            
	            while (signature.equals(dictionary.get(aboveCounter).getSignature())) {
	            	signMatch.add(dictionary.get(aboveCounter).getWords());
	            	aboveCounter++;
	                if (aboveCounter == dictionary.size()) {
	                    break;
	                    
	                }
	            }
	        }
	        return signMatch;
	    }	
			
}
/**
 * time measurement test I used a words.text file that is uploaded on canvas
 *Last login: Wed Feb  7 10:42:32 on ttys000
MacBook-Air:~ Tomo$ cd /Applications/WS2-3/bin/predictive
MacBook-Air:predictive Tomo$  time java -cp .. predictive.Sigs2WordsProto 4663 7654 0987 3467865 986 87 23 
4663: [hood, ione, good, gond, hone, hoof, gone, goof, home]
7654: [soli]
0987: []
3467865: []
986: [wun, yun]
87: [up, ur, us]
23: [ce, ad, be, ae]

real	0m3.749s
user	0m4.341s
sys	0m0.589s
MacBook-Air:predictive Tomo$  time java -cp .. predictive.Sigs2WordsList 4663 7654 0987 3467865 986 87 23 
4663 : hood ione good gond hone hoof gone goof home 
7654 : soli 
0987 : 
3467865 : 
986 : wun yun 
87 : up ur us 
23 : ce ad be ae 

real	0m1.200s
user	0m2.587s
sys	0m0.149s

10s

 */

