package de.wwi2020seb.softwareengineering.gruppe7.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

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
		
		return AllResultLists;
		
				}

	public static void main(String[] args) {
		
//		File f = new File("C:\\Users\\marce\\Desktop\\Wahlen");
//		File fileArray[] = f.listFiles();
		File f = new File("C:\\Users\\Marcel\\Desktop\\Wahlen");
		File fileArray[] = f.listFiles();
		
		BufferedReader br;
		String line;
		String values[];
		ArrayList<ResultList> AllResultLists = new ArrayList<>();
		String districtName;

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
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator testIterator = AllResultLists.iterator();
		while(testIterator.hasNext()) {
			ResultList nextResultList = (ResultList)testIterator.next();
			System.out.println("Bezirk: " + nextResultList.getName());
			Set resultMaps = nextResultList.getResults();
			Iterator setIterator = resultMaps.iterator();
				while(setIterator.hasNext()) {
					ResultMap currentResultMap = (ResultMap)setIterator.next();
					System.out.println(currentResultMap.getName() + " hat " + currentResultMap.getVoteCount() + " Stimmen.");
				}
		}
		

	}
}
