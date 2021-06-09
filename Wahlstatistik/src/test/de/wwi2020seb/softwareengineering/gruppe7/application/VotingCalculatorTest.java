package test.de.wwi2020seb.softwareengineering.gruppe7.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.wwi2020seb.softwareengineering.gruppe7.application.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.application.ResultMap;
import de.wwi2020seb.softwareengineering.gruppe7.application.VotingCalculator;

class VotingCalculatorTest {
	
	VotingCalculator vc = new VotingCalculator();

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
	@DisplayName("Test for percentage calculation")
	void test() {
		ResultList r = new ResultList("Test");
		ResultMap rm = new ResultMap("Relaxo", 100);
		r.addResult(rm);
		r.addResult(new ResultMap("Mathis Neunzig", 70));
		r.addResult(new ResultMap("Kitty Blume", 25));
		r.addResult(new ResultMap("Pikachu", 5));
		vc.calculatePercentages(r);
		assertEquals((double) 50, rm.getPercentage());
	}

}
