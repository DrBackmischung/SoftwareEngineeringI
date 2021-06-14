package de.wwi2020seb.softwareengineering.gruppe7.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

public class CSVReader {
	
	private BufferedReader br;
	private String line;
	private String values[];
	private ArrayList<ResultList> allResultLists;
	private String districtName; 
	private File f;
	private File fileArray[];
	private static CSVReader r;
	
	public CSVReader() {
		
	}
	
	public static CSVReader getInstance() {
		if(r == null) {
			r = new CSVReader();
		}
		return r;
	}
	
	public int readData(String dataPath) {
		
		f = new File(dataPath);
		fileArray = f.listFiles();

		allResultLists = new ArrayList<>();
		try {
			for(File path : fileArray) {
				
				if(path.getName().endsWith(".csv")) {
					values = path.getName().split(".csv");
					districtName = values[0];
					ResultList currentDistrict = new ResultList(districtName);
					br = new BufferedReader(new FileReader(path));
					while( (line = br.readLine()) != null) {
						values    = line.split(";");
					    ResultMap currentResultMap = new ResultMap(values[0], Integer.parseInt(values[1]));
					    currentDistrict.addResult(currentResultMap);
					}
				
					allResultLists.add(currentDistrict);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(1);
			return 1;
		}  catch (IOException e) {
			System.out.println(2);
			return 2;
		} finally {
			try {
				br.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		    catch(Exception e) {
	
			}
		}
		
		if(allResultLists.size() == 0) {
			System.out.println(3);
			return 3;
		}
		
		return 0;
		
	}
	
	public ArrayList<ResultList> getData() {
		
		return allResultLists;
		
	}

}
