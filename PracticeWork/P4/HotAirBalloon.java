/**
 * 
 * @author Tomohiro Furuya
 * @version 4 Nov 2017
 * This class is sub class of Aircraft class which is super class of HotAirBalloon class
 */
public class HotAirBalloon extends Aircraft{

	private double gasTemperature;
	/**
	 * constructor of HotAirBallonn
	 * @param maxSpeed is max speed of aeroplane
	 * @param maxWeight is max weight of aeroplane
	 * @param maxPersons is max person which aeroplane can carry
	 * @param gasTemperature is gas temperature when HotAirBallon fly. 
	 */
	public HotAirBalloon(double maxSpeed, double maxWeight, int maxPersons, double gasTemperature) {
		super(maxSpeed, maxWeight, maxPersons);
		// TODO Auto-generated constructor stub
		this.gasTemperature = gasTemperature;
	}
	/**
	 * getter of gas temperature
	 * @return gasTemperature as double
	 */
	public double getGasTemperature() {
		return gasTemperature;
	}
	/**
	 * setter of HotAirBalloon about gasTemperature
	 * @param gasTemperature
	 */
	public void setGasTemperature(double gasTemperature) {
		this.gasTemperature = gasTemperature;
	}
	/**
	 * defines how to print about HotAirBalloon
	 * print out detail of aeroplane which is about max speed, max weight, 
	 * max person and gas temperature when HotAirBallon fly. 
	 * \u00B0C is Encode of degrees celsius
	 */
	@Override
	public String toString() {
		return  super.toString() + " It has a gas temperature of maximally " + gasTemperature + "\u00B0C.";
	}

	
}
