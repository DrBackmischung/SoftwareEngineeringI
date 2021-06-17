package de.wwi2020seb.softwareengineering.gruppe7.datamodels;

import java.util.Comparator;

public class DescendingResultComparator implements Comparator<ResultMap> {

	@Override
	public int compare(ResultMap o1, ResultMap o2) {
		if(o1.getVoteCount() - o2.getVoteCount() != 0) {
			return o2.getVoteCount() - o1.getVoteCount();
		} else if(o1.getName().compareTo(o2.getName()) != 0) {
			return o1.getName().compareTo(o2.getName());
		}
		return 0;
	}

}
