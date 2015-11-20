package com.seten.movievisualization.client;

import java.util.List;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.geochart.GeoChart;
import com.googlecode.gwt.charts.client.geochart.GeoChartColorAxis;
import com.googlecode.gwt.charts.client.geochart.GeoChartOptions;
import com.googlecode.gwt.charts.client.util.ChartHelper;

public class Geomap {
	
	//private int americaCounter = 0;
	//private int unitedKingdomCounter = 0; 
	//private int indiaCounter = 0;
	//private List<Movie> MOVIES;
	private List<KeyPairValue> OBJECTS;
	
	/*public Geomap(List <Movie> DATA){
		MOVIES = DATA;
	}*/
	public Geomap(){};
	public Geomap(List <KeyPairValue> DATA) {
		OBJECTS = DATA;
	}
  
	public void initialize () {
	/*	
	for(Movie m : MOVIES) {
		if(m != null){
			if(m.country.equalsIgnoreCase("United States of America")) {
				americaCounter++;
			}
			
			
		}
	}
	
	for(Movie m : MOVIES) {
		if(m != null){
			if(m.country.equalsIgnoreCase("UK")) {
				unitedKingdomCounter++;
			}
			
			
		}
	}
	
	for(Movie m : MOVIES) {
		if(m != null){
			if(m.country.equalsIgnoreCase("India")) {
				indiaCounter++;
			}
			
			
		}
	}
	
  
	// Create Objects for geoTable
	KeyPairValue germany = new KeyPairValue("GB", unitedKingdomCounter);
	KeyPairValue un = new KeyPairValue("United States of America", americaCounter);
	KeyPairValue india = new KeyPairValue("India", indiaCounter);
	Object[][] geoData = {{"Country","Movies per Year"}, {germany.country, germany.counter}, {un.country, un.counter}, {india.country, india.counter}};
	DataTable geoTable = ChartHelper.arrayToDataTable(geoData);
	*/
		
	/*
	Object[][] geoDataObjects = {{"Country","Movies per Year"}, 
				{OBJECTS.get(0).country, OBJECTS.get(0).counter }, 
				{OBJECTS.get(1).country, OBJECTS.get(1).counter}, 
				{OBJECTS.get(2).country, OBJECTS.get(2).counter}
	};
	*/
	
	//With RPC 
	int numberOfCountries = OBJECTS.size();
	Object[][] geoDataObjects = new Object[numberOfCountries + 1][2];
	geoDataObjects[0][0] = "Country";
	geoDataObjects[0][1] = "Movies per Year";
	/*
	geoDataObjects[1][0] = OBJECTS.get(0).country;
	geoDataObjects[1][1] = OBJECTS.get(0).counter;
	geoDataObjects[2][0] = OBJECTS.get(1).country;
	geoDataObjects[2][1] = OBJECTS.get(1).counter;
	geoDataObjects[3][0] = OBJECTS.get(2).country;
	geoDataObjects[3][1] = OBJECTS.get(2).counter;
	*/
	int counter = 0;
	for(int i = 1; i<OBJECTS.size() + 1; i++) {
		
		for(int y = 0; y<2; y++) {
			if(y==0) {
				geoDataObjects[i][y] = OBJECTS.get(counter).country;
			}
			if(y==1) {
				geoDataObjects[i][y] = OBJECTS.get(counter).counter;
			}
		}
		
		counter++;
	}
	
	
	
	
	DataTable geoTableTwo = ChartHelper.arrayToDataTable(geoDataObjects);
  	
	
	//Create new GeoChart
	GeoChart geoChartTwo = new GeoChart();

	
	//GeoChart Options
 
	GeoChartOptions optionsTwo = GeoChartOptions.create();
	GeoChartColorAxis geoChartColorAxisTwo = GeoChartColorAxis.create();
	geoChartColorAxisTwo.setColors("green", "yellow", "red");
	optionsTwo.setColorAxis(geoChartColorAxisTwo);
	optionsTwo.setDatalessRegionColor("grey");
	//Draw
	geoChartTwo.draw(geoTableTwo, optionsTwo);
	//Add
	RootPanel.get("gwtContainer").add(geoChartTwo);
	}
}
