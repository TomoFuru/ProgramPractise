
public class SelectionSort {
public static void main(int[] numbers){
		
		
		int [] arr = {4, 3, 6, 1, 9, 2};
		int min = arr[0];
        for(int i = 0; i< arr.length;  i++ ) {
			
			if (min > arr[i] ) {
				min = arr[i];
			}
		} 
        System.out.println("Smallest element being " + min + " ");
		}
	
}
