package com.seten.movievisualization.client;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MovieDBServiceAsync {
	
void getMovies(int amount, AsyncCallback<List<Movie>> callback);

void getKeyValuePair(int i, AsyncCallback<List<KeyPairValue>> callback);
}
