package de.wwi2020seb.softwareengineering.gruppe7.application;

import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.data.CSVReader;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

public class VotingManager {
	
	private static VotingManager vm;
	
	public int readData(String dataPath) {
		return CSVReader.getInstance().readData(dataPath);
	}

	public ArrayList<ResultList> getData() {
		ArrayList<ResultList> results;
		results = CSVReader.getInstance().getData();
		if(results != null) {
			VotingCalculator vc = this.new VotingCalculator();
			ArrayList<String> names = vc.getAllNames(results);
			for(ResultList r : results) {
				vc.calculatePercentages(r);
				vc.enrichCandidates(r, names);
			}
			results.add(vc.calculateCityResult(results));
		}
		return results;
	}
	
	public static VotingManager getInstance() {
		if(vm == null) {
			vm = new VotingManager();
		}
		return vm;
	}
	
	public class VotingCalculator {
			
		public void enrichCandidates(ResultList r, ArrayList<String> names) {
			for(String s : names) {
				boolean containsName = false;
				for(ResultMap m : r.getResults()) {
					if(m.getName().equalsIgnoreCase(s))
							containsName = true;
				}
				if(!containsName) {
					r.addResult(new ResultMap(s, 0));
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
				double r = (result / votes * 100)*10;
				r = (int) r;
				if(r % 10 >= 5) {
					r += 1;
				} 
				r = (double) r/10;
				m.setPercentage(r);
			}
		}
		
		public ResultList calculateCityResult(ArrayList<ResultList> results) {
			ResultList cityResult = new ResultList("---Gesamt---");
			for(ResultList r : results) {
				for(ResultMap m : r.getResults()) {
					boolean containsCandidate = false;
					for(ResultMap c : cityResult.getResults()) {
						if(m.getName().equalsIgnoreCase(c.getName())) {
							c.addVotes(m.getVoteCount());
							containsCandidate = true;
						}
					}
					if(!containsCandidate) {
						cityResult.addResult(new ResultMap(m.getName(), m.getVoteCount()));
					}
				}
			}
			calculatePercentages(cityResult);
			return cityResult;
		}
		
		public ArrayList<String> getAllNames(ArrayList<ResultList> results) {
			ArrayList<String> names = new ArrayList<>();
			for(ResultList r : results) {
				for(ResultMap m : r.getResults()) {
					if(!names.contains(m.getName()))
						names.add(m.getName());
				}
			}
			return names;
		}
		
	}
	
}
