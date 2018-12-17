import java.util.ArrayList;
/**
 * 
 * @author Tomohiro Furuya
 * @version 25 Nov 2017
 *
 */
public class CustomerBase{

	private ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>();
	/**
	 * making a constructor for CustomerBase class with one field variable
	 * @param allCustomers
	 */
	public CustomerBase(ArrayList<CustomerWithGoods> allCustomers) {
		//super();
		this.allCustomers = allCustomers;
	}

	/**
	 * this method is making customer list as ArrayList
	 * keep adding each customer to array list
	 * @param customer is customer of this method 
	 */
	public void addCustomer(CustomerWithGoods customer) {
		allCustomers.add(customer);
	}
	/**
	 * this method is calculating total spending cost of each customer 
	 * and then picking up some customers as loyal customer who are above an average
	 * @return loyal is arraylist of loyal customer
	 */
	public ArrayList<CustomerWithGoods> filterLoyal(){
		ArrayList<CustomerWithGoods> loyal = new ArrayList<CustomerWithGoods>() ;
		double ave = 0;
		double total = 0;
		for(int i = 0; i < allCustomers.size();i++) {
			total += allCustomers.get(i).getGoods().size();
			//counter++;
		}
		ave =total/ allCustomers.size();
		for(int i=0; i< allCustomers.size();i++) {
			if(allCustomers.get(i).getGoods().size() > ave) {
			loyal.add(allCustomers.get(i));
		}
		}
	return loyal;
	}
	/**
	 * this method is calculating how many good each customer bought 
	 * and then picking up some customers as valued customer who are above an average
	 * @return valued is arraylist of valued customer
	 */
	public ArrayList<CustomerWithGoods> filterValued(){
		ArrayList<CustomerWithGoods> valued = new ArrayList<CustomerWithGoods>();
		double ave= 0;
		double total = 0;
		for(int i = 0; i< allCustomers.size(); i++) {
			total += allCustomers.get(i).valueOfGoods();
		}
		ave = total / allCustomers.size();
		
		for(int i =0;i< allCustomers.size();i++) {
			if(allCustomers.get(i).valueOfGoods() > ave) {
				valued.add(allCustomers.get(i));
			}
		}
		return valued;
	}
	
}
