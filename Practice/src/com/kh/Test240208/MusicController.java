package com.kh.Test240208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	
	public List printAll() {
		return list;
	}
	
	public Music searchMusic(String title) {
		for (Music music : list) {
			if (music.getTitle().equals(title)) {
				return music;
			}
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		for (Music music : list) {
			if (music.getTitle().equals(title)) {
				list.remove(music);
			}
		}
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		for (Music music1 : list) {
			if (music1.getTitle().equals(title)) {
				music1.setTitle(music.getTitle());
				music1.setSinger(music.getSinger());
			}
		}
		return null;
	}
	
	public int ascTitle() {
		Collections.sort(list, (m1, m2) -> m1.getTitle().compareTo(m2.getTitle()));
		return 1;
	}
	
	public int descSinger() {
		Collections.sort(list, (m1, m2) -> m2.getSinger().compareTo(m1.getSinger()));
		return 1;
	}
}
