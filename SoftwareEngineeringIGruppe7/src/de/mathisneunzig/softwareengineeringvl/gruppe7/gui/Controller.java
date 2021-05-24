package de.mathisneunzig.softwareengineeringvl.gruppe7.gui;

import java.util.ArrayList;

import de.mathisneunzig.softwareengineeringvl.gruppe7.ButtonListener;
import de.mathisneunzig.softwareengineeringvl.gruppe7.Haltestelle;
import de.mathisneunzig.softwareengineeringvl.gruppe7.applicationservices.Server;

public class Controller {
	private boolean receiving = false;
	private Server server;
	private Model model;
	private View view;
	private MessageListener listener;

	public Controller() {
		model = new Model();
	}

	public void startApplication() {
		view = new View(this);
		view.setVisible(true);
		listener = new MessageListener(this);
		view.addButtonListener(new ButtonListener(view, model));
	}
	
	public String[] getAllStopNames() {
		String[] stops = new String[model.getAllStops().size()];
		for(int i = 0; i<stops.length; i++) {
			stops[i] = model.getAllStops().get(i).getName();
		}
		return stops;
	}
	
	public ArrayList<Haltestelle> getAllStops() {
		return model.getAllStops();
	}
	
	public View getView() {
		return view;
	}
	
	public Model getModel() {
		return model;
	}

//	public void receiveMessage() {
//		receiving = true;
//		try {
//			server = new Server();
//			model.addPropertyChangeListener(listener);
//			model.writeData(server.getMessage());
//			receiving = false;
//			model.removePropertyChangeListener(listener);
//		} catch (Exception er) {
//			receiving = false;
//		}
//	}
//
//	public boolean sendMessage(String message) {
//		try {
//			if (!receiving) {
//				Client client = new Client();
//				client.send(43, 62, message);
//			} else {
//				return false;
//			}
//
//			return true;
//
//		} catch (Exception er) {
//			return false;
//		}
//	}
//
//	public void setViewLabel(String text) {
//		view.setMyLabel(text);
//	}

}
