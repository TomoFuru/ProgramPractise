/**
 * Film is a class for a very simple file
 * @author Tomohiro Fruya
 * @version 7 October 2017
 */
public class Film {
    private String title;
    private int year;
    private int length;
    
    /**
     * 
     * @param title is the title of film
     * @param year is the year that the film released
     * @param length is the length of film
     */
    public Film(String title, int year, int length){
    	this.title = title;
    	this.year = year;
    	this.length = length;
    }
   /**
    *  get name of film
    * @return the name of film as String
    */
	public String getTitle() {
		return title;
	}
   /**
    * @return the number of film year as int
    */
	public int getYear() {
		return year;
	}
	/**
	    * @return the number of length of film as int
	    */
		
	public int getLength() {
		return length;
	}
    /**
     * set length of film
     * @param length the new length of specific film
     */
	public void setLength(int length) {
		this.length = length;
	}
    /**defines how to print a film
     * the print tyoe of film
     */
	@Override
	public String toString() {
		return "[" +  title + ", " + year + ", " + length + " mins. ]";
	}
	/**main method of program
	 * This class is to test the Film class and its methods.
      *  We create some objects of class Film and get some parts back.
	 */
public static void main(String[] args) {
		
		Film Cars  = new Film( "Cars",2006 ,116 );
	
		System.out.println(Cars);	
	}
	
	
}
