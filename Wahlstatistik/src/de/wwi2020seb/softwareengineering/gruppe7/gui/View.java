package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.Label;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultComparator;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

public class View extends JFrame {
	
	private static final long serialVersionUID = -7882604954697153551L;
	@SuppressWarnings("unused")
	private Controller c;
	private JComboBox<String> districtComboBox;
	private List cityResultList;
	private List districtResultList;
	
	public View(Controller c) {
		
		this.c = c;
		
		this.setTitle("Wahlstatistik");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 322);
		getContentPane().setLayout(null);
		
		cityResultList = new List();
		cityResultList.setBounds(10, 50, 220, 225);
		getContentPane().add(cityResultList);
		
		districtResultList = new List();
		districtResultList.setBounds(241, 77, 220, 194);
		getContentPane().add(districtResultList);
		
		districtComboBox = new JComboBox<>();
		districtComboBox.setBounds(241, 50, 218, 21);
		districtComboBox.addActionListener(c.new ComboBoxListener());
		getContentPane().add(districtComboBox);
		
		Label cityLabel = new Label("Gesamt");
		cityLabel.setBounds(10, 23, 59, 21);
		getContentPane().add(cityLabel);
		
		Label districtLabel = new Label("Bezirke");
		districtLabel.setBounds(241, 23, 59, 21);
		getContentPane().add(districtLabel);
		
	} 
	
	public void printResultOfDistrict(ResultList r) {
		r.getResults().sort(new ResultComparator());
		districtResultList.removeAll();
		for(ResultMap m : r.getResults()) {
			districtResultList.add(m.toString());
		}
	}
	
	public void printResultOfCity(ResultList r) {
		cityResultList.removeAll();
		r.getResults().sort(new ResultComparator());
		for(ResultMap m : r.getResults()) {
			cityResultList.add(m.toString());
		}
	}
	
	public void loadComboBoxContent(ArrayList<String> names) {
		districtComboBox.removeAllItems();
		for(String s : names) {
			districtComboBox.addItem(s);
		}
	}

	public String getComboBoxContent() {
		return (String) districtComboBox.getSelectedItem();
	}
	
}
