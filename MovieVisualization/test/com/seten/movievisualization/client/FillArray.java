package com.seten.movievisualization.client;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FillArray {

	@Test
	public void test() {
		
		// Chech whether Object[][] is correctly populated from List<KeyPairValue>
		List<KeyPairValue> KEYVALUEPAIR = Arrays.asList(
				
				new KeyPairValue("GB", 10),
				new KeyPairValue("United States of America", 20),
				new KeyPairValue("India", 30),
				new KeyPairValue("Canada", 40),
				new KeyPairValue("Germany", 50),
				new KeyPairValue("France", 60),
				new KeyPairValue("Brazil", 70),
				new KeyPairValue("Russia", 80)
				
		);
		
		Geomap gmp = new Geomap(KEYVALUEPAIR);
		
		int numberOfCountries = KEYVALUEPAIR.size();
		Object[][] geoDataObjects = new Object[numberOfCountries + 1][2];
		geoDataObjects[0][0] = "Country";
		geoDataObjects[0][1] = "Movies per Year";
		
		gmp.fillArray(geoDataObjects);
		
		assertEquals(10, geoDataObjects[1][1]);
		assertEquals("Brazil", geoDataObjects[7][0]);
		
	
	}

}
