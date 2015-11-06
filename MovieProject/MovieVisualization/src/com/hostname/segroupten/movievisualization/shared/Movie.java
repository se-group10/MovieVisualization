package com.hostname.segroupten.movievisualization.shared;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private Date releasedate;
    private String country;
    private int length;
    private String source;
    private String genres;
    private String language;
    
    public Movie(String name, Date releasedate, String country, int length, String source) {
    	 this.name = name;
         this.releasedate = releasedate;
         this.country = country;
         this.length = length;
         this.source = source;
    }

    public Movie(String name, Date releasedate, String country, int length, String source, String genres, String language) {
       this.name = name;
       this.releasedate = releasedate;
       this.country = country;
       this.length = length;
       this.source = source;
       this.genres = genres;
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
    
    public String getSource(){
    	return this.source;
    }

	public String getGenres() {
		return this.genres;
	}

	public String getLanguage() {
		return this.language;
	}
    
    
 }
 