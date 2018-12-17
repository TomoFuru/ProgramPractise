
public class Circle {
    /**
     *  
     * @param radius is length of the circle
     * @param Math.PI define of pie
     * @return the area of the circle
     */
	public static double 
	        
	circle(double radius) {
		/**
		 * calculate an area of circle
		 */
		return Math.PI *radius * radius ;
	}
	public static void main(String[] args) {
		/**
		 *  define the radius of circle as 5
		 */
		double a = 5;
		
		System.out.println("The area of a " + "circle with radius " + a + " is " + circle(a) + ".");
		
	}
}
