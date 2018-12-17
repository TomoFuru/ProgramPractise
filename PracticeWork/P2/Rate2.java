
public class Rate2 {
     
	public static double 
	balance(double year) {
		double rates = 2.3;
		double capital = 10000.0;
		double rateperyear = (1 + 0.01 * rates);
		return rateperyear;
		
	}
	public static void main(String[] args) {
		System.out.println("After 5 years, the balance is " + balance(5) + "." );
		System.out.println("After 500 years, the balance is " + balance(500) + "." );
	}
	}

