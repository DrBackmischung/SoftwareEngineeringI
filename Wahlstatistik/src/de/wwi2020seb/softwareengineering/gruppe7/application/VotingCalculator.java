package de.wwi2020seb.softwareengineering.gruppe7.application;

import java.util.ArrayList;

public class VotingCalculator {
/*
 * Bekommt alle DistrictResultLists und fuegt alle fehlenden Personen hinzu
 */
	
	public void enrichCandidates(ResultList d, ArrayList<String> names) {
		for(String s : names) {
			boolean containsName = false;
			for(ResultMap m : d.getResults()) {
				if(m.getName().equalsIgnoreCase(s))
						containsName = true;
			}
			if(!containsName) {
				d.addResult(new ResultMap(s, 0));
			}
		}
	}
	
	public void calculatePercentages(ResultList d) {
		double votes = 0;
		for(ResultMap m : d.getResults()) {
			votes += m.getVoteCount();
		}
		for(ResultMap m: d.getResults() ) {
			double result = m.getVoteCount();
			m.setPercentage(result / votes * 100);
		}
	}
	
}
