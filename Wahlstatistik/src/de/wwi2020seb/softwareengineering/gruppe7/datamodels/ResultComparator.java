package de.wwi2020seb.softwareengineering.gruppe7.datamodels;

import java.util.Comparator;

public class ResultComparator implements Comparator<ResultMap> {

	@Override
	public int compare(ResultMap o1, ResultMap o2) {
		System.out.println(o1.getName()+" - "+o1.getVoteCount()+" vs. "+o2.getName()+" - "+o2.getVoteCount());
		if(o1.getVoteCount() - o2.getVoteCount() != 0) {
			System.out.println("Votes"+(o1.getVoteCount() - o2.getVoteCount()));
			return o2.getVoteCount() - o1.getVoteCount();
		} else if(o1.getName().compareTo(o2.getName()) != 0) {
			System.out.println("Name: "+o1.getName().compareTo(o2.getName()));
			return o1.getName().compareTo(o2.getName());
		}
		return 0;
	}

}
