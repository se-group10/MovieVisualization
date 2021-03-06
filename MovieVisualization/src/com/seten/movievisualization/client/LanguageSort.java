package com.seten.movievisualization.client;

import java.util.Comparator;

import com.seten.movievisualization.client.Movie;

public class LanguageSort implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2){
		if (m1 == m2) {return 0;}

		// Compare the name columns.
		if (m1 != null) {
		return (m2 != null) ? m1.getLanguage().compareToIgnoreCase(m2.getLanguage()) : 1;
		}
	return -1;
	}

}