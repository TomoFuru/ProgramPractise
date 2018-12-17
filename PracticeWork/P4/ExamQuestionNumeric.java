/**
 * 
 * @author Tomohiro Furuya
 * @version 10 Nov 2017
 */
public class ExamQuestionNumeric extends ExamQuestion{
		 private int numericAnswer;
		/**
		 * constructor of ExamQuestionNumeric class
		 * @param questionText questionText is text of question which will be given
		 * @param maximalMark is maximal mark when someone get correct answer
		 * @param numericAnswer is answer of Question which will be given
		 */
		public ExamQuestionNumeric(String questionText, int maximalMark, int numericAnswer) {
			super(questionText, maximalMark);
			this.numericAnswer = numericAnswer;
		}
		/**
		 * 
		 * @param value is the value which is offered by answerer who solve the question
		 * @return if value is same as numericAnswer of Question, MaximalMark will be returned, 
		 * whereas value isn't same as maximalMark ,  mark will be 0.
		 */
		public int mark(int value) {
		
			if(numericAnswer == value) {
				 return getMaximalMark();
			}else 
					return 0;
				
			}
		/**
		 * defines how to print about aeroplane
		 * print out detail of ExamQuestionNumeric which is about maximalMark and QuestionText,
		 *  which come from ExamQuestion class and numericAnswer come from ExamQuestionNumeric class
		 */
		@Override
		public String toString() {
			return super.toString() +" Correct answer is:" + numericAnswer  ;
		}
}
		

		// TODO Auto-generated constructor stub
		
		

	
	


