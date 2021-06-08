package de.wwi2020seb.softwareengineering.gruppe7.gui;

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

}
