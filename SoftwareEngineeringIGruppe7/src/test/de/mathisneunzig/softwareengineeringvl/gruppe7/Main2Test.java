package test.de.mathisneunzig.softwareengineeringvl.gruppe7;

import org.junit.jupiter.api.*;

import de.mathisneunzig.softwareengineeringvl.gruppe7.Main;

class Main2Test {
	
	static Main main;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Main();
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
	@DisplayName("Zwei Nummern werden addiert: 1 + 3 = 4")
	void test() {
		Assertions.assertEquals(4, main.addNumber(1, 3));
	}

}
