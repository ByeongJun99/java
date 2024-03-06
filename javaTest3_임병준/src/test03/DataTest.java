package test03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {

	public static void main(String[] args) {

		Date date1 = new Date();
		Date date2 = new Date(1987-1900, 5-1, 27);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.print("생일 : " + sdf.format(date2));
		switch(date2.getDay()) {
		case 1:
			System.out.println(" 월요일");
			break;
		case 2:
			System.out.println(" 화요일");
			break;
		case 3:
			System.out.println(" 수요일");
			break;
		case 4:
			System.out.println(" 목요일");
			break;
		case 5:
			System.out.println(" 금요일");
			break;
		case 6:
			System.out.println(" 토요일");
			break;
		case 7:
			System.out.println(" 일요일");
			break;
		}
		System.out.println("현재 : " + sdf.format(date1));
		System.out.println("나이 : " + (date1.getYear() - date2.getYear()) + " 세");
		
	}

}
