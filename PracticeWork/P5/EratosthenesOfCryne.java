/**
 * 
 * @author Tomohiro Furuya
 * @version 25 Nov 2017
 */
public class EratosthenesOfCryne {

	/**
	 * 
	 * @param max is the length of numbers
	 * @return primes are number array of prime number
	 */
	public static int[] sieve(int max) {
		
		boolean[] sieve = new boolean[max+1]; //need to add 1 because ??
		int primecounter=0;  //use counter for searching position of prime number in boolean array
		//sieve[0] =false;// 0 is not prime number
		//sieve[1] =false;//1is not prime number
		/**
		 * this for loop define from 2 to end of sieve array, everynumber is true.
		 * because it is before using seive.
		 */

		for (int i = 2; i < sieve.length;i++) {	
			sieve[i] = true;
			sieve[0] = false;
			sieve[1] = false;
		}
		/**
		 * this for loop is 1 st step of sieve.
		 * remove/turn to false all even numbers in boolean array
		 */
		for(int i= 3;i<sieve.length; i++) {
			if(i % 2 == 0) {//remove even  number2
				sieve[i]=false;
			}
		}
		/**
		 * this for loop is 2nd step of sieve.
		 * remove/turn to false all multiple numbers of prime number in boolean array.
		 */
		for(int i = 3; i*i <sieve.length; i++) {
			if(sieve[i]==true) {
			
				for(int j = i * 2; j< sieve.length; j += i) {
					sieve[j]= false;
				}	
			}	//
		}
		/**
		 * calculate how many prime numbers are in the array
		 * It need to make prime numbers array
		 */
		for(int k=0; k<sieve.length; k++) {
				if(sieve[k]==true)
				primecounter++;
			}
		/**
		 * 
		 */
		int[] primes = new int[primecounter];//array length is same as amount of prime numbers in boolean array
		int  m=0;
		/**
		 * this for loop is making prime numbers array with using condition
		 * sieve[i]=true imply prime number
		 */
		for(int i = 0; i< sieve.length;i++) {
			if(sieve[i] == true) {
				primes[m] = i;
				m++;	
			}
		}
		return primes;
	}
    /**
     * print method for printing out of numbers of array
     * @param a is name of number array
     */
	
	public static void print(int[] primes) {
		for(int i= 0; i<primes.length;i++) {
		System.out.print(primes[i] +" ");	
		}
	}
	
	/**
	 * main method of program
	 * This class is to test sieve class methods.
	 * 
	 */
	public static void main(String[] args) {
		
		int test = 100;
	
		print(sieve(test));
	
	}
}

