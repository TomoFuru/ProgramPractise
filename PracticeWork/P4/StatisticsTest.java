import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;
/**
 * test for WS1-4 Ex2
 * @author Tomohiro Furuya
 * @version 13 Nov 2017
 */
public class StatisticsTest {
	private final static double EPSILON = 1e-6;

	/**
	 * test1 checks about calculating mean and std by using 
	 */
	@Test
	public void test1() {

		Function<Double, Double> f1 = x -> x ;
		double[] a = { 50, 60, 70, 80, 90};

		double expectedMean = 70;
		double actualMean = Statistics.mean(f1, a);
		assertEquals("Your calculation of mean is wrong!",expectedMean, actualMean, EPSILON);

		double expectedStd = 14.142135623730951;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals("Your calculation of standard deviation is wrong!",expectedStd, actualStd, EPSILON);

	}

	/**
	 * test2 checks about calculating mean and std by using octal number 
	 */
	@Test
	public void test2() {

		Function<Double, Double> f1 = x -> x * x;
		double[] a = { 1.0, 3.0, 5.0, 7.0, 9.0 };

		double expectedMean = 33;
		double actualMean = Statistics.mean(f1, a);
		assertEquals("Your calculation of mean is wrong!",expectedMean, actualMean, EPSILON);

		double expectedStd = 29.06544339933592;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals("Your calculation of standard deviation is wrong!",expectedStd, actualStd, EPSILON);

	}

	/**
	 * test3 checks about calculating mean and std by using　decimal numbers 
	 */
	@Test
	public void test3() {

		Function<Double, Double> f1 = x -> x * 2 + x * x;
		double[] a = { 0.5, 1.2, 0.9, 5.3, 6.0, 3.5, 4.7};

		double expectedMean = 20.732857142857142;
		double actualMean = Statistics.mean(f1, a);
		assertEquals("Your calculation of mean is wrong!",expectedMean, actualMean, EPSILON);

		double expectedStd = 17.636242484712888;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals("Your calculation of standard deviation is wrong!",expectedStd, actualStd, EPSILON);

	}

	/**
	 * test4 checks about calculating mean and std by using tangent, negative number and large number
	 */
	@Test
	public void test4() {

		Function<Double, Double> f1 = x -> Math.tan(x);
		double[] a = { -5,-2, 1,4,7, 10, 13, 16, 19,22,25};

		double expectedMean = 0.962832798298994;
		double actualMean = Statistics.mean(f1, a);
		assertEquals("Your calculation of mean is wrong!",expectedMean, actualMean, EPSILON);

		double expectedStd = 1.0133778603511583;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals("Your calculation of standard deviation is wrong!",expectedStd, actualStd, EPSILON);

	}

	/**
	 * test5 checks about calculating mean and std by using cosine and sine
	 */
	@Test
	public void test5() {

		Function<Double, Double> f1 = x -> Math.sin(Math.cos(x) * Math.sin(x));
		double[] a = { 1,0,1,0,1,0, 0.5, 1,0 ,0.5,1.0};

		double expectedMean = 0.2738725021463765;
		double actualMean = Statistics.mean(f1, a);
		assertEquals("Your calculation of mean is wrong!",expectedMean, actualMean, EPSILON);

		double expectedStd = 0.2073238414489904;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals("Your calculation of standard deviation is wrong!",expectedStd, actualStd, EPSILON);
	}

	/**
	 *  test6 checks about calculating mean and std by using Math.pow
	 */
	@Test
	public void test6() {

		Function<Double, Double> f1 = x -> Math.pow(x, 0.9);
		double[] a = new double[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = i % 100;
		}
		
		double expectedMean = 32.89226389907406;
		double actualMean = Statistics.mean(f1, a);
		assertEquals("Your calculation of mean is wrong!",expectedMean, actualMean, EPSILON);

		double expectedStd = 17.89034883208274;
		double actualStd = Statistics.standardDeviation(f1, a);
		assertEquals("Your calculation of standard deviation is wrong!",expectedStd, actualStd, EPSILON);
	}

	

}
