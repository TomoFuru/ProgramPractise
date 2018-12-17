
public class Time2 {
	
	public static double degrees(int hour, double minutes)
	
	{ 
		/**
		 *  convert 24 hours to 12 hours
		 */
		int hours = hour % 12;
	double degreesperh = 30 * hours + 0.5 * minutes;
	double degreespermin = 6 * minutes;
	double caldegree = (degreespermin - degreesperh);
	double degreeofclock = Math.abs(caldegree);
	return degreeofclock;
	
	
		   }
public static void main(String[] args) {
	System.out.println(degrees(9,0));	
	System.out.println(degrees(3,0));
	System.out.println(degrees(18,0));	
	System.out.println(degrees(1,0));
		System.out.println(degrees(2,30));	
		System.out.println(degrees(4,41));
		
}
	}


