import java.util.ArrayList;
/**
 * 
 * @author Tomohiro Furuya
 * @version 25 Nov 2017
 */
public class CustomerBaseMain {
 
	public static void main(String[] args) {
	/**
	 * define anArrayList of allCustomers
	 */
		ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>();
		CustomerBase main = new CustomerBase(allCustomers);
		/**
		 * make 4 customers to work other class
		 */
	CustomerWithGoods luis = new CustomerWithGoods("Luis", "34 Bristol Road", "07845627735");
	CustomerWithGoods basilio = new CustomerWithGoods("Basilio", "2 Williamstown Road", "07743987621");
	CustomerWithGoods mette = new CustomerWithGoods("Mette","3 Harbor Lane", "07865905530");
	CustomerWithGoods isabel = new CustomerWithGoods("Isabel","57 Malvern Road", "07598127634");
	/**
	 * define a name and price of good
	 * create 6 different goods
	 */
	Good burger = new Good("Burger", 12);
	Good chips = new Good("Chips", 4);
	Good panini = new Good("Panini", 8);
	Good salad = new Good("Salad", 6);
	Good tea = new Good("Tea", 2);
	Good drink = new Good("Drink", 4);
	/**
	 * add each Customer to arraylist
	 */
	allCustomers.add(luis);
	allCustomers.add(basilio);
	allCustomers.add(mette);
	allCustomers.add(isabel);
	/**
	 * making a record of purchasing each customer
	 */
	luis.buy(burger);
	luis.buy(salad);
	luis.buy(tea);
	basilio.buy(burger);
	basilio.buy(panini);
	basilio.buy(chips);
	basilio.buy(drink);
	mette.buy(panini);
	mette.buy(salad);
	isabel.buy(salad);
	isabel.buy(drink);
	
	/**
	 * output value customer and valued customer
	 */
	System.out.println("Loyal Customers are: ");
	ArrayList<CustomerWithGoods>  loyalCustomers =new ArrayList<CustomerWithGoods>(main.filterLoyal());
	for(int i=0; i<loyalCustomers.size();i++) {
		System.out.println(loyalCustomers.get(i).getCustomerName());
	}

	System.out.println("Valued Customers are: ");
	ArrayList<CustomerWithGoods> valuedCustomers = new ArrayList<CustomerWithGoods>(main.filterValued());
	for(int i=0; i<valuedCustomers.size(); i++) {
		System.out.println(valuedCustomers.get(i).getCustomerName());
		
	}
 }
}
