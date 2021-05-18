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
	@DisplayName("Zwei Nummern werden addiert: 1 + 2 = 3")
	void test() {
		Assertions.assertEquals(3, main.addNumber(1, 2));
	}

}
