package com.hostname.segroupten.movievisualization.client;
import com.hostname.segroupten.movievisualization.shared.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.lang.Number;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client
.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;



public class MovieVisualization implements EntryPoint {
   /**
   * A simple data type that represents a contact.
   */

  public class ReleaseDateSort implements Comparator <Movie>{
	   @Override
	   public int compare(Movie movie1, Movie movie2){
		   return movie1.getDate().compareTo(movie2.getDate());

	   }
   }
  
  

   /**
   * The list of data to display.
   */
   public static List<Movie> MOVIES = Arrays.asList(
      new Movie("The Lord of the Rings: The Fellowship of the Ring", new Date(80, 4, 5), "USA", 201, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Vertigo", new Date(85, 2, 15), "USA", 109, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Harry Potter and the Half-Blood Prince",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Babc", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("The Lord of the Rings", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland", "Fantasy", "French"),
      new Movie("The Lord of the Rings: The Two Towers", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Harry Potter and the Goblet of Fire",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Goldfinger", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("7 ways to die", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("8 ways to die", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Harry Potter and the Order of the Phoenix",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("babc", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("The Random", new Date(80, 4, 11), "India", 140, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("The Project", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Spectre", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Film1", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Film2", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland", "Horror", "English"),
      new Movie("Harry Potter and the Deathly Hallows � Part 2",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Film4", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Film 6", new Date(80, 5, 12), "India", 140, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Film 7", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Film5", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Film 8", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Film 9", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Harry Potter and the Chamber of Secrets",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Film3", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Comedy", "German"),
      new Movie("Harry Potter and the Deathly Hallows � Part 1", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland", "Fantasy", "French"),
      new Movie("Film 10", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland", "Fantasy", "French"),
      new Movie("xy", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland", "Fantasy", "French")
	 );

   public void onModuleLoad() {
      // Create a CellTable.
      final CellTable<Movie> table = new CellTable<Movie>();
      table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
      table.setVisible(false);
      
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
      
     TextColumn<Movie> genresColumn = new TextColumn<Movie>() {
          @Override
          public String getValue(Movie object) {
             return object.getGenres();
      	}
     };

     TextColumn<Movie> languageColumn = new TextColumn<Movie>() {
         @Override
         public String getValue(Movie object) {
            return object.getLanguage();
     	}
     };
    
    
     Column<Movie, Number> lengthColumn = new Column<Movie,Number>(new NumberCell()){
    	@Override
    	public Integer getValue(Movie movie){
    		return movie.getLength();
    	}
     };

      

      // Add Columns to Table
     table.addColumn(nameColumn, "Name");
     table.addColumn(dateColumn, "Release Date");
     table.addColumn(lengthColumn, "Length (minutes)");
     table.addColumn(languageColumn, "Language");
     table.addColumn(countryColumn, "Country");
     table.addColumn(genresColumn, "Genres");

      
      // Make the columns sortable.
      nameColumn.setSortable(true);
      dateColumn.setSortable(true);
      countryColumn.setSortable(true);
      lengthColumn.setSortable(true);
      languageColumn.setSortable(true);
      genresColumn.setSortable(true);
      
      
      // Add a selection model to handle user selection.
      final SingleSelectionModel<Movie> selectionModel = new SingleSelectionModel<Movie>();
      table.setSelectionModel(selectionModel);
      selectionModel.addSelectionChangeHandler(
      new SelectionChangeEvent.Handler() {
         public void onSelectionChange(SelectionChangeEvent event) {
            Movie selected = selectionModel.getSelectedObject();
            if (selected != null) {
               Window.alert(
            		    "the information for " +selected.getName()+" was provided by \n" + selected.getSource()
            		   
            		   
            		   );
            }
         }
      });
      /*
     ArrayList<Movie> moviesfromdb = new ArrayList<Movie>();
     MovieDatabaseServiceAsync moviesrv = GWT.create(MovieDatabaseService.class);
      AsyncCallback<Movie[]> callback = new AsyncCallback<Movie[]>(){

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("error on loading from serverside MovieDBservice");
			
		}

		@Override
		public void onSuccess(Movie[] result) {
			Window.alert(result[0].country);
			
		}
    	  
      };*/
           

     SimplePager pager = new SimplePager();
     pager.setDisplay(table);
     
     //Create a data provider.
     ListDataProvider<Movie> dataProvider = new ListDataProvider<Movie>();
     
     // Connect the table to the data provider.
     dataProvider.addDataDisplay(table);
     
     // Add the data to the data provider, which automatically pushes it to the
     // widget.
     List<Movie> list = dataProvider.getList();
     for (Movie contact : MOVIES) {
       list.add(contact);
     }
    
     // Sorting nameColumn
     // Add a ColumnSortEvent.ListHandler to connect sorting to the
     // java.util.List.
     ListHandler<Movie> columnSortHandler = new ListHandler<Movie>(list);
     columnSortHandler.setComparator(nameColumn, new StringSort());

     // Sorting lengthColumn
     columnSortHandler.setComparator(lengthColumn, new LengthSort());
    	 	
     // Sorting countryColumn
     columnSortHandler.setComparator(countryColumn, new CountrySort());

     // Sorting dateColumn
     columnSortHandler.setComparator(dateColumn, new DateSort());
     
     // Sorting genreColumn
     columnSortHandler.setComparator(genresColumn, new GenreSort());
     
     // Sorting languageColumn
     columnSortHandler.setComparator(languageColumn, new LanguageSort());	
     	
     table.addColumnSortHandler(columnSortHandler);
     
     // Sort for Name Column
     table.getColumnSortList().push(nameColumn);
      
     /* TODO implement the function&buttons so that the celltable is updated with the new values of the arraylist
      do this for all the attributes (sortByName, sortByLength etc..) keep in mind that you have to create
      classes for the sorting algorithm (like ReleaseDateSort)
      
      */

      final Button sortByReleaseDate  = new Button ("Sort By Release Date");
      sortByReleaseDate.addClickHandler(new ClickHandler(){
      	public void onClick(ClickEvent event) {
      		Window.alert("sort button was pressed, function not implementde");
      		//this line sorts the arraylist by date
      		Collections.sort(MOVIES, new ReleaseDateSort());

      	}
   	
      });
          
 
      
      
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
      
      
      // Set Style of Button
      sortByReleaseDate.setStylePrimaryName("gwt-Button");
      visibleButton.setStylePrimaryName("gwt-Button");
      
      // Set the total row count. This isn't strictly necessary,
      // but it affects paging calculations, so its good habit to
      // keep the row count up to date.
      
      table.setRowCount(MOVIES.size(), true);
     // table.setVisibleRange();
      
      // Push the data into the widget.
      
      table.setRowData(0, MOVIES);
      VerticalPanel panel = new VerticalPanel();
      panel.setBorderWidth(1);	    
      panel.setWidth("500");
      panel.add(table);
      panel.add(pager);
      VerticalPanel panel2 = new VerticalPanel();
      panel2.add(image);
      RootPanel.get("adv").add(panel2);
      
      // panel.add(image);
      // Add the widgets to the root panel.
      
      RootPanel.get("buttons").add(visibleButton);
      RootPanel.get("buttons").add(sortByReleaseDate);
      RootPanel.get("gwtContainer").add(panel);
     
   }

private void refreshtable() {
	// TODO Auto-generated method stub
}
}

