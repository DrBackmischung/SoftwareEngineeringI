package test.de.wwi2020seb.softwareengineering.gruppe7.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.wwi2020seb.softwareengineering.gruppe7.application.VotingManager;
import de.wwi2020seb.softwareengineering.gruppe7.application.VotingManager.VotingCalculator;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

class VotingCalculatorTest {
	
	private static VotingManager vm = VotingManager.getInstance();
	static VotingCalculator vc;
	static ResultList r1, r2;
	static ResultMap m11, m12, m13, m21, m22;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		vc = vm.new VotingCalculator();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		r1 = new ResultList("Bezirk1");
		m11 = new ResultMap("Relaxo", 22);
		m12 = new ResultMap("Pichu", 68);
		m13 = new ResultMap("Glumanda", 10);
		r1.addResult(m11);
		r1.addResult(m12);
		r1.addResult(m13);
		r2 = new ResultList("Bezirk2");
		m21 = new ResultMap("Relaxo", 30);
		m22 = new ResultMap("Pichu", 70);
		r2.addResult(m21);
		r2.addResult(m22);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test percentage calculation method")
	void testPercentageCalculation() {
		vc.calculatePercentages(r1);
		vc.calculatePercentages(r2);
		assertEquals((double) 22, m11.getPercentage());
		assertEquals((double) 68, m12.getPercentage());
		assertEquals((double) 10, m13.getPercentage());
	}
	
	@Test
	@DisplayName("Test enrich names method")
	void testEnrichNames() {
		ArrayList<ResultList> results = new ArrayList<>();
		results.add(r1);
		results.add(r2);
		vc.enrichCandidates(r1, vc.getAllNames(results));
		vc.enrichCandidates(r2, vc.getAllNames(results));
		assertEquals(3, r1.getResults().size());
		assertEquals(3, r2.getResults().size());
	}
	
	@Test
	@DisplayName("Test get all names method")
	void testGetAllNames() {
		ArrayList<ResultList> results = new ArrayList<>();
		results.add(r1);
		results.add(r2);
		ArrayList<String> names = vc.getAllNames(results);
		assertEquals(3, names.size());
		assertEquals(true, names.contains("Relaxo"));
		assertEquals(true, names.contains("Glumanda"));
		assertEquals(true, names.contains("Pichu"));
	}
	
	@Test
	@DisplayName("Test calculate city result method")
	void testCalculateCityResult() {
		ArrayList<ResultList> results = new ArrayList<>();
		vc.calculatePercentages(r1);
		vc.calculatePercentages(r2);
		vc.enrichCandidates(r1, vc.getAllNames(results));
		vc.enrichCandidates(r2, vc.getAllNames(results));
		results.add(r1);
		results.add(r2);
		ResultList r = vc.calculateCityResult(results);
		assertEquals("---Gesamt---", r.getName());
		assertEquals(3, r.getResults().size());
		ResultMap relaxo = null;
		for(ResultMap m : r.getResults()) {
			if(m.getName().equals("Relaxo"))
				relaxo = m;
		}
		assertEquals(52, relaxo.getVoteCount());
		assertEquals((double)26, relaxo.getPercentage());
	}

}
