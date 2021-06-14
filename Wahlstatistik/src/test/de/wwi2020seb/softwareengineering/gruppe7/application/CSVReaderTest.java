package test.de.wwi2020seb.softwareengineering.gruppe7.application;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.wwi2020seb.softwareengineering.gruppe7.data.CSVReader;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;


public class CSVReaderTest {
	
	CSVReader testReader = CSVReader.getInstance();
	ArrayList<ResultList> resultLists = new ArrayList<ResultList>();
	ArrayList<ResultList> expected = new ArrayList<ResultList>();
	@Test
	@DisplayName("CSV Reader Test")
	public void testCSVReader() {
	
		ResultList Innenstadt = new ResultList("Innenstadt");
		Innenstadt.addResult(new ResultMap("Mathis", 6));
		Innenstadt.addResult(new ResultMap("Marcel", 2));
		Innenstadt.addResult(new ResultMap("Leo", 2));
		
		ResultList Jungbusch = new ResultList("Jungbusch");
		Jungbusch.addResult(new ResultMap("Mathis", 3));
		Jungbusch.addResult(new ResultMap("Marcel", 3));
		Jungbusch.addResult(new ResultMap("Leo", 4));
		
		ResultList Ketsch = new ResultList("Ketsch");
		Ketsch.addResult(new ResultMap("Marcel", 2));
		Ketsch.addResult(new ResultMap("Jana", 8));
		
		expected.add(Innenstadt);
		expected.add(Jungbusch);
		expected.add(Ketsch);
			
		resultLists =  testReader.getData();
		
		Iterator<ResultList> firstExpected = expected.iterator();
		Iterator<ResultList> firstResult = resultLists.iterator();
		while(firstResult.hasNext()) {
			
			ResultList currentList = (ResultList) firstResult.next();
			ResultList expectedList = (ResultList) firstExpected.next();
			assertEquals(expectedList.getName(), currentList.getName());
			
			ArrayList<ResultMap> currentResultMaps = currentList.getResults();
			Iterator<ResultMap> currResultMapsIterator = currentResultMaps.iterator();
			
			ArrayList<ResultMap> expectedResultMaps = expectedList.getResults();
			Iterator<ResultMap> expResultMapsIterator = expectedResultMaps.iterator();
			while(currResultMapsIterator.hasNext()) {
				ResultMap currentMap = (ResultMap) currResultMapsIterator.next();
				ResultMap expectedMap = (ResultMap) expResultMapsIterator.next();
				
				assertEquals(expectedMap.getName(), currentMap.getName());
				assertEquals(expectedMap.getVoteCount(), currentMap.getVoteCount());
				
			}
					
		}
		
	

	}
	
}
