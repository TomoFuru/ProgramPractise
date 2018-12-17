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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dbhw3 {
	
	
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

		//	PreparedStatement createTable1 = conn.prepareStatement(songsTable);
		//	PreparedStatement createTable2 = conn.prepareStatement(tagsTable);
			PreparedStatement createTable3 = conn.prepareStatement(artistTable);
		//	PreparedStatement createTable4 = conn.prepareStatement(albumTable);

			// Execute queries to create tables.

			//int a = 
			//		createTable1.executeUpdate();
			//int b = 
			//		createTable2.executeUpdate();
					//int a = 
				createTable3.executeUpdate();
			//int b = 
				//	createTable4.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			//
			}
		}
		public void makeLists() {
		    String line;
		    String splitter = ",";
		    String[] token;
		    List<String> list = new ArrayList<>();
		    Connection connention = connectToDatabase();
		    try {
		    	BufferedReader br = new BufferedReader(new FileReader("artists-songs-albums-tags.csv"));

		      while ((line = br.readLine()) != null) {
		        token = line.split(splitter); 
		        list.addAll(Arrays.asList(token));
		      }
		      String[] strArray = list.toArray(new String[list.size()]);
		      br.close();
		      ArrayList<String> musictags = new ArrayList<>();
		        int rowNumber;
		       rowNumber= 0;
		       for (int i = 5; i < strArray.length; i++) {
		        if (rowNumber == 0) {
		          songs.add(strArray[i]);
		        } else if (rowNumber == 1) {
		          artists.add(strArray[i]);
		        } else if (rowNumber == 2) {
		          albums.add(strArray[i]);
		        } else if (rowNumber == 3) {
		          musictags.add(strArray[i]);
		        } else {
		          if (Character.isLowerCase(strArray[i].charAt(0))) {
		            musictags.add(strArray[i]);
		          } else {
		            rowNumber = 0;
		            tags.add(musictags);
		            songs.add(strArray[i]);
		            musictags = new ArrayList<>();
		          }
		        }
		        rowNumber++;
		      }
		     } catch (FileNotFoundException e) {
		      System.out.println("File not found");
		    } catch (IOException ex) {
		      System.out.println(ex.getMessage() + "Error reading file");
		    }
		  }
			public void makeArtist() {
			    Connection conn = connectToDatabase();
			   
			   // String sql = "INSERT INTO tags(song_id,tag) VALUES(?,?)";
			    try {
			      BufferedReader br = new BufferedReader(new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv"));
			      String album = "INSERT INTO tags(albumid,album) VALUES(?,?)";
			      try {
			        br.readLine();
			      } catch (IOException e1) {
			        e1.printStackTrace();
			      }
			      String line = null;
			      int idcounter;
			      idcounter = 1;
			      try {
			        while ((line = br.readLine()) != null) {
			          try {
			            if (line != null) {
			              String[] array = line.split(",");
			              for (int i = 1; i < array.length; i++) {
			                PreparedStatement statement = conn.prepareStatement(album);
			                statement.setInt(1, i);
			                statement.setString(2, array[i]);
			               
			                statement.executeUpdate();
			                statement.close();
			              }
			             idcounter++;
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
				dbhw3 methods =new dbhw3();
				methods.connectToDatabase();
				methods.createTable();
			//methods.makeSongs();
			//	methods.makeTags();
			//	methods.makeAlbum();
				methods.makeArtist();
			}
}
