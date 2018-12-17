

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * WS2-4EX4
 * @author Tomohiro Furuya
 * @version 14 Feb 2018
 */
public class TreeDictionary implements Dictionary{
	
	
	
	private TreeDictionary[] treeDictionary = new TreeDictionary[8];
	  private Set<String> words;

	  /**
	   * Constructor for creating empty treeDicitonary
	   */
	  public TreeDictionary() {
	    for (int i = 0; i < treeDictionary.length; i++) {
	      treeDictionary[i] = null;
	    }
	    words = new HashSet<>();
	  }
	  /**
		 * The TreeDictionary constructor takes in a file destination and set to store the words
		 * creates a TreeDictionary 
		 * @param path is the String it will read the text file of word
		 */
	  public TreeDictionary(String path) {

	    for (int i = 0; i < treeDictionary.length; i++) {
	      treeDictionary[i] = new TreeDictionary();
	    }
	    words = new HashSet<>();
	    Scanner scanList;
	    try {
	    	File wordsFile = new File(path);
	    	scanList = new Scanner(wordsFile);
	      while (scanList.hasNextLine()) {
	        String word = scanList.nextLine().toLowerCase();
	        if (isValidWord(word)) {
	          String signature = wordToSignature(word);
	          int key = (int) signature.charAt(0) - 48;
	          treeDictionary[key - 2].addToTree(word, signature, 1);
	        }
	      }
	    } catch (FileNotFoundException e) {
	      System.out.println("No File Found!");
	    }
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
	 * this method add a word to tree 
	 * @param word is a String that is linked to inputed number
	 * @param signature is String that is input signature
	 * @param wordLetter is Integer that is input number that is linked to word
	 */
	  public void addToTree(String word, String signature, int wordLetter) {

	    words.add(word);
	    if (signature.length() > wordLetter) {
	      int key = signature.charAt(wordLetter) - 48;
	      wordLetter++;
	      if (treeDictionary[key - 2] == null) {
	        treeDictionary[key - 2] = new TreeDictionary();
	      }
	      treeDictionary[key - 2].addToTree(word, signature, wordLetter);
	    }
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
	     * @return Set containing the signature and all words associated with it  
		 */
	  public Set<String> signatureToWords(String signature) {
	    Set<String> matchingWords = new HashSet<>();
	    for (String word : signToWordsHelper(signature)) {
	      matchingWords.add(word.substring(0, (signature.length())));
	    }
	    return matchingWords;
	  }
	/**
	 * method is helper method for signatureToWords method
	 * @param signature is a String as input signature
	 * @return treeDictionary as array which is consisted of number that is linked to words
	 */
	  public Set<String> signToWordsHelper(String signature) {
	    if (signature.isEmpty()) {
	      return words;
	    } else {
	      int key = (int) signature.charAt(0) - 48;
	      return treeDictionary[key - 2].signToWordsHelper(signature.substring(1));
	    }
	  }
	 
}

/**
 * Compare speed between ex3 and ex4. Ex3 is fater than ex4 but ex4 can pick up not only word 
 * that is completely same as number but olso prefix
 * MacBook-Air:predictive Tomo$  time java -cp .. predictive.Sigs2WordsTree 4663 7654 986 87 23 
4663 : inoe inod hood inme ioof ione imme good inne hond inof hooe hone gond hoof gooe gnof home gone goof honf gome gonf 
7654 : solg poli poki soli rnli soki 
986 : yum wun zun zum yvo yun zto wum 
87 : vp up tp vr ur tq vs tr us ts 
23 : cd ce bd be ad cf ae bf af 

real	0m9.058s
user	0m23.741s
sys	0m0.836s
MacBook-Air:predictive Tomo$  time java -cp .. predictive.Sigs2WordsMap 4663 7654 986 87 23 
4663 : hood ione ioof good hond inne gond hone hoof gone goof home gome 
7654 : rnli soli 
986 : yum wun yun 
87 : vp up tp vr ur vs tr us ts 
23 : cd bd ce ad be cf ae bf af 

real	0m2.554s
user	0m5.922s
sys	0m0.308s
MacBook-Air:predictive Tomo$ 

 */

	


