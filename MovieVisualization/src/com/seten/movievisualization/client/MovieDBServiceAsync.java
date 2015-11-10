package com.seten.movievisualization.client;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MovieDBServiceAsync {
	
void getMovies(int amount, AsyncCallback<List<Movie>> callback);
}
