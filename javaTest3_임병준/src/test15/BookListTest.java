package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookListTest {

	public static void main(String[] args) {
		
		BookListTest test5 = new BookListTest();
		ArrayList<Book> list = new ArrayList<Book>();
		
		test5.storeList(list);// Book 객체를 3개 생성하여 리스트에 넣는다.
		
		test5.saveFile(list); //books.dat 파일에 리스트에 저장된 Book 객체들을 저장한다.
		
		List<Book> booksList = test5.loadFile();
		//books.dat 파일로부터 객체들을 읽어서 리스트에 담는다.
		
		test5.printList(booksList); //리스트에 저장된 객체 정보를 출력한다.
		// 할인된 가격은 booksList 에 기록된 객체 정보를 사용하여 getter 로 계산 출력한다.
		// – for each 문을 이용 할 것
		
	}
	
	public void storeList(List<Book> list) {
		// 리스트에 Book 객체를 담는다.
		list.add(new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.15));
		list.add(new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.2));
		list.add(new Book("객체지향 JAVA8", "금영욱", 30000, "북스홈", 0.1));
	}
	
	public void saveFile(List<Book> list) {
		// books.dat 파일에 리스트에 저장된 Book 객체들을 출력 기록한다.
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public List<Book> loadFile() {
		// books.dat 파일에 기록된 객체들을 읽어서 Book 객체에 기록하고, Book 객체를 리스트에 담아 리턴한다.
		List<Book> booksList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
            booksList = (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return booksList;
	}
	
	public void printList(List<Book> list) {
		// 리스트에 저장된 객 체정보를 출력한다. for each 문 사용한다.
        for (Book book : list) {
            System.out.println(book.toString());
            System.out.println("할인된 가격 : " + (int)(book.getPrice()*(1-book.getDiscountRate())) + "원");
        }
	}

}
