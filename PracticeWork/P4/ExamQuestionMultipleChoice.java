import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Tomohiro Furuya
 * @version 13 Nov 2017
 */
public class ExamQuestionMultipleChoice extends ExamQuestion{
	
	private ArrayList<String> possibleAnswers;
	private  ArrayList<Integer> correctAnswers;
	/**
	 * constructor of ExamQuestionMultipleChoice
	 * @param questionText questionText is text of question which will be given
	 * @param maximalMark maximal mark when someone get correct answer
	 * @param possibleAnswers is the list of possible answers which one of them is going to be answer
	 * @param correctAnswers is the list of correct answers about question
	 */
	public ExamQuestionMultipleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswers,
			ArrayList<Integer> correctAnswers) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswers = correctAnswers;
	}
	 /**
	  * method which is calculating a marks which is based on 
	  * how many correct answers and incorrect answers in the list of answer which someone provide
	  * @param answersProvided is the list of Answers which someone provided
	  * @return when correct answers is more than incorrect answers in the list of answer, the method calculate percentages of correct answers,
	  *  marks is give by maximalMark times percentage of correct answer, 
	  *  but when when correct answers is more than incorrect answers in the list of answer, mark is 0.
	  */
	public int mark(ArrayList<Integer> answersProvided) {
	double correctAnswer = 0;
	 double incorrectAnswer = 0;
	 /**
	  * Set<Integer> following 3 line of code is used for stop counting same number multiple times
	  */
     Set<Integer> hs = new HashSet<>();
	 hs.addAll(answersProvided);
	 answersProvided.clear();
	 answersProvided.addAll(hs);
		for(int i=0; i<answersProvided.size(); i++) {
          if ((correctAnswers.contains(answersProvided.get(i)) )) {
				 correctAnswer++;
          	}else {
			incorrectAnswer++;
          	} 
			}
		double mark = 0;
		if(correctAnswer > incorrectAnswer) 
		{
			mark = (int) Math.round((getMaximalMark()*((correctAnswer-incorrectAnswer)/correctAnswers.size())));

		}
		else { 
		 mark =	0;	
	}
	return (int) mark;
 }
	/**
	 * defines how to print about aeroplane
	 * print out detail of ExamQuestionSimpleChoice which is about maximalMark and QuestionText,
	 *  which come from ExamQuestion class, possibleAnswers and correctAnswers which come from ExamQuestionMultipleChoice
	 */
	@Override
	public String toString() {
		return super.toString() +"Possible answers are " + possibleAnswers + "."+" Correct answer position is " + correctAnswers
				+ ".";
	}
	
}

