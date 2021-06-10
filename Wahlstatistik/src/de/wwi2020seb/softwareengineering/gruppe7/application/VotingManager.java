package de.wwi2020seb.softwareengineering.gruppe7.application;

import java.util.ArrayList;

import de.wwi2020seb.softwareengineering.gruppe7.data.JSONConverter;

public class VotingManager {

	public static ArrayList<ResultList> getData() {
		return JSONConverter.getData();
	}
	
}
