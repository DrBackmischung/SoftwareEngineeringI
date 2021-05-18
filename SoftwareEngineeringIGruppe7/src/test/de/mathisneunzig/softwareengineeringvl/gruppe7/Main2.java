package test.de.mathisneunzig.softwareengineeringvl.gruppe7;

import org.junit.jupiter.api.*;

class Main2 {
	
	static de.mathisneunzig.softwareengineeringvl.gruppe7.Main main;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new de.mathisneunzig.softwareengineeringvl.gruppe7.Main();
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
