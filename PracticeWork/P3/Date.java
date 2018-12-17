

/**
 *   The Date class here is used to pick up on the simpler Date class
 *   from week 2 in order to show how we can restrict the creation of
 *   dates to admissible dates. To this end we write a method
 *   admissible which checks whether inputs of the constructor form a
 *   valid date. If not on construction an IllegalArgumentException is
 *   thrown. Note that we have not dealt with the setters here, they
 *   would need corresponding checks.
 *   
 *   @version 2017-10-19
 *   @author Manfred Kerber
 */
public class Date {

    /**
     * Three field variables for day, month, and year of types int,
     * String and int, respectively.
     */
    private int day;
    private String month;
    private int year;
    
    
    public static boolean admissibleYear(int year){
    	return year >= 1;
    }
   public final static String[] MONTHS =
    {"January","February","March","April","May","June","July",
    	"August","September","October","November","December"};
    
   public final static int[] LENGHTS =
	    {31,28,31,30,31,30,
	     31,31,30,31,30,31};
	    
   
    public static boolean admissibleMonth(String month){
    	for (String m: MONTHS){
    		if(m.equals(month)){
    			return true;
    		}
    	}
    	return false;
   }
    
    public static boolean leapYear(int year){
    	if (year % 400 == 0){
    		return true;
    	}
    	else if (year % 100 == 0){
    		return false;
    	} else if (year % 4 == 0){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static boolean admissibleDay(int day,String month, int year){
    	if(month.equals(MONTHS[1]) && leapYear(year)){
    		return 1 <= day&& day <= 29;
    	}
    	for (int i = 0; i < MONTHS.length; i++){
    		if(month.equals(MONTHS[i]) && 
    				1 <= day && day <= LENGHTS[i]){
    			return true;
    		}
    	}
    	return false;
    }
    /**
     *  @param day The input of a day such as 21 as an int.
     *  @param month The input of a month such as "October" as a String.
     *  @param year The input of a year such as 2016 as an int.
     *  @return true if the day, the month, and the year are all admissible
     *  THIS IS A METHOD STUB. THE METHOD NEEDS STILL TO BE WRITTEN!
     */
    public static boolean admissible(int day, String month, int year) {
        return admissibleYear(year) && admissibleMonth(month)
        		&& admissibleDay(day,month,year);
        	}
     
    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }

    /**
     *  @param day The input of a day such as 21 as an int.
     *  @param month The input of a month such as "October" as a String.
     *  @param year The input of a year such as 2016 as an int.
     *  Note that the constructor throws an IllegalArgumentException if
     *  the date to be constructed would be not admissible.
     */
    public Date(int day, String month, int year) {
    	if (admissible(day,month,year)){
        this.day = day;
        this.month = month;
        this.year = year;
    }else {
    	throw new 
    	IllegalArgumentException("Invalid date in class Date.");}
    }
	
    public static void main(String[] args) {
    	try {
        Date d1 = new Date(20, "October", 2017);
        System.out.println(d1);
        Date d2 = new Date(32, "October", 2017);
        System.out.println(d2);
        Date d3 = new Date(20, "Friday", 2017);
        System.out.println(d3);
    }
    	catch(IllegalArgumentException e){
    		System.out.println("illegal date");}
    	System.out.println(leapYear(2016));
    }
} 


