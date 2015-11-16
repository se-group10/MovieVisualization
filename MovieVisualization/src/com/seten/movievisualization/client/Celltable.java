package com.seten.movievisualization.client;


import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.googlecode.gwt.charts.client.geochart.GeoChart;
//import com.hostname.segroupten.movievisualization.client.MovieVisualization.ReleaseDateSort;
//import com.hostname.segroupten.movievisualization.shared.Movie;

public class Celltable extends CellTable {

	
	
	public Celltable(List <Movie> DATA){
		final List<Movie> MOVIES = DATA;
	      // Create a CellTable.
	      final CellTable<Movie> table = new CellTable<Movie>();
	      table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
	      table.setVisible(true);
	      
	      // Add a text column to show the name.
	      TextColumn<Movie> nameColumn =  new TextColumn<Movie>() {
	         @Override
	         public String getValue(Movie object) {
	            return object.getName();
	         }
	      };    


	      // Add a date column to show the releasdate.
	      DateCell dateCell = new DateCell();
	      Column<Movie, Date> dateColumn = new Column<Movie, Date>(dateCell) {
	         @Override
	         public Date getValue(Movie object) {
	            return object.getDate() ;
	         }
	        
	      };


	      // Add a text column to show the country.
	      TextColumn<Movie> countryColumn = new TextColumn<Movie>() {
	         @Override
	         public String getValue(Movie object) {
	            return object.getCountry();
	         }
	      };

	      
	      
	      
	     Column<Movie, Number> lengthColumn = new Column<Movie,Number>(new NumberCell()){
	    	@Override
	    	public Integer getValue(Movie movie){
	    		return movie.getLength();
	    	
	    	
	    	
	    	}
	     };

	      TextColumn<Movie> languageColumn = new TextColumn<Movie>() {
		         @Override
		         public String getValue(Movie object) {
		            return object.getLanguage();
		         }
		      };
		      
		      TextColumn<Movie> genreColumn = new TextColumn<Movie>() {
			  @Override
			  public String getValue(Movie object) {
				  return object.getGenre();
			  }
			  };
			  
			  
			  
			  
	     
	      // Add Columns to Table
	     table.addColumn(nameColumn, "Movie Name");
	     table.addColumn(dateColumn, "Release Date");
	     table.addColumn(countryColumn, "Country");
	     table.addColumn(lengthColumn, "Length (minutes)");
	     table.addColumn(languageColumn, "Language");
	     table.addColumn(genreColumn, "Genre");

	      
	      // Make the column sortable.
	      nameColumn.setSortable(true);
	      dateColumn.setSortable(true);
	      countryColumn.setSortable(true);
	      lengthColumn.setSortable(true);
	      languageColumn.setSortable(true);
	      genreColumn.setSortable(true);
	      
	      
	      // Add a selection model to handle user selection.
	      final SingleSelectionModel<Movie> selectionModel = new SingleSelectionModel<Movie>();
	      table.setSelectionModel(selectionModel);
	      selectionModel.addSelectionChangeHandler(
	      new SelectionChangeEvent.Handler() {
	         public void onSelectionChange(SelectionChangeEvent event) {
	            Movie selected = selectionModel.getSelectedObject();
	            if (selected != null) {
	               Window.alert(
	            		    ""
	            		   
	            		   
	            		   );
	            }
	         }
	      });

	     // Jan Stuff :-)    
	     SimplePager pager = new SimplePager();
	     pager.setDisplay(table);
	     
	     //Create a data provider.
	     ListDataProvider<Movie> dataProvider = new ListDataProvider<Movie>();
	     
	     // Connect the table to the data provider.
	     dataProvider.addDataDisplay(table);
	     
	     // Add the data to the data provider, which automatically pushes it to the
	     // widget.
	     List<Movie> list = dataProvider.getList();
	     for (Movie movie : MOVIES) {
	       list.add(movie);
	     }
	    
	     // Sorting nameColumn
	     // Add a ColumnSortEvent.ListHandler to connect sorting to the
	     // java.util.List.
	     ListHandler<Movie> columnSortHandler = new ListHandler<Movie>(list);
	     columnSortHandler.setComparator(nameColumn,new NameSort());
	     
	     // Sorting Columns
	     columnSortHandler.setComparator(lengthColumn, new LengthSort());
	     columnSortHandler.setComparator(countryColumn, new CountrySort());
	     columnSortHandler.setComparator(genreColumn, new GenreSort());
	     columnSortHandler.setComparator(languageColumn, new LanguageSort());
	     columnSortHandler.setComparator(dateColumn, new DateSort());
	     	
	     	
	     table.addColumnSortHandler(columnSortHandler);
	     
	     // We know that the data is sorted alphabetically by default.
	     table.getColumnSortList().push(nameColumn);
	 
	      
	      
	      final PushButton visibleButton = new PushButton("show celltable!");
	      	visibleButton.addClickHandler(new ClickHandler(){
	      		public void onClick(ClickEvent event) {

	      			if (table.isVisible()){
	      				table.setVisible(false);
	      				visibleButton.setText("show celltable!");
	      			}
	      			else {
	      				table.setVisible(true);
	      				visibleButton.setText("hide celltable!");
	      			}
				
	      		}
	      	});
	      
	      
	      Image image = new Image();
	      image.setUrl("ressources/ad-placeholder.jpg");
	      image.setWidth("1000px");
	      image.setHeight("64px");
	      
	      // Set Style of Button
	      //sortByReleaseDate.setStylePrimaryName("gwt-Button");
	      visibleButton.setStylePrimaryName("gwt-Button");
	      
	      // Set the total row count. This isn't strictly necessary,
	      // but it affects paging calculations, so its good habit to
	      // keep the row count up to date.
	      
	      table.setRowCount(MOVIES.size(), true);
	     // table.setVisibleRange();
	      
	      // Push the data into the widget.
	      
	      table.setRowData(0, MOVIES);
	      table.setWidth("1000px");
	      VerticalPanel panel = new VerticalPanel();
	      panel.setBorderWidth(1);	    
	     // panel.setWidth("1000px");
	      panel.add(table);
	      panel.add(pager);
	      VerticalPanel panel2 = new VerticalPanel();
	      panel2.add(image);
	      RootPanel.get("adv").add(panel2);
	      RootPanel.get("gwtContainer").add(panel);
		

	}
	private void refreshtable() {
		// TODO Auto-generated method stub
	}


}