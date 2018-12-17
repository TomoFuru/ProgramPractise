import java.util.ArrayList;
/**
 * 
 * @author Tomohiro Furuya
 * @version 24 Nov 2017
 *
 */
public class CustomerWithGoods extends Customer{

	private ArrayList<Good> goods = new ArrayList<Good>() ;
	/**
	 * 
	 * @param customerName is name of each customer
	 * @param address is address of each customer
	 * @param telephoneNumber is telephone number of each customer
	 */
	public CustomerWithGoods(String customerName, String address, String telephoneNumber) {
		// TODO Auto-generated constructor stub
		super(customerName, address, telephoneNumber);
	}
    /**
     * 
     * @return goods which shop offered
     */
	public ArrayList<Good> getGoods() {
		return goods;
	}
	/**
	 * 
	 * @param good is good that customer bought
	 */
	public void buy(Good good) {
		goods.add(good);
	}
	/**
	 * this for loop calculate total cost each customer spend
	 * @return amount of value each customer spend
	 */
	public int valueOfGoods() {
		int totalcost = 0;
		for(int i=0; i< goods.size(); i++) {
			totalcost += goods.get(i).getPrice();
		}
		return totalcost;
	}
	/**
	 * this toString method out about name of goods
	 */
	@Override
	public String toString() {
		return "Customer Name: " +getCustomerName() +" Goods customer buy " + goods + "";
	}
	
}
