package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * WS2-3 EX3
 * @author Tomohoiro Furuya
 * @version 12 Fab 2018
 */
public class MapDictionary implements Dictionary{
	
	private Map<String, HashSet<String>> diction = new HashMap<>();

	
	

	/**
	 * The MapDictionary constructor takes in a file destination and
	 * creates a MapDictionary 
	 * @param path is the String it will read the text file of word
	 */
		  public MapDictionary(String path) {
			  
			    Scanner scanList;
			    try {
			    	File wordsFile = new File(path);
			    	scanList = new Scanner(wordsFile);
			      while (scanList.hasNext()) {
			        String words = scanList.next().toLowerCase();
			        String signature = wordToSignature(words);
			        if(diction.containsKey(signature)) {
			        	HashSet<String> matchingWords = diction.get(signature);
			        if(!matchingWords.contains(words)) {
			         if(isValidWord(words)) {
			          	matchingWords.add(words);
			        }
			      diction.put(signature, matchingWords);
			        }}else {
			    	 	HashSet<String> matching = new HashSet<>();
			    	  if(isValidWord(words)) {
			      }
			        	matching.add(words);
			        diction.put(signature, matching);
			        	}
			     }
			    }catch (FileNotFoundException e) {
			      System.out.println("No dictionary file found");
			    }
			   //Collections.sort(diction);
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
			@Override
			public Set<String> signatureToWords(String signature) {
				if(diction.containsKey(signature)){
					return diction.get(signature);
				}
				else {
					return new HashSet<String>();
				}
			}
			
		
}
