package de.mathisneunzig.softwareengineeringvl.gruppe7.gui;

import java.util.ArrayList;

import de.mathisneunzig.softwareengineeringvl.gruppe7.Haltestelle;
import de.mathisneunzig.softwareengineeringvl.gruppe7.Linie;

public class Model {
	
	String[] sl1 = {"Schˆnau", "Schˆnauschule", "Schˆnau Siedlung", "Waldhof Nord", "Waldhof Bahnhof", "Luzenberg", "Unterm¸hlaustraﬂe", "Herzogenriedstraﬂe", "Neuer Messplatz", "Carl-Benz-Straﬂe", "Alte Feuerwache", "Abendakademie", "Marktplatz", "Paradeplatz", "Schloss", "Universit‰t", "Hauptbahnhof", "Tattersall", "Kopernikusstraﬂe", "Krappm¸hlstraﬂe", "Hochschule", "Lettestraﬂe", "Voltastraﬂe", "Neckarau Bahnhof", "Friedrichsstraﬂe", "Isarweg", "Dannstadter Straﬂe", "Sandrain", "Rheinau Karlsplatz", "Neuhofer Straﬂe", "Waldseestraﬂe", "Distelsand", "Rheinau Bahnhof"};
    String[] sl2 = {"Neckarstadt West", "B¸rgermeister-Fuchs-Straﬂe", "Neumarkt", "Alte Feuerwache", "Kurpfalzbr¸cke", "MVV-Hochhaus", "Dalbergstraﬂe", "Rheinstraﬂe", "Rathaus-rem", "Paradeplatz", "Strohmarkt", "Wasserturm", "Rosengarten", "Nationaltheater", "Theresienkrankenhaus", "Universit‰tsklinikum", "Bibienastraﬂe", "Hauptfriedhof", "Pfeifferswˆrth", "Neckarplatt", "Am Aubuckel", "Liebfrauenstraﬂe", "Bl¸cherstraﬂe", "Feudenheim Kirche", "Neckarstraﬂe", "Feudenheim"};
	String[] sl3 = {"Sandhofen", "Hanfstraﬂe", "B¸rst‰dter Straﬂe", "Papyrus", "Zellstoff-Fabrik", "Roche", "Altrheinstraﬂe", "Stolberger Straﬂe", "Luzenberg", "Unterm¸hlaustraﬂe", "Herzogenriedstraﬂe", "Neuer Messplatz", "Carl-Benz-Straﬂe", "Alte Feuerwache", "Abendakademie", "Marktplatz", "Paradeplatz", "Strohmarkt", "Wasserturm", "Kunsthalle", "Hauptbahnhof", "Hauptbahnhof S¸d", "Windeckstraﬂe", "Diesterwegschule", "Meer‰ckerplatz", "Markuskirche", "Franz-Sigel-Straﬂe", "Freiheitsplatz", "Neckarau West", "Tannh‰userring", "Stollenwˆrth", "Rheingoldhalle"};
    String[] sl49 = {"Rheingoldhalle", "Franzosenweg", "Strandbad"};
    String[] sl47 = {"Rheinau Bahnhof", "L¸deritzstraﬂe", "Chiemseestraﬂe", "Frobeniusstraﬂe", "Gerhart-Hauptmann-Schule", "Fridtjof-Nansen-Weg"};
	
	
//    private Haltestelle main_station = new Haltestelle("Hauptbahnhof");
//    private Haltestelle west_station = new Haltestelle("Westbahnhof");
//    private Haltestelle east_station = new Haltestelle("Ostbahnhof");
//    private Haltestelle market 		 = new Haltestelle("Markt");
    
//    private Linie l301 = new Linie(301);
//    private Linie l302 = new Linie(302);
    
    Linie l1 = new Linie(1);
    Linie l2 = new Linie(2);
    Linie l3 = new Linie(3);
    Linie l49 = new Linie(49);
    Linie l47 = new Linie(47);
	private ArrayList<Linie> lines = null;

    public Model() {
//        support = new PropertyChangeSupport(this);
    	
		lines = new ArrayList<>();
		
		boolean contains = false;
		
		for(String s1 : sl1) {
			contains = false;
			for(Haltestelle h : getAllStops()) {
				if(h.getName().equalsIgnoreCase(s1)) {
					l1.addStop(h);
					contains = true;
				}
			}
			if(!contains) {
				l1.addStop(new Haltestelle(s1));
			}
		}
		
		lines.add(l1);
		
		for(String s2 : sl2) {
			contains = false;
			for(Haltestelle h : getAllStops()) {
				if(h.getName().equalsIgnoreCase(s2)) {
					l2.addStop(h);
					contains = true;
				}
			}
			if(!contains) {
				l2.addStop(new Haltestelle(s2));
			}
		}
		
		lines.add(l2);
		
		for(String s3 : sl3) {
			contains = false;
			for(Haltestelle h : getAllStops()) {
				if(h.getName().equalsIgnoreCase(s3)) {
					l3.addStop(h);
					contains = true;
				}
			}
			if(!contains) {
				l3.addStop(new Haltestelle(s3));
			}
		}
		
		lines.add(l3);
		
		for(String s49 : sl49) {
			contains = false;
			for(Haltestelle h : getAllStops()) {
				if(h.getName().equalsIgnoreCase(s49)) {
					contains = true;
					l49.addStop(h);
				}
			}
			if(!contains) {
				l49.addStop(new Haltestelle(s49));
			}
		}
		
		lines.add(l49);
		
		for(String s47 : sl47) {
			contains = false;
			for(Haltestelle h : getAllStops()) {
				if(h.getName().equalsIgnoreCase(s47)) {
					contains = true;
					l47.addStop(h);
				}
			}
			if(!contains) {
				l47.addStop(new Haltestelle(s47));
			}
		}
		
		lines.add(l47);
		
		for(Linie l : lines) {
			System.out.println(l.getNumber());
			for(Haltestelle h : l.getStops()) {
				System.out.println(h.getName());
			}
		} 
    	
//        l301.addStop(main_station);
//        l301.addStop(west_station);
//        l301.addStop(market);
//        lines.add(l301);
//        
//        l302.addStop(main_station);
//        l302.addStop(east_station);
//        lines.add(l302);
        
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
//        support.firePropertyChange("message",  message,  data);
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
    
    ArrayList<String> connections = new ArrayList<>();
     
    public void calculateConnection(Haltestelle from,  Haltestelle to) {
    	for(Linie l : lines) {
    		System.out.println("Currently: "+l.getNumber());
    		if(l.getStops().contains(from) && l.getStops().contains(to)) {
    			connection = l.getNumber()+": "+from.getName()+" -> "+to.getName();
    			connections.add(connection);
    			System.out.println("No change required.");
//    			return;
    		} else if(l.getStops().contains(from)){
    			for(Haltestelle s : l.getStops()) {
    	    		System.out.println("Currently: "+s.getName());
    				for(Linie l2 : lines) {
        	    		System.out.println("Currently: "+l2.getNumber());
    					if(l2.getStops().contains(s) && l2.getStops().contains(to)) {
    							System.out.println("There is a match. Line "+l2.getNumber()+" stops at interchange station "+s.getName()+" and you can transfer to Line "+l2.getNumber()+" here.");
        						connection = l.getNumber()+": "+from.getName()+" -> "+s.getName() + " >> "+l2.getNumber()+": "+s.getName()+" -> "+to.getName();
        		    			connections.add(connection);
//        						return;
    					} else if(l2.getStops().contains(s)) {
    						for(Haltestelle s3 : l.getStops()) {
    		    				for(Linie l3 : lines) {
    		    					if(l3.getStops().contains(s3) && l3.getStops().contains(to)) {
    		        						connection = l.getNumber()+": "+from.getName()+" -> "+s.getName() + " >> "+l2.getNumber()+": "+s.getName()+" -> "+s3.getName() + " >> "+l3.getNumber()+": "+s3.getName()+" -> "+to.getName();
    		        		    			connections.add(connection);
    		        		    			if(!(l.getNumber() == l2.getNumber())) {
//    		        							return;
    		        						}
    		    					} else if(l3.getStops().contains(s)) {
    		    						
    		    					}
    		    				}
    		    			}
    					}
    				}
    			}
    		} else {

//				connection = "No Connection found.";
//				break;
				
    		}
    	}
    	
    	for(String s : connections) {
    		System.out.println(connection);
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
