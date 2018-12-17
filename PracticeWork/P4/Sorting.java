/**
 * 
 * @author Tomohiro Furuya
 * @version 9 Nov 2017
 */
public class Sorting  {

	
   
    /**
     * 
     * @param a The array to be sorted
     * @return The sorted array.
     */
	
	
    public static Sortable[] quickSort(Sortable[] a) {
        if (a.length == 0) {
            return a;
        }
        return quickSort(a,0,a.length-1); 
    }

    /**
     *   @param a The array to be sorted in a range.
     *   @param start The smallest index in the range of the array to be sorted.
     *   @param end The largest index in the range of the array to be sorted.
     *   @return The value of the pivot.
     */
    public static Sortable determinePivot(Sortable[] a, int start, int end) {
        
        int pivot_index = start + (end - start) / 2;

       
        return a[pivot_index];
    }

    /**
     *   Performs in-place quicksort over the provided array,
     *   @param a The array to be sorted in a range.
     *   @param start The smallest index in the range of the array to be sorted.
     *   @param end The largest index in the range of the array to be sorted.
     *   @return The array in which the specified range is sorted.
     */
    public static Sortable[] quickSort(Sortable[] a, int start, int end) {
        Sortable temp;
        int i = start;
        int j = end;
    
       Sortable pivot = determinePivot(a, start, end);
        while (i <= j) {
            while (a[i].compareValue() < pivot.compareValue()) {
                i++;
            }   
            while (a[j].compareValue() > pivot.compareValue()) {
                j--;
            }

            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        if (start < j)
            quickSort(a,start,j);
        if (i < end)
            quickSort(a,i,end);
        return a;
    }
}
