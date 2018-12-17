import java.util.ArrayList;


public class Contains {
	/**
	 * 
	 * @param from is the beginning number of array which is included in array
	 * @param to is the end number of array which is excluded in array
	 * @param containedDigit is the number which is going to be searched in array
	 * @return arl is the array which is included number of containedDigit as String
	 */
	public static ArrayList<Integer> allIntergersWith(int from, int to, int containedDigit){
		
		ArrayList<Integer> arl = new ArrayList<Integer>();
		       
		for(int i = from ; i < to ; i++) {
		 if( String.valueOf(i).contains(String.valueOf(Math.abs(containedDigit))))
				 arl.add(i);
		 }
	return arl;
}
	 /**
     * main method of program
     * This class is to test the ArrayList<Integer> allIntergersWith class and its methods.
     *  We give an arrays for make class SelectionSort  working and get some parts back.
     * 
     */
	public static void mani(String[] args) {
		
		System.out.println(allIntergersWith(23,53,3));
		
}

}