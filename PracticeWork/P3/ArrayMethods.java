import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author Tomohiro Furuya
 * @version 26 Oct 2017
 */
public class ArrayMethods {
   
     
    /**
     * @param a is the 2D array of some numbers which are going to be picked up minimum number
     * @return min is the minimum number of array as double
     * 2 for loops are using for picking up the minimum number in 2D arrays
     */
	public static double min(double[][] a) {
		try {
		double min = a[0][0];
		for(int i= 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				
							min = Math.min(min, a[i][j]);
        			          
				}
		}
		return min;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(" ");
		}
			}
		
	/**
	 * @param a is the 2D array of some numbers which are going to be picked up maximum number
	 * @return max is the minimum number of array as double
	 * 2 for loops are using for picking up the minimum number in 2D arrays
	 */
	public static double max(double[][] a) {
		try {
		double max =  a[0][0];
		
		for (int i = 0; i <  a.length; i++) {
			
			for (int j = 0; j <  a[i].length; j++) {
				 
				//need to define the largestnumber
				//if(a[i][j] > max) {
					//a[i][j]
						max = Math.max(max, a[i][j]);
			}
				
			}
		return max;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(" ");
			}
		}
	
	/**
	 * 
	 * @param a is the 2D array of some numbers which are going to be calculated mean of arrays
	 * @return ave is the average of arrays which is same as mean
	 * 2 for loops are using for calculating mean in 2D arrays
	 */
	public static double mean(double[][] a) {
		try {
		int count = 0;
		 double ave = 0;
		 double sum = 0;
		for (int i=0; i< a.length;  i++) {
			for (int j=0; j< a[i].length; j++) {
		        sum += a[i][j];
		          count++;
		    }
		}
		        ave = sum / count;
		    return ave;	
	}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(" ");
			}
		}
   /**
    * @param a is the 2D array of some numbers which are going to be calculated mean of arrays
    * @return median is the median of 2D arrays
    * At first, I try to convert from 2D arrays to 1D array for calculating median
    * 2 for loops are using for calculating mean in 2D arrays
    */
	public static double median(double[][] a) {
		try {
		double median = 0;
		int size = 0;
		ArrayList<Double> list = new ArrayList<>();
  	 
 	    	for(int i=0; i < a.length; i++) {
		
			 for (int j=0; j< a[i].length; j++) {
				
				 list.add(a[i][j]);
			 }
 	    	}
				Collections.sort(list);
				size = list.size();
				 
				if(size % 2 != 0) {
					size /= 2;
					median = list.get(size );
				}else {
					size /= 2;
					median = ((list.get((size) -1) + list.get(size))/2);
				}
				return median;
				}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(" ");
			}
		}
	 		
	/**
     * main method of program
     * This class is to test the min, max, mean and median class and their methods.
     * This class is also sorting Array numbers from minimum number to maximum number
     *  We create an array for calculate min, max, mean and median and get some parts back.
     */
	public static void main(String[] args) {
	 double[][] arr = {{1,2,3,5},{4,6,9}};
	
	 
	
	 System.out.println(min(arr));
	 System.out.println(max(arr));
	 System.out.println(mean(arr));
	 System.out.println(median(arr)); 
	}
}


