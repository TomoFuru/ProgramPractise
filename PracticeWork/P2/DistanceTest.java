import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Tomohiro Furuya
 * @version 15 Oct 2017
 */
public class DistanceTest {
	
     private Distance dis1,dis2,dis3;
     
	@Before
	public void setUp() throws Exception {
		dis1 = new Distance(4.3);
		dis2 = new Distance(7.68);
		dis3 = new Distance(9.15);
	}
	   
	 /**
     *  test1 is tested about getter method of kilometres
     */
	@Test
	public void test1() {
		double expected = 4.3;
		assertEquals("Getter of kilometres has a problem!",expected, dis1.getKilometres(), 0.00000001);
	}
    /**
     *  test2 is tested about getter method of miles
     */
	@Test
	public void test2() {
		double expected =  2.671902767594169;
		assertEquals("Getter of Miles has a problem!",expected, dis1.getMiles(), 0.00000001);
	}
    /**
     * test3 is tested about getter method of metres
     */
	@Test
	public void test3() {

		double expected = 7680;
		assertEquals("Getter of Metres has a problem!",expected, dis2.getMetres(), 0.000001);
	}
    /**
     * test4 is tested about getter method of yards
     */
	@Test
	public void test4() {

		double expected = 8398.971006748106;
		assertEquals("Getter of Yards has a problem!",expected, dis2.getYards(),  0.000001);
	}
    /**
     * test5 is tested about getter method of miles
     */
	@Test
	public void test5() {

		double expected = 5.685560540345732;
		assertEquals("Getter of Miles has a problem!",expected, dis3.getMiles(), 0.000001);
	}
    /**
     * test6 is tested about getter method of yards
     */
	@Test
	public void test6() {

		double expected = 10006.58655100849;
		assertEquals("Getter of Yards has a problem!",expected, dis3.getYards(),  0.000001);
	}
}
