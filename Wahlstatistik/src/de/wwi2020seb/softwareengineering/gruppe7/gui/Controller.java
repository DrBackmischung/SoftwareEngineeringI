package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.application.VotingManager;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

public class Controller {
	
	private Model model;
	private View view;
	private static Controller controller;
	
	private Controller() {
		model = Model.getInstance();
		/*
		 * Aus dem Reader kommt eine ArrayList vom Typ ResultList zurueck
		 */
		model.readData(VotingManager.getInstance().getData());
	}

	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public void startApplication() {
		view = new View(this);
		loadData();
	}
	
	public void loadData() {
//		String district = view.getComboBoxContent();
		String district = "Jungbusch";
		if(!model.loadDistrict(district)) {
			System.out.println("Distrikt "+district+" nicht gefunden.");
		};
	}
	
	public void printData() {
		ResultList r = model.getResultForDistrict();
		System.out.println("Distrikt: "+r.getName());
		for(ResultMap m : r.getResults()) {
			System.out.println(m.getName()+" hat "+m.getVoteCount()+" ("+m.getPercentage()+") Stimmen");
		}
		ResultList r2 = model.getResultForCity();
		System.out.println("Gesamt: "+r2.getName());
		for(ResultMap m : r2.getResults()) {
			System.out.println(m.getName()+" hat "+m.getVoteCount()+" ("+m.getPercentage()+") Stimmen");
		}
//		view.printResultOfCity(model.getResultForCity());
//		view.printResultOfDistrict(model.getResultForDistrict());
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
