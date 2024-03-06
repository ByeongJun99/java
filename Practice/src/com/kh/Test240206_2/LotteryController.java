package com.kh.Test240206_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LotteryController {
	private HashSet lottery = new HashSet();
	private HashSet win = new HashSet();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		boolean isRemove = lottery.remove(l);
		if (isRemove) {
			win.remove(l);
		}
		return isRemove;
	}
	
	public HashSet winObject() {
		if (lottery.size() < 4) {
			System.out.println("대상자가 부족합니다.");
			return null;
		}
		
		List<Lottery> list = new ArrayList<Lottery>(lottery);
		
		while(win.size() < 4) {
			int rand = (int) (Math.random() * list.size());
			win.add(list.get(rand));
		}
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject() {
		TreeSet<Lottery> sortedWinset = new TreeSet<>(new SortedLottery());
		sortedWinset.addAll(win);
		
		return sortedWinset;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
}
