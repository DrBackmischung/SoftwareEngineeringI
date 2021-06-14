package test.de.wwi2020seb.softwareengineering.gruppe7.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import de.wwi2020seb.softwareengineering.gruppe7.gui.Controller;

public class ControllerTest {
	
	@Test
	@DisplayName("Test Singelton")
	public void testSingelton(){
	 	Controller firstController = Controller.getInstance();
	 	Controller secondController = Controller.getInstance();
	 	assertEquals(firstController, secondController);
	}
	
	
}
