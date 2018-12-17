package predictive;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * WS2-3-part1
 * @author Tomohiro Furuya
 * @version 3 Feb 2018 
 */
public class PredictivePrototype {

	/**
	 * this method takes a word and return a numeric signature
	 * I useed StringBuffer because It was better to use StringBuffer as String are immutable, 
	 * but StringBuffers are not and given we need to constantly append it was better to use StringBuffer.
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
	 * @param signature is String that is given
	 * @return a set of possible words from a dictionary that is read
	 */
	public static Set<String> signatureToWords(String signature){
	
		Set<String> signMatch = new HashSet<String>();
		
		try {
		//	File wordsFile = new File("/Applications/WS2-3/words.txt");
			File wordsFile = new File("/usr/share/dict/words");
			Scanner scanList = new Scanner(wordsFile);
		while(scanList.hasNextLine()) {
			String predictedWord = scanList.nextLine();
			if(wordToSignature(predictedWord).equals(signature)&& isValidWord(predictedWord)) {
			signMatch.add(predictedWord.toLowerCase());
		}
		}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file to open.");
		//	e.printStackTrace(); //
			//System.exit(1);
		}

		return signMatch;
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


	
	 
	public static void main(String[] args) {
	    String signature = "43556";
	    Set<String> matches = PredictivePrototype.signatureToWords(signature);
	    for (String s : matches) {
	      System.out.println(s);
	    }
	  }
	
	
		
	
		
	}

