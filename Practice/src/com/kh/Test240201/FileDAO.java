package com.kh.Test240201;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {
	public boolean checkName(String file) {
		File f = new File(file);
		return f.exists();
	}
	
	public void fileSave(String file, String s) {
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * StringBuilder : 효율적으로 문자열을 처리하기 위한 클래스로 다양한 기능의 메소드를 제공한다.
	 * append(), insert(), delete(), replace()....
	 */
	public StringBuilder fileOpen(String file) {
		StringBuilder sb = new StringBuilder();
		
		try(FileReader fr = new FileReader(file)) {
			int value = 0;
			while((value = fr.read()) != -1) {
				sb.append((char)value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb;
	}
	
	public void fileEdit(String file, String s) {
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(s);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
