import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArrayMethodsTest {
	
	@Before
	public void setUp() throws Exception {
	}

	public final ExpectedException exception = ExpectedException.none();

	private final static double EPSILON = 1e-6;

	/**
     *  test1 is tested every value in 6 numbers
     */
	@Test
	public void test1() {

		double[][] a = { { 7, 4.1, 1.1 }, { -5.2, 4.8, 8.6 } };

		double expectedMin = -5.2;
		double expectedMax = 8.6;
		double expectedMean = 3.4;
		double expectedMedian = 4.45;

		assertEquals("Your minimum calculate is wrong!",expectedMin, ArrayMethods.min(a), EPSILON);
		assertEquals("Your maximum calculate is wrong!",expectedMax, ArrayMethods.max(a), EPSILON);
		assertEquals("Your mean calculate is wrong!",expectedMean, ArrayMethods.mean(a), EPSILON);
		assertEquals("Your median calculate is wrong!",expectedMedian, ArrayMethods.median(a), EPSILON);
	}

	/**
     *  test2 is tested every value in 6 numbers without decimal
     */
	@Test
	public void test2() {

		double[][] a = { { 7,8,9 }, { 10,11,12 } };

		double expectedMin = 7;
		double expectedMax = 12;
		double expectedMean = 9.5;
		double expectedMedian = 9.5;

		assertEquals("Your minimum calculate is wrong!",expectedMin, ArrayMethods.min(a), EPSILON);
		assertEquals("Your maximum calculate is wrong!",expectedMax, ArrayMethods.max(a), EPSILON);
		assertEquals("Your mean calculate is wrong!",expectedMean, ArrayMethods.mean(a), EPSILON);
		assertEquals("Your mediam calculate is wrong!",expectedMedian, ArrayMethods.median(a), EPSILON);
	}

	/**
     *  test3 is tested about IllegalArgumentException
     */
	@Test
	public void test3() {

		double[][] a = { {} };
		exception.expect(IllegalArgumentException.class);
		ArrayMethods.mean(a);
	}

	/**
     *  test4 is tested every value in 6 numbers without decimal
     */
	@Test
	public void test4() {

		double[][] a = { { 2.4,5.8,7.9 },{1.3}, { 9.2, -6.7 } };

		double expectedMin = -6.7;
		double expectedMax = 9.2;
		double expectedMean = 3.316666666666666;
		double expectedMedian = 4.1;

		double actualMin = ArrayMethods.min(a);
		double actualMax = ArrayMethods.max(a);
		double actualMean = ArrayMethods.mean(a);
		double actualMedian = ArrayMethods.median(a);

		assertEquals("Your minimum calculate is wrong!",expectedMin, actualMin, EPSILON);
		assertEquals("Your maximum calculate is wrong!",expectedMax, actualMax, EPSILON);
		assertEquals("Your mean calculate is wrong!",expectedMean, actualMean, EPSILON);
		assertEquals("Your median calculate is wrong!",expectedMedian, actualMedian, EPSILON);
	}

	/**
     *  test5 is tested every value in 4d arrays with huge value number
     */
	@Test
	public void test5() {

		double[][] a = { { 8.0,23.0,7.0,13.0 }, { -4.6, 7.1, 4.0 }, { 6.8, 7.2, }, { -7.2} };

		double expectedMin = -7.2;
		double expectedMax = 23.0;
		double expectedMean = 6.43;
		double expectedMedian = 7.05;

		double actualMin = ArrayMethods.min(a);
		double actualMax = ArrayMethods.max(a);
		double actualMean = ArrayMethods.mean(a);
		double actualMedian = ArrayMethods.median(a);

		assertEquals("Your minimum calculate is wrong!",expectedMin, actualMin, EPSILON);
		assertEquals("Your maximum calculate is wrong!",expectedMax, actualMax, EPSILON);
		assertEquals("Your mean calculate is wrong!",expectedMean, actualMean, EPSILON);
		assertEquals("Your median calculate is wrong!",expectedMedian, actualMedian, EPSILON);
	}
	/**
     *  test6 is tested every value in 7D arrays with huge value number
     */
	@Test
	public void test6() {

		double[][] a = { {0.9},{1.5},{3.7},{2.4},{5.8},{1.2},{6.9}};

		double expectedMin = 0.9;
		double expectedMax = 6.9;
		double expectedMean = 3.2;
		double expectedMedian = 2.4;

		double actualMin = ArrayMethods.min(a);
		double actualMax = ArrayMethods.max(a);
		double actualMean = ArrayMethods.mean(a);
		double actualMedian = ArrayMethods.median(a);

		assertEquals("Your minimum calculate is wrong!",expectedMin, actualMin, EPSILON);
		assertEquals("Your maximum calculate is wrong!",expectedMax, actualMax, EPSILON);
		assertEquals("Your mean calculate is wrong!",expectedMean, actualMean, EPSILON);
		assertEquals("Your median calculate is wrong!",expectedMedian, actualMedian, EPSILON);
	}
}

