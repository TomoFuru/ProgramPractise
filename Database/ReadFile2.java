package readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile2 {

  String dbURL = ":::::";
  String Username = ":::::";
  String Password = ":::::";

 Connection con = null;
// array for contents of csv file
  ArrayList<String> songs = new ArrayList<>();
  ArrayList<String> artists = new ArrayList<>();
  ArrayList<String> albums = new ArrayList<>();
  ArrayList<ArrayList<String>> tags = new ArrayList<>();
//making table
 private String Table2 = "CREATE TABLE IF NOT EXISTS albums(album_id INT NOT NULL PRIMARY KEY, album VARCHAR NOT NULL);";
 private String Table1 = "CREATE TABLE IF NOT EXISTS artists(artist_id INT NOT NULL PRIMARY KEY, artist VARCHAR NOT NULL);";
 private String Table3 = "CREATE TABLE IF NOT EXISTS songs(song_id INT NOT NULL PRIMARY KEY, song VARCHAR NOT NULL, artist INTEGER REFERENCES artists(artist_id) NOT NULL, album INTEGER REFERENCES albums(album_id) NOT NULL);";
private String Table4 = "CREATE TABLE IF NOT EXISTS tags(song_id INT REFERENCES songs(song_id) NOT NULL, tag VARCHAR NOT NULL);";
  

  public Connection connectToDatabase() {
		Connection connection = null;
		try {
		//String Password;
		connection = DriverManager.getConnection(dbURL, Username, Password);
		}
		catch (SQLException ex) {
		ex.printStackTrace();
		}
		if (connection != null) {
		System.out.println("Database accessed!");
		} else {
		System.out.println("Failed to make connection");
		}
		return connection;
	}

  public void makeLists() {
    String line;
    String splitter = ",";
    String[] token;
    List<String> list = new ArrayList<>();
    Connection connection = connectToDatabase();
   // String fileName=;
    try {
    	BufferedReader br = new BufferedReader(new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv/"));

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
    
    } catch (IOException ex) {
    
    }
  }
  public void createTables() {
	    try {
	      Connection connection = connectToDatabase();
	      PreparedStatement createT1 = connection.prepareStatement(Table1);
	      PreparedStatement createT2 = connection.prepareStatement(Table2);
	      PreparedStatement createT3 = connection.prepareStatement(Table3);
	      PreparedStatement createT4 = connection.prepareStatement(Table4);
	   
	      createT1.executeUpdate();
	      createT2.executeUpdate();
	      createT3.executeUpdate();
	      createT4.executeUpdate();
	      
	     
	    } catch (Exception e) {
	      e.printStackTrace();
	      
	    }
	  }
 
	  public void artistTable() {
		  Connection connection = connectToDatabase();
    String SQLartist = "INSERT INTO artists(artist_id , artist) VALUES(?,?)";
    try (PreparedStatement psmt = connection.prepareStatement(SQLartist)) {
      int SQLdefault = 0;
      for (String artists : this.artists) {
        psmt.setInt(1, SQLdefault);
        psmt.setString(2, artists);
        psmt.executeUpdate();
        SQLdefault++;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
	  }
	  public void albumsTable() {
		  Connection connection = connectToDatabase();
    String SQLalbum = "INSERT INTO albums(album_id, album) VALUES(?,?)";
    try (PreparedStatement psmt = connection.prepareStatement(SQLalbum)) {
      int SQLdefault = 0;
     for (String albums : this.albums){
        psmt.setInt(1, SQLdefault);
        psmt.setString(2, albums);
        psmt.executeUpdate();
        SQLdefault++;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
	  }

   public void songsTable() {
	   Connection connection = connectToDatabase();
    String SQLsongs = "INSERT INTO songs(song_id, song, artist, album) VALUES(?,?,?,?)";
    String SQLarid = "SELECT artist_id FROM artists WHERE artist LIKE ?";
    String SQLalid = "SELECT album_id FROM albums WHERE album LIKE ?";
    int artistID = 0;
    int albumID = 0;

    try (PreparedStatement psmt = connection.prepareStatement(SQLsongs);
        PreparedStatement artistStatement = connection.prepareStatement(SQLarid);
        PreparedStatement albumStatement = connection.prepareStatement(SQLalid)) {
   // 	String line;
      int SQLdefault = 0;
      for (String line : songs) {
        psmt.setInt(1, SQLdefault);
        psmt.setString(2, line);

        artistStatement.setString(1, this.artists.get(SQLdefault));
        albumStatement.setString(1, this.albums.get(SQLdefault));

        ResultSet artistResult = artistStatement.executeQuery();
        while (artistResult.next()) {
          artistID = artistResult.getInt(1);
        }

        ResultSet albumResult = albumStatement.executeQuery();
        while (albumResult.next()) {
          albumID = albumResult.getInt(1);
        }

        psmt.setInt(3, artistID);
        psmt.setInt(4, albumID);

        psmt.executeUpdate();
        SQLdefault++;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

public void tagsTable(){
    String SQLtags = "INSERT INTO tags(song_id, tag) VALUES(?,?)";
    Connection connection = connectToDatabase();
    try (PreparedStatement psmt = connection.prepareStatement(SQLtags)) {
      int SQLdefault = 0;
      for (List<String> tagList : tags) {
        for (String string : tagList) {
          psmt.setInt(1, SQLdefault);
          psmt.setString(2, string);
          psmt.executeUpdate();
        }
        SQLdefault++;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
 
  
  
  
  public static void main(String[] args) throws SQLException {
		ReadFile2 methods =new ReadFile2();
		methods.connectToDatabase();
		methods.makeLists();
		methods.createTables();
		methods.artistTable();
	//	methods.artistTable();
		methods.albumsTable();
		methods.songsTable();
		methods.tagsTable();
	
	}
	
}

