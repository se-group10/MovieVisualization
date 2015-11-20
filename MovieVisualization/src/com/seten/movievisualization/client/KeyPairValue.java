package com.seten.movievisualization.client;

import java.io.Serializable;

public class KeyPairValue implements Serializable {
	
	public String country;
	public int counter;
	
	public KeyPairValue(){}
	public KeyPairValue(String country, int counter) {
		this.country = country;
		this.counter = counter;
	}
	
	public KeyPairValue(String country) {
		this.country = country;
		
	}


}
