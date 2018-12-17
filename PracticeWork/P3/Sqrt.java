
public class Sqrt {

	public static double sumSqrt(double[] a) {
	
		double sum = 0;
		
			for(int i=0; i < a.length; i++ ) {
				sum += Math.sqrt(a[i]);
		}	
			return sum;	
	}
	public static void main(String[] args) {
		
		double[] arr = {1,2,4,9};
		
		System.out.print(sumSqrt(arr));
	}
}
