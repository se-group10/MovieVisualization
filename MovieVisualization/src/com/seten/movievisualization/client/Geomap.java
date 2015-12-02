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
	private DataTable geoTable;
	private GeoChart geoChart;
	private GeoChartOptions options;
	private GeoChartColorAxis geoChartColorAxis;
	

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
	this.geoTable = ChartHelper.arrayToDataTable(geoDataObjects);
  	
	if(this.geoChart == null){
		
		//Create new GeoChart
		this.geoChart = new GeoChart();

	
		//GeoChart Options and Axis
		this.options = GeoChartOptions.create();
		this.geoChartColorAxis = GeoChartColorAxis.create();
		geoChartColorAxis.setColors("yellow", "green", "red");
		options.setColorAxis(geoChartColorAxis);
		options.setDatalessRegionColor("grey");
	
		//GeoMap draw
		geoChart.draw(geoTable, options);
	
		//Add to container
		RootPanel.get("gwtContainer").add(geoChart);
		}
	}
	
	public void redraw() {
		//geoChart.clearChart();
		geoChart.draw(geoTable, options);
		//geoChartTwo.redraw();
	}
	
	public List<KeyPairValue> getOBJECTS() {
		return OBJECTS;
	}
	public void setOBJECTS(List<KeyPairValue> oBJECTS) {
		OBJECTS = oBJECTS;
	}
	public DataTable getGeoTableTwo() {
		return geoTable;
	}
	public void setGeoTableTwo(DataTable geoTableTwo) {
		this.geoTable = geoTableTwo;
	}
	public GeoChart getGeoChartTwo() {
		return geoChart;
	}
	public void setGeoChartTwo(GeoChart geoChartTwo) {
		this.geoChart = geoChartTwo;
	}
	public GeoChartOptions getOptionsTwo() {
		return options;
	}
	public void setOptionsTwo(GeoChartOptions optionsTwo) {
		this.options = optionsTwo;
	}
	public GeoChartColorAxis getGeoChartColorAxisTwo() {
		return geoChartColorAxis;
	}
	public void setGeoChartColorAxisTwo(GeoChartColorAxis geoChartColorAxisTwo) {
		this.geoChartColorAxis = geoChartColorAxisTwo;
	}

	
}
