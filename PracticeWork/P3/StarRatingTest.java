import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StarRatingTest {
   @Rule 
   public final ExpectedException exception = ExpectedException.none();
	@Before
	public void setUp() throws Exception {
	}

	 /**
     *  test1 is tested about rating 5.0
     */
    @Test
    public void test1() {
		
        double rating = 5.0;
		
        String expected = "[HAS ONLY ONE REVIEW]";
        String actual = StarRating.interpret(rating);
		
        assertEquals("Your starrating method is wrong!",expected, actual);
    }
	 
    /**
     *  test2 is tested about rating 3.3
     */
    @Test
    public void test2() {
		
        double rating = 3.3;
		
        String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals("Your starrating method is wrong!",expected, actual);
    }
   
    /**
     *  test3 is tested about checking about IllegalArgumentException
     */
    @Test
    public void test3() {
		
        double rating = 100;
		
        exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
    }
   
    /**
     *  test6 is tested about rating 1.5
     */
    @Test
    public void test4() {
		
        double rating = 1.5;
		
        String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals("Your starrating method is wrong!",expected, actual);
    }
    /**
     *  test7 is tested about checking about IllegalArgumentException
     */
    @Test
    public void test5() {
		
        double rating = -4.2;
		
       exception.expect(IllegalArgumentException.class);
        StarRating.interpret(rating);
			
    }
   
    /**
     *  test8 is tested about rating 3.0
     */
    @Test
    public void test6() {
		
        double rating = 3.0;
		
        String expected = "CRAP";
        String actual = StarRating.interpret(rating);
		
        assertEquals("Your starrating method is wrong!",expected, actual);
    }
	
   
}


