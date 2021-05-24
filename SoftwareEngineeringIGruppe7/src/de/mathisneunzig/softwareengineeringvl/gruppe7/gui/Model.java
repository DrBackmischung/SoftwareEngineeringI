package de.mathisneunzig.softwareengineeringvl.gruppe7.gui;

import java.util.ArrayList;

import de.mathisneunzig.softwareengineeringvl.gruppe7.Haltestelle;
import de.mathisneunzig.softwareengineeringvl.gruppe7.Linie;

public class Model {
    
    private Haltestelle main_station = new Haltestelle("Hauptbahnhof");
    private Haltestelle west_station = new Haltestelle("Westbahnhof");
    private Haltestelle east_station = new Haltestelle("Ostbahnhof");
    private Haltestelle market 		 = new Haltestelle("Markt");
    
    private Linie l301 = new Linie(301);
    private Linie l302 = new Linie(302);
	private ArrayList<Linie> lines = null;

    public Model() {
//        support = new PropertyChangeSupport(this);
    	
		lines = new ArrayList<>();
    	
        l301.addStop(main_station);
        l301.addStop(west_station);
        l301.addStop(market);
        lines.add(l301);
        
        l302.addStop(main_station);
        l302.addStop(east_station);
        lines.add(l302);
        
    }

//    // Observable Properties
//    private PropertyChangeSupport support;
//
//    private Message message;
//
//    public String getData(){
//
//        return message.getText();
//    }
//    
//    public boolean writeData(Message data)
//    {
//        support.firePropertyChange("message", message, data);
//        message = data;
//        return true;
//    }
//
//    public void addPropertyChangeListener(PropertyChangeListener pcl) {
//        support.addPropertyChangeListener(pcl);
//    }
//
//    public void removePropertyChangeListener(PropertyChangeListener pcl) {
//        support.removePropertyChangeListener(pcl);
//    }
    
    String connection;
    
    public void calculateConnection(Haltestelle from, Haltestelle to) {
    	connection = " >> ";
    	for(Linie l : lines) {
    		if(l.getStops().contains(from) && l.getStops().contains(to)) {
    			connection = l.getNumber()+": "+from.getName()+" -> "+to.getName();
    			break;
    		} else if(l.getStops().contains(from)){
    			for(Haltestelle s : l.getStops()) {
    				for(Linie l2 : lines) {
    					if(l2.getStops().contains(s)) {
    						if(l2.getStops().contains(to)) {
        						connection = l.getNumber()+": "+from.getName()+" -> "+s.getName() + " >> "+l2.getNumber()+": "+s.getName()+" -> "+to.getName();
//        						break;
        					} else {
//        						connection = "No Connection found.";
//        						break;
        					}
    					}
    				}
    			}
    		} else {

//				connection = "No Connection found.";
//				break;
				
    		}
    	}
    }
    
    public void resetConnection() {
    	connection = new String();
    }
    
    public String getConnection() {
    	return connection;
    }
    
    public ArrayList<Haltestelle> getAllStops() {
    	ArrayList<Haltestelle> stops = new ArrayList<>();
    	for(Linie l : lines) {
    		for(Haltestelle s : l.getStops()) {
    			if(!stops.contains(s)) {
    				stops.add(s);
    			}
    		}
    	}
    	return stops;
    }

}
