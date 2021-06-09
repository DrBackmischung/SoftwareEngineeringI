package de.wwi2020seb.softwareengineering.gruppe7.application;

import java.util.ArrayList;

public class ResultList {
	
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

}