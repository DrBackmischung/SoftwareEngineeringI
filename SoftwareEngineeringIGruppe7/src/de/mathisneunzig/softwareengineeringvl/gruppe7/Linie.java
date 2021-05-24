package de.mathisneunzig.softwareengineeringvl.gruppe7;

import java.util.ArrayList;

public class Linie {
	
	private int number = 0;
	private ArrayList<Haltestelle> stops = null;
	
	public Linie(int number) {
		this.number = number;
		stops = new ArrayList<>();
	}
	
	public int getNumber() {
		return number;
	}
	
	public void addStop(Haltestelle stop) {
		if(!stops.contains(stop))
			stops.add(stop);
	}
	
	public void removeStop(Haltestelle stop) {
		if(stops.contains(stop))
			stops.remove(stop);
	}
	
	public ArrayList<Haltestelle> getStops() {
		return stops;
	}

}
