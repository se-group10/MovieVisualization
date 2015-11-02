package com.hostname.segroupten.movievisualization.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hostname.segroupten.movievisualization.shared.Movie;;

public interface MovieDatabaseServiceAsync {
void getMovies( AsyncCallback<Movie[]> callback);
}
