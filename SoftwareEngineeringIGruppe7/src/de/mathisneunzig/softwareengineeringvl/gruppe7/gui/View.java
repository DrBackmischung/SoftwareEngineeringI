package de.mathisneunzig.softwareengineeringvl.gruppe7.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;

import de.mathisneunzig.softwareengineeringvl.gruppe7.Haltestelle;
import javax.swing.JTextField;

public class View extends JFrame {

	private static final long serialVersionUID = 4444206610305438106L;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					View frame = new View();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/** 
	 * Create the frame.
	 */
	JComboBox cb_from;
	JComboBox cb_to;
	JButton btn_calculate;
	
	private Controller controller = null;
	private JTextField textField;
	
	public View(Controller controller) throws HeadlessException {
		
		init();
		this.controller = controller;
	}
	
	private void init() {
		
		String[] stops = {"Sch�nau", "Sch�nauschule", "Sch�nau Siedlung", "Waldhof Nord", "Waldhof Bahnhof", "Luzenberg", "Unterm�hlaustra�e",
				"Herzogenriedstra�e", "Neuer Messplatz", "Carl-Benz-Stra�e", "Alte Feuerwache", "Abendakademie", "Marktplatz", "Paradeplatz", "Schloss",
				"Universit�t", "Hauptbahnhof", "Tattersall", "Kopernikusstra�e", "Krappm�hlstra�e", "Hochschule", "Lettestra�e", "Voltastra�e", "Neckarau Bahnhof", "Friedrichsstra�e",
				"Isarweg", "Dannstadter Stra�e", "Sandrain", "Rheinau Karlsplatz", "Neuhofer Stra�e", "Waldseestra�e", "Distelsand", "Rheinau Bahnhof", "Neckarstadt West",
				"B�rgermeister-Fuchs-Stra�e", "Neumarkt", "Kurpfalzbr�cke", "MVV-Hochhaus", "Dalbergstra�e", "Rheinstra�e", "Rathaus-rem", "Strohmarkt", "Wasserturm",
				"Rosengarten", "Nationaltheater", "Theresienkrankenhaus", "Universit�tsklinikum", "Bibienastra�e",
				"Hauptfriedhof", "Pfeiffersw�rth", "Neckarplatt", "Am Aubuckel", "Liebfrauenstra�e", "Bl�cherstra�e", "Feudenheim Kirche", "Neckarstra�e", "Feudenheim", 
				"Sandhofen", "Hanfstra�e", "B�rst�dter Stra�e", "Papyrus", "Zellstoff-Fabrik", "Roche", "Altrheinstra�e", "Stolberger Stra�e", "Kunsthalle",
				"Hauptbahnhof S�d", "Windeckstra�e", "Diesterwegschule", "Meer�ckerplatz", "Markuskirche", "Franz-Sigel-Stra�e", "Freiheitsplatz", "Neckarau West",
				"Tannh�userring", "Stollenw�rth", "Rheingoldhalle", "Franzosenweg", "Strandbad", "L�deritzstra�e", "Chiemseestra�e", "Frobeniusstra�e", "Gerhart-Hauptmann-Schule", "Fridtjof-Nansen-Weg"};
		
		cb_from = new JComboBox(stops);
		cb_to   = new JComboBox(stops); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 502);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 645, 441);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_header = new JLabel("Fahrplanauskunft");
		lbl_header.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_header.setBounds(10, 11, 161, 22);
		panel.add(lbl_header);
		
		cb_from.setBounds(90, 78, 135, 22);
		panel.add(cb_from);
		
		cb_to.setBounds(90, 111, 135, 22);
		panel.add(cb_to);
		
		JLabel lbl_from = new JLabel("From");
		lbl_from.setBounds(34, 82, 46, 14);
		panel.add(lbl_from);
		
		JLabel lbl_to = new JLabel("To");
		lbl_to.setBounds(34, 115, 46, 14);
		panel.add(lbl_to);
		
		JProgressBar pb_calculateConnection = new JProgressBar();
		pb_calculateConnection.setBounds(10, 416, 625, 14);
		panel.add(pb_calculateConnection);
		
		btn_calculate = new JButton("Search...");
		btn_calculate.setBounds(34, 144, 191, 23);
		panel.add(btn_calculate);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 249, 625, 41);
		panel.add(textField);
		textField.setColumns(10);
		
	}
	
	public Haltestelle getFrom() {
		String from = (String) cb_from.getSelectedItem();
		for(Haltestelle s : controller.getAllStops()) {
			if(s.getName().equals(from)) {
				return s;
			}
		}
		return null;
	}
	
	public Haltestelle getTo() {
		String to = (String) cb_to.getSelectedItem();
		for(Haltestelle s : controller.getAllStops()) {
			if(s.getName().equals(to)) {
				return s;
			}
		}
		return null;
	}
	
	public String getConnection() {
		return textField.getText();
	}
	
	public void setConnection(String connection) {
		textField.setText(connection);
	}
	
	public void addButtonListener(ActionListener e) {
		btn_calculate.addActionListener(e);
	}
	
}
