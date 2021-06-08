package de.wwi2020seb.softwareengineering.gruppe7.gui;

public class Model {
	
	public static Model model;

	public static Model getInstance() {
		if(model == null) {
			model = new Model();
		}
		return model;
	}

}
