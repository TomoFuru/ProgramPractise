import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Tomohiro Furuya
 * @version 15 Oct 2017
 */
public class ClubMemberTest {
    
	private ClubMember newmember;
	@Before
	public void setUp() throws Exception {
		
		newmember = new ClubMember("Chris", "21 June 1987", "S010294", "Silver");
	}
	/**
     *  test1 is tested about string method of main program
     */
	public void test1() {

		assertEquals("Getter of Name has a problem!","Chris", newmember.getName());
		assertEquals("Getter of Registration Number has a problem!","SO10294", newmember.getRegistrationNumber());
		assertEquals("Getter of MembershipType has a problem!","Silver", newmember.getMembershipType());
	}
	/**
	 * test2 is tested about outputting about date of birth of club member
	 */
	@Test
	public void test2() {
		
		assertEquals("Getter of Date of Birth has a problem!","21 June 1987", newmember.getDateOfBirth());	
	}
	/**
	 * test3 is tested about checking getter of registration number work 
	 */
	@Test
	public void test3() {
		
		assertEquals("Getter of RegistrationNumber has a problem!","S010294", newmember.getRegistrationNumber());	
	}
	/**
	 * test4 is tested about string method of program
	 */
	@Test
	public void test4() {
		
		String expected = "[Chris, 21 June 1987, ID: S010294, Silver]";
		assertEquals("toString has a problem",expected, newmember.toString());
	}
	/**
	 * test5 is tested about making new objects of club member and checking program 
	 */
	@Test
	public void test5() {
		
		newmember = new ClubMember("Ian", "3 December 1990", "M188353", "Gold");

		String expected = "[Ian, 3 December 1990, ID: M188353, Gold]";
		assertEquals("toString has a problem",expected, newmember.toString());
	}
	/**
	 * test6 is tested about making new objects and checking String method
	 */
	@Test
	public void test6() {
		
		newmember = new ClubMember("Phillip", "27 March 1992", "W427012", "Platinum");
		String expected = "[Phillip, 27 March 1992, ID: W427012, Platinum]";
		assertEquals("toString has a problem!",expected, newmember.toString());
	}
}
