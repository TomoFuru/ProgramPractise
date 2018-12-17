/**
 * 
 * @author Tomohiro Furuya
 * @version 24 Oct 2017
 */
public class SelectionSort {
	/**
	 * 
	 * @param numbers is the 1D array of some numbers which will be sorted
	 * @return numbers is the smallest number in the numbers as int
	 * in for loop, it work for finding minimum number in the array
	 */
	 public static int[] selectionSort(int[] numbers){
         
	        for (int i = 0; i < numbers.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < numbers.length; j++)
	                if (numbers[j] < numbers[index]) 
	                    index = j;
	      
	            		int smallestNumber = numbers[index];  
	            			numbers[index] = numbers[i];
	            			numbers[i] = smallestNumber;
	        }
	 return numbers;
 }
	     /**
	      * main method of program
	      * This class is to test the SelecytionSort class and its methods.
	      * This class is also sorting Array numbers from minimum number to maximum number
          *  We create some objects of class SelectionSort and get some parts back.
	      * 
	      */
	 public static void main(String[] args){
	         
	        int[] arr1 = {4,3,6,1,9,2};
	        	/**
	        	 *  System.out.println(arr1);
	        	 */
	       
	        int[] arr2 = selectionSort(arr1);
	        for(int i:arr2){
	        	
	            System.out.print( i );
	            System.out.print(",");
	        }
	    }
	}
	
	