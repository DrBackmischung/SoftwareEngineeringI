package de.wwi2020seb.softwareengineering.gruppe7.datamodels;

public class ResultMap 
//implements Comparable 
{
	
	private String name;
	private int votes;
	private double percentage;
	
	public ResultMap(String name, int votes) {
		this.name = name;
		this.votes = votes;
		percentage = 0.0;
	}
	
	public String toString() {
		return name+"\t"+ "- "+votes+" Stimmen ("+percentage+"%)";
	}

	public String getName() {
		return name;
	}
	
	public int getVoteCount() {
		return votes;
	}
	
	public void addVotes(int i) {
		votes += i;
	}
	
	public void setPercentage(double p) {
		this.percentage = p;
	}
	
	public double getPercentage() {
		return percentage;
	}

	/*
	 * Automatische Sortierung nach Stimmenanzahl
	 */
//	@Override
//	public int compareTo(Object o) {
//		return this.getVoteCount() - ((ResultMap) o).getVoteCount();
//	}
	
}
