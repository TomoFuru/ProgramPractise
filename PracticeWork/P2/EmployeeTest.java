import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Tomohiro Furuya
 * @version 16 OCT 2017
 */
public class EmployeeTest {
	
	private Employee newemp1;
	private final static double EPSILON = 1e-6;
	
	@Before
	public void setUp() throws Exception {
		newemp1 = new Employee("John", 10, 40);
	}

	@Test
	/**
	 * test1 is tested about setter and getter of name, hourly salary and number of hours
	 */
	public void test1() {

		newemp1.setName("Tonny");
		newemp1.setHourlySalary(35);
		newemp1.setNumberOfHours(40);

		assertEquals("Tonny", newemp1.getName());
		assertEquals(35, newemp1.getHourlySalary(), EPSILON);
		assertEquals(40, newemp1.getNumberOfHours());
	}
    /**
     *  test2 is tested about String method of program
     */
	@Test
	public void test2() {

		newemp1.setHourlySalary(23.8);
		newemp1.setNumberOfHours(59);

		assertEquals(1279.2262, newemp1.monthlySalary(8.9), EPSILON);

		String expected = "John has an hourly salary of 23.8 \u00a3 and has worked last month for 59 hours.";

		assertEquals(expected, newemp1.toString());
	}
	/**
	 * test3 is tested about String method o program
	 */
    @Test
    public void test3() {
    	      newemp1.setHourlySalary(27);
    	      newemp1.setNumberOfHours(45);
    	      newemp1.increaseSalary(12.2);
    	     String expected = "John has an hourly salary of 30.294000000000004 \u00a3 and has worked last month for 45 hours.";
    	     
    	     assertEquals(expected,newemp1.toString());
    }
	/**
	 * test4 is tested about String method with increase salary and monthly salary
	 */
	@Test
	public void test4() {
		newemp1.setName("Marco");
		newemp1.setHourlySalary(71.7);
		newemp1.setNumberOfHours(28);

		assertEquals(1806.84, newemp1.monthlySalary(10), EPSILON);

		newemp1.increaseSalary(8.3);

		assertEquals(1521.96156, newemp1.monthlySalary(30), EPSILON);

		String expected = "Marco has an hourly salary of 77.6511 \u00a3 and has worked last month for 28 hours.";

		assertEquals(expected, newemp1.toString());

	}
    /**
     * test5 is tested about String method with increase salary and monthly salary
     */
	@Test
	public void test5() {

		newemp1.setHourlySalary(43);
		newemp1.setNumberOfHours(82);

		newemp1.increaseSalary(3.2);
		newemp1.increaseSalary(7.9);
		
		assertEquals(3926.299728, newemp1.monthlySalary(0), EPSILON);

		String expected = "John has an hourly salary of 47.881704000000006 \u00a3 and has worked last month for 82 hours.";

		assertEquals(expected, newemp1.toString());
	}
    /**
     *   test6 is tested about string method of program
     */
	@Test
	public void test6() {
		newemp1.setName("Tim");
		newemp1.setHourlySalary(0);
		newemp1.setNumberOfHours(0);

		newemp1.increaseSalary(0);
		newemp1.increaseSalary(0);
		assertEquals(0.0, newemp1.monthlySalary(0), EPSILON);

		String expected = "Tim has an hourly salary of 0.0 \u00a3 and has worked last month for 0 hours.";

		assertEquals(expected, newemp1.toString());

	}

}



