package de.wwi2020seb.softwareengineering.gruppe7.datamodels;

import java.util.Comparator;

public class AscendingResultComparator implements Comparator<ResultMap> {

	@Override
	public int compare(ResultMap o1, ResultMap o2) {
		if(o1.getVoteCount() - o2.getVoteCount() != 0) {
			return o1.getVoteCount() - o2.getVoteCount();
		} else if(o2.getName().compareTo(o1.getName()) != 0) {
			return o2.getName().compareTo(o1.getName());
		}
		return 0;
	}

}
