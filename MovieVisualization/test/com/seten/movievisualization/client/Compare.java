package com.seten.movievisualization.client;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.seten.movievisualization.client.Movie;

/*
*Test for sort funcitons:
*compareCountry
*compareString, for comparing movie.name & movie.language
*compareInt
*compareLength
*compareMovieDate
*
*/

public class Compare {

	@Test
	public void test() {
		
		Movie movie1 = new Movie("The Lord of the Rings", new Date(80, 4, 5), "a", 201, "Horror", "English");
		
		Movie movie2 = new Movie("The Lord of the Rings", new Date(85, 2, 15), "A", 109, "Horror", "English");
		
		Movie movie3 = new Movie("Harry Potter", new Date(80, 4, 5),"c", 201, "Horror", "English");
	
		
		/*
		 * Test for Method @Override Compare in CountrySort
		 * Expected Result:
		 * testOne: movie1.getCountry = "a", movie2.getCountry = "A". Expected Result = 0
		 * testTwo: movie1.getCountry = "a", movie2.getCountry = "c". Expected Result = 8
		 * testThree: movie3.getCountry = "c", movie1.getCountry = "a". Expected REsult = -8
		 */
		int countryTestOne = compareCountry(movie1, movie2);
		int countryTestTwo = compareCountry(movie1, movie3);
		int countryTestThree = compareCountry(movie3, movie1);
		
		assertEquals(0, countryTestOne);
		assertTrue("countryTestTwo", countryTestTwo < 0);
		assertTrue("countreTestThree", countryTestThree>0);
		
		/*
		 * Test for Method @Override Compare in StringSort
		 * Expected Result:
		 * testOne: movie1.name = "The Lord of the Rings", movie2.name = "The Lord of the Rings". Expected Result = 0
		 * testTwo: movie1.name, movie2.name, Expected Result = 12
		 * testThree: movie3.name = "c", movie1.name = "a". Expected REsult = -12
		 */
		
		int nameTestOne = compareString(movie1, movie2);
		int nameTestTwo = compareString(movie1, movie3);
		int nameTestThree = compareString(movie3, movie1);

		assertEquals(0, nameTestOne);
		assertEquals(12, nameTestTwo);
		assertEquals(-12, nameTestThree);
		
		// Test for Method compareInt. Expected Result: compareIntTestOne = -1, TestTwo = 1, TestThree = 0
		int compareIntTestOne = compareInt(1,2);
		int compareIntTestTwo = compareInt(2,1);
		int compareIntTestThree = compareInt(1,1);
		
		assertEquals(-1, compareIntTestOne);
		assertEquals(1, compareIntTestTwo);
		assertEquals(0, compareIntTestThree);
		
		// Test for Method compareLength. Expected Result, TestOne = 0, TestTwo = 1, TestThree = -3
		
		int compareLengthOne = compareLength(movie1, movie3);
		int compareLengthTwo = compareLength(movie1, movie2);
		int compareLengthThree = compareLength(movie2, movie1);
		
		System.out.println(compareLengthTwo);
		
		assertEquals(0, compareLengthOne);
		assertEquals(1, compareLengthTwo);
		assertEquals(-1, compareLengthThree);
		
		// Test for Method compareMovieDate. Expected Result, TestOne = -1, TestTwo = 1, TestThree = 0
		
		int compareDateOne = compareMovieDate(movie1, movie2);
		int compareDateTwo = compareMovieDate(movie2, movie1);
		int compareDateThree = compareMovieDate(movie1, movie3);
		
		assertEquals(-1, compareDateOne);
		assertEquals(1, compareDateTwo);
		assertEquals(0, compareDateThree);
	}
	
	public static int compareCountry(Movie m1, Movie m2){
		if (m1 == m2) {return 0;}

		// Compare the name columns.
		if (m1 != null) {
		System.out.println((m2 != null) ? m1.getCountry().compareToIgnoreCase(m2.getCountry()) : 1);
		return (m2 != null) ? m1.getCountry().compareToIgnoreCase(m2.getCountry()) : 1;
		}
	return -1;
	
	}
	public static int compareString(Movie m1, Movie m2){
		if (m1 == m2) {return 0;}

		// Compare the name columns.
		if (m1 != null) {
		return (m2 != null) ? m1.getName().compareToIgnoreCase(m2.getName()) : 1;
		}
	return -1;
	}
	public static int compareLength(Movie m1, Movie m2) {
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
	public static int compareMovieDate(Movie m1, Movie m2) {
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
	//Gives back -1 if first before second, 0 if first = second, otherwise 1. Used for sorting columns
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
