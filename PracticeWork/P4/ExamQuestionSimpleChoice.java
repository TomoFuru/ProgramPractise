import java.util.ArrayList;
/**
 * 
 * @author Tomohiro Furuya
 * @version 1 Nov 2017
 */
public class ExamQuestionSimpleChoice extends ExamQuestion{
        
	private ArrayList<String> possibleAnswers;
	private  int correctAnswer;
	/**
	 * constructor of ExamQuestionSimple class
	 * @param questionText questionText is text of question which will be given
	 * @param maximalMark is maximal mark when someone get correct answer
	 * @param possibleAnswers is the list of possible answers which one of them is going to be answer
	 * @param correctAnswer is the answer of question which is a choice from the list
	 */
	public ExamQuestionSimpleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswers,
			int correctAnswer) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}
	/**
	 * @param value is the value which is offered by answerer who solve the question
	 * @return if value is same as correctAnswer of Question, MaximalMark will be returned, 
	 * whereas value isn't same as maximalMark ,  mark will be 0.
	 */
	public int mark(int value) {
		if(correctAnswer == value) {
			 return getMaximalMark();
		}else {
				return 0;
		}
		}
	/**
	 * defines how to print about aeroplane
	 * print out detail of ExamQuestionSimpleChoice which is about maximalMark and QuestionText,
	 *  which come from ExamQuestion class, possibleAnswers and correct answer which come from ExamQuestionSimpleChoice
	 */
	@Override
	public String toString() {
		return super.toString() + "Possible answers are:" + possibleAnswers + "Correct answer position is:" + correctAnswer;
	}
}

