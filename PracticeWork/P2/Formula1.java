
public class Formula1 {
	
		public static  void main(String[] arg) {
		
		int es=1,ds=2,ep=3,dp=4;
		
		/**
		 * it follows 1/2 + 1/3 
		 */
		int f1,f2,f3,f4,f5,f6,f7,f8,f9,f10;
		
		f1 = es * ep;
		/**
		 * 1*3 = 3
		 */
		f2 = ds * es;
		/**
		 * 1*2 = 2
		 */
		f3 = ds * ep;
		/**
		 * 2*3=6
		 */
		f4 = f1 + f2;
		System.out.println(" 1/2 + 1/3 = "+ f4 + "/" + f3 +".");
	    /**
	     * it follows 1/3 + 3/4
	     */
		
		f5 = es * dp;
		/**
		 * 1*4=4
		 */
	    f6 = ep * ep;
	    
	   f7 = f5 + f6 ;
	    /**
	     * 3*3 = 9
	     */
		f8 = ep * dp;
		
		/**
		 * 3*4= 12
		 */
		f9 = f5 + f6;
		System.out.println(" 1/3 + 3/4 = "+ f7 + "/" + f8 +".");	
		/**
		 * it follows 1/2 * 1/4
		 */
		f10 = es *ds;
		System.out.println(" 1/2 * 2/3 = "+ f10 + "/" + f3 +".");	
		/**
		 * it follows 1/4 * 2/3
		 */
		System.out.println(" 1/2 * 2/3 = "+ f2 + "/" + f7 +".");	
	}

}
