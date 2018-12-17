/**
 * 
 * @author Tomohiro Furuya
 * @version 4 Nov 2017
 * This class is sub class of Aircraft class which is super class of Aeroplane class
 */

public class Aeroplane extends Aircraft{
	
	private double range;
	/**
	 * constructor of Aeroplane
	 * @param maxSpeed is max speed of aeroplane
	 * @param maxWeight is max weight of aeroplane
	 * @param maxPersons is max person which aeroplane can carry
	 * @param range is range which this aeroplane can fly
	 */
	public Aeroplane(double maxSpeed, double maxWeight, int maxPersons, double range) {
		super(maxSpeed, maxWeight, maxPersons);
		// TODO Auto-generated constructor stub
		this.range = range;
	}
	/**getter of aeroplane about range
	 * @return the rage of Aeroplane as double  
	 */
	public double getRange() {
		return range;
	}
	/**setter of aeroplane about range
	 * @param the range is the new range of Aeroplane
	 */
	public void setRange(double range) {
		this.range = range;
	}
	/**
	 * defines how to print about aeroplane
	 * print out detail of aeroplane which is about max speed, max weight, 
	 * max person and range it can keep flying
	 */
	@Override
	public String toString() {
		return super.toString() +" It has a range of " + range + " km.";
	}

	
}
