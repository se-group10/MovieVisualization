package com.hostname.segroupten.movievisualization.server;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hostname.segroupten.movievisualization.client.MovieDatabaseService;
import com.hostname.segroupten.movievisualization.shared.Movie;

public class MovieDatabaseServiceImpl extends RemoteServiceServlet implements MovieDatabaseService {

	@Override
	public Movie[] getMovies() {
		// TODO Auto-generated method stub
		Movie test1 = new Movie("Lord of the Rings", new Date(2003), "USA", 201, "Institute XY, Zürich, Switzerland");
	     Movie test2 =  new Movie("Vertigo", new Date(1950), "USA", 109, "Institute XY, Zürich, Switzerland");
	     Movie test3 =  new Movie("harrypotter",new Date(1990),"UK", 60, "Institute XY, Zürich, Switzerland");
	     Movie test4 =  new Movie("xy", new Date(2010), "Zürich", 90, "Institute XY, Zürich, Switzerland");
	   Movie movies[] = new Movie[4];
	   movies[0] = test1;
	   movies[1] = test2;
	   movies[2] = test3;
	   movies[3] = test4; 
	     
	     return movies;
	   	
	}

}
