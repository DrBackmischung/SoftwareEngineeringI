package test.de.wwi2020seb.softwareengineering.gruppe7.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import de.wwi2020seb.softwareengineering.gruppe7.gui.Controller;

public class ControllerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("Test Singelton")
	public void testSingelton(){
	 	Controller firstController = Controller.getInstance();
	 	Controller secondController = Controller.getInstance(); 
	 	assertEquals(firstController, secondController);
	}
	
	
}
