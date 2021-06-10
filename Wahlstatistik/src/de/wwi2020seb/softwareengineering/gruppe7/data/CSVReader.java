package de.wwi2020seb.softwareengineering.gruppe7.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVReader {

	public static void main(String[] args) {
		
		BufferedReader br; 
		String paths[] = new String[2];
		String line;
		String values[];
//		ArrayList<String> personenList = new ArrayList<>();
		
//Alle CSV Dateien eintragen. Bessere Lösung?
		paths[0]  = "C:\\Users\\marce\\Desktop\\Niederfeld.csv";
		paths[1]  = "C:\\Users\\marce\\Desktop\\Jungbusch.csv";

		try {
			for(String path : paths) {
				
				br = new BufferedReader(new FileReader(path));
				while( (line = br.readLine()) != null) {
					values = line.split(";");
//					personenList.add(values[0]);
					System.out.println(values[0] + " hat " + values[1] + " Stimmen");
				}
			
//			Iterator personenIterator = personenList.iterator();
//			while(personenIterator.hasNext()) {
//				String person = (String) personenIterator.next();
//				System.out.println(person);
//			}
			System.out.println("Finish");
//			personenList = new ArrayList<>();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}

	}
}
