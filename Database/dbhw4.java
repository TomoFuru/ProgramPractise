package readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbhw4 {
	private static String Username = ":::::";
	private static String Password = ":::::";
	private static String dbURL = ":::::";
	//private static String databaseURL = "jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/world";

	static Connection connect;
	static Statement sqlQuery;
	static ResultSet resultSet;
	
	private  String songsTable = "CREATE TABLE IF NOT EXISTS songs(song_id INT PRIMARY KEY, song VARCHAR, artist VARCHAR NOT NULL, album VARCHAR NOT NULL);";
    private String tagsTable = "CREATE TABLE IF NOT EXISTS tags(song_id int REFERENCES songs (song_id), tag VARCHAR NOT NULL);";
    private  String albumTable = "CREATE TABLE IF NOT EXISTS albums (album_id SERIAL primary key, album VARCHAR NOT NULL);";
    private String artistTable = "CREATE TABLE IF NOT EXISTS artists (artist_id SERIAL primary key, artist VARCHAR NOT NULL);";
 
	 public Connection connectToDatabase() {
			Connection conn = null;
			try {
			//String Password;
			conn = DriverManager.getConnection(dbURL, Username, Password);
			}
			catch (SQLException ex) {
			ex.printStackTrace();
			}
			if (conn != null) {
			System.out.println("Database accessed!");
			} else {
			System.out.println("Failed to make connection");
			}
			return conn;
		}
	    
	    
		public void createTable() {
			Connection conn = connectToDatabase();
			try{
				//Connection conn = DriverManager.getConnection(dbURL, Username, Password);		// Establish connection to the database.

			// SQL queries to create tables in the database.

			//String songsTable = "CREATE TABLE songs (song_id INT PRIMARY KEY, song VARCHAR, artist VARCHAR NOT NULL, album VARCHAR NOT NULL);";
			//String tagsTable = "CREATE TABLE tags (song_id int REFERENCES songs (song_id), tag VARCHAR NOT NULL);";

			PreparedStatement createTable1 = conn.prepareStatement(songsTable);
			PreparedStatement createTable2 = conn.prepareStatement(tagsTable);
			PreparedStatement createTable3 = conn.prepareStatement(artistTable);
			PreparedStatement createTable4 = conn.prepareStatement(albumTable);

			// Execute queries to create tables.

			//int a = 
					createTable1.executeUpdate();
			//int b = 
					createTable2.executeUpdate();
					//int a = 
					createTable3.executeUpdate();
			//int b = 
					createTable4.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			//
			}
		}
		public void makeTags() {
		    Connection conn = connectToDatabase();
		   
		   // String sql = "INSERT INTO tags(song_id,tag) VALUES(?,?)";
		    try {
		      BufferedReader br = new BufferedReader(new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv"));
		      String data2 = "INSERT INTO tags(song_id,tag) VALUES(?,?)";
		      try {
		        br.readLine();
		      } catch (IOException e1) {
		        e1.printStackTrace();
		      }
		      String line= null ;
		      int counter;
		      counter = 1;
		      try {
		        while ((line = br.readLine()) != null) {
		          try {
		            if (line != null) {
		              String[] array = line.split(",");
		              for (int i = 3; i < array.length; i++) {
		                PreparedStatement statement = conn.prepareStatement(data2);
		                statement.setInt(1, i);
		                statement.setString(2, array[i]);
		                statement.executeUpdate();
		                statement.close();
		              }
		              counter++;
		            }
		          } finally {
		              br.close();
		          }
		        }
		      } catch (IOException e) {
		        e.printStackTrace();
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    } catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		   
		  }
			
		public static void main(String[] args) throws SQLException {
			dbhw4 methods =new dbhw4();
			methods.connectToDatabase();
			methods.createTable();
	//	methods.makeSongs();
			methods.makeTags();
	//		methods.makeAlbum();
	//		methods.makeArtist();
		}
		
}
