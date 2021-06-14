package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import de.wwi2020seb.softwareengineering.gruppe7.application.VotingManager;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;

public class Controller {
	
	private Model model;
	private View view;
	private static Controller controller;
	
	private Controller() {
		model = Model.getInstance();
		model.readData(VotingManager.getInstance().getData(""));
	}

	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public void startApplication() {
		view = new View(this);
	}
	
	public void loadData() {
		String district = view.getComboBoxContent();
		if(!model.loadDistrict(district)) {
			System.out.println("Distrikt "+district+" nicht gefunden.");
		};
	}
	
	public void printData() {
		ResultList r = model.getResultForDistrict();
		if(r != null) {
			view.printResultOfDistrict(model.getResultForDistrict());
		}
		view.printResultOfCity(model.getResultForCity());
	}
	
	public void openGUI() {
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
	
   public class LoadDataListener implements ActionListener{
	   
	   public LoadDataListener() { }

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		int rueckgabeWert = chooser.showOpenDialog(null);
		 if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
			 model.readData(VotingManager.getInstance().getData(chooser.getSelectedFile().getAbsolutePath()));
			 view.loadComboBoxContent(model.getDistrictNames());
			 loadData();
			 printData();
			 }
		
	}

		   
 }

}
