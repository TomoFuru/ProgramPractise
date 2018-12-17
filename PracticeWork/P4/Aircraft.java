/**
 * 
 * @author Tomohiro Furuya
 * @version 4 Nov 2017
 * This class is superclass of Aeroplane and HotAirBaloon class.
 * Aircraft class is consist of 3 field variables and 
 * constructor, getter, setter of them and String method.
 */
public  class Aircraft {

	private double maxSpeed;
	private double maxWeight;
	private int maxPersons;
	/**
	 * 
	 * @param maxSpeed is max speed of aircraft
	 * @param maxWeight is max weight of aircraft
	 * @param maxPersons is max person which aircraft can carry
	 */
	public Aircraft(double maxSpeed, double maxWeight, int maxPersons) {
		super();
		this.maxSpeed = maxSpeed;
		this.maxWeight = maxWeight;
		this.maxPersons = maxPersons;
	}
	/**
	 * getter of maxSpeed 
	 * @return maxSpeed of Aircraft as double
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}
	/**
	 * getter of maxWeight
	 * @return maxWeight of Aircraft as double
	 */
	public double getMaxWeight() {
		return maxWeight;
	}
	/**
	 * getter of maxPerson Aircraft can carry
	 * @return maxPerson of Aircraft as int
	 */
	public int getMaxPersons() {
		return maxPersons;
	}
	/**
	 * setter of Aircraft about maxSpeed 
	 * @param maxSpeed is the new maxSpeed of Aircraft
	 */
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	/**
	 * setter of Aircraft about maxWeight
	 * @param maxWeight is the new maxWeight of Aircraft
	 */
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}
	/**
	 * setter of Aircraft about maxPersons
	 * @param maxPersons is the new maxPerson Aircraft can carry
	 */
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
    /** defines how to print about Aircraft
     * String method include if method because when person is 1,
     *  it should print as 1 person, else print as other number and persons
     */
	@Override
	public String toString() {
		if(maxPersons ==1) {
			return "The aircraft has a maximal speed of " + maxSpeed + " km/h and a maximal weight of " + maxWeight + " kg." + " It can carry "+ maxPersons + " person.";
		}else {
		return "The aircraft has a maximal speed of " + maxSpeed + " km/h and a maximal weight of " + maxWeight + " kg." + " It can carry "+ maxPersons + " persons.";
		}
	}	
}
