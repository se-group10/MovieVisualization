package com.seten.movievisualization.client;

import java.util.Collections;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.geochart.GeoChart;
import com.googlecode.gwt.charts.client.geochart.GeoChartColorAxis;
import com.googlecode.gwt.charts.client.geochart.GeoChartOptions;




/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MovieVisualization implements EntryPoint {
	
	private MovieDBServiceAsync movieDBSvc = GWT.create(MovieDBService.class);
	
	

	
	
	
	public void onModuleLoad() {
	// makes an rpc request
	getMovies();
	getKeyValuePair();
	
	
	Label l1 = new Label ("");
	l1.setHeight("200");
	Label l2 = new Label("");
	Label l3 = new Label("");
	l2.setHeight("200");
	TabPanel tabPanel = new TabPanel();
	
	
	
	tabPanel.add(l1, "Celltable");
	tabPanel.add(l2, "World Map");
	tabPanel.add(l3, "Maintenance");
	
	
	RootPanel.get("gwtContainer").add(tabPanel);
	
	// Create GeoChart and and add to gwt Container
	
	// TODO For GeoChart create DataTable. Create DataTable from: List<Movie> or CellTable? 
	
	/*GeoChart geoChart = new GeoChart();
	
	// Example Data
	DataTable dataTable = DataTable.create();
	dataTable.addColumn(ColumnType.STRING, "Country");
	dataTable.addColumn(ColumnType.NUMBER, "Popularity");
	dataTable.addRows(6);
	dataTable.setValue(0, 0, "Germany");
	dataTable.setValue(0, 1, 200);
	dataTable.setValue(1, 0, "United States");
	dataTable.setValue(1, 1, 300);
	dataTable.setValue(2, 0, "Brazil");
	dataTable.setValue(2, 1, 400);
	dataTable.setValue(3, 0, "Canada");
	dataTable.setValue(3, 1, 500);
	dataTable.setValue(4, 0, "France");
	dataTable.setValue(4, 1, 600);
	dataTable.setValue(5, 0, "RU");
	dataTable.setValue(5, 1, 700);
	
	
	
	//Options
	GeoChartOptions options = GeoChartOptions.create();
	GeoChartColorAxis geoChartColorAxis = GeoChartColorAxis.create();
	geoChartColorAxis.setColors("green", "yellow");
	options.setColorAxis(geoChartColorAxis);
	options.setDatalessRegionColor("gray");
	//Draw
	geoChart.draw(dataTable, options);
	//Add
	RootPanel.get("gwtContainer").add(geoChart);
	*/
	
	}
	

	
	
	private void getMovies(){
		// initializes service proxy
		if (movieDBSvc == null){
			movieDBSvc = GWT.create(MovieDBService.class);
		}
		
		
		AsyncCallback<List<Movie>> callback = new AsyncCallback<List<Movie>>(){

			@Override
			// inherted methods
			// method called when a serverside error occurs
			public void onFailure(Throwable caught) {
				Window.alert("RPC request to server not successfull");
				
			}

			// method called when no serverside error occurs
			@Override
			public void onSuccess(List<Movie> result) {
			// Window.alert("RPC query succesfull");
				Celltable ctb = new Celltable(result);
				//Geomap gmp = new Geomap(result);
				//gmp.initialize();
			}
			
		};
		// actual request to the serverside
		movieDBSvc.getMovies(1, callback);
		

	}
	
	private void getKeyValuePair(){
		// initializes service proxy
		if (movieDBSvc == null){
			movieDBSvc = GWT.create(MovieDBService.class);
		}
		
		
		AsyncCallback<List<KeyPairValue>> callback = new AsyncCallback<List<KeyPairValue>>(){

			

			@Override
			// inherted methods
			// method called when a serverside error occurs
			public void onFailure(Throwable caught) {
				Window.alert("RPC request to server not successfull");
				
			}

			// method called when no serverside error occurs
			@Override
			public void onSuccess(List<KeyPairValue> result) {
			// Window.alert("RPC query succesfull");
				Geomap gmp = new Geomap(result);
				gmp.initialize();
				
			}
			
		};
		// actual request to the serverside
		movieDBSvc.getKeyValuePair(1, callback);
		

	}

	
}
