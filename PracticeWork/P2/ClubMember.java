/**
 * 
 * @author Tomohiro Furuya
 * @version 7 Oct 2017
 */
public class ClubMember {
	private String name;
	private String dateOfBirth;
	private String registrationNumber;
	private String membershipType;
	
	/**
	 * @param name is the name of ClubMember
	 * @param dateOfBirth is the dateOfBirth of ClubMember
	 * @param registrationNumber is the registrationNumber of ClubMember
	 * @param membershipType is the membershipType of ClubMember
	 */
	
	public ClubMember(String name, String dateOfBirth, String registrationNumber, String membershipType) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.registrationNumber = registrationNumber;
		this.membershipType = membershipType;
	}
    /**
     * @return the name of club member as String
     */
	public String getName() {
		return name;
	}
    /**
     * @return the date of birth of club member as String
     */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
    /**
     * @return the registration number of club member as String 
     */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
    /** 
     * @return the membership type of club member as String
     */
	public String getMembershipType() {
		return membershipType;
	}
    /**defines how to print a film
     * the print tyoe of film
     */
	@Override
	public String toString() {
		return "[" + name + ", " + dateOfBirth + ", "
				+"ID: "+ registrationNumber + ", " + membershipType + "]";
	}
	 /**
     * main method of program
	 * This class is to test the ClubMember class and its methods.
      *  We create some objects of class ClubMember and get some parts back.
     */
	public static void main(String[] args) {
		
		ClubMember c1 = new ClubMember("John Smith","5 October 1993", "C212121","Gold" );
	
		System.out.println(c1.toString());	
	}	
}
