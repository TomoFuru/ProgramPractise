/**
 * 
 * @author Tomohiro Furuya
 * @version 9 Nov 2017
 * this class has implementation to Sortable class/interface 
 */
public class Customer implements Sortable{
	
	private String name;
	private double totalMoneySpent;
	private String address;
	/**
	 * constructor of Customer class
	 * @param name is the name of Customer
	 * @param totalMoneySpent is total money spent of Customer
	 * @param address is the address of Customer
	 */
	public Customer(String name, double totalMoneySpent, String address) {
		super();
		this.name = name;
		this.totalMoneySpent = totalMoneySpent;
		this.address = address;
	}
	/**
	 * defines how to print about Customer
	 * print out detail of customer which is about name, total money spent and address
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", totalMoneySpent=" + totalMoneySpent + ", address=" + address + "]";
	}
	/**
	 * implementation to Sortable interface
	 * return total money spent as double
	 */
	public double compareValue() {
		return this.totalMoneySpent;
		
	}

}
