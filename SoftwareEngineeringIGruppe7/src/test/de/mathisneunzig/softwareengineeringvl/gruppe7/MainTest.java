package test.de.mathisneunzig.softwareengineeringvl.gruppe7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import de.mathisneunzig.softwareengineeringvl.gruppe7.Haltestelle;
import de.mathisneunzig.softwareengineeringvl.gruppe7.Main;
import de.mathisneunzig.softwareengineeringvl.gruppe7.gui.Controller;

class MainTest {
	
	static Controller c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Controller();
		c.startApplication();
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
	@DisplayName("Connection Test: Connection between Hauptbahnhof and Ostbahnhof")
	void simpleConnection() {
		Haltestelle s1 = null, s2 = null;
		String from = "Hauptbahnhof";
		for(Haltestelle s : c.getAllStops()) {
			if(s.getName().equals(from)) {
				s1 = s;
			}
		}
		String to = "Ostbahnhof";
		for(Haltestelle s : c.getAllStops()) {
			if(s.getName().equals(to)) {
				s2 = s;
			}
		}
		c.getModel().calculateConnection(s1, s2);
		assertEquals("302: Hauptbahnhof -> Ostbahnhof", c.getModel().getConnection());
	}
	
	@Test
	@DisplayName("Connection Test: Connection between Markt and Ostbahnhof")
	void changeConnection() {
		Haltestelle s1 = null, s2 = null;
		String from = "Markt";
		for(Haltestelle s : c.getAllStops()) {
			if(s.getName().equals(from)) {
				s1 = s;
			}
		}
		String to = "Ostbahnhof";
		for(Haltestelle s : c.getAllStops()) {
			if(s.getName().equals(to)) {
				s2 = s;
			}
		}
		c.getModel().calculateConnection(s1, s2);
		assertEquals("301: Markt -> Hauptbahnhof >> 302: Hauptbahnhof -> Ostbahnhof", c.getModel().getConnection());
	}

}
