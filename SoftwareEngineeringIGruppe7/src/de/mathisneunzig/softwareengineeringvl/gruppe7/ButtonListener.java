package de.mathisneunzig.softwareengineeringvl.gruppe7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.mathisneunzig.softwareengineeringvl.gruppe7.gui.Model;
import de.mathisneunzig.softwareengineeringvl.gruppe7.gui.View;

public class ButtonListener implements ActionListener {

	private View v;
	private Model m;
	
	public ButtonListener(View v, Model m) {
		this.v = v;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Haltestelle from, to;
		from = v.getFrom();
		to = v.getTo();
		
		m.calculateConnection(from, to);
		String connection = m.getConnection();
		m.resetConnection();
		
		v.setConnection(connection);
		
	}

}
