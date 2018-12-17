import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;


/**
 * WS2-4
 * @author Tomohiro Furuya
 * @version 17 Feb 2018
 */
public class DictionaryModel extends Observable implements DictionaryModelInterface{

	private TreeDictionary treeDictionary;
	private String path;
	private String textMessage;
	private String signature;
	private String word;
	private Set<String> predictedWords;
	private ArrayList<String> wordList;
	private List<String> currentWordlist;
	private int index;
	
	
	/**
	 * First constructor is taking the dictionaryFile path.
	 * Calls the reFresh() method to update changes.
	 * @param dictionaryFile is String
	 * @throws IOException 
	 */
	public DictionaryModel(String dictionaryFile) throws IOException{
		
		treeDictionary = new TreeDictionary(dictionaryFile); // Creates the tree
		reFresh();
	}
	/**
	 * This constructor which takes word file whatever user want
	 * Calls the reFresh() method to update changes
	 * @throws IOException
	 */
	public DictionaryModel() throws IOException{
		// this.path =  "/usr/share/dict/words";
		treeDictionary = new TreeDictionary  ("/Applications/WS2-4/words.txt");
		 reFresh();
		// this.treeDictionary = new TreeDictionary("/Applications/WS2-3/words.txt");	
		 
	}
	
	/**
	 * Getter for treeDictionary
	 * @return treeDicitionary as TreeDictionary
	 */
	public TreeDictionary getTreeDictionary() {
		return treeDictionary;
	}

	/**
	 * Getter for textMessage
	 * @return textMessage as String
	 */
	public String getTextMessage() {
		return textMessage;
	}

	/**
	 * Getter for signature
	 * @return signature as String
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * Getter for word
	 * @return word as String
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Getter for predictedWords
	 * @return predictedWord as Set<String>
	 */
	public Set<String> getPredictedWords() {
		return predictedWords;
	}

	/**
	 * Getter for WordList
	 * @return wordList as ArrayList
	 */
	public ArrayList<String> getWordList() {
		return wordList;
	}

	
	/**
	 * Getter for CurrentWord
	 * @return currentWord as List<String>
	 */
	public List<String> getCurrentWordlist() {
		return currentWordlist;
	}

	

	
	/**
	 * Helper method.
	 * The reFresh method - reFresh can also empty the field variable for re-assignment.
	 * Signature - used to translate the signature into words.
	 * predictedWords - connecting signature and word.
	 * Word - word that is chosen
	 *  currentWordListcontaining - the text presented.
	 * index is used to select the next potential word.
	 */
	
    public void reFresh() {
		
		signature = "";
		word = ""; 
		textMessage = "";
		currentWordlist = new ArrayList<String>();
		predictedWords = new TreeSet<String>();
		wordList = new ArrayList<String>();
		index = 0;
		
	}
    /**
     * Helper method
     * this method check given string is empty or not
     * @param str
     * @return when str is empty, return true, otherwise return false
     */
	public static boolean isEmpty(String str) {
		boolean isEmpty = (str == null || str.trim().length() == 0);
		return isEmpty; 
	}
	

	/**
	 * Helper method
	 * this method adds potential words to an array list.
	 */
	public void addWords() {
		
		 wordList = new ArrayList<String>(); // Resets list
		 
	     Iterator<String> it = predictedWords.iterator();
	     
	     while(it.hasNext()){
	    	 wordList.add(it.next());
	     }
	}
	/**
	 * this method return alist of the word that typed in, is including the last word 
	 */
	@Override
	public List<String> getMessage() {
		currentWordlist = new ArrayList<String>(Arrays.asList(textMessage.split("\\s+")));
		currentWordlist.add(word); // Adds current word
		return currentWordlist;
	}

	/**
	 * this method add numeric key that has been typed in by the user 
	 * this method extends the current word with possible mmatches for new key
	 */
	@Override
	public void addCharacter(char key) {
		signature += key; // Adds character to the sig;
		predictedWords = treeDictionary.signatureToWords(signature);
		addWords(); // Adds new word
		
		word = wordList.get(index); 

		setChanged();
		notifyObservers(); // notify view
	}

	/**
	 * this method removes the last character typed in 
	 */
	@Override
	public void removeLastCharacter() {

		if (isEmpty(word) && !isEmpty(textMessage)) {
			textMessage = textMessage.substring(0, textMessage.length() - 1);
		} else if (!isEmpty(word) && !isEmpty(signature)) {
				signature = signature.substring(0, signature.length() - 1);
				word = word.substring(0, word.length() - 1);

				wordList = new ArrayList<String>(treeDictionary.signatureToWords(signature));
				wordList.add(word);

			
		}else {
			reFresh();
		}
	
	setChanged();
	notifyObservers();
	}

	/**
	 * this method cycles through the possible matches for current word
	 */
	@Override
	public void nextMatch() {
		
		    if (index + 1 < wordList.size()) {
		      word = wordList.get(index += 1);
		    } else {
		      index = 0;
		      word = wordList.get(index);
		    }
		    setChanged();
		    notifyObservers();
		  }

	/**
	 * this method accepts the current mutch word and adds it to the composed message
	 */
	@Override
	public void acceptWord() {
        textMessage += " " + word; 
		word = "";
		signature = "";
		predictedWords = new TreeSet<String>();
		wordList = new ArrayList<String>();
		index = 0;

		addWords();
		setChanged();
		notifyObservers(); // Notify view
		
	}
	
	
	
}
