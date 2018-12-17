
public class Formula2 {
	/**
	 * 
	 * @param es numerator of fraction es/ds
	 * @param dp denominator of fraction eep/dp
	 * @return formula1
	 */
	public static int 	
	fraction1(int es, double dp) {
  int formula1=   (int) (es * dp);
return formula1; 
	}
	/**
	 * 
	 * @param ep numerator of fraction ep/dp
	 * @param ds denominator of fraction es/ds
	 * @return formula2
	 */
  public static int 
  fraction2 (int ep, double ds) {
	  int  formula2= (int) (ep * ds);
	  return formula2;
  }
  /**
	 * 
	 * @param ds  denominator of fraction es/ds
	 * @param dp denominator of fraction ep/dp
	 * @return formula3
	 */
  public static int 
  fraction3 (int ds, double dp) {
	  int  formula3= (int) (ds * dp);
	return formula3;
  }
  /**
   * 
   * @param es numerator of fraction es/ds
   * @param ep numerator of fraction ep/dp
   * @return
   */
  public static int 
  fraction4 (int es, double ep) {
	  int  formula4= (int) (es * ep);
	return formula4;
  }
 public static void main(String[] args) {
	 System.out.println(" 1/2 + 1/3 = "+ (fraction1(1,3) + fraction2(1,2)) + "/" + fraction3(2,3) +".");
	 System.out.println(" 1/3 + 3/4 = "+ ( fraction1(1,4) + fraction2(3,3)) + "/" +fraction3(3,4) +".");
	 System.out.println(" 1/2 * 2/3 = "+ fraction4(1,2) + "/" + fraction3(2,3) +".");
	 System.out.println(" 1/4 * 2/3 = "+ fraction4(1,2) + "/" + fraction3(4,3) +".");
 }
  
  
}

