package de.wwi2020seb.softwareengineering.gruppe7.data;

import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultMap;

public class JSONConverter {

	public static ArrayList<ResultList> getData() {
		ArrayList<ResultList> results = new ArrayList<>();
		ResultList rl1 = new ResultList("Jungbusch");
		rl1.addResult(new ResultMap("Mathis Neunzig", 99));
		rl1.addResult(new ResultMap("Prof. Dr. Armin Wiedemann", 1));
		ResultList rl2 = new ResultList("Neustadt a. d. Weinstrasse");
		rl2.addResult(new ResultMap("Mathis Neunzig", 8));
		rl2.addResult(new ResultMap("Prof. Dr. Armin Wiedemann", 92));
		results.add(rl1);
		results.add(rl2);
		return results;
	}
	
}
