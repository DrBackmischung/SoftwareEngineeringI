package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.application.DistrictResultList;

public class Model {
	
	public static Model model;
	private static ArrayList<DistrictResultList> results;
	private DistrictResultList cityResult;

	public static Model getInstance() {
		if(model == null) {
			model = new Model();
		}
		return model;
	}
	
	public Model() {
		results = new ArrayList<>();
	}
	
	public DistrictResultList getResultForDistrict(String name) {
		for(DistrictResultList d : results) {
			if(d.getName().equalsIgnoreCase(name))
				return d;
		}
		return null;
	}
	
	public DistrictResultList getResultForCity() {
		return cityResult;
	}

}
