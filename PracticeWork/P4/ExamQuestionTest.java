import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Tomohiro Furuya
 * @version 15 Nov 2017
 */
public class ExamQuestionTest {

	
    private ExamQuestion question1, question2;
    private ExamQuestionNumeric numericQuestion1,numericQuestion2,numericQuestion3;
private ExamQuestionSimpleChoice simpleChoiceQuestion1,simpleChoiceQuestion2,simpleChoiceQuestion3;
private ExamQuestionMultipleChoice multipleChoiceQuestion1,multipleChoiceQuestion2;
/**
 * before carrying out the tests, we need set a some variances which is related to each classes and methods
 */
@Before
public void setup(){
	question1 = new ExamQuestion("What is 7 times 5?", 1000);
	question2 = new ExamQuestion("What is 11 plus 111?", 10);
	
	numericQuestion1 = new ExamQuestionNumeric("What is 10 divided by 2?", 10, 5);
	numericQuestion2 = new ExamQuestionNumeric("What is 111 minus 1?", 250, 110);
	numericQuestion3 = new ExamQuestionNumeric("What is 5 plus 3?", 100, 8);
	
	ArrayList<String> simpleChoiceAnswers1 = new ArrayList<String>(Arrays.asList("7","4","9","5","14"));
	simpleChoiceQuestion1 = new ExamQuestionSimpleChoice("What is 7 plus 2?", 10, simpleChoiceAnswers1, 3);
	
	ArrayList<String> simpleChoiceAnswers2 = new ArrayList<String>(Arrays.asList("1","6","10","23","-6","0"));
	simpleChoiceQuestion2 = new ExamQuestionSimpleChoice("What is 2 times 3?", 100, simpleChoiceAnswers2, 2);
	
	ArrayList<String> simpleChoiceAnswers3 = new ArrayList<String>(Arrays.asList("Munich","Hamburg","Berlin","Frankfurt"));
	simpleChoiceQuestion3 = new ExamQuestionSimpleChoice("Which is the capital of Germany ?", 100, simpleChoiceAnswers3, 3);

	ArrayList<String> possibleAnswers1 = new ArrayList<>(Arrays.asList("0","-4","-2","1","2","4"));
	ArrayList<Integer> correctAnswers1 = new ArrayList<>(Arrays.asList(1,5,6));
	multipleChoiceQuestion1 = new ExamQuestionMultipleChoice("x*x*x-6*x*x+8*x = 0", 10, possibleAnswers1, correctAnswers1);

	ArrayList<String> possibleAnswers2 = new ArrayList<>(Arrays.asList("-4","0","2","4","-2"));
	ArrayList<Integer> correctAnswers2 = new ArrayList<>(Arrays.asList(1, 4));
	multipleChoiceQuestion2 = new ExamQuestionMultipleChoice("x * x = 16", 10, possibleAnswers2, correctAnswers2);
	
}
	/**
	 *  Test1 checks about string method of Question
	 */
    @Test
    public void test1() {
            int actual1 =  question1.getMaximalMark();
            int actual2 =  question2.getMaximalMark();

            int expected1 = 1000;
            int expected2 = 10;

            assertEquals("Mark is wrong!",expected1,actual1);
            assertEquals("Mark is wrong!",expected2,actual2);

            String actual3 = question1.getQuestionText();
            String expected3 = "What is 7 times 5?";

            String actual4 = question2.getQuestionText();
            String expected4 = "What is 11 plus 111?";

            assertEquals("Question is wrong!",expected3,actual3);
            assertEquals("Question is wrong!",expected4,actual4);

    }
            
    /**
     * Test2 checks about numericQuestion in different max marks.
     */
    @Test
public void test2(){
	
	int expected1 = 10;
	int actual1 = numericQuestion1.mark(5);
	
	int expected2 = 0;
	int actual2 = numericQuestion2.mark(112);
	
	int expected3 = 250;
	int actual3 = numericQuestion2.mark(110);
	
	int expected4 = 100;
	int actual4 = numericQuestion3.mark(8);
	
	assertEquals("numericQuestion method has a problem!",expected1, actual1);
	assertEquals("numericQuestion method has a problem!",expected2, actual2);
	assertEquals("numericQuestion method has a problem!",expected3, actual3);
	assertEquals("numericQuestion method has a problem!",expected4, actual4);
	
}

/**
 *  Test3 checks about simpleChoiceQuestion in 2 cases which is about get maximum mark and 0 mark
 */
@Test
public void test3() {
	
	int expected1 = 10;
	int actual1 = simpleChoiceQuestion1.mark(3);
	
	int expected2 = 100;
	int actual2 = simpleChoiceQuestion2.mark(2);
	
	int expected3 = 0;
	int actual3 = simpleChoiceQuestion3.mark(1);
	
	int expected4 = 100;
	int actual4 = simpleChoiceQuestion3.mark(3);
	
	assertEquals("simpleChoiceQuestion has a problem!",expected1, actual1);
	assertEquals("simpleChoiceQuestion has a problem!",expected2, actual2);
	assertEquals("simpleChoiceQuestion has a problem!",expected3, actual3);
	assertEquals("simpleChoiceQuestion has a problem!",expected4, actual4);
}

/**
 * Test5 check about multipleChoicequestion in get half mark because there are same answer in ArrayList
 */
@Test
public void test4() {
	
	ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(4, 4));
	
	int expected = 5;
	int actual = multipleChoiceQuestion2.mark(givenAnswers);
	
	assertEquals("multipleChoiceQuestion has a problem!",expected, actual);

}

/**
 * Test5 check about multipleChoicequestion in get mark or mark is o case 
 */
@Test
public void test5() {
	
	ArrayList<Integer> givenAnswers1 = new ArrayList<>(Arrays.asList(1, 5, 6));
	ArrayList<Integer> givenAnswers2 = new ArrayList<>(Arrays.asList(1, 2,3,4,5));
	
	int expected1 = 10;
	int actual1 = multipleChoiceQuestion1.mark(givenAnswers1);
	
	int expected2 = 0;
	int actual2 = multipleChoiceQuestion1.mark(givenAnswers2);
	
	assertEquals("multipleChoiceQuestion has a problem!",expected1, actual1);
	assertEquals("multipleChoiceQuestion has a problem!",expected2, actual2);
}

/**
 *  Test6 checks about multipleChoicequestion in get mark or mark is o case 
 */
@Test
public void test6() {
	
	ArrayList<Integer> givenAnswers1 = new ArrayList<>(Arrays.asList(1,4));
	ArrayList<Integer> givenAnswers2 = new ArrayList<>(Arrays.asList(2,5));
	
	int expected1 = 10;
	int actual1 = multipleChoiceQuestion2.mark(givenAnswers1);
	
	int expected2 = 0;
	int actual2 = multipleChoiceQuestion2.mark(givenAnswers2);
	
	assertEquals("multipleChoiceQuestion has a problem!",expected1, actual1);
	assertEquals("multipleChoiceQuestion has a problem!",expected2, actual2);
}
}


