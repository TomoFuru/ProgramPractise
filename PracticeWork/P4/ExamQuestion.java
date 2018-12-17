/**
 * 
 * @author Tomohiro Furuya
 * @version 10 Nov 2017
 */
public class ExamQuestion {
	
	private String questionText;
	private int maximalMark;
	/**
	 * constructor of ExamQuestion class
	 * @param questionText is text of question which will be given
	 * @param maximalMark is maximal mark when someone get correct answer
	 */
	public ExamQuestion(String questionText, int maximalMark) {
		super();
		this.questionText = questionText;
		this.maximalMark = maximalMark;
	}
	/**
	 * getter of questionText
	 * @return questionText of ExamQuestion as String
	 */
	public String getQuestionText() {
		return questionText;
	}
	/**
	 * getter of maximalMark
	 * @return maximalMark of ExamQuenstion as int
	 */
	public int getMaximalMark() {
		return maximalMark;
	}
	/**
	 * setter of ExamQuestion about questionText
	 * @param questionText is the new questionText of ExamQuestion
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	/**
	 * setter of ExamQuestion about maximalMark
	 * @param maximalMark is the new maximalMark of ExamQuestion
	 */
	public void setMaximalMark(int maximalMark) {
		this.maximalMark = maximalMark;
	}
	/**
	 * defines how to print about aeroplane
	 * print out detail of ExamQuestion which is about maximalMark and QuestionText
	 */
	@Override
	public String toString() {
		return "Question (maxdimal mark:" +  maximalMark+"):"+ questionText ;
	}
	
	
	
}
