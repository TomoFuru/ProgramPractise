import java.util.ArrayList;
/**
 * 
 * @author Tomohiro furuya
 * @version 27 Nov 3017
 */
public class BuildClass {

	private String className;
	private ArrayList<Var>fields;
	/**
	 * constructor for BuidClass for setting two fields variable 
	 * @param className is classname of Build class
	 * @param fields is field of Build class
	 */
	public BuildClass(String className, ArrayList<Var> fields) {
		super();
		this.className = className;
		this.fields = fields;
	}
  /**
   *  this method is string method for outputting field variables
   * @return var is list of field variables
   */
	public String makeFields() {
		String var = "";
		for(int i=0; i<fields.size(); i++) {
			var += ("     private " + fields.get(i).getTypeOfVar() +" "+ fields.get(i).getNameOfVar()+";\n");
		}
		//var+="\r\n";
		return var;
	}
	/**
	 *  this method is String method for making constructor
	 * @return is string method of class name
	 */
	public String makeConstructor() {
		
		String heading = "";
		String variables = "";

		for(int i = 0; i < fields.size()-1; i++) {
			heading += fields.get(i).getTypeOfVar() + " " + fields.get(i).getNameOfVar() + ", ";
		}
		for(int i = fields.size()-1 ; i < fields.size(); i++) {
			heading += fields.get(i).getTypeOfVar() + " " + fields.get(i).getNameOfVar() + ") {" + "\n";
		}
		for(int i = 0; i <fields.size(); i++) {
			variables += "     this." + fields.get(i).getNameOfVar() + " = " + fields.get(i).getNameOfVar() + "; " + "\n";
		}

		return "\n" + "     public " + className + " (" + heading + "\n" + variables + "\n" + "     }";

	}
    /**
     * this String method is for making virtual getter method as String
     * @return get is virtual getter as String method
     */
	public String makeGetters() {
		String get = "";
		for(int i=0; i<fields.size(); i++) {
			String vartype = fields.get(i).getTypeOfVar();
			String varname = fields.get(i).getNameOfVar();
			get += "     public "+ vartype + " get"+ varname.substring(0,1).toUpperCase()
					+ varname.substring(1)+ "() {\n           return "
					 + varname +
			        ";\n     }\n\n";
			}
		return "\n\n" +get;
	}
	/**
	 * this setter method is for making virtual setter method as String
	 * @return set is virtual setter as String
	 */
	public String makeSetters() {
		String set ="";
		for(int i=0; i<fields.size(); i++) {
			String vartype = fields.get(i).getTypeOfVar();
			String varname = fields.get(i).getNameOfVar();
			set += "     public void set"+ varname.substring(0,1).toUpperCase() + varname.substring(1) +"(" + vartype 
					+ " " +varname+") { \n"+"          this." + varname + " = "+varname + "; \n\n     } \n\n";
					
		}
		return set;
	}
	/**
	 * 
	 * @return
	 */
	public String buildClass() {
		String buildClass =makeFields() + makeConstructor() + makeGetters() + makeSetters();
		return "public class " + className + " {\n\n" + buildClass + "}";
	}
	/**
	 * this method is used for checking each methods have been already created.
	 * Define three field variables for outputting each method
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Var> a = new ArrayList<Var>();
		Var var1 = new Var("String", "name");
		Var var2 = new Var("String", "address");
		Var var3 = new Var("String", "postcode");

		a.add(var1);
		a.add(var2);
		a.add(var3);

		BuildClass main = new BuildClass("Customer", a);

		System.out.println(main.buildClass());

	}
	
}
