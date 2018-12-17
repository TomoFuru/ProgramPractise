/**
 * this program is 
 * @author Tomohiro Furuya 
 * @version 11 Oct 2017
 */
public class Complex {

	private double RealPart;
	private double ImaginaryPart;
	
	/**
	 * 
	 * @param realPart is real part of complex number
	 * @param imaginaryPart is imaginary part of complex number
	 */
	public Complex(double realPart, double imaginaryPart) {
		super();
		this.RealPart = realPart;
		this.ImaginaryPart = imaginaryPart;
	}
   /**
    * @return real part of complex number as double
    */
	public double getRealPart() {
		return RealPart;
	}
    /**
     * @return imaginary part of complex number as double
     */
	public double getImaginaryPart() {
		return ImaginaryPart;
	}
	/**defines how to print a film
     * the print tyoe of film
     */
	@Override
	public String toString() {
		return "" + RealPart + " + " + ImaginaryPart + "i";
	}
	/**
	 * @param summand is other complex number when we calculate a complex number
	 * @return add formula between two complex numbers
	 */
	public Complex add(Complex summand) {
		return new Complex (this.RealPart + summand.RealPart, this.ImaginaryPart + summand.ImaginaryPart);
		
	}
	/**
	 * @param factor is the formula when we calculate factor of 2 complex number
	 * @return multiply formula between two complex numbers
	 */
	public Complex multiply(Complex factor) {
		return new Complex(RealPart * factor.RealPart - ImaginaryPart * factor.ImaginaryPart, 
				           RealPart*factor.ImaginaryPart + ImaginaryPart * factor.RealPart);
	}
	/**
     * main method of program
	 * This class is to test the Complex class and its methods.
     * We create some objects of class Complex and get some parts back.
     */
   public static void main(String[] args) {
	   Complex c1 = new Complex(1,1);
	   Complex c2 = new Complex(3,7);
	   Complex c3 = new Complex(1,0);
	   /**
	    * calculate addition formula of 2 complex numbers c2 and c1
	    */
	    c2.add(c1).toString();
        System.out.println(c2.add(c1).toString());
       /**
        * calculate factor formula of 2 complex numbers c2 and c1
        */
       c2.multiply(c1).toString();
       System.out.println(c2.multiply(c1).toString());
	   
	   
   } 

	
		
	}
	
	

