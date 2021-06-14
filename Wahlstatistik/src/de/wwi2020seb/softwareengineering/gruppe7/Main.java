package de.wwi2020seb.softwareengineering.gruppe7;

import javax.swing.JFileChooser;

import de.wwi2020seb.softwareengineering.gruppe7.gui.Controller;

public class Main {
	
	public static void main(String[] args) {
		
		Controller c = Controller.getInstance();
		c.startApplication();
		c.openGUI();
		
	}

}
