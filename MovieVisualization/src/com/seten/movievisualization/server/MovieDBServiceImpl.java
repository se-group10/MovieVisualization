package com.seten.movievisualization.server;

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

}
