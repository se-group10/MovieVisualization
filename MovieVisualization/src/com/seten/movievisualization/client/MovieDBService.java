package com.seten.movievisualization.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("movies")
public interface MovieDBService extends RemoteService{

	List<Movie> getMovies(int amount);
	
	List<KeyPairValue> getKeyValuePair(int i);
}
