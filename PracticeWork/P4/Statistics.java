import java.util.function.Function;
/**
 * 
 * @author Tomohiro Furuya
 * @version 7 Nov 2017
 */
public class Statistics {
		/**
		 * this method for calculating mean 
		 * @param f is a fucntion which is A function from double to double for which the values
         *   are to be computed and printed.
		 * @param argumentValues is array which will be calculated mean 
		 * @return average which is same as mean of array of argumrntValues
		 */
		public static double mean(Function<Double ,Double> f , double[] argumentValues) {
			/**
			 * sum is a sum of argumentValues as double
			 * ave is an average of argumentValues as double which is same as mean
			 */
			double sum = 0;
			double ave = 0;
			/**
			 * for loop is used for calculating a mean of argumrntValue 
			 * function f is used for sum of array 
			 * ave is given sum divided by length of array
			 */
				for(int i= 0; i< argumentValues.length; i++) {
		 sum +=  f.apply(argumentValues[i]);
		 ave = sum / argumentValues.length;
			}
			return  ave;	
			}
		/**
		 * 
		 * @param f is a fucntion which is A function from double to double for which the values
         *   are to be computed and printed.
		 * @param argumentValues is array which will be calculated standard Deviation
		 * @return std is standardDeviation of argumentValues
		 */
		public static double standardDeviation(Function<Double ,Double> f, double[] argumentValues) {
			/**
			 * sum is sum of argumentValues as double
			 * ave is mean of argumentValues as double
			 * var is variance of argumentValues as double
			 * std is standard deviation of argumentValues as double
			 */
			double sum = 0; 
			double ave = 0;
		    double var = 0; 
		    double std = 0;
		  /**
		   * 1st for loop is used for calculating mean of array
		   * 2nd for loop is used for calculation standard deviation of array
		   * variance is given by square of expect value
		   */
		  for(int i=0; i< argumentValues.length; i++) {
			  sum += f.apply(argumentValues[i]);
		  }
			   ave = sum / argumentValues.length;
			   for(int i= 0; i < argumentValues.length; i++) {
			   
			var += (f.apply(argumentValues[i])- ave)*(f.apply(argumentValues[i])-ave);
			 
	
		  }	   
		  std = Math.sqrt(var/argumentValues.length);
			   return std;		   
  }
		
		
	
/**
	public static void main(String args[]) {
		//double[] sd = { 1,0,1,0,1,0, 0.5, 1,0 ,0.5,1.0};
		double[] a = new double[100000];

		for (int i = 0; i < a.length; i++) {
			a[i] = i % 100;
		}
		System.out.println(mean(x ->Math.pow(x, 0.9),a));
		System.out.println(standardDeviation(x ->Math.pow(x, 0.9) ,a));
	}
*/	
	} 
