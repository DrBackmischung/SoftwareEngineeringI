package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.wwi2020seb.softwareengineering.gruppe7.application.VotingManager;

public class Controller {
	
	private Model model;
	private View view;
	private static Controller controller;
	
	private Controller() {
		model = Model.getInstance();
		/*
		 * Aus dem Reader kommt eine ArrayList vom Typ ResultList zurueck
		 */
		model.readData(VotingManager.getData());
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
		loadData();
		model.calculateCityResult();
	}
	
	public void loadData() {
		String district = view.getComboBoxContent();
		if(!model.loadDistrict(district)) {
			/*
			 * Exception
			 */
		};
	}
	
	public void printData() {
		view.printResultOfCity(model.getResultForCity());
		view.printResultOfDistrict(model.getResultForDistrict());
	}
	
	public void openGUI() {
		printData();
		view.setVisible(true);
	}
	
	public View getView() {
		return view;
	}
	 
	public Model getModel() {
		return model;
	}
	
	public class ComboBoxListener implements ActionListener {
		
		public ComboBoxListener() { }

		@Override
		public void actionPerformed(ActionEvent e) {
			loadData();
			printData();
		}

	}

}
