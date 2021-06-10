package de.wwi2020seb.softwareengineering.gruppe7.application;

import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.data.JSONConverter;
import de.wwi2020seb.softwareengineering.gruppe7.datamodels.ResultList;

public class VotingManager {

	public static ArrayList<ResultList> getData() {
		ArrayList<ResultList> results = JSONConverter.getData();
		return results;
	}
	
}
