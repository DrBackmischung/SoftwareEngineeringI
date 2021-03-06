package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import de.wwi2020seb.softwareengineering.gruppe7.application.VotingManager;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.AscendingResultComparator;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.DescendingResultComparator;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;

public class Controller {
	
	private Model model;
	private View view;
	private static Controller controller;
	public final int ASCENDING = 1;
	public final int DESCENDING = 2;
	
	private Controller() {
		model = Model.getInstance();
	}

	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public View getView() {
		return view;
	} 
	 
	public Model getModel() {
		return model;
	}
	
	public void startApplication() {
		view = new View(this);
	}
	
	public void openGUI() {
		view.setVisible(true);
	}
	
	public void loadData() {
		String district = view.getComboBoxContent();
		if(district != null && !model.loadDistrict(district)) { 
				view.printLog(("Distrikt "+district+" nicht gefunden."));
		};
	}
	
	public void printData() {
		ResultList r = model.getResultForDistrict();
		if(r != null)
			view.printResultOfDistrict(r);
		r = model.getResultForCity();
		if(r != null)
			view.printResultOfCity(model.getResultForCity());
	}
	
	public void convertLogMessageFromReader(int msgID) {
		switch (msgID) {
		case 1:
			view.printLog("Dateipfad konnte nicht gefunden werden!");
			break;
		case 2:
			view.printLog("Pfad konnte vom Programm nicht geoeffnet werden!");
			break;
		case 3:
			view.printLog("Im gewaehlten Dateipfad befinden sich keine Wahldaten!");
			break;
		case 4:
			view.printLog("Die Datei konnte nicht erstellt werden!");
			break;
		case 5:
			view.printLog("Der Datenreader ist fehlerhaft!");
			break;
		case 6:
			view.printLog("Datei konnte nicht erstellt werden!");
			break;
		}
	}
	
	public class ComboBoxListener implements ActionListener {
		
		public ComboBoxListener() { }

		@Override
		public void actionPerformed(ActionEvent e) {
			loadData();
			printData();
		}
	}
	
    public class LoadDataListener implements ActionListener {
	   
	   public LoadDataListener() { }

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);
			int rueckgabeWert = chooser.showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				view.printLog("Wahlverzeichnis geladen: '"+chooser.getSelectedFile().getName()+"'.");
				int i = VotingManager.getInstance().readData(chooser.getSelectedFile().getAbsolutePath());
				convertLogMessageFromReader(i);
				model.readData(VotingManager.getInstance().getData());
				view.loadComboBoxContent(model.getDistrictNames());
				if(i != 0) {
					view.clear();
				} else {
					loadData();
					printData();
				}
			}
		
		}
 
    }
	
	public class SortListener implements ActionListener {
		
		private int i;
		
		public SortListener(int i) { 
			this.i = i;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(i == ASCENDING) {
				view.switchComparator(new AscendingResultComparator());
			} else if(i == DESCENDING) {
					view.switchComparator(new DescendingResultComparator());
			} else {
				view.printLog("Sortierung nicht moeglich.");
			}
			printData();
		}
	}
	
	public class ExportListener implements ActionListener {
		
		public ExportListener() { }

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new java.io.File("."));
		    int retrival = chooser.showSaveDialog(null);
		    if (retrival == JFileChooser.APPROVE_OPTION) {
		    	int i = 0;
		    	if(chooser.getSelectedFile().toString().endsWith(".csv")) {
		    		i = VotingManager.getInstance().saveData(chooser.getSelectedFile().toString(), model.getResultForCity());
		    	} else {
		    		i = VotingManager.getInstance().saveData(chooser.getSelectedFile() + ".csv", model.getResultForCity());
		    	}
		    	view.printLog("Stadtergebnis exportiert!");
		    	convertLogMessageFromReader(i);
		    }
		}
	}

}
