import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class CustomerTest {

	

	

	
		
		
		@Test
		public void test1() {
			
			ArrayList<Customer> allCustomers = new ArrayList<Customer>();
			
			Customer george = new Customer ("George", "24 Harbone", "09077593493");
			Customer rahim = new Customer("Rahim", "44 Edgbaston", "07658933893");
			
			allCustomers.add(george);
			allCustomers.add(rahim);
			
			String expected1 = "Customer Name: George, Address: 24 Harbone, Telephone Number: 09077593493.";
			String actual1 = george.toString();
			
			String expected2 = "Customer Name: Rahim, Address: 44 Edgbaston, Telephone Number: 07658933893.";
			String actual2 = rahim.toString();
			
			assertEquals(expected1, actual1);
			assertEquals(expected2, actual2);
			
		}
		
		@Test
		public void test2() {
			
			ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>();

			CustomerWithGoods scott = new CustomerWithGoods ("Scott", "22 North Road", "07257935874");
			CustomerWithGoods alina = new CustomerWithGoods ("Alina", "7 ", "07656547282");
			
			allCustomers.add(scott);
			allCustomers.add(alina);
			
			Good pizza = new Good("Pizza", 5);
			Good pasta = new Good("Pasta", 7);
			Good salad = new Good("Salad", 3);
			Good panini = new Good("Panini", 11);
			Good coffee = new Good("Coffee", 1);
			
			scott.buy(pizza);
			scott.buy(pasta);
			scott.buy(salad);
			alina.buy(coffee);
			alina.buy(panini);
			
			int expected1 = 15;
			int actual1 = scott.valueOfGoods();
			
			int expected2 = 12;
			int actual2 = alina.valueOfGoods();
			
			assertEquals(expected1, actual1);
			assertEquals(expected2, actual2);
			
		}
		
		@Test
		public void test3() {
			
			ArrayList<Customer> allCustomers = new ArrayList<Customer>();
			
			CustomerWithGoods ellen = new CustomerWithGoods("Ellen", "9 Smoker Road", "07445555777");
			CustomerWithGoods Tom = new CustomerWithGoods("Tom", "55 Yarraville Lane", "08733781267");
			
			allCustomers.add(ellen);
			allCustomers.add(Tom);
			
			Good chocolate = new Good("Chocolate", 5);
			Good vanilla = new Good("Vanilla", 6);
			Good chocomint = new Good("Chocomint", 3);
			Good salt = new Good("Salt", 2);
			Good strawberry = new Good("Strawberry", 6);
			
			ellen.buy(chocolate);
			ellen.buy(vanilla);
			ellen.buy(strawberry);
			Tom.buy(chocomint);
			Tom.buy(strawberry);
			Tom.buy(salt);
			
			
			String expected1 = "Customer Name: Ellen Goods customer buy [Chocolate is £ 5, Vanilla is £ 6, Strawberry is £ 6]";
			String actual1 = ellen.toString();
			
			String expected2 = "Customer Name: Tom Goods customer buy [Chocomint is £ 3, Strawberry is £ 6, Salt is £ 2]";
			String actual2 = Tom.toString();
			
			assertEquals(expected1, actual1);
			assertEquals(expected2, actual2);
			
		}
		
		@Test
		public void test4() {
			

			ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>();
			
			CustomerBase main = new CustomerBase(allCustomers);
			
			CustomerWithGoods dan = new CustomerWithGoods ("Dan", "11 Speare Ave", "07156732957");
			CustomerWithGoods jess = new CustomerWithGoods("Jess", "5 Selly Park", "07457247142");
			CustomerWithGoods david = new CustomerWithGoods("David", "2 Gym Lane", "07547256103");
			CustomerWithGoods john = new CustomerWithGoods("John", "99 South Road", "0773627184");

			Good tuna = new Good("Tuna", 3);
			Good salmon = new Good("Salmon", 2);
			Good oyster = new Good("Oyster", 7);
			Good squid = new Good("Squid", 5);
			Good carrot = new Good("Carrot", 14);

			allCustomers.add(dan);
			allCustomers.add(jess);
			allCustomers.add(david);
			allCustomers.add(john);

			dan.buy(salmon);
			dan.buy(carrot);
			jess.buy(carrot);
			jess.buy(oyster);
			jess.buy(squid);
			jess.buy(tuna);
			david.buy(oyster);
			david.buy(squid);
			david.buy(salmon);
			john.buy(carrot);
			john.buy(salmon);
			john.buy(tuna);
			john.buy(salmon);

			ArrayList<CustomerWithGoods> loyalCustomers = new ArrayList<CustomerWithGoods>(Arrays.asList(jess, john));
			
			ArrayList<CustomerWithGoods> expected = loyalCustomers;
			
			ArrayList<CustomerWithGoods> actual = main.filterLoyal();
			
			assertEquals(expected, actual);
					
		}
		
		@Test
		public void test5() {

			ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>();
			
			CustomerBase main = new CustomerBase(allCustomers);
			
			CustomerWithGoods dan = new CustomerWithGoods ("Dan", "11 Speare Ave", "07156732957");
			CustomerWithGoods jess = new CustomerWithGoods("Jess", "5 Selly Park", "07457247142");
			CustomerWithGoods david = new CustomerWithGoods("David", "2 Gym Lane", "07547256103");
			CustomerWithGoods john = new CustomerWithGoods("John", "99 South Road", "0773627184");

			Good chicken = new Good("Chicken", 5);
			Good rice = new Good("Rice", 2);
			Good curry = new Good("Curry", 13);
			Good naan = new Good("Naan", 1);
			Good familypack = new Good("Family Pack", 30);

			allCustomers.add(dan);
			allCustomers.add(jess);
			allCustomers.add(david);
			allCustomers.add(john);

			dan.buy(chicken);
			dan.buy(rice);
			dan.buy(naan);
			dan.buy(naan);
			dan.buy(naan);
			jess.buy(rice);
			david.buy(curry);
			david.buy(naan);
			david.buy(chicken);
			john.buy(familypack);
			john.buy(familypack);
			john.buy(familypack);
			john.buy(familypack);

			ArrayList<CustomerWithGoods> valueCustomers = new ArrayList<CustomerWithGoods>(Arrays.asList(john));
			
			ArrayList<CustomerWithGoods> expected = valueCustomers;
			
			ArrayList<CustomerWithGoods> actual = main.filterValued();
			
			assertEquals(expected, actual);
					
		}
		
		@Test
		public void test6() {
			
			ArrayList<CustomerWithGoods> allCustomers = new ArrayList<CustomerWithGoods>();

			CustomerWithGoods ollie = new CustomerWithGoods ("Ollie", "66 Aldi", "0457378299");
			CustomerWithGoods anita = new CustomerWithGoods ("Anita", "33 Espana Lane", "0805481504");
			
			allCustomers.add(ollie);
			allCustomers.add(anita);
			
			Good beer = new Good("Beer", 5);
			Good chips = new Good("Chips", 2);
			Good coke = new Good("Coke", 1);
			Good whitewine = new Good("White Wine", 4);
			Good sake = new Good("Sake", 30);
			Good mulledwine = new Good("Mulled Wine", 6);
			
			ollie.buy(beer);
			ollie.buy(mulledwine);
			ollie.buy(mulledwine);
			ollie.buy(sake);
			ollie.buy(sake);
			ollie.buy(mulledwine);
			ollie.buy(beer);
			ollie.buy(chips);
			
			anita.buy(whitewine);
			anita.buy(whitewine);
			anita.buy(mulledwine);
			anita.buy(mulledwine);
			anita.buy(coke);
			
			int expected1 = 90;
			int actual1 = ollie.valueOfGoods();
			
			int expected2 = 21;
			int actual2 = anita.valueOfGoods();
			
			assertEquals(expected1, actual1);
			assertEquals(expected2, actual2);
			
		}


}
