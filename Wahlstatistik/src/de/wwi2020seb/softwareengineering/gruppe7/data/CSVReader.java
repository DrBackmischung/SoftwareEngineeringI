package de.wwi2020seb.softwareengineering.gruppe7.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\marce\\Desktop\\Mappe1.csv";
		
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while( (line = br.readLine()) != null) {
				String[] values = line.split(";");
				System.out.println(values[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}

	}
}
