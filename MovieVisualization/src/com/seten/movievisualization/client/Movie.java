package com.seten.movievisualization.client;

import java.io.Serializable;
import java.util.Date;
//makes the class serializable for an rpc connection
public class Movie implements Serializable {

	
public   String name;
public  Date releasedate;
public  String country;
public   int length;
public String genre;
public String language;

public Movie(){}
// default constructor for the Movie class
	public Movie(String name, Date year, String country, int length, String genre, String language) {
	    this.name = name;
	    this.releasedate = year;
	    this.country = country;
	    this.length = length;
	    this.genre = genre;
	    this.language = language;
	}


	public String getName(){
		return this.name;
	}
	    
	    
	public Date getDate(){
		return this.releasedate;
	}
	   
	public String getCountry(){
		return this.country;
	}
	    
	public int getLength(){
		return this.length;
	}
	public String getGenre() {
		return this.genre;
	}
	public String getLanguage() {
		return this.language;
	}
}
	 