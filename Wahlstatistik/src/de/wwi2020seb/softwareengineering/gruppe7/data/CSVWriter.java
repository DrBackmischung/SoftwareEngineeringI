package de.wwi2020seb.softwareengineering.gruppe7.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

public class CSVWriter {
	
	private static CSVWriter r;
	
	public CSVWriter() {
		
	}
	
	public static CSVWriter getInstance() {
		if(r == null) {
			r = new CSVWriter();
		}
		return r;
	}
	
	public int saveData(String path, ResultList r) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		File f = new File(path);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				return 6;
			}
		}
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            for(ResultMap m : r.getResults()) {
            	bw.write(m.getName()+";"+m.getVoteCount()+";"+m.getPercentage()+"%");
            	bw.newLine();
            }
            bw.flush();
        } catch (Exception ex) {
            return 4;
        } finally {
        	try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				return 5;
			}
        }
		return 0;
	}

}
