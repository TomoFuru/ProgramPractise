import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ContainsTest {
	@Rule 
	   public final ExpectedException exception = ExpectedException.none();
	@Before
	public void setUp() throws Exception {
	}

	

		/**
	     *  test1 is tested about picking number which is contained 4 between 14 and 54
	     */
	    @Test
	    public void test1() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(14,24,34,40,41,42,43,44,45,46,47,48,49,54));
	        ArrayList<Integer> actual = Contains.allIntergersWith(14, 55, 4);
				
	        assertEquals("Your method picked up wrong number!!",expected, actual);
				
	    }
			
	    /**
	     *  test2 is tested about picking number which is contained 6 between 78 and 83
	     */
	    @Test
	    public void test2() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList());
	        ArrayList<Integer> actual = Contains.allIntergersWith(78,84, 6);
				
	        assertEquals("Your method picked up wrong number!!",expected, actual);
				
	    }
			
	    /**
	     *  test3 is tested about picking number which is contained 1 between -11 and 29
	     */
	    @Test
	    public void test3() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(-11,-10,-1,1,10,11,12,13,14,15,16,17,18,19,21));
	        ArrayList<Integer> actual = Contains.allIntergersWith(-11, 30, 1);
				
	        assertEquals("Your method picked up wrong number!!",expected, actual);
				
	    }

	    /**
	     *  test4 is tested about picking negative numbers which is contained 5
	     */
	    @Test
	    public void test4() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(-45, -35, -25, -15));
	        ArrayList<Integer> actual = Contains.allIntergersWith(-49, -14, 5);
				
	        assertEquals("Your method picked up wrong number!!",expected, actual);
				
	    }
			
	    /**
	     *  test5 is tested about picking numbers which are contained 0 between 90 and 121
	     */
	    @Test
	    public void test5() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(90,100, 101, 102, 103, 104, 105, 106, 107, 108, 109,110,120));
	        ArrayList<Integer> actual = Contains.allIntergersWith(90, 121, 0);
				
	        assertEquals("Your method picked up wrong number!!",expected, actual);
				
	    }

	    /**
	     *  test6 is tested about picking numbers which are contained 0 between 0 and 9
	     */
	    @Test
	    public void test6() {

	        ArrayList<Integer> expected = new ArrayList<Integer>
	            (Arrays.asList(0));
	        ArrayList<Integer> actual = Contains.allIntergersWith(0, 10, 0);
				
	        assertEquals("Your method picked up wrong number!!",expected, actual);
				
	    }
	}

