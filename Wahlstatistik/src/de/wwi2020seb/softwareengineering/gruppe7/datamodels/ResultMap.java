package de.wwi2020seb.softwareengineering.gruppe7.datamodels;

public class ResultMap {
	
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
	
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		if(this.getName().equals(((ResultMap) o).getName()))
			return false;
		if(this.getVoteCount() == ((ResultMap) o).getVoteCount())
			return false;
		if(this.getPercentage()== ((ResultMap) o).getPercentage())
			return false;
		return true;
	}
	
	public int hashCode() {
		return this.getName().hashCode() ^ this.getVoteCount() ^ (int) this.getPercentage();
	}
	
}
