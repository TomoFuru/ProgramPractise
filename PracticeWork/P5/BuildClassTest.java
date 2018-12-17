import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BuildClassTest {
	
	@Test
	public void test1() {
	ArrayList<Var> a = new ArrayList<Var>();
	Var t1 = new Var("String", "School");
	Var t2 = new Var("String", "Course");
	Var t3 = new Var("String", "StudentID");

	a.add(t1);
	a.add(t2);
	a.add(t3);
	

	BuildClass main = new BuildClass("Student", a);

	String expected = 

			"public class Student {"
					+ "\n\n"

	     +"     private String School;\n"
	     +"     private String Course;\n"
	     +"     private String StudentID;\n\n"

	     +"     public Student (String School, String Course, String StudentID) {\n\n"

	     +"     this.School = School; \n"
	     +"     this.Course = Course; \n"
	     +"     this.StudentID = StudentID; \n\n"

	     +"     }\n\n"

	     +"     public String getSchool() {\n"
	     +"           return School;\n"

	     +"     }\n\n"

	     +"     public String getCourse() {\n"
	     +"           return Course;\n"

	     +"     }\n\n"
	     
	     +"     public String getStudentID() {\n"
		 +"           return StudentID;\n"
			
		 +"     }\n\n"

	     +"     public void setSchool(String School) { \n"
	     +"          this.School = School; \n\n"

	     +"     } \n\n" 

	     +"     public void setCourse(String Course) { \n" 
	     +"          this.Course = Course; \n\n"

	     +"     } \n\n" 
	     
		 +"     public void setStudentID(String StudentID) { \n" 
         +"          this.StudentID = StudentID; \n\n"

         +"     } \n\n" 

	+"}";

	String actual = main.buildClass();

	assertEquals(expected, actual);

}

@Test
public void test2() {

	ArrayList<Var> a = new ArrayList<Var>();
	Var t4 = new Var("int", "Number");
	Var t5 = new Var("String", "Name");

	a.add(t4);
	a.add(t5);

	BuildClass main = new BuildClass("Football", a);

	String expected = 

			"public class Football {"
					+ "\n\n"

	     +"     private int Number;\n"
	     +"     private String Name;\n\n"

	     +"     public Football (int Number, String Name) {\n\n"

	     +"     this.Number = Number; \n"
	     +"     this.Name = Name; \n\n"

	     +"     }\n\n"

	     +"     public int getNumber() {\n"
	     +"           return Number;\n"

	     +"     }\n\n"

	     +"     public String getName() {\n"
	     +"           return Name;\n"

	     +"     }\n\n"

	     +"     public void setNumber(int Number) { \n"
	     +"          this.Number = Number; \n\n"

	     +"     } \n\n" 

	     +"     public void setName(String Name) { \n" 
	     +"          this.Name = Name; \n\n"

	     +"     } \n\n" 

	+"}";

	String actual = main.buildClass();

	assertEquals(expected, actual);

}

@Test
public void test3() {

	ArrayList<Var> a = new ArrayList<Var>();
	Var t6 = new Var("String", "coffee");
	Var t7 = new Var("String", "cake");

	a.add(t6);
	a.add(t7);


	BuildClass main = new BuildClass("Cafe", a);

	String expected = 

			"public class Cafe {"
					+ "\n\n"

	     +"     private String coffee;\n"
	     +"     private String cake;\n\n"

	     +"     public Cafe (String coffee, String cake) {\n\n"

	     +"     this.coffee = coffee; \n"
	     +"     this.cake = cake; \n\n"

	     +"     }\n\n"

	     +"     public String getCoffee() {\n"
	     +"           return coffee;\n"

	     +"     }\n\n"

	     +"     public String getCake() {\n"
	     +"           return cake;\n"

	     +"     }\n\n"

	     +"     public void setCoffee(String coffee) { \n"
	     +"          this.coffee = coffee; \n\n"

	     +"     } \n\n" 

	     +"     public void setCake(String cake) { \n" 
	     +"          this.cake = cake; \n\n"

	     +"     } \n\n" 

	+"}";

	String actual = main.buildClass();

	assertEquals(expected, actual);

}

@Test
public void test4() {

	ArrayList<Var> a = new ArrayList<Var>();
	Var t8 = new Var("double", "average");
	Var t9 = new Var("double", "highest");

	a.add(t8);
	a.add(t9);


	BuildClass main = new BuildClass("Rating", a);

	String expected = 

			"public class Rating {"
					+ "\n\n"

	     +"     private double average;\n"
	     +"     private double highest;\n\n"

	     +"     public Rating (double average, double highest) {\n\n"

	     +"     this.average = average; \n"
	     +"     this.highest = highest; \n\n"

	     +"     }\n\n"

	     +"     public double getAverage() {\n"
	     +"           return average;\n"

	     +"     }\n\n"

	     +"     public double getHighest() {\n"
	     +"           return highest;\n"

	     +"     }\n\n"

	     +"     public void setAverage(double average) { \n"
	     +"          this.average = average; \n\n"

	     +"     } \n\n" 

	     +"     public void setHighest(double highest) { \n" 
	     +"          this.highest = highest; \n\n"

	     +"     } \n\n" 

	+"}";

	String actual = main.buildClass();

	assertEquals(expected, actual);

}

@Test
public void test5() {

	ArrayList<Var> a = new ArrayList<Var>();
	Var t10 = new Var("String", "Manchester");
	Var t11 = new Var("String", "Glasgow");

	a.add(t10);
	a.add(t11);

	BuildClass main = new BuildClass("CityinUK", a);

	String expected = 

			"public class CityinUK {"
					+ "\n\n"

	     +"     private String Manchester;\n"
	     +"     private String Glasgow;\n\n"

	     +"     public CityinUK (String Manchester, String Glasgow) {\n\n"

	     +"     this.Manchester = Manchester; \n"
	     +"     this.Glasgow = Glasgow; \n\n"

	     +"     }\n\n"

	     +"     public String getManchester() {\n"
	     +"           return Manchester;\n"

	     +"     }\n\n"

	     +"     public String getGlasgow() {\n"
	     +"           return Glasgow;\n"

	     +"     }\n\n"

	     +"     public void setManchester(String Manchester) { \n"
	     +"          this.Manchester = Manchester; \n\n"

	     +"     } \n\n" 

	     +"     public void setGlasgow(String Glasgow) { \n" 
	     +"          this.Glasgow = Glasgow; \n\n"

	     +"     } \n\n" 

	+"}";


	String actual = main.buildClass();

	assertEquals(expected, actual);

}

@Test
public void test6() {

	ArrayList<Var> a = new ArrayList<Var>();
	Var t12 = new Var("int", "Busticket");
	

	a.add(t12);
	

	BuildClass main = new BuildClass("Ticket", a);

	String expected = 

			"public class Ticket {"
					+ "\n\n"

	     +"     private int Busticket;\n\n"

	     +"     public Ticket (int Busticket) {\n\n"

	     +"     this.Busticket = Busticket; \n\n"

	     +"     }\n\n"

	     +"     public int getBusticket() {\n"
	     +"           return Busticket;\n"

	     +"     }\n\n"

	     +"     public void setBusticket(int Busticket) { \n"
	     +"          this.Busticket = Busticket; \n\n"

	     +"     } \n\n" 

	+"}";

	String actual = main.buildClass();

	assertEquals(expected, actual);

}


}
