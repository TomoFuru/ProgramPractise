import static org.junit.Assert.*;

import org.junit.Test;
/**
 * test for WS1-4 ex3
 * @author Tomohiro Furuya
 * @version 14 Nov 2017
 */
public class SortableTest {

public static final double EPSILON = 1e-6;
	
	private Sortable s1, s2, s3, s4, s5, s6;
	
	/**
	 * Test1 checks about Car sub-class
	 */
	@Test
	public void test1() {
		
		s1 = new Car(93.0, "XC90", "Volvo");
		
		double expected = 93.0;
		double actual = s1.compareValue();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	/**
	 * Test2 checks about Car sub-class with defining different type of car from test1
	 */
	@Test
	public void test2() {
		
		s2 = new Car(180.0, "GS F", "Lexus");
		
		double expected = 180.0;
		double actual = s2.compareValue();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	/**
	 * Test3 checks about Customer sub-class
	 */
	@Test
	public void test3() {
		
		s4 = new Customer("Kate", 222.2, "151 Edgebaston Park Road");
		
		double expected = 222.2;
		double actual = s4.compareValue();
		
		assertEquals(expected, actual, EPSILON);
	}
	
	/**
	 * Test4 checks quickSorting method by using Car class
	 */
	@Test
	public void test4() {
		
		s1 = new Car(200.2, "XC90", "Volvo");
		s2 = new Car(180.0, "GS F", "Lexus");
		s3 = new Car(200.1, "SUBURBAN", "Chevrolet");
		
		Sortable[] a = {s1, s2, s3};
		
		Sortable[] expected = {s2, s3, s1} ;
		Sortable[] actual = Sorting.quickSort(a);
		
		assertArrayEquals(expected, actual);
	}
	
	/**
	 * Test5 checks quickSorting method by using Customer class
	 */
	@Test
	public void test5() {
		
		s4 = new Customer("Kate", 222.2, "151 Edgebaston Park Road");
		s5 = new Customer("Daniel", 35.0, "33 Hadson Avenue");
		s6 = new Customer("Sherlock", 379.5, "221B Baker Street");
		
		Sortable[] a = {s4, s5, s6};
		
		Sortable[] expected = {s5, s4, s6} ;
		Sortable[] actual = Sorting.quickSort(a);
		
		assertArrayEquals(expected, actual);
	}

	/**
	 * Test5 checks quickSorting method by using Car and Customer class
	 */
	@Test
	public void test6() {
		
		s1 = new Car(202.0, "XC90", "Volvo");
		s2 = new Car(201.8, "FG61 CWF", "BMW");
		s3 = new Car(999.9, "SUBURBAN", "Chevrolet");
		s4 = new Customer("Kate", 201.9, "151 Edgebaston Park Road");
		s5 = new Customer("Daniel", 35.0, "33 Hadson Avenue");
		s6 = new Customer("Sherlock", 779.5, "221B Baker Street");
		
		Sortable[] a = {s1, s2, s3, s4, s5, s6};
		
		Sortable[] expected = {s5, s2, s4, s1, s6, s3} ;
		Sortable[] actual = Sorting.quickSort(a);
		
		assertArrayEquals(expected, actual);
	}
	

}
