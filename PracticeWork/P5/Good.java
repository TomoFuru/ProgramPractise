/**
 * 
 * @author Tomohiro Furuya
 * @version 25 Nov 2017
 */
public class Good {
	private String name;
	private int price;

	/**
	 * making a constructor for Good class
	 * @param name is name of goods
	 * @param price is price of goods
	 */
	
	public Good(String name, int price) {
		//super();
		this.name = name;
		this.price = price;
	}
	/**
	 * making setter for field variable of price
	 * @return price is price of goods as int
	 */
	public int getPrice() {
		return price;
	}
    /**
     * toString method for outputting name and price of goods
     */
	@Override
	public String toString() {
		return  name + " is £ " + price ;
	}
	
	
}
