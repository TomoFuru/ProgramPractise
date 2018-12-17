import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SelectionSortTest {

	@Before
	public void setUp() throws Exception {
	}
	 /**
     *  test1 is tested about sorting 9 numbers
     */
    @Test 
    public void test1() {
		
        int[] a = {4, 2, 6, 7, 5, 8, 2, 9, 3};
		
		
        int[] expected = {2, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }
    /**
     *  test2 is tested about sorting 4 numbers
     */
    @Test 
    public void test2() {
		
        int[] a = {1, 1, 1, 5};
		
		
        int[] expected = {1, 1, 1, 5};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }
	
    /**
     *  test3 is tested about sorting 15 numbers
     */
    @Test 
    public void test3() {
		
        int[] a = {7, 4, 9, 3, 7, 2, 7, 5, 1, 8, 5, 0, 3, 2, 9};
		
		
        int[] expected = {0, 1, 2, 2, 3, 3, 4, 5, 5, 7, 7, 7, 8, 9, 9};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }
    /**
     *  test4 is tested about sorting no numbers
     */
    public void test4() {
		
        int[] a = {};
		

        int[] expected = {};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }
    /**
     *  test5 is tested about sorting 21 numbers
     */
    @Test 
    public void test5() {
		
        int[] a = {0, 2, 8, 6, 4, 2, 2, 9, 5, 5, 8, 6, 9, 0, 8, 4, 0, 9, 4, 6, 5};
		
		
        int[] expected = {0, 0, 0,  2, 2, 2, 4, 4, 4, 5, 5, 5, 6, 6, 6, 8, 8, 8, 9, 9, 9};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }
	
    /**
     *  test6 is tested about only sorting 1 number
     */
    @Test 
    public void test6() {
		
        int[] a = {6};
		
		
        int[] expected = {6};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }
	
    /**
     *  test7 is tested about sorting 6 numbers including negative numbers
     */
    @Test 
    public void test7() {
		
        int[] a = {Integer.MAX_VALUE, -2, -3, -1, -1, -2, 4};
		

        int[] expected = {-3, -2, -2, -1, -1, 4, Integer.MAX_VALUE};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }

    /**
     *  test8 is tested about sorting 10 numbers (some oh them are same number)
     */
    @Test 
    public void test8() {
		
        int[] a = {1, 1, 1, 3, 3, 3, 4, 4, 4, 0};
		

        int[] expected = {0, 1, 1, 1, 3, 3, 3, 4, 4, 4};
        int[] actual = SelectionSort.selectionSort(a);
		
        assertArrayEquals("Your sorting system is wrong!",expected, actual);
    }

   
}
