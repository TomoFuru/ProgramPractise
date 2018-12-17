/**
 * 
 * @author Tomohiro Furuya
 *@version 9 Oct 2017
 */
public class Distance {
	

    private double Kilometres;
    private double Miles;
    private double Metres;
    private double Yards;
    
    /**
     * @param kilometres is distance given in kilometres
     * @param miles is distance given in miles with conversion formula to km
     * @param metres is distance given in metres with conversion formula to km
     * @param yards is distance given in param with conversion formula to km
     */
    
	public Distance(double kilometres ) {
		super();
		this.Kilometres = kilometres;
	    this.Miles =(kilometres  / 1.60934);
		this.Metres = (kilometres / 0.001);
		this.Yards = Miles  * 1760;
		
		
	}
   /**
    * @return distance in kilometres as double
    */
   public double getKilometres () {
		return Kilometres;
	}
   /**
    * @return distance that converts from kilometres to miles as double
    */
	public double getMiles() {
		return Miles;
	}
    /**
     * @return distance that converts from kilometres to metres as double
     */
	public double getMetres() {
		return Metres ;
	}
    /**
     * @return dostance that convertsfrom kilometre to yards as double
     */
	public double getYards() {
		return Yards;
	}
  
   
	@Override
	public String toString() {
		return "" + Kilometres+" km is "  + Miles + " Miles ," + Metres + " Metres" + " and " + Yards
				+ " Yards. ";
	}
    /**
     * main method of program
	 * This class is to test the Distance class and its methods.
      *  We create some objects of class Distance and get some parts back.
     */
    public static void main(String[] args) {
		
		Distance distance = new Distance(9.15);	
		
		distance.getKilometres();
		System.out.println(distance);
		
		
	}
	
	
}
