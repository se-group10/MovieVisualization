package com.seten.movievisualization.server;

import com.seten.movievisualization.client.KeyPairValue;
import com.seten.movievisualization.client.Movie;
import java.util.List;
import com.seten.movievisualization.client.MovieDBService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MovieDBServiceImpl extends RemoteServiceServlet implements MovieDBService {
	@Override
	public List<Movie> getMovies(int amount) {
		
		   List<Movie> MOVIES = Arrays.asList(
				   
				      new Movie("The Lord of the Rings: The Fellowship of the Ring", new Date(1005), "India", 201, "Fantasy", "English"),
				      new Movie("Vertigo", new Date(1935), "India", 109,"Thriller", "English"),
				      new Movie("Harry Potter and the Half-Blood Prince",new Date(2006),"UK", 60,"Magic", "English"),
				      new Movie("Babc", new Date(2006), "India", 90,"Horror", "French"),
				      new Movie("The Lord of the Rings", new Date(2001), "India", 140,"Fantasy", "Hindi"),
				      new Movie("The Lord of the Rings: The Two Towers", new Date(2005), "United States of America", 90,"Fantasy", "English"),
				      new Movie("Harry Potter and the Goblet of Fire",new Date(2000),"UK", 60,"Adventure", "English"),
				      new Movie("Goldfinger", new Date(1976), "India", 90,"Action", "English"),
				      new Movie("7 ways to die", new Date(1996), "United States of America", 140,"Aciton", "English"),
				      new Movie("8 ways to die", new Date(2002), "United States of America", 90,"Action", "English"),
				      new Movie("abcdefghijklmnopqrstuvwxyz",new Date(1944),"United States of America", 60,"Random", "English"),
				      new Movie("Harry Potter and the Order of the Phoenix",new Date(2006),"United States of America", 60,"Adventure", "English"),
				      new Movie("babc", new Date(2006), "United States of America", 90,"Something", "English"),
				      new Movie("The Random", new Date(1912), "United States of America", 140,"XY", "Hindi"),
				      new Movie("The Project", new Date(1923), "United States of America", 90,"Comedy", "English"),
				      new Movie("Spectre", new Date(1980), "United States of America", 90,"Fantasy", "German"),
				      new Movie("Film1", new Date(1990), "United States of America", 140,"Comedy", "Hindi"),
				      new Movie("Film2", new Date(1966), "United States of America", 90,"Adventure", "English"),
				      new Movie("Harry Potter and the Deathly Hallows � Part 2",new Date(1944),"UK", 60,"Adventure", "English"),
				      new Movie("Film4", new Date(1956), "India", 90,"Movie", "English"),
				      new Movie("Film 6", new Date(1955), "India", 140,"Shortmovie", "Hindi"),
				      new Movie("Film 7", new Date(1948), "India", 90,"Crime", "German"),
				      new Movie("Film5", new Date(1934), "India", 90,"Thriller", "SwissGerman"),
				      new Movie("Film 8", new Date(1948), "United States of America", 140,"Random", "Hindi"),
				      new Movie("Film 9", new Date(1952), "United States of America", 90,"Documentation", "French"),
				      new Movie("Harry Potter and the Chamber of Secrets",new Date(2001),"UK", 60,"Fantasy", "English"),
				      new Movie("Film3", new Date(1920), "United States of America", 90,"Documentation", "English"),
				      new Movie("Harry Potter and the Deathly Hallows � Part 1", new Date(2005), "United States of America", 140,"Fantasy", "English"),
				      new Movie("Film 10", new Date(1959), "UK", 90,"Fantasy", "German"),
				      new Movie("xy", new Date(1929), "United States of America", 90,"Fantasy", "Swissgerman")
					 );
		return MOVIES;
	}
	
	public List<KeyPairValue> getKeyValuePair(int i) {
		
		List<KeyPairValue> KEYVALUEPAIR = Arrays.asList(
				
				new KeyPairValue("GB", 10),
				new KeyPairValue("United States of America", 20),
				new KeyPairValue("India", 30)
				
				);
		
		
		return KEYVALUEPAIR;
	}

}
