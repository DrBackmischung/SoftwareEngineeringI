package test.de.wwi2020seb.softwareengineering.gruppe7.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import de.wwi2020seb.softwareengineering.gruppe7.gui.Controller;
import de.wwi2020seb.softwareengineering.gruppe7.gui.Model;

public class ControllerTest {
	
	@Test
	@DisplayName("Test Singelton")
	public void testSingelton(){
	 	Controller firstController = Controller.getInstance();
	 	Controller secondController = Controller.getInstance(); 
	 	assertEquals(firstController, secondController);
	}
	
	
}
