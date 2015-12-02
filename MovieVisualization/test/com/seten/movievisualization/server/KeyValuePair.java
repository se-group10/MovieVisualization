package com.seten.movievisualization.server;

import static org.junit.Assert.*;

import org.junit.Test;
import com.google.gwt.junit.client.GWTTestCase;
import java.util.List;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.seten.movievisualization.client.KeyPairValue;
import com.seten.movievisualization.client.MovieDBService;
import com.seten.movievisualization.client.MovieDBServiceAsync;

public class KeyValuePair extends GWTTestCase{

	   @Test
	   public void test() {
	        MovieDBServiceAsync mdb = GWT.create(MovieDBService.class);
	        ServiceDefTarget target = (ServiceDefTarget) mdb;
	        target.setServiceEntryPoint("movievisualiziation/movies");
	        // a delaz is used because the RPC request is asynchronous
	        delayTestFinish(10000);
	        
	        
	        mdb.getKeyValuePair(0, new AsyncCallback<List<KeyPairValue>>(){
	 
	              @Override
	              public void onFailure(Throwable caught) {
	                  // if the rpc request results in an error
	                  fail("request failure: " + caught.getMessage());
	                               
	              }
	 
	              @Override
	              public void onSuccess(List<KeyPairValue> result) {
	                  // if the rpc request responds
	                  // checks whether the returned result is empty
	                               
	                  assertTrue(result.size()>0);
	                  finishTest();
	                  
	              } });
	   }
	       
	 
	   @Override
	   public String getModuleName() {
	        return "com.seten.movievisualization.Movievisualization";
	   }
	 
}