package de.wwi2020seb.softwareengineering.gruppe7.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;

public class View extends JFrame {

	private static final long serialVersionUID = -7140986200488666516L;
	private JPanel contentPane;
	JComboBox<String> comboBox;

	public View(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(6, 41, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(179, 77, 140, 22);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * auslagern
				 */
			}
		});
	}
	
	public void printResultOfDistrict() {
		
	}
	
	public void printResultOfCity() {
		
	}
}
