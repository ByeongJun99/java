package test11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<10; i++) {
			list.add((int)((Math.random() * 100) + 1));
		}
		
		Collections.sort(list, new Decending());
		
		display(list);
		
	}
	
	public static void display(List list) {
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
 