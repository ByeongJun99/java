package com.kh.Test240214_3;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
	public void output() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("test.txt");
			fw.write(97);
			fw.write(65);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}