package de.wwi2020seb.softwareengineering.gruppe7.datamodels;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class ResultList implements Serializable {
	
	private static final long serialVersionUID = 6769684837926322L;
	private String districtName;
	private Set<ResultMap> results;
	
	public ResultList(String name) {
		this.districtName = name;
		results = new TreeSet<>();
	}
	
	public String getName() {
		return districtName;
	}
	
	public void addResult(ResultMap r) {
		results.add(r);
	}
	
	public Set<ResultMap> getResults() {
		return results;
	}

}