package com.seten.movievisualization.client;

import java.util.Comparator;
import java.util.Date;

import com.seten.movievisualization.client.Movie;

public class DateSort implements Comparator<Movie> {
	@Override
	public int compare(Movie m1, Movie m2) {
		if (m1 == m2) {
			return 0;
	    }

    // Compare the name columns.
		if (m1 != null) {
			if (m2!=null) {
				return compareDate(m1.getDate(), m2.getDate());
	        }
	    }
	// Default
		return -1;
	}
	
	//Gives back 1 if first > second, 0 if first = second, otherwise -1. Used for sorting columns
	private static int compareDate(Date first, Date second) {
		if(first.equals(second)){
			return 0;	
		}		
		else if(first.before(second)) {
			return -1;
			}
		else return 1;
	}

}