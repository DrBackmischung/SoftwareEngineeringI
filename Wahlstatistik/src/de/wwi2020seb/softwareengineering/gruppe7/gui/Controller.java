package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	private Model model;
	private View view;
	private static Controller controller;
	
	private Controller() {
		model = Model.getInstance();
	}

	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public void startApplication() {
		view = new View(this);
		prepareData(); 
	}
	
	public void prepareData() {
		String district = view.getComboBoxContent();
		if(!model.loadDistrict(district)) {
			/*
			 * Exception
			 */
		};
		model.calculateCityResult();
	}
	
	public void openGUI() {
		view.printResultOfCity(model.getResultForCity());
		view.printResultOfDistrict(model.getResultForDistrict());
		view.setVisible(true);
	}
	
	public View getView() {
		return view;
	}
	 
	public Model getModel() {
		return model;
	}
	
	class ComboBoxListener implements ActionListener {

		private View v;
		private Model m;
		
		public ComboBoxListener(View v, Model m) {
			this.v = v;
			this.m = m;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}

	}

}
