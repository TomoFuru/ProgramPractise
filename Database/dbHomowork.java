package readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class dbHomowork {


	final String url = ":::::";
	final String user = ":::::";
	final String password = "::::::";
	private static String Username = ":::::";
	private static String Password = ":::::";
    private static String dbURL = "artists-songs-albums-tags.csv1";
	//private static String databaseURL = "jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/world";
	private ArrayList<String> tagEntry = new ArrayList<String>();
    
	static Connection connect;
	static Statement sqlQuery;
	static ResultSet resultSet;
	
	
	
    /**
	 * @param args the command line arguments
	 */
    public static void connectToDatabase() {

		try {

			connect = DriverManager.getConnection(dbURL, Username, Password);

		} catch (Exception e) {
			System.out.println("Connection Failed! Please try again.");
			e.printStackTrace();
		}
	}
    
    
	public static void main(String[] args) {
		// TODO code application logic here
		String line;
		String splitter=",";
		String[] token;

		List<String> list = new ArrayList<String>();

		TreeMap<Integer, ArrayList<String>> tagsMusic = new TreeMap<Integer, ArrayList<String>>();	// Create new TreeMap for the tags.
		
		try {
			/*
           to read data from file
			 */
			BufferedReader br=new BufferedReader(new FileReader("/Applications/DatabaseHW/artists-songs-albums-tags.csv")); // Read the unmodified CSV file.

			int k = 0;	// Initialise counter to 0.

			while((line=br.readLine())!=null){
				if (commacounter(line) < 29) {// There should be at most 28 commas in a regular line. 
					ArrayList<String> tagsList = new ArrayList<String>();
					token=line.split(splitter); 	// To separate each word after looking " , " in the file and make it as token.

					for (int i=0;i<token.length;i++){
						list.add(token[i]);		// Add each token to the ArrayList.

						if (i > 2) {	// If there are more than 2 tokens.
							if (token[i].contains("'")) {	// If a token contains "'" , replace it with "''".
								token[i] = token[i].replace("'", "''");
							}
							tagsList.add(token[i]);		// Add the modified token to the ArrayList.
						}
					}
					tagsMusic.put(k, tagsList);	// Add each token to the TreeMap with key k.
					k++;	// Increment the counter value by 1 for each new token.
				}
				else { 
					
					//The following code was adapted from https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
					
					ArrayList<String> tagsList = new ArrayList<String>();	// Create new ArrayList for the tags.
					
					// Regular Expressions to deal with the format and punctuation of the tags in the CSV file.
					
					String other = " [^\"] ";
					String quote = String.format(" \" %s* \" ", other);
					String regex = String.format("(?x),(?=(?:%s*%s)*%s*$)",other, quote, other);
					
					token = line.split(regex, -1);	// Split each tag into a new line.
					
					for (int i = 0; i < token.length; i++) {
						if (i < 3) {	// If there are less than 3 tags, add them to the ArrayList.
							list.add(token[i]);
						}
						else {
							if (token[i].contains("'")) {		// If the token contains "'", replace it with "''".
								token[i] = token[i].replace("'", "''");
							}
							tagsList.add(token[i]);		// Add the token to the ArrayList.
						}
					}
					tagsMusic.put(k, tagsList);		// Add each token to the TreeMap with key k.
					k++;	// Increment the counter value by 1 for each new token.
				}
			}

			// Convert the list into an Array.
			
			String[] arrString = list.toArray(new String[list.size()]);	// Create a new List.
			ArrayList<String> songs = new ArrayList<String>();		// Create new ArrayList for the songs.
			
			for (int  i=4; i<list.size();i++) {		// Start at 4 to skip first line of CSV file.
				if (arrString[i].toUpperCase().equals(arrString[i])) {		// If there are upper case letters.

					if (arrString[i].contains("'")) {	// If there are "'" in the String, replace with "''".
						arrString[i] = arrString[i].replace("'", "''");
					}
					songs.add(arrString[i]);	// Add the song, artist and album to the ArrayList.
				}
			}
			
			ArrayList<String> songEntry = new ArrayList<String>();	// Create a new Array for the songs.
			int songID = 0;		// Initialise the song ID to 0.
			
			for(int i = 0; i < songs.size(); i += 3) {		// For each song there are 3 parts; song, artist and album, so need to increment by 3 each time.
				songID++;	// Increment song ID by 1 for each new entry.
				String insertStmt = "INSERT INTO songs VALUES (" + songID +", '" + songs.get(i) + "', '" + songs.get(i+1) + "', '" + songs.get(i+2) + "');";
				songEntry.add(insertStmt);		// Add song ID, song, artist and album to the ArrayList.
			}

			tagsMusic.remove(0); 	// Removes the first line of column headers from map.
			
			ArrayList<String> tagEntry = new ArrayList<String>();	// Create a new ArrayList for the tags.
			
			for (int i = 1; i <= tagsMusic.size(); i++) {
				ArrayList<String> key = tagsMusic.get(i);	// Create a new ArrayList for the key.
				for (int j = 0; j < key.size(); j++) {
					if(key.get(j).equals("")) {		// If the key is equal to "", then remove it.
						key.remove(j);
						j--;	// Decrement j by 1.
					}
					else {
						String insertKey = "INSERT INTO tags VALUES (" + i + ", '" + key.get(j) + "');";
						tagEntry.add(insertKey);	// Add the tag and key to the ArrayList of tags.
					}
				}
			}

			br.close();	// Close BufferedReader.
		
					
			}
		
				catch (FileNotFoundException e){
					System.out.println("File is not found");
				}

				catch (IOException ex) {
					System.out.println(ex.getMessage() + "Error reading the file");
				}
				
			
		}
	
	public void makeTable() {
			try {

				final String url = "jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/txf795";
				final String user = "txf795";
				final String password = "kawaiicharlie";	// Password removed.

				Connection conn = DriverManager.getConnection(url, user, password);		// Establish connection to the database.

				// SQL queries to create tables in the database.

				String songsTable = "CREATE TABLE songs (song_id INT PRIMARY KEY, song VARCHAR, artist VARCHAR NOT NULL, album VARCHAR NOT NULL);";
				String tagsTable = "CREATE TABLE tags (song_id int REFERENCES songs (song_id), tag VARCHAR NOT NULL);";

				PreparedStatement createTable1 = conn.prepareStatement(songsTable);
				PreparedStatement createTable2 = conn.prepareStatement(tagsTable);

				// Execute queries to create tables.

				int a = createTable1.executeUpdate();
				int b = createTable2.executeUpdate();

				// Creates a new entry for each song in the songs table of the database.

				for (int i = 0; i < songEntry.size(); i++) {
					PreparedStatement stmt = conn.prepareStatement(songEntry.get(i));
					int n = stmt.executeUpdate();
				}

				// Creates a new entry for each tag in the tags table associated with each distinct song in the songs table of the database.

				for (int i = 0; i < tagEntry.size(); i++) {
					PreparedStatement stmt = conn.prepareStatement(tagEntry.get(i));
					int n = stmt.executeUpdate();
				}
				conn.close();	// Close Connection to the database.
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}

		
	
	
	/**
	 * Method to count the commas
	 * @param s is a String.
	 * @return counter is the number of commas.
	 */
	
	public static int commacounter(String s) {
		
		int counter = 0;	// Initialise counter to 0.
		
		for (char c : s.toCharArray()) {
			if (c == ',') {
				counter++;		// Increment counter by 1 for each comma.
			}
		}
		return counter;	// return the number of commas.
	}
	
}
