/**
 * @author Tomohiro Furuya
 *@version 11 Oct 2017
 */
public class Employee {
    private String name;
    private double hourlySalary;
    private  int numberOfHours;  
    /**
     * @param name is the name of employee
     * @param hourlySalary is the hourly salary of employee
     * @param numberOfHours is how many hours does employee work in a month
     */
	public Employee(String name, double hourlySalary, int numberOfHours) {
	
		this.name = name;
		this.hourlySalary = hourlySalary;
		this.numberOfHours = numberOfHours;
	}
   /**
    * @return the name of employee as String
    */
	public String getName() {
		return name;
	}
    /**
     * @param name the new name of employee
     */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * @return the hourly salary of employee as double
     */
	public double getHourlySalary() {
		return hourlySalary;
	}
    /**
     * @param hourlySalary the new hourly salary of employee
     */
	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}
    /**
     * @return the number of working hours of employee as int 
     */
	public int getNumberOfHours() {
		return numberOfHours;
	}
    /**
     * @param numberOfHours the new number of working hours as int 
     */
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	/**
	 * defines how to print a film
     * the print type of film
	 */
	@Override
	public String toString() {
		return  name + " has an hourly salary of " + hourlySalary
				+ " £ and has worked last month for " + numberOfHours + " hours.";		
	}
	/**calculating the monthly salary that includes tax 
	 * @param taxRate is the tax that come from hourlySalary times numberofHours
	 * @return calculate the salary that is reduced calculated tax
	 */
	public double monthlySalary(double taxRate) {
		return taxRate = ((100-taxRate) / 100)* hourlySalary * numberOfHours ;		
	}
	/**calculating the new hourly salary with increasing rate
	 * @param percentage is the percentage of increasing salary of employee
	 */
	public void increaseSalary(double percentage) {
		setHourlySalary (((percentage + 100)/ 100) * getHourlySalary());
	}
	/**main method of program
	 * This class is to test the Employee class and its methods.
      *  We create some objects of class Employee and get some parts back.
	 */
       public static void main (String[] args) {
		
		Employee john = new Employee((String) "John", (double) 10, (int) 40);
	
		System.out.println(john);	
		
		john.monthlySalary(20);
		System.out.println("John's monthly salary after tax is " + john.monthlySalary(20));
		
		john.increaseSalary(1);
		System.out.println(john);
		
		
		
				
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


    
    
    

