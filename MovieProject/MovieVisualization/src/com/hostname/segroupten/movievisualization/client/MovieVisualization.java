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
		   return movie1.releasedate.compareTo(movie2.releasedate);

	   }
   }

   /**
   * The list of data to display.
   */
   public static List<Movie> MOVIES = Arrays.asList(
      new Movie("The Lord of the Rings: The Fellowship of the Ring", new Date(80, 4, 5), "USA", 201, "Institute XY, Zürich, Switzerland"),
      new Movie("Vertigo", new Date(85, 2, 15), "USA", 109, "Institute XY, Zürich, Switzerland"),
      new Movie("Harry Potter and the Half-Blood Prince",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland"),
      new Movie("Babc", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("The Lord of the Rings", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland"),
      new Movie("The Lord of the Rings: The Two Towers", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Harry Potter and the Goblet of Fire",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland"),
      new Movie("Goldfinger", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("7 ways to die", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland"),
      new Movie("8 ways to die", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Harry Potter and the Order of the Phoenix",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland"),
      new Movie("babc", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("The Random", new Date(80, 4, 11), "India", 140, "Institute XY, Zürich, Switzerland"),
      new Movie("The Project", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Spectre", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Film1", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland"),
      new Movie("Film2", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Harry Potter and the Deathly Hallows � Part 2",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland"),
      new Movie("Film4", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Film 6", new Date(80, 5, 12), "India", 140, "Institute XY, Zürich, Switzerland"),
      new Movie("Film 7", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Film5", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Film 8", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland"),
      new Movie("Film 9", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Harry Potter and the Chamber of Secrets",new Date(46, 6, 6),"UK", 60, "Institute XY, Zürich, Switzerland"),
      new Movie("Film3", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("Harry Potter and the Deathly Hallows � Part 1", new Date(80, 4, 12), "India", 140, "Institute XY, Zürich, Switzerland"),
      new Movie("Film 10", new Date(85, 2, 22), "USA", 90, "Institute XY, Zürich, Switzerland"),
      new Movie("xy", new Date(23,4,6), "Zürich", 90, "Institute XY, Zürich, Switzerland")
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

      
      
      
     Column<Movie, Number> lengthColumn = new Column<Movie,Number>(new NumberCell()){
    	@Override
    	public Integer getValue(Movie movie){
    		return movie.getLength();
    	}
     };

      
      
      /*
      TextColumn<Movie> newlengthColumn = new TextColumn<Movie>() {
         @Override
         public String getValue(Movie object) {
            return object.getLength() + " minutes";
         }
      };  
      table.addColumn(newlengthColumn, "Length formatted"); */

      // Add Columns to Table
     table.addColumn(nameColumn, "Movie Name");
     table.addColumn(dateColumn, "Release Date");
     table.addColumn(countryColumn, "Country");
     table.addColumn(lengthColumn, "Length (minutes)");

      
      // Make the name column sortable.
      nameColumn.setSortable(true);
      dateColumn.setSortable(true);
      countryColumn.setSortable(true);
      lengthColumn.setSortable(true);
      
      
      
      // Add a selection model to handle user selection.
      final SingleSelectionModel<Movie> selectionModel = new SingleSelectionModel<Movie>();
      table.setSelectionModel(selectionModel);
      selectionModel.addSelectionChangeHandler(
      new SelectionChangeEvent.Handler() {
         public void onSelectionChange(SelectionChangeEvent event) {
            Movie selected = selectionModel.getSelectedObject();
            if (selected != null) {
               Window.alert(
            		    "the information for " +selected.name+" was provided by \n" + selected.source
            		   
            		   
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
     for (Movie contact : MOVIES) {
       list.add(contact);
     }
    
     // Sorting nameColumn
     // Add a ColumnSortEvent.ListHandler to connect sorting to the
     // java.util.List.
     ListHandler<Movie> columnSortHandler = new ListHandler<Movie>(list);
     columnSortHandler.setComparator(nameColumn,new Comparator<Movie>() {
    	   	public int compare(Movie m1, Movie m2) {
    	       // Compare the objects
    	       if (m1 == m2) {
    	           return 0;
    	       }

    	       // Compare the name columns.
    	       if (m1 != null) {
    	           return (m2 != null) ? m1.getName().compareToIgnoreCase(m2.getName()) : 1;
    	       }
    	       return -1;
    	       }
    	    });
     
     // Sorting lengthColumn
     // Add a ColumnSortEvent.ListHandler to connect sorting to the
     // java.util.List.
     columnSortHandler.setComparator(lengthColumn, new Comparator<Movie>() {
     		public int compare(Movie m1, Movie m2) {
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
     		
     });
     
     // Sorting countryColumn
     // Add a ColumnSortEvent.ListHandler to connect sorting to the
     // java.util.List.
     // git test
     
     columnSortHandler.setComparator(countryColumn, new Comparator<Movie>() {
     		public int compare(Movie m1, Movie m2) {
     	       if (m1 == m2) {
    	           return 0;
    	       }

    	       // Compare the name columns.
    	       if (m1 != null) {
    	           return (m2 != null) ? m1.getCountry().compareToIgnoreCase(m2.getCountry()) : 1;
    	       }
    	       return -1;
     		}
     		
     });
     
     // Sorting dateColumn
     columnSortHandler.setComparator(dateColumn, new Comparator<Movie>() {
  		public int compare(Movie m1, Movie m2) {
  	       if (m1 == m2) {
 	           return 0;
 	       }

 	       // Compare the name columns.
 	       if (m1 != null) {
 	           if (m2!=null) {
 	        	   return compareDate(m1.getDate(), m2.getDate());
 	           }
 	       }
 	       return -1;
  		}
  		
  });
     	
     	
     table.addColumnSortHandler(columnSortHandler);
     
     // We know that the data is sorted alphabetically by default.
     table.getColumnSortList().push(nameColumn);
      
     /* TODO implement the function&buttons so that the celltable is updated with the new values of the arraylist
      do this for all the attributes (sortByName, sortByLength etc..) keep in mind that you have to create
      classes for the sorting algorithm (like ReleaseDateSort)
      
      */

      final Button sortByReleaseDate  = new Button ("Sort By Release Date");
      sortByReleaseDate.addClickHandler(new ClickHandler(){
      	@Override
      	public void onClick(ClickEvent event) {
      		Window.alert("sort button was pressed, function not implementde");
      		//this line sorts the arraylist by date
      		Collections.sort(MOVIES, new ReleaseDateSort());
      	  
      	  
         // table.addColumn(nameColumn, "Movie Name");
         // table.addColumn(dateColumn, "Release Date");
         // table.addColumn(countryColumn, "Country");
         // table.addColumn(lengthColumn, "Length");
      	
      	
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

private static int compareInt(int first, int second) {
	if(first == second){
		return 0;
	}
	
	else if(first > second){
		return 1; }
		else return -1;
}

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
