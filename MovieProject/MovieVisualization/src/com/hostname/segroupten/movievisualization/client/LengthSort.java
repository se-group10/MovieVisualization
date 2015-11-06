package com.hostname.segroupten.movievisualization.client;

import java.util.Comparator;

import com.hostname.segroupten.movievisualization.shared.Movie;

public class LengthSort implements Comparator <Movie> {
	
	
	@Override
	public int compare(Movie m1, Movie m2) {
		// Are objects equal?
		if (m1==m2) {
			return 0;
		}
		// Compare the length
		if(m1 != null) {
			if(m2 != null) {
				return compareInt(m1.getLength(), m2.getLength());
			}
			//return (m2 != null) ? m1.getLength().compareTo(m2.getLength()) : 1;
		}
		return -1;
	}
	
	// Gives back 1 if first > second, 0 if first = second, otherwise -1. Used for sorting columns
	private static int compareInt(int first, int second) {
		if(first == second){
			return 0;
		}
		
		else if(first > second){
			return 1; }
			else return -1;
	}


}
