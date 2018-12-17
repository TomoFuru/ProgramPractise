package readfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class querryCode {
	public static void main(String[] args) {
	final	String dbURL = ":::::";
	final	  String Username = ":::::";
	final	  String Password = ":::::";
		  try {
	      Connection connection = DriverManager.getConnection(dbURL, Username, Password);
         
	      PreparedStatement query1 = connection.prepareStatement(
	          "SELECT COUNT(DISTINCT album) FROM albums;");
	      ResultSet result1 = query1.executeQuery();
	      while (result1.next()) {
	        int answer1 = result1.getInt(1);
	        System.out.println("Q1:\n" + answer1 + "\n");
	      }

	      PreparedStatement query2 = connection.prepareStatement(
	          "SELECT COUNT(DISTINCT album) FROM albums JOIN songs ON albums.album_id = songs.song_id JOIN tags ON songs.song_id = tags.song_id WHERE tag LIKE '%funk rock%';");
	      ResultSet result2 = query2.executeQuery();
	      while (result2.next()) {
	        int answer2 = result2.getInt(1);
	        System.out.println("Q2:\n" + answer2 + "\n");
	      }

	      PreparedStatement query3 = connection.prepareStatement(
	          "SELECT DISTINCT artist FROM artists JOIN songs ON artists.artist_id = songs.song_id JOIN tags ON songs.song_id = tags.song_id WHERE tag LIKE '%new wave%' ORDER BY artist ASC;");
	      ResultSet result3 = query3.executeQuery();
	      ArrayList<String> artists = new ArrayList<String>();
	      while (result3.next()) {
	        String answer3 = result3.getString(1);
	        artists.add(answer3);
	      }
	      System.out.println("Q3:\n" + artists + "\n");

	      PreparedStatement query4 = connection.prepareStatement(
	          "SELECT COUNT(song) FROM songs JOIN tags ON tags.song_id = songs.song_id WHERE song NOT LIKE '%LOVE%' AND tag LIKE '%love%' -"
	      +"SELECT COUNT(song) FROM songs JOIN tags ON tags.song_id = songs.song_id WHERE song NOT LIKE '%LOVE%' AND tag LIKE '%love%'\"");
	      ResultSet result4 = query4.executeQuery();
	      while (result4.next()) {
	        int answer4 = result4.getInt(1);
	        System.out.println("Q4:\n" + answer4 + "\n");
	      }
	      /**
	      PreparedStatement query5 = connection.prepareStatement(
		          "SELECT COUNT(song) FROM songs JOIN tags ON tags.song_id = songs.song_id WHERE song NOT LIKE '%LOVE%' AND tag LIKE '%love%'");
		      ResultSet result5 = query5.executeQuery();
		      while (result4.next()) {
		        int answer5 = (result5.getInt(1)-result4.getInt(1)) ;
		        System.out.println("Q4:\n" + answer5 + "\n");
		      }
	      
	      */
	      
	       PreparedStatement query6 = connection.prepareStatement(
	       "SELECT COUNT(DISTINCT album) FROM albums JOIN songs ON songs.song_id = albums.album_id WHERE song LIKE '%DOG%';");
	       ResultSet result6 = query6.executeQuery();
	       while (result6.next()) {
	       int answer6 = result6.getInt(1);
	       System.out.println("Q5:\n" + answer6 + "\n");
	       }
	      
	       PreparedStatement query7 = connection.prepareStatement(
	       "SELECT COUNT(song_id) FROM songs OIN tags ON tags.song_id = songs.song_id WHERE tag LIKE '%rhythmic%'- "
	       + "SELECT COUNT(song_id) FROM songs JOIN tags ON tags.song_id = songs.song_id WHERE tag LIKE '%playful%';");
	       ResultSet result7 = query7.executeQuery();
	       boolean answer7 = false;
	       while (result7.next()) {
	         answer7 = result7.getBoolean(1);
	       System.out.println("Q6:\n" + answer7);
	       }
	       connection.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	      System.out.println("Could not connect to the database");
	    }
	  }
	
}
