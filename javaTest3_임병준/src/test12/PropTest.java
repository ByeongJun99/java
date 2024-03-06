package test12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class PropTest {

	public static void main(String[] args) {

		Properties prop = new Properties();
		
		prop.setProperty("1", "apple,1200,3");
		prop.setProperty("2", "banana,2500,2");
		prop.setProperty("3", "grape,4500,5");
		prop.setProperty("4", "orange,800,10");
		prop.setProperty("5", "melon,5000,2");
		
		fileSave(prop);
		
		fileOpen(prop);
		
	}
	
	public static void fileSave(Properties p) {
		try {
			FileWriter fw = new FileWriter("data.xml");
			fw.write(p.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileOpen(Properties p) {
		try {
			Set<String> sortedP = new TreeSet<>(p.stringPropertyNames());
			
			FileReader fr = new FileReader("data.xml");
			Fruit[] f = new Fruit[5];
			int value = 0;
			int i = 0;
			while((value = fr.read()) != -1) {
				f[i++] = new Fruit();
			}
//			for(int j=f.length-1; j>=0; j--) {
//				System.out.println(f[j].toString());
//			}
			for (String key : sortedP) {
	            System.out.println(key + ": " + p.getProperty(key));
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
