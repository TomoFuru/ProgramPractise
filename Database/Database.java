package readfile
;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private static String Username = ":::::::";
	private static String Password = ":::::";
	private static String dbURL = "artists-songs-albums-tags.csv1";
	
	static Connection connect;
	static Statement sqlQuery;
	static ResultSet resultSet;

	public static void connectToDatabase() {

		try {

			connect = DriverManager.getConnection(dbURL, Username, Password);

		} catch (Exception e) {
			System.out.println("Connection Failed! Please try again.");
			e.printStackTrace();
		}
	}

	private static void getDataFromDB() {
		 
		try {
			
			String getQueryStatement = "SELECT * FROM countries";
 
			Statement sqlQuery = connect.createStatement();
 
			// Execute the Query, and get a java ResultSet
			ResultSet resultSet = sqlQuery.executeQuery(getQueryStatement);
 
			// Let's iterate through the java ResultSet
			while (resultSet.next()) {
				
				//String population = resultSet.getString("population");
				//String name = resultSet.getString("name");
				//String population = resultSet.getString("population");
				String song = resultSet.getString("song");
				String artist = resultSet.getString("artist");
				
				String tag1 = resultSet.getString("tag1");
				
				//System.out.println(population + " | " + name);
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
	}
	
	public static void main(String[] argv) {
		 
		try {
			
			connectToDatabase();
			getDataFromDB();
 
		//	sqlQuery.close();
			connect.close(); 
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	public ResultSet sqlStatement(Statement sqlQuery) {

		try {

			sqlQuery = connect.createStatement();
			resultSet = sqlQuery.executeQuery("select * from countries");

		} catch (Exception e) {
			System.out.println("Incorrect SQl Statement. Please try again.");
			e.printStackTrace();
		}
		return resultSet;

	}

	public static void main(String[] args) throws SQLException {
		
		System.out.println(resultSet.getString("name") + ", " + resultSet.getString("population"));

		try {

			Connection connect = DriverManager.getConnection(
					"jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/world", "axb1302", "password");

			Statement stateM = connect.createStatement();

			ResultSet res = stateM.executeQuery("select * from countries");

			while (res.next()) {
				System.out.println(resultSet.getString("name") + ", " + res.getString("population"));
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}
*/
	
}

			
			

