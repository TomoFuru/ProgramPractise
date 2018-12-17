import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Tester {
	

public static void main(String[] args) {
	    	 double[][] arr = {{1,2,3,5},{4,6,7}};
	    	
	    	 
	    	 System.out.println(median(arr));
	    	 System.out.println(getMax(arr));
	    }
	
	public static double median(double[][] a ) {
		double median = 0;
		int size = 0;
		ArrayList<Double> list = new ArrayList<>();
  	  // double[] list = new double[a.length * a[0].length];
  	  // int[] a1 = new double[a.length * a.length];
  	    
		//int[] a1 = new double[a.length * a.length];
 	    
		for(int i=0; i < a.length; i++) {
			//double[] arr = a[i];
			 for (int j=0; j< a[i].length; j++) {
				// double newarr = a[i][j];
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
					median = (list.get((size*2) -1) + list.get(size)/2);
				}
				return median;
				}
			    /**    
				 int middle = size() / 2;
				    if (list.length % 2 == 1) {
					   return list[middle];
					    } else {
					   return (list[middle - 1] + list[middle]) / 2.0;
					    }
					    */
			 

public static double getMax(double[][] a) {
	double max =  a[0][0];
	
	for (int i = 0; i <  a.length; i++) {
		
		for (int j = 0; j <  a[i].length; j++) {
			 
			//need to define the largestnumber
			if(a[i][j] > max) {
				a[i][j] = max;
				
				
			}
		}
	}
	return max;
}	
}
	
		
		
		
	
 


