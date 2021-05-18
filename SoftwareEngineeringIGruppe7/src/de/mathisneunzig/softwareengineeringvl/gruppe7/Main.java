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

	    JButton btn1 = new JButton("Full-Screen");
	    JButton btn2 = new JButton("Normal");

	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    panel.add(btn1);
	    panel.add(btn2);
	    frame.add(panel); 

//	    frame.pack();
	    frame.setVisible(true);
		
	}
	
	public int addNumber(int a, int b) {
		return a+b;
	}

}
