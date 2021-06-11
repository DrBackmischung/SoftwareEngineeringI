package de.wwi2020seb.softwareengineering.gruppe7.datamodels;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultList implements Serializable {
	
	private static final long serialVersionUID = 6769684837926322L;
	private String districtName;
	private ArrayList<ResultMap> results;
	
	public ResultList(String name) {
		this.districtName = name;
		results = new ArrayList<>();
	}
	
	public String getName() {
		return districtName;
	}
	
	public void addResult(ResultMap r) {
		results.add(r);
	}
	
	public ArrayList<ResultMap> getResults() {
		return results;
	}

}