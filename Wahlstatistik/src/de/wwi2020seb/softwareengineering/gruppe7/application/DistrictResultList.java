package de.wwi2020seb.softwareengineering.gruppe7.application;

import java.util.ArrayList;

public class DistrictResultList {
	
	private String districtName;
	private ArrayList<ResultMap> results;
	
	public DistrictResultList(String name) {
		this.districtName = name;
		results = new ArrayList<>();
	}
	
	public String getName() {
		return districtName;
	}
	
	public void addResult(ResultMap r) {
		results.add(r);
	}
	
	// moin

}