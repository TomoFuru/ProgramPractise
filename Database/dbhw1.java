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
import java.util.List;

public class dbhw1 {

	private static String Username = ":::::";
	private static String Password = ":::::";
	private static String dbURL = ":::::";
	
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
			
		String songsTable = "CREATE TABLE songs (song_id INT PRIMARY KEY, song VARCHAR, artist VARCHAR NOT NULL, album VARCHAR NOT NULL);";
		String tagsTable = "CREATE TABLE tags (song_id int REFERENCES songs (song_id), tag VARCHAR NOT NULL);";

		PreparedStatement createTable1 = conn.prepareStatement(songsTable);
		PreparedStatement createTable2 = conn.prepareStatement(tagsTable);
		
				createTable1.executeUpdate();
		
				createTable2.executeUpdate();
				//int a = 
			//	createTable3.executeUpdate();
		//int b = 
		//		createTable4.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
		//
		}
	}
	
	public void makeSongs() throws SQLException {
		
	    //}
	  //  System.out.println("Tags table populated!");
		Connection conn = connectToDatabase();
	    
	    String insert = "INSERT INTO songs(song_id,song,artist,album) VALUES(?,?,?,?)";
	    try {
	      BufferedReader br = new BufferedReader(
	          new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv"));
	      try {
	        br.readLine();
	      } catch (IOException e1) {
	        e1.printStackTrace();
	      }
	      String line=null; 
	      //= null;
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
	                ps.setString(3, data[1]);
	                ps.setString(4, data[2]);
	                ps.executeUpdate();
	                ps.close();
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
	
	public void makeAlbum() {
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
	      String line ;
	      int idcounter;
	      idcounter = 1;
	      try {
	        while ((line = br.readLine()) != null) {
	          try {
	            if (line != null) {
	              String[] array = line.split(",");
	              for (int i = 2; i < array.length; i++) {
	                PreparedStatement statement = conn.prepareStatement(album);
	                statement.setInt(1, i);
	                statement.setString(2, array[i]);
	                if(array[i]==array[i+1]) {
	                	idcounter--;
	                } else {
	                	idcounter++;
	                }
	                	
	                statement.executeUpdate();
	                statement.close();
	              }
	            //  idcounter++;
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
	      String line ;
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
	                if(array[i]==array[i+1]) {
	                	idcounter--;
	                } else {
	                	idcounter++;
	                }
	                	
	                statement.executeUpdate();
	                statement.close();
	              }
	              //idcounter++;
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
	      String line;
	      line = null;
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
		*/
	
	public static void main(String[] args) throws SQLException {
		dbhw1 methods =new dbhw1();
		methods.connectToDatabase();
		methods.createTable();
	methods.makeSongs();
		//methods.makeTags();
	//	methods.makeAlbum();
	//	methods.makeArtist();
	}
	/**
	Connection conn = connectToDatabase();
	// String line;
  //     String splitter=",";
    //   String[] token;
	String line;
	int idCounter;
	idCounter = 1;
	//line=conn.readLine();
  try {   // List<String> list=new ArrayList<String>();
	BufferedReader br=new BufferedReader(new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv"));
   // String line;
    while((line=br.readLine())!=null)
    {if (line != null) {
        String[] value = line.split(",");
        String sql = "INSERT INTO songs(song_id,song,artist,album) VALUES(?,?,?,?)";
        		/**"insert into songs(song_id,songs, artist, album) "
                + "values ('"+value[0]+"','"+value[1]+"','"+value[2]+"','"+value[3]+"')";
                */
       // System.out.println(sql);
        //PreparedStatement pst = null;
        /**
        	PreparedStatement  pst = conn.prepareStatement(sql);
        	for (int j = 0; j < 1; j++) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idCounter);
                ps.setString(2, value[0]);
                ps.setString(3, value[1]);
                ps.setString(4, value[2]);
                ps.executeUpdate();
                ps.close();
                idCounter++;
              }
            
    }
            br.close();
          }
       
        
     // }
       //  br.close();

     

  } catch (IOException e) {
        e.printStackTrace();
     
      } catch (SQLException e) {
        e.printStackTrace();
      }
  /**
  catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
      */
}
