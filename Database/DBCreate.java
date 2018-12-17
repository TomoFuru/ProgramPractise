package readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBCreate {
  private final String dbName = "jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/txf795";
  private final String username = ":::::";
  private final String password = "::::::";

  private String Table1 = "CREATE TABLE IF NOT EXISTS songs(song_id INT NOT NULL PRIMARY KEY, song VARCHAR NOT NULL)";
  private String Table2 = "CREATE TABLE IF NOT EXISTS tags(song_id INT REFERENCES songs (song_id) NOT NULL, tag VARCHAR NOT NULL)";
 // private String T2 = "CREATE TABLE IF NOT EXISTS artist(song_id INT NOT NULL PRIMARY KEY, artist VARCHAR NOT NULL)";
 // private String T3 = "CREATE TABLE IF NOT EXISTS album(song_id INT NOT NULL PRIMARY KEY, album VARCHAR NOT NULL)";

  public static void main(String[] args) {
    DBCreate db = new DBCreate();
    db.createTables();
    db.loadSongs();
    db.loadTags();
  }

  public Connection connection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(dbName, username, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (conn != null) {
      System.out.println("Database accessed!");
    } else {
      System.out.println("Failed to make connection");
    }
    return conn;
  }

  public void createTables() {
    try {
      Connection conn = connection();
      System.out.println("Attempting to create tables");
      PreparedStatement createT1 = conn.prepareStatement(Table1);
      PreparedStatement createT2 = conn.prepareStatement(Table2);
      PreparedStatement createT3 = conn.prepareStatement(Table2);
      createT1.executeUpdate();
      createT2.executeUpdate();
      createT3.executeUpdate();
      System.out.println("Table creation successful");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error! Tables could not be created. Check Stack Trace.");
    }
  }

  public void loadSongs() {
    Connection conn = connection();
    System.out.println("Attempting to populate the songs table");
    String insert = "INSERT INTO songs(song_id,song) VALUES(?,?)";
    String insert2 = "INSERT INTO artist(song_id,artist) VALUES(?,?)";
    String insert3 = "INSERT INTO albums(song_id,albums) VALUES(?,?)";
   
    try {
      BufferedReader br = new BufferedReader(
          new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv"));
      try {
        br.readLine();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      String line = null;
      int i = 1;
      try {
        while ((line = br.readLine()) != null) {
          try {
            if (line != null) {
              String[] data = line.split(",");
              for (int j = 0; j < 1; j++) {
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setInt(1, i);
                ps.setString(2, data[0]);
                
                PreparedStatement ps2 = conn.prepareStatement(insert2);
                ps2.setString(3, data[1]);
                
                PreparedStatement ps3 = conn.prepareStatement(insert3);
                ps3.setString(4, data[2]);
                
                
                ps.executeUpdate();
                ps2.executeUpdate();
                ps3.executeUpdate();
                
                ps.close();
                ps2.close();
                ps3.close();
                i++;
              }
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
    System.out.println("Songs table populated!");
  }

  public void loadTags() {
    Connection conn = connection();
    System.out.println("Attempting to populate the tags table");
    String insert = "INSERT INTO tags(song_id,tag) VALUES(?,?)";
    try {
      BufferedReader br = new BufferedReader(
          new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv"));
      try {
        br.readLine();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      String line = null;
      int i = 1;
      try {
        while ((line = br.readLine()) != null) {
          try {
            if (line != null) {
              String[] data = line.split(",");
              for (int j = 3; j < data.length; j++) {
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setInt(1, i);
                ps.setString(2, data[j]);
                ps.executeUpdate();
                ps.close();
              }
              i++;
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
    System.out.println("Tags table populated!");
  }
}
