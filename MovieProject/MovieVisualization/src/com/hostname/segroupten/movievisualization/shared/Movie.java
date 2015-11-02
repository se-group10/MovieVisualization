package com.hostname.segroupten.movievisualization.shared;

import java.io.Serializable;
import java.util.Date;

public  class Movie implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String name;
    public final Date releasedate;
    public final String country;
    public final int length;
    public final String source;

    public Movie(String name, Date releasedate, String country, int length, String source) {
       this.name = name;
       this.releasedate = releasedate;
       this.country = country;
       this.length = length;
       this.source = source;
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
 }
 