/**
 * 
 * @author Tomohiro Furuya
 * @version 27 Oct 2017
 */
public class StarRating {
   
	/**
	 * 
	 * @param rating is the rating of each cartoon
	 * @return starrating which is based on average of rating as String 
	 * if loop is using for dividing interpretation of the cartoon
	 */
	
	public static String interpret(double rating) {
		
		 String starrating = "";
		
		if( 1 <= rating && rating <= 3.5 ) 
			return  starrating= "CRAP";
				else if( rating > 3.5 && rating<= 4.0 ) 
			return starrating = "OK";
				else if( rating > 4.0 && rating<= 4.5 ) 
			return starrating = "EXCELLENT";
				else if ( rating > 4.5 &&rating <= 5.0) 
			return starrating= "[HAS ONLY ONE REVIEW]";
		if ( rating > 5.0 || rating < 1.0 )			
			throw new IllegalArgumentException("Invalid rating in StarRating.");
			else return starrating;
	
				}

}

