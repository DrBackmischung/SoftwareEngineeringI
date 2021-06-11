package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Label;

public class View extends JFrame {
	public View() {
		this.setTitle("Wahlstatistik");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 322);
		getContentPane().setLayout(null);
		
		List cityResultList = new List();
		cityResultList.setBounds(10, 50, 130, 225);
		getContentPane().add(cityResultList);
		
		List districtResultList = new List();
		districtResultList.setBounds(331, 81, 130, 194);
		getContentPane().add(districtResultList);
		
		String[] testBezirke = {"Bezirk 1","Bezirk 2"};
		
		JComboBox districtComboBox = new JComboBox(testBezirke);
		districtComboBox.setBounds(331, 50, 130, 21);
		getContentPane().add(districtComboBox);
		
		Label cityLabel = new Label("Gesamt");
		cityLabel.setBounds(10, 23, 59, 21);
		getContentPane().add(cityLabel);
		
		Label districtLabel = new Label("Bezirke");
		districtLabel.setBounds(331, 23, 59, 21);
		getContentPane().add(districtLabel);
		
	}

	
/*
	private static final long serialVersionUID = -7140986200488666516L;
	private JPanel contentPane;
	JComboBox<String> comboBox;

	public View(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ascendingButton = new JButton("aufsteigend");
		ascendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ascendingButton.setBounds(181, 41, 89, 23);
		contentPane.add(ascendingButton);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(321, 41, 140, 22);
		contentPane.add(comboBox);
		
		JButton descendingButton = new JButton("absteigend");
		descendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		descendingButton.setBounds(181, 70, 89, 21);
		contentPane.add(descendingButton);
		
		JTextPane cityResultTextPane = new JTextPane();
		cityResultTextPane.setBounds(10, 41, 123, 218);
		contentPane.add(cityResultTextPane);
		
		JButton refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		refreshButton.setBounds(181, 114, 89, 21);
		contentPane.add(refreshButton);
		
		JScrollBar scrollBar = new JScrollBar();
		cityResultTextPane.add(scrollBar);
		scrollBar.setBounds(116, 41, 17, 218);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(292, 114, 123, 128);
		contentPane.add(scrollPane);
		
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 // auslagern
				
			}
		});
	}
*/	
	
	
	public void printResultOfDistrict() {
		
	}
	
	public void printResultOfCity() {
		
	}
}
