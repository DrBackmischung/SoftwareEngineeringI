package test.de.wwi2020seb.softwareengineering.gruppe7.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import de.wwi2020seb.softwareengineering.gruppe7.gui.Model;

public class ModelTest {
	
	@Test
	@DisplayName("Test Singelton")
	public void testSingelton() {
		
		Model modelOne = Model.getInstance();
		Model modelTwo = Model.getInstance();
		
		assertEquals(modelOne, modelTwo);
		
	}
	
	@Test
	@DisplayName("Test Data in Model")
	public void testData() {
		
	}

}
