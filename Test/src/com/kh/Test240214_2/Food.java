package com.kh.Test240214_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Food {
	private String name;
	private int kcal;
	
	public Food() {
		super();
	}

	public Food(String name, int kcal) {
		super();
		this.name = name;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	@Override
	public String toString() {
		return name + " : " + kcal + "kcal";
	}
	
	public void fileSave(String fileName) {
		try {
			FileOutputStream fs = null;
			
			fs = new FileOutputStream(fileName);
			
			ObjectOutputStream os = new ObjectOutputStream(fs);
            
			Food food = new Food("사과", 20);
			os.writeObject(food);
            
			os.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
