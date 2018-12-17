/**
 * 
 * @author Tomohiro Furuya
 * @version 9 Nov 2017
 * this class has implementation to Sortable class/interface 
 */
public class Car implements Sortable {

	private double maxSpeed;
	private String carNumber;
	private String make;
	/**
	 * constructor of Car class
	 * @param maxSpeed is max speed of car
	 * @param carNumber is number of car
	 * @param make is name of car company which designed car
	 */
	public Car(double maxSpeed, String carNumber, String make) {
		super();
		this.maxSpeed = maxSpeed;
		this.carNumber = carNumber;
		this.make = make;
	}
	/**
	 * defines how to print about Car
	 * print out detail of car which is about max speed, car number and  
	 * make is name of car company which designed car
	 */
	@Override
	public String toString() {
		return "Car [maxSpeed=" + maxSpeed + ", carNumber=" + carNumber + ", make=" + make + "]";
	}
	/**
	 * implementation to Sortable interface
	 * return maxSpeed of car as double
	 */
	public double compareValue() {
		return this.maxSpeed;
		
	}
	
}
