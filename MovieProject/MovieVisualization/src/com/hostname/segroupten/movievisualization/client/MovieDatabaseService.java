package com.hostname.segroupten.movievisualization.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hostname.segroupten.movievisualization.shared.Movie;

@RemoteServiceRelativePath("movies")
public interface MovieDatabaseService extends RemoteService {

	
		Movie[] getMovies();
	}

