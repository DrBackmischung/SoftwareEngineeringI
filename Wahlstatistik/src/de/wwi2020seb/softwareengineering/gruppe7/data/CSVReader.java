package de.wwi2020seb.softwareengineering.gruppe7.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.application.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.application.ResultMap;

public class CSVReader {
	
	private BufferedReader br;
	private String line;
	private String values[];
	private ArrayList<ResultList> AllResultLists;
	private String districtName;
	private File f;
	private File fileArray[];
	
	public ArrayList<ResultList> getData() {
		
//		f = new File("C:\\Users\\marce\\Desktop\\Wahlen");
//		fileArray[] = f.listFiles();
		f = new File("C:\\Users\\Marcel\\Desktop\\Wahlen");
		fileArray = f.listFiles();
		
		
		AllResultLists = new ArrayList<>();
		try {
			for(File path : fileArray) {
				values 		 = path.getName().split(".csv");
				districtName = values[0];
				ResultList currentDistrict = new ResultList(districtName);
				br = new BufferedReader(new FileReader(path));
				
				while( (line = br.readLine()) != null) {
					values    = line.split(";");
				    ResultMap currentResultMap = new ResultMap(values[0], Integer.parseInt(values[1]));
				    currentDistrict.addResult(currentResultMap);
				}
			
				AllResultLists.add(currentDistrict);
				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Dateipfad nicht gefunden. Bitte wählen sie einen gültigen aus");
		}  catch (IOException e) {
			e.printStackTrace();
			System.out.println("Probleme beim lesen der Datei. Stellen sie sicher, dass nur CSV Dateien gelesen werden");
		}
			finally {
				try {
					br.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		
		return AllResultLists;
		
				}

}
