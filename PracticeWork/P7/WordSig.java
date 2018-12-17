package predictive;
/**
 * wordSig method for ex2
 * @author Tomohiro Furuya
 * @version 4 Feb 2018
 */
public class WordSig implements Comparable<WordSig> {

	private String words;
	private String signature;
	
	public WordSig(String words, String signature) {
		//super();
		this.words = words;
		this.signature = signature;
	}
	
	public String getWords() {
		return words;
	}

	public String getSignature() {
		return signature;
	}

	@Override
	public int compareTo(WordSig ws) {
		return this.getSignature().compareTo(ws.getSignature());
	}
		
	

	@Override
	public String toString() {
		return  words + " : " + signature;
	}
	
}
