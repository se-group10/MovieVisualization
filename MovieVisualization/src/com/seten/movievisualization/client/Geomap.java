package com.seten.movievisualization.client;

import java.util.List;

import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.geochart.GeoChart;
import com.googlecode.gwt.charts.client.geochart.GeoChartColorAxis;
import com.googlecode.gwt.charts.client.geochart.GeoChartOptions;
import com.googlecode.gwt.charts.client.util.ChartHelper;

public class Geomap {
	

	private List<KeyPairValue> OBJECTS;
	
	/*public Geomap(List <Movie> DATA){
		MOVIES = DATA;
	}*/
	public Geomap(){};
	public Geomap(List <KeyPairValue> DATA) {
		OBJECTS = DATA;
	}
  
	public void initialize () {
	
	//With RPC 
	int numberOfCountries = OBJECTS.size();
	Object[][] geoDataObjects = new Object[numberOfCountries + 1][2];
	geoDataObjects[0][0] = "Country";
	geoDataObjects[0][1] = "Movies per Year";
	
	//Fill Object[][] - Array as basis for dataTable.
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
	
	//Create DataTable from array
	DataTable geoTableTwo = ChartHelper.arrayToDataTable(geoDataObjects);
  	
	
	//Create new GeoChart
	GeoChart geoChartTwo = new GeoChart();

	
	//GeoChart Options and Axis
	GeoChartOptions optionsTwo = GeoChartOptions.create();
	GeoChartColorAxis geoChartColorAxisTwo = GeoChartColorAxis.create();
	geoChartColorAxisTwo.setColors("yellow", "green", "red");
	optionsTwo.setColorAxis(geoChartColorAxisTwo);
	optionsTwo.setDatalessRegionColor("grey");
	
	//GeoMap draw
	geoChartTwo.draw(geoTableTwo, optionsTwo);
	
	//Add to container
	RootPanel.get("gwtContainer").add(geoChartTwo);
	}
}
