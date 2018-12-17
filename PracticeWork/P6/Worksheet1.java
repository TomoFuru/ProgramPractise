/**
 * Worksheet1 in 2nd semester-WS2-1
 * @author Tomohiro Furuya 
 * @version 19 Jan 2018
 *
 */

public class Worksheet1 {

  // Exercise 1
	/**
	 * Coding the recursive algorithms for rising integer m to the power of integer n
	 * this method using function of "power"
	 * @param m is Integer
	 * @param n
	 * @return rising integer m to the power of integer n
	 */
  public static int power(int m, int n) {
		if(n ==0) {
    		return 1;
    	}
    	else 
    		return (m * power(m,n-1));
     } 
	/**
	 * Coding the recursive algorithms for rising integer m to the power of integer n
	 * this method using function of "fastPower"
	 * 
	 * @param m is an Integer that will be increase 
	 * @param n is an Integer
	 * @return rising integer m to the power of integer n
	 * return is changed to 3 cases, when n is 0, n is even number and n is odd number
	 */
  public static int fastPower(int m, int n) {
	  if(n ==0) {
 		 return 1;
 	 }
 	 else if(n%2 ==0)// when n is even number
 		 {
 		
 		 return (fastPower(m,n/2)*fastPower(m,n/2));
 	 }else 
 		 return (m * fastPower(m,n-1));
 	
	}

  // Exercise 2
  	/**
  	 * this method return new list with all elements of given a list of integers 
  	 * @param a is a list of Integer
  	 * @return new list with sign negated, negative num become positive, positive num become negative
  	 */
	public static List<Integer> negateAll(List<Integer> a) {
		if(a.isEmpty())
 			return new List<Integer>();
 			
 		else 
 		return new List<Integer>(a.getHead()*(-1),negateAll(a.getTail()));
	}

  // Exercise 3
	/**
	 * code a method that find the position of the first occurrence of integer x in list a
	 * x and a are given
	 * @param x is an integer which will try to find a same number from given list
	 * @param a is a list of Integer
	 * @return position of first appearance of x in a
	 */
	public static int find(int x, List<Integer> a) {
		if (a.isEmpty())
 			throw new IllegalArgumentException("List does not have enough elements.");
 		else if(x == a.getHead())
 			return 0;
 		else {
 	  return 1 + find(x,a.getTail());
 		}
		}

	
	
	// Exercise 4
	/**
	 * code a method of examine a list whether all elements in given list are positive number or not
	 * list a is given
	 * @param a is a list of Integer
	 * @return a boolean value 
	 */
	public static boolean allPositive(List<Integer> a) {
		if(a.isEmpty()) {
 			return true ;
		}
 		else if (a.getHead() >= 0)
 			return allPositive(a.getTail());
 	
 		else if(a.getHead() <0) 
 		return false;
 		else 
 			return true;		
 		} 
	

	// Exercise 5
	/**
	 * code a method that make a new list which consists of all the positive numbers from given integer list
	 * new list should be in the same relative order as in a 
	 * @param a is a list of Integer that is given
	 * @return new list which consists of all the positive elements of a
	 */
	public static List<Integer> positives(List<Integer> a) {
		if(a.isEmpty()) {
			return new List<Integer>();
		}else if(a.getHead() > 0){
			return new List<>(a.getHead(),positives(a.getTail()));
		}else
			return a.getTail();
	}
	/**
	 * code a method that test a list whether integer list is sorted in increasing order or not
	 * @param a is a list of Integer that is given 
	 * @return boolean value indicating whether a is sorted in increasing order
	 */
	// Exercise 6

	public static boolean sorted(List<Integer> a) {
		if(a.isEmpty()) {
			return true;
		}else if(a.getTail().isEmpty()) {
		return true;
		}
		else if (a.getHead() <= (a.getTail()).getHead())
			return sorted(a.getTail());
		else 
		return false;
		
	}
	/**
	 * Code a method that is about creating new list which is sorted list 
	 * that consists of all elements from two given list
	 * @param a is List of Integer that is given
	 * @param b is List of Integer that is given
	 * @return new sorted list that contains all elements of given list a and all elements of given list b
	 */
	// Exercise 7

	public static List<Integer> merge(List<Integer> a, List<Integer> b) {
			if(a.isEmpty() && b.isEmpty()) {
				return new List<Integer>();
			}
			else if(a.isEmpty()) {
				return b;
			}else if(b.isEmpty()) {
				return a;
			}else if(a.getHead() <= b.getHead()) {
				return new List<Integer>(a.getHead(),merge(a.getTail(),b));
			}else 
				return new List<Integer>(b.getHead(),merge(a,b.getTail()));
			}
	/**
	 * Code method that create a new list 
	 * which is copy of given list with all duplicate copies removed
	 * @param a- a List of Integer that is given
	 * @return 
	 */
	// Exercise 8

	static List<Integer> removeDuplicates(List<Integer> a) {
			if(a.isEmpty()) {
				return new List<Integer>();
			}else if(a.getTail().isEmpty()) {
				return a;
			}
			else if(a.getHead()==(a.getTail().getHead())) {
				return removeDuplicates(a.getTail());
			}else {
				return new List<Integer>(a.getHead(),removeDuplicates(a.getTail()));
			}
	}
	}

	


