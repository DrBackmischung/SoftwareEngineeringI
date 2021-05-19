package de.mathisneunzig.softwareengineeringvl.gruppe7;

import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Aufgabe 7");
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setUndecorated(false);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    frame.add(panel); 

//	    frame.pack();
	    frame.setVisible(true);
		 
	}
	
	public int closeOperation() {
		return WindowConstants.EXIT_ON_CLOSE;
	}
	
	public int extendedState() {
		return JFrame.MAXIMIZED_BOTH;
	}

}
