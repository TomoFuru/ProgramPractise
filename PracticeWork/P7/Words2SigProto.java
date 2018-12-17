package predictive;
/**
 * main method for ex1
 * @author Tomohiro Furuya
 * @version 4 Feb 2018
 */
public class Words2SigProto {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(PredictivePrototype.wordToSignature(args[i]));
		}
	}
}
