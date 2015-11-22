package com.seten.movievisualization.server;

import com.seten.movievisualization.client.KeyPairValue;
import com.seten.movievisualization.client.Movie;
import java.util.List;
import com.seten.movievisualization.client.MovieDBService;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

// import of the SQL connections
import java.sql.*

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MovieDBServiceImpl extends RemoteServiceServlet implements MovieDBService {
	
	// BEGINNING OF NEW, UNFINISHED CODE SNIPPET
	
	// connect to the SQL database via App Engine (Taken from official SQL Cloud Google page)
	// --> exception handling needed as well (try, catch)?
	String url = null;
	if (SystemProperty.environment.value() ==
	    SystemProperty.Environment.Value.Production) {
	  // Connecting from App Engine.
	  // Load the class that provides the "jdbc:google:mysql://" prefix.
	  Class.forName("com.mysql.jdbc.GoogleDriver");
	  url = "jdbc:google:mysql://segroup10-1119:database20151114?user=root";
	} else { // Connecting from an external network.
	  Class.forName("com.mysql.jdbc.Driver");
	  url = "jdbc:mysql://173.194.224.108:3306?user=root";
	}
	
	// this line from elsewhere --> does it need it?
	// or is drivermanager initialized already elsewhere?
	DriverManager.registerDriver(new AppEngineDriver());
	
	
	
	// // IDEA: USE A BASIC METHOD WITHIN SPECIFIC METHODS TO DO THE MAJOR (ALWAYS SAME) WORK
	
	// basic get-method that can be used to build up connection to db and do the query
	public List<Movie> getMovies() {
		
		try { // set up connection to the database
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlquery);

			// Extract data from result set --> do we need this one?
			// or is it totally fine to have the data in the rs?
			// at least: for testing purposes to see if it works properly
			while(rs.next()){
				//Retrieve by column name
				String moviename = rs.getString("moviename");
				int releaseyear = rs.getInt("releaseyear");
				int runtime = rs.getInt("runtime");
				String languages = rs.getString("languages");
				String countries = rs.getString("countries");
				String genres = rs.getString("genres");
				System.out.println(moviename, releaseyear, runtime, languages, countries, genres)
		// or perhaps better to see if it works: follow Jans advicedo
		// do a pop up window and look at one attribut of the whole movie object
		// this is done by: Window.alert(result.get(1).country)
		
		} catch (Exception e) { // catch possible exceptions
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		} finally { // clean up environment
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	
	}
	
	
	// BEGINNING OF JANS PROTOTYPES
	
	@Override // what/why exactly?
	public List<Movie> getMoviesFromYear(int year){
		sqlquery = "SELECT * FROM movietable WHERE releaseyear=year";
		// or do we have to write sqlquery = "SELECT * FROM movietable WHERE releaseyear=" + year
		List<Movie> MOVIES = Arrays.asList(this.getMovies()); // or does getMovies already return a list?
															// than we can do Arrays.asList(rs), or simply MOVIES = rs ?
		return MOVIES;
	}
	
	public List<Movie> getMoviesFromYear(int yearMin, int yearMax){
		sqlquery = "SELECT * FROM movietable WHERE releaseyear BETWEEN yearMin AND yearMax";
		List<Movie> MOVIES = Arrays.asList(this.getMovies());
		return MOVIES;
	}
	
	public List<Movie> getMoviesFromName(String name){
		// SQL abfrage nach Filmen die mit name beginnen. (falls möglich)
		sqlquery = "SELECT * FROM movietable WHERE moviename LIKE %name%";
		// für diese implementation wäre es besser, den Filmnamen natürlichsprachlich vorliegen zu haben...
		List<Movie> MOVIES = Arrays.asList(this.getMovies());
		return MOVIES;
	}
	
	public List<Movie> getMoviesFromCountry(String country){
		/* SQL abfrage nach Land = country. Falls ihr IDs benützt für die 
		* Länder könntet ihr mit einem switch case aus dem country String
		* die ID auslesen
		*/
		sqlquery = "SELECT * FROM movietable WHERE countries=country";
		List<Movie> MOVIES = Arrays.asList(this.getMovies());
		return MOVIES;
	}
	
	public List<Movie> getMoviesFromLength(int length){
		sqlquery = "SELECT * FROM movietable WHERE runtime=length";
		List<Movie> MOVIES = Arrays.asList(this.getMovies());
		return MOVIES;
	}
	
	public List<Movie> getMoviesFromLength(int lengthMin, int lengthMax){
		sqlquery = "SELECT * FROM movietable WHERE releaseyear BETWEEN lengthMin AND lengthMax";
		List<Movie> MOVIES = Arrays.asList(this.getMovies());
		return MOVIES;
	}
	
	public List<Movie> getMoviesFromLanguage(String language){
		/* SQL abfrage nach Sprache = language. Falls ihr IDs benützt für die 
			* Sprachen könntet ihr mit einem switch case aus dem language String
			* die ID auslesen.
			*/
		sqlquery = "SELECT * FROM movietable WHERE languages LIKE %language%"; // auch nötig, wenn mit auswahlbalken arbeiten,
																			// da die sprache in einem string mit anderen sprachen steht
		List<Movie> MOVIES = Arrays.asList(this.getMovies());
		return MOVIES;
	}

	public List<Movie> getMoviesFromGenre(String genre){
		/* SQL abfrage nach Genre = genre. Falls ihr IDs benützt für die 
			* Genres könntet ihr mit einem switch case aus dem genre String
			* die ID auslesen.
			*/
		sqlquery = "SELECT * FROM movietable WHERE genres LIKE %genre%";
		List<Movie> MOVIES = Arrays.asList(this.getMovies());
		return MOVIES;
	}

	// END OF JANS PROTOTYPES
	
	
	

	// perhaps for later: extension of the movie database via INSERT statement
	public void updateMovietable(String moviename, int releaseyear, int runtime, String/LIST?!?! languages, String/list?! countries, String/list genres) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO movietable(MOVIENAME,RELEASEYEAR,RUNTIME,LANGUAGES,COUNTRIES,GENRES) " + "VALUES ('moviename', releaseyear, runtime, 'languages', 'countries', 'genres')");
		} catch (Exception e) { 
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	
	// END OF NEW, UNFINISHED CODE SNIPPET
	
	
	
	
	
	
	@Override
	public List<Movie> getMovies(int amount) {
		
		   List<Movie> MOVIES = Arrays.asList(
				   
				      new Movie("The Lord of the Rings: The Fellowship of the Ring", new Date(1005), "USA", 201, "Fantasy", "English"),
				      new Movie("Vertigo", new Date(1935), "USA", 109,"Thriller", "English"),
				      new Movie("Harry Potter and the Half-Blood Prince",new Date(2006),"UK", 60,"Magic", "English"),
				      new Movie("Babc", new Date(2006), "Zürich", 90,"Horror", "French"),
				      new Movie("The Lord of the Rings", new Date(2001), "India", 140,"Fantasy", "Hindi"),
				      new Movie("The Lord of the Rings: The Two Towers", new Date(2005), "USA", 90,"Fantasy", "English"),
				      new Movie("Harry Potter and the Goblet of Fire",new Date(2000),"UK", 60,"Adventure", "English"),
				      new Movie("Goldfinger", new Date(1976), "Zürich", 90,"Action", "English"),
				      new Movie("7 ways to die", new Date(1996), "India", 140,"Aciton", "English"),
				      new Movie("8 ways to die", new Date(2002), "USA", 90,"Action", "English"),
				      new Movie("abcdefghijklmnopqrstuvwxyz",new Date(1944),"UK", 60,"Random", "English"),
				      new Movie("Harry Potter and the Order of the Phoenix",new Date(2006),"UK", 60,"Adventure", "English"),
				      new Movie("babc", new Date(2006), "Zürich", 90,"Something", "English"),
				      new Movie("The Random", new Date(1912), "India", 140,"XY", "Hindi"),
				      new Movie("The Project", new Date(1923), "USA", 90,"Comedy", "English"),
				      new Movie("Spectre", new Date(1980), "Zürich", 90,"Fantasy", "German"),
				      new Movie("Film1", new Date(1990), "India", 140,"Comedy", "Hindi"),
				      new Movie("Film2", new Date(1966), "USA", 90,"Adventure", "English"),
				      new Movie("Harry Potter and the Deathly Hallows � Part 2",new Date(1944),"UK", 60,"Adventure", "English"),
				      new Movie("Film4", new Date(1956), "Zürich", 90,"Movie", "English"),
				      new Movie("Film 6", new Date(1955), "India", 140,"Shortmovie", "Hindi"),
				      new Movie("Film 7", new Date(1948), "Germany", 90,"Crime", "German"),
				      new Movie("Film5", new Date(1934), "Zürich", 90,"Thriller", "SwissGerman"),
				      new Movie("Film 8", new Date(1948), "India", 140,"Random", "Hindi"),
				      new Movie("Film 9", new Date(1952), "France", 90,"Documentation", "French"),
				      new Movie("Harry Potter and the Chamber of Secrets",new Date(2001),"UK", 60,"Fantasy", "English"),
				      new Movie("Film3", new Date(1920), "Zürich", 90,"Documentation", "English"),
				      new Movie("Harry Potter and the Deathly Hallows � Part 1", new Date(2005), "India", 140,"Fantasy", "English"),
				      new Movie("Film 10", new Date(1959), "Germany", 90,"Fantasy", "German"),
				      new Movie("xy", new Date(1929), "Zürich", 90,"Fantasy", "Swissgerman")
					 );
		return MOVIES;
	}
	
	public List<KeyPairValue> getKeyValuePair(int i) {
		
		List<KeyPairValue> KEYVALUEPAIR = Arrays.asList(
				
				new KeyPairValue("GB", 10),
				new KeyPairValue("United States of America", 20),
				new KeyPairValue("India", 30),
				new KeyPairValue("Canada", 40),
				new KeyPairValue("Germany", 50),
				new KeyPairValue("France", 60),
				new KeyPairValue("Brazil", 70),
				new KeyPairValue("Russia", 80)
				
				);
		
		
		return KEYVALUEPAIR;
	}

}
