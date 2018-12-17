/**
 * WS2-2
 *  @author Tomohiro Furuya
 *  @version 23 Jan 2018
 * 
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {
   // Exercise 1
/**
 * method that make a new tree that consist of elements which is negated from given tree
 * @param t is Tree of Integer that is given 
 * @return new Tree which all elements of it is negated 
 */
    public static Tree<Integer> negateAll(Tree<Integer> t) {
		if(t.isEmpty()) {	
    		return new Tree();
		}else {
		return new Tree<Integer>(-t.getValue(),negateAll(t.getLeft()),negateAll(t.getRight()));	
		}
    }

 // Exercise 2
    /**
     * method checks whether all elements of given tree are positive or not
     * @param a is a Tree that is given
     * @return when a is empty or all value of tree is positive number, return true. 
     * Otherwise return false
     */
    public static boolean allPositive(Tree<Integer> a) {
    		if(a.isEmpty()) {
    			return true;
    		}else if(a.getValue() >=0) {//when all elements in Tree is positive
    			return allPositive(a.getLeft())&& allPositive(a.getRight());
    		}else {
				return false;
    		} }


    // Exercise 3
/**
 * method is returning new tree that is the mirror image of a along the left-right axis
 * @param t is a tree that is given
 * @return new tree that is the mirror image of given tree a 
 */
    public static<E> Tree<E> mirror(Tree<E> t) {
    		if(t.isEmpty()) {
    			return new Tree<>();
    		}else //making mirror tree
    			return new Tree<E>(t.getValue(),mirror(t.getRight()),mirror(t.getLeft()));
		}

    // Exercise 4

   //help method for outputting postorder
    public static<E> List<E> append(List<E> a, List<E> b) {
        if (a.isEmpty()) {
            return b;
        } else {
            return new List<E>(a.getHead(), append(a.getTail(), b));//add elements to List
        }
    }
  
    public static<E> List<E> postorder(Tree<E> t) {
		if(t.isEmpty()) {
			return new List<E>();
		} else {//making postorder list
			return append((append(postorder(t.getLeft()), postorder(t.getRight()))), 
					(new List<E> (t.getValue(), new List<E>())));
			
		}
    }


		// Exercise 5
/**
 *  method is checking whether given tree is binary search tree or not
 * @param a is tree that is given 
 * @return boolean value true when given tree is binary search tree, otherwise return false
 */
    public static boolean isSearchTree(Tree<Integer> a) {
		if(a.isEmpty()) {
			return true;
		}else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
			return true;
		}else if(a.getLeft().isEmpty()) {
			if(a.getValue() > a.getRight().getValue()) //when value of node is smaller than right's side child
				{
				return false;
			}else {
				return true && isSearchTree(a.getRight());
			}
		}else if (a.getRight().isEmpty()) {
			if(a.getValue() < a.getLeft().getValue())//when value of node is smaller than left's side child
			{
				return false;
			}else {
				return true && isSearchTree(a.getLeft());
			}
		}else if(a.getValue() < a.getLeft().getValue() || a.getValue() > a.getRight().getValue()) {
			return false ;
		}else { 
		return	true && isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
		}	
		}
		

    // Exercise 6
    /**
     * method that prints the all elements stored in given tree in descending order
     * @param a is tree that is given 
     * this method prints the value stored in tree in descending order
     */
    public static void printDescending(Tree<Integer> a) {
    		if(a.isEmpty()) {
    			 System.out.print(" ");
    		}else {
    			printDescending(a.getRight());//get value of right side of tree
    			System.out.print(a.getValue());
    			printDescending(a.getLeft()); //get value of left side of tree
    		}
    		
    }

		// Exercise 7
    /**
     * method is examining the maximum value of tree that is given
     * @param a is Tree that is given 
     * @return maximum value of given tree a 
     */
    public static int max(Tree<Integer> a) {
    	
    		if(a.isEmpty()) {
			throw new IllegalArgumentException("list does not have any elements.");
		}else if(a.getRight().isEmpty()) {
			return a.getValue(); //when right side of tree is empty, max value is top node
		}else {
			return Math.max(a.getValue(), max(a.getRight()));//most right position in Tree is max value of Tree
			
			}
			
    }
  
    // Exercise 8
/**
 * method delete specific value x from binary search tree a and return the resulting tree
 * @param a is Tree of Integer
 * @param x is integer that will be removed from tree
 * @return the new tree that is removed x value from original tree and it must be binary search tree
 */
 public static Tree<Integer> delete(Tree<Integer> a, int x) {
    	
			if(a.isEmpty()) {
				return a;
			} else if(x < a.getValue()) {
				return new Tree<Integer>(a.getValue(), delete(a.getLeft(),x), a.getRight()); 
			} else if(x > a.getValue()) {
				return new Tree<Integer>(a.getValue(), (a.getLeft()), delete(a.getRight(), x));
			} else { 
				if(a.getLeft().isEmpty() && a.getRight().isEmpty()) {
					return new Tree<Integer>(); 
				} else if (a.getLeft().isEmpty()) {
					return a.getRight();
				} else if (a.getRight().isEmpty()) { 
					return a.getLeft();
				} else {
					return new Tree<Integer>(max(a.getLeft()), delete(a.getLeft(),max(a.getLeft())), a.getRight()); 
					
				}
			}
    }
 
   
    
    
		// Exercise 9
/**
 * method is checking wether given tree is height-balanced tree or not
 * @param a is tree that is given 
 * @return boolean value when given tree is height-balanced tree, returning true, othewwise return false
 */
    public static<E> boolean isHeightBalanced(Tree<E> a) {
    		if(a.isEmpty()) {
    			return true;
    		}else if(Math.abs(a.getLeft().getHeight()-a.getRight().getHeight())>1) 
    			//when the difference of height of both side of tree is more than 2
    		{
			return false;
    		}else {
    			return true && isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
    		}
    }


    
    
		// Exercise 10
//balance roteta depend on which side is heavy and how many times do we need to rotate
public static Tree<Integer> insertHB(int x, Tree<Integer> a) {
	
	    if (a.isEmpty()) {
	      return new Tree<Integer>(x, new Tree<Integer>(), new Tree<Integer>());
	    }else if (x <= a.getValue()) {
	      return new Tree<Integer>(a.getValue(), insert(x, a.getLeft()), a.getRight());
	    } else {
	    } return new Tree<Integer>(a.getValue(), a.getLeft(), insert(x, a.getRight()));
	  }
  

  public static Tree<Integer> deleteHB(Tree<Integer> a, int x) {
	    return listToTree(deleteHelper(a, x));
  }
  
  public static List<Integer> insertHelper(Tree<Integer> t, int x) {
    if (t.isEmpty())
      return new List<Integer>();
    else if (t.getValue() == x)
      return append(insertHelper(t.getLeft(), x),insertHelper(t.getRight(), x));
    else
      return append(insertHelper(t.getLeft(), x), new List<Integer>(t.getValue(),insertHelper(t.getRight(), x)));
  }
  
  public static List<Integer> deleteHelper(Tree<Integer> t, int x) {
    if (t.isEmpty())
      return new List<Integer>();
    else if (t.getValue() == x)
      return append(deleteHelper(t.getLeft(), x),deleteHelper(t.getRight(), x));
    else
      return append(deleteHelper(t.getLeft(), x), new List<Integer>(t.getValue(),deleteHelper(t.getRight(), x)));
  }

  public static Tree<Integer> insert(int n, Tree<Integer> t) {
    if (t.isEmpty())
      return new Tree<Integer>(n, new Tree<Integer>(), new Tree<Integer>());
    else if (n <= t.getValue())
      return new Tree<Integer>(t.getValue(), insert(n, t.getLeft()), t.getRight());
    else
      return new Tree<Integer>(t.getValue(), t.getLeft(), insert(n, t.getRight()));
  }

  public static Tree<Integer> listToTree(List<Integer> l) {
    if (l.isEmpty())
      return new Tree<Integer>();
    else
      return insert(l.getHead(), listToTree(l.getTail()));
  }

  public static List<Integer> inorder(Tree<Integer> t) {
    if (t.isEmpty())
      return new List<Integer>();
    else 
      return append(inorder(t.getLeft()), new List<Integer>(t.getValue(), inorder(t.getRight())));
  }
  
  public static List<Integer> treeSort(List<Integer> l) {
    return inorder(listToTree(l));
  }
}



