import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Tomohiro Furuya
 * @version 15 OCT 2017
 */
public class FilmTest {
       
	private Film film1;
	@Before
	public void setUp() throws Exception {
	film1 = new Film("Moneyball",2011,133);	
	}
   /**
    *
    *  test1 is tested about setter of Film class
    */
	@Test
	public void test1() {
		
		film1.setLength(10);
		
		assertEquals("Name of Film has a problem!","Moneyball", film1.getTitle());
		assertEquals("Year of Film is erong!",2011, film1.getYear());
		assertEquals("Length of Film is wrong!!",10, film1.getLength());
		
	}
	/**
	 *  test2 is tested about getter method of film
	 */
	@Test
	public void test2() {
		 
		 assertEquals("Program of Name has some problem!","Moneyball", film1.getTitle());
				
	}
	/**
	 * test3 is tested about outputting of Program 
	 */
	@Test
	public void test3() {
		 
		 
			String expected ="[Moneyball, 2011, 133 mins. ]";
			assertEquals("Expected Strings has mistake!",expected, film1.toString());
			
	}
	/**
	 * test4 is tested about making some object and String method of program
	 */
	@Test
	public void test4() {
         	 
			film1 = new Film("Iron Man",2008,126);
			String expected = "[Iron Man, 2008, 126 mins. ]";
			assertEquals("Expected Strings has mistake!",expected, film1.toString());
	}
	/**
	 * test5 is tested about getter of title, year and length of film 
	 */
	@Test
	public void test5() {
           film1.setLength(120);
		 
		 assertEquals("Moneyball", film1.getTitle());
			assertEquals(2011, film1.getYear());
			assertEquals("Length of Film is wrong!!",120, film1.getLength());
				
	}
	/**
	 * test6 is tested about setter method of length of film
	 */
	@Test
	public void test6() {
		
		film1.setLength(150);
		 
		 assertEquals("Moneyball", film1.getTitle());
			assertEquals(2011, film1.getYear());
			assertEquals("Length of Film is wrong!!",150, film1.getLength());
			
			
	}

}
