import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Tomohiro Furuya
 * @version 16 OCT 2017
 */
public class ComplexTest {

	
	private Complex c1, c2,c3,c4,c5;
	private final static double EPSILON = 1e-6;
	
	@Before
	public void setUp() {
	     c1 = new Complex(2,3);
	     c2 = new Complex(4,8);
	     c3 = new Complex(0,3);
	     c4 = new Complex(7,0);
	     c5 = new Complex(9,13);
	}
    /**
     *  test1 is tested about addition formula of c1 and c2
     */
	@Test
	public void test1() {

		Complex c6 = c1.add(c2);
		
		assertEquals(6.0, c6.getRealPart(), EPSILON);
		assertEquals(11.0, c6.getImaginaryPart(), EPSILON);
		
		assertEquals(2.0, c1.getRealPart(),EPSILON);
		assertEquals(3.0, c1.getImaginaryPart(),EPSILON);
		
		assertEquals(4.0, c2.getRealPart(),EPSILON);
		assertEquals(8.0, c2.getImaginaryPart(),EPSILON);
		
		String expected = "6.0 + 11.0i";
		assertEquals("Your addition calculate is wrong!",expected, c6.toString());
	
	}
	/**
	 * test2 is tested about checking a multiply formula of c1 and c2
	 */
	@Test
	public void test2() {

		Complex c6 = c1.multiply(c2);
		
		assertEquals(-16.0, c6.getRealPart(), EPSILON);
		assertEquals(28.0, c6.getImaginaryPart(), EPSILON);
		
		assertEquals(2.0, c1.getRealPart(),EPSILON);
		assertEquals(3.0, c1.getImaginaryPart(),EPSILON);
		
		assertEquals(4.0, c2.getRealPart(),EPSILON);
		assertEquals(8.0, c2.getImaginaryPart(),EPSILON);
		
		String expected = "-16.0 + 28.0i";
		assertEquals("Your multiply calculation is wrong!",expected, c6.toString());
	
	}
	/**
	 * test3 is tested about checking an addition of c3 and c4
	 */
	@Test
	public void test3(){

		Complex c6 = c3.add(c4);
		
		assertEquals(7.0, c6.getRealPart(), EPSILON);
		assertEquals(3.0, c6.getImaginaryPart(), EPSILON);
		
		assertEquals(0.0, c3.getRealPart(),EPSILON);
		assertEquals(3.0, c3.getImaginaryPart(),EPSILON);
		
		assertEquals(7.0, c4.getRealPart(),EPSILON);
		assertEquals(0.0, c4.getImaginaryPart(),EPSILON);
		
		String expected = "7.0 + 3.0i";
		assertEquals("Your addition calculate is wrong!",expected, c6.toString());
	
	}
	/**
	 * test4 is tested about checking a multiply of c3 and c4
	 */
	@Test
	public void test4() {

		Complex c6 = c3.multiply(c4);
		
		assertEquals(0.0, c6.getRealPart(), EPSILON);
		assertEquals(21.0, c6.getImaginaryPart(), EPSILON);
		
		assertEquals(0.0, c3.getRealPart(),EPSILON);
		assertEquals(3.0, c3.getImaginaryPart(),EPSILON);
		
		assertEquals(7.0, c4.getRealPart(),EPSILON);
		assertEquals(0.0, c4.getImaginaryPart(),EPSILON);
		
		String expected = "0.0 + 21.0i";
		assertEquals("Your multiply calculation is wrong!",expected, c6.toString());
	
	}
	/**
	 * test5 is tested about an addition of c2 and c5
	 */
	@Test
	public void test5() {
		
		
		Complex c6 = c2.add(c5);
		
		assertEquals(13.0, c6.getRealPart(), EPSILON);
		assertEquals(21.0, c6.getImaginaryPart(), EPSILON);
		
		assertEquals(4.0, c2.getRealPart(),EPSILON);
		assertEquals(8.0, c2.getImaginaryPart(),EPSILON);
		
		assertEquals(9.0, c5.getRealPart(),EPSILON);
		assertEquals(13.0, c5.getImaginaryPart(),EPSILON);
		
		String expected = "13.0 + 21.0i";
		assertEquals("Your addition calculate is wrong!",expected, c6.toString());
	
	}
    /**
     * test6 is tested about checking multiply of c3 and c5
     */
	@Test
	public void test6() {
		
		
		Complex c6 = c3.multiply(c5);
		
		assertEquals(-39.0, c6.getRealPart(), EPSILON);
		assertEquals(27, c6.getImaginaryPart(), EPSILON);
		
		assertEquals(0.0, c3.getRealPart(),EPSILON);
		assertEquals(3.0, c3.getImaginaryPart(),EPSILON);
		
		assertEquals(9.0, c5.getRealPart(),EPSILON);
		assertEquals(13.0, c5.getImaginaryPart(),EPSILON);
		
		String expected = "-39.0 + 27.0i";
		assertEquals("Your multiply calculation is wrong!",expected, c6.toString());
	
	}
}
