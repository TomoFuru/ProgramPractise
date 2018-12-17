
public class Rate1  {

	public static void main(String[] arg) {
		double capital, rate, fiveyears, fivehundredyears,balance5,balance500,rateperyear;
		/**
		 * @define the rate of year
		 * @define capital  as capital of year0
		 * @param fiveyears length of 5 years
		 * @param fivehundred length of 500 years
		 * @param balance5 5 years later's balance
		 * @param balance500 500 years later's balance
		 * @param rateperyear formula of rate per year
		 */
		
		 rate = 2.3   ; 
		 capital = 10000.0 ;
		 fiveyears = 5; 
		 fivehundredyears = 500;
			
	rateperyear 	= (1 + 0.01 * rate);
			balance5 = capital * (java.lang.Math.pow(rateperyear,fiveyears));
			balance500 = capital * (java.lang.Math.pow(rateperyear,fivehundredyears));
			
			System.out.println("After 5 years, the balance is " + balance5 + "." );
			System.out.println("After 500 years, the balance is " + balance500 + "." );
		}
		
	}


