package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

public class Model {
	
	public static Model model;
	private ArrayList<ResultList> results;
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
			 * Hier Exception einfuegen
			 */
			return null;
	}
	
	public ResultList getResultForCity() {
		for(ResultList r : results) {
			if(r.getName().equals("---Gesamt---")) {
				return r;
			}
		}
		return null;
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

	public void readData(ArrayList<ResultList> data) {
		
		results = data;
		
	}

	public ArrayList<String> getDistrictNames() {
		ArrayList<String> names = new ArrayList<>();
		for(ResultList r : results) {
			if(r.getName() != "---Gesamt---") 
				names.add(r.getName());
		}
		return names;
	}

}
