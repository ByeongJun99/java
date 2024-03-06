package test05;

public class BookArrayTest {

	public static void main(String[] args) {

		Book bArray[] = new Book[3];
		
		bArray[0] = new Book("자바의 정석", "남궁성", 30000, "도우출판", 10);
		bArray[1] = new Book("열혈강의 자바", "구정은", 29000, "도우출판", 10);
		bArray[2] = new Book("객체지향 JAVA8", "금영욱", 30000, "도우출판", 10);
		
		for(int i=0; i<bArray.length; i++) {
			Book b = bArray[i];
			System.out.println(b.getTitle() + ", " + b.getAuthor() + ", " + b.getPublisher() + ", " + b.getPrice() + "원, " + (int)b.getDiscountRate() + "% 할인");
			System.out.println("할인된 가격 : " + (b.getPrice() - (int)(b.getPrice() * b.getDiscountRate() / 100)) + "원");
		}
		
	}

}
