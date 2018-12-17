import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * test for WS1-4 Ex1
 * @author Tomohiro Furuya
 * @version 14 Nov 2017
 */
public class AircraftTest {
	/**
	 * before carrying out the tests, we need set a some variances which is related to each classes and methods
	 */
	private Aircraft aircraft1, aircraft2, aircraft3;
	private Aeroplane aeroplane;
    private HotAirBalloon hotAirBaloon1, hotAirBaloon2;
	private final static double EPSILON = 1e-6;
	
	@Before
	public void setUp() {
		aircraft1 = new Aircraft(650.0, 2017, 350);
		aircraft2 = new Aeroplane(1170.0, 850, 480, 1850);
		aircraft3 = new HotAirBalloon(280.0, 450.0, 7, 88);

		aeroplane = new Aeroplane(999.0, 550, 200, 2200);
		hotAirBaloon1 = new HotAirBalloon(150.0, 700, 3, 95);
		hotAirBaloon2 = new HotAirBalloon(200.0, 550, 0, 100);
	}

	/**
	 * test1 checks about string method of each aircraft
	 */
	@Test
	public void test1() {

		String expected1 = "The aircraft has a maximal speed of 650.0 km/h and a maximal weight of 2017.0 kg."
				+ " It can carry 350 persons.";
		String actual1 = aircraft1.toString();

		assertEquals("The information of aircraft is wrong!",expected1, actual1);

		String expected2 = "The aircraft has a maximal speed of 1170.0 km/h and a maximal weight of 850.0 kg."
				+ " It can carry 480 persons. It has a range of 1850.0 km.";
		String actual2 = aircraft2.toString();

		assertEquals("The information of aircraft is wrong!",expected2, actual2);

		String expected3 = "The aircraft has a maximal speed of 280.0 km/h and a maximal weight of 450.0 kg. It can carry 7 persons."
				+ " It has a gas temperature of maximally 88.0\u00B0C.";
		String actual3 = aircraft3.toString();

		assertEquals("The information of aircraft is wrong!",expected3, actual3);
	}

	/**
	 * test2 checks about String method with using setters
	 */
	@Test
	public void test2() {

		aircraft1.setMaxPersons(1);
		aircraft2.setMaxPersons(2);
		aircraft3.setMaxPersons(aircraft1.getMaxPersons());

		String expected1 = "The aircraft has a maximal speed of 650.0 km/h and a maximal weight of 2017.0 kg."
				+ " It can carry 1 person.";
		String actual1 = aircraft1.toString();

		assertEquals("The information of aircraft is wrong!",expected1, actual1);

		String expected2 = "The aircraft has a maximal speed of 1170.0 km/h and a maximal weight of 850.0 kg."
				+ " It can carry 2 persons. It has a range of 1850.0 km.";
		String actual2 = aircraft2.toString();

		assertEquals("The information of aircraft is wrong!",expected2, actual2);

		String expected3 = "The aircraft has a maximal speed of 280.0 km/h and a maximal weight of 450.0 kg. It can carry 1 person."
				+ " It has a gas temperature of maximally 88.0\u00B0C.";
		String actual3 = aircraft3.toString();

		assertEquals("The information of aircraft is wrong!",expected3, actual3);

	}

	/**
	 * test3 checks about string method with setter of maxSpeed in aircraft 1 and 3
	 */
	@Test
	public void test3() {

		aircraft1.setMaxSpeed(968);
		aircraft3.setMaxSpeed(85.3);

		double expected1 = 968;
		double actual1 = aircraft1.getMaxSpeed();

		assertEquals("The information of aircraft is wrong!",expected1, actual1, EPSILON);

		double expected2 = 85.3;
		double actual2 = aircraft3.getMaxSpeed();

		assertEquals("The information of aircraft is wrong!",expected2, actual2, EPSILON);

		aircraft2.setMaxWeight(3500);

		String expected3 = "The aircraft has a maximal speed of 1170.0 km/h and a maximal weight of 3500.0 kg. It can carry 480 persons."
				+ " It has a range of 1850.0 km.";
		String actual3 = aircraft2.toString();

		assertEquals("The information of aircraft is wrong!",expected3, actual3);

	}

	/**
	 * test4 checks about String method with setters about Range, Person and Gas temperature in hotAirBallon
	 */
	@Test
	public void test4() {
		aeroplane.setRange(75);
		aeroplane.setMaxPersons(1);
		hotAirBaloon2.setGasTemperature(10);
		hotAirBaloon2.setMaxPersons(110);
		double expectedRange = 75;
		double actualRange = aeroplane.getRange();

		assertEquals("The information of aircraft is wrong!",expectedRange, actualRange, EPSILON);

		double expectedTemp = 10;
		double actualTemp = hotAirBaloon2.getGasTemperature();

		assertEquals("The information of aircraft is wrong!",expectedTemp, actualTemp, EPSILON);

		String expected1 = "The aircraft has a maximal speed of 999.0 km/h and a maximal weight of 550.0 kg."
				+ " It can carry 1 person. It has a range of 75.0 km.";
		String actual1 = aeroplane.toString();

		assertEquals("The information of aircraft is wrong!",expected1, actual1);

		String expected2 = "The aircraft has a maximal speed of 200.0 km/h and a maximal weight of 550.0 kg. It can carry 110 persons."
				+ " It has a gas temperature of maximally 10.0\u00B0C.";
		String actual2 = hotAirBaloon2.toString();

		assertEquals("The information of aircraft is wrong!",expected2, actual2);

              
	}
	/**
	 * test5 checks about String method with setters about MaxWeight, MaxSpeed and GasTempurature in hotAirBallon
	 */
	@Test
	public void test5() {

		aircraft2.setMaxWeight(555);
		aircraft3.setMaxSpeed(999.9);
		hotAirBaloon1.setGasTemperature(400);
		double expected1 = 555;
		double actual1 = aircraft2.getMaxWeight();

		assertEquals("The information of aircraft is wrong!",expected1, actual1, EPSILON);

		double expected2 = 999.9;
		double actual2 = aircraft3.getMaxSpeed();

		assertEquals("The information of aircraft is wrong!",expected2, actual2, EPSILON);

		String expected3 = "The aircraft has a maximal speed of 150.0 km/h and a maximal weight of 700.0 kg. It can carry 3 persons."
				+ " It has a gas temperature of maximally 400.0\u00B0C.";
		String actual3 = hotAirBaloon1.toString();

		assertEquals("The information of aircraft is wrong!",expected3, actual3);

	}

	/**
	 * test6 checks about String method with setters about Range, gasTemperature and maxPerson in aeroplane and hotAirBallon
	 */
	@Test
	public void test6() {
		aeroplane.setRange(876.4);
		hotAirBaloon2.setGasTemperature(309.2);
		hotAirBaloon2.setMaxPersons(4);

		double expectedRange = 876.4;
		double actualRange = aeroplane.getRange();

		assertEquals("The information of aircraft is wrong!",expectedRange, actualRange, EPSILON);

		double expectedTemp = 309.2;
		double actualTemp = hotAirBaloon2.getGasTemperature();

		assertEquals("The information of aircraft is wrong!",expectedTemp, actualTemp, EPSILON);

		String expected1 = "The aircraft has a maximal speed of 999.0 km/h and a maximal weight of 550.0 kg."
				+ " It can carry 200 persons. It has a range of 876.4 km.";
		String actual1 = aeroplane.toString();

		assertEquals("The information of aircraft is wrong!",expected1, actual1);

		String expected2 = "The aircraft has a maximal speed of 200.0 km/h and a maximal weight of 550.0 kg. It can carry 4 persons."
				+ " It has a gas temperature of maximally 309.2\u00B0C.";
		String actual2 = hotAirBaloon2.toString();

		assertEquals("The information of aircraft is wrong!",expected2, actual2);

                String expected3 = "The aircraft has a maximal speed of 200.0 km/h and a maximal weight of 550.0 kg. It can carry 4 persons."
				+ " It has a gas temperature of maximally 309.2\u00B0C.";
		String actual3 = hotAirBaloon2.toString();

		assertEquals("The information of aircraft is wrong!",expected3, actual3);

	}

}
