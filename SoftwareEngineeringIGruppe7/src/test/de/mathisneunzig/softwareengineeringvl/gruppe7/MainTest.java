package test.de.mathisneunzig.softwareengineeringvl.gruppe7;

import org.junit.jupiter.api.*;

import de.mathisneunzig.softwareengineeringvl.gruppe7.Main;

class MainTest {
	
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
	@DisplayName("Fenster wird geprueft")
	void test() {
		
	}

}
