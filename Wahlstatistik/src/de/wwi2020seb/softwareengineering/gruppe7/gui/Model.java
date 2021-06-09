package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.application.ResultList;

public class Model {
	
	public static Model model;
	private static ArrayList<ResultList> results;
	private ResultList cityResult;
	private ResultList currentDistrictResult = null;

	public static Model getInstance() {
		if(model == null) {
			model = new Model();
		}
		return model;
	}
	
	public Model() {
		results = new ArrayList<>();
	}
	
	public ResultList getResultForDistrict() {
		if(currentDistrictResult != null)
			return currentDistrictResult;
		else
			/*
			 * Hier Exception einfügen
			 */
			return null;
	}
	
	public ResultList getResultForCity() {
		return cityResult;
	}
	
	public void calculateCityResult() {
		
	}
	
	public boolean loadDistrict(String name) {
		for(ResultList d : results) {
			if(d.getName().equalsIgnoreCase(name)) {
				currentDistrictResult = d;
				return true;
			}
		}
		return false;
	}

}
