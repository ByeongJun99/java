package com.kh.Test240206;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookController {
	private List<Book> bookList = new ArrayList();

	public BookController() {
		super();
		bookList.add(new Book("자바의 정석", "남궁 성", "기타", 20000));
		bookList.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		bookList.add(new Book("대화의 기술", "강보람", "인문", 17500));
		bookList.add(new Book("암 정복기", "박신우", "의료", 21000));
	}
	
	public void insertBook(Book bk) {
		bookList.add(bk);
	}
	
	public ArrayList selectList() {
		return (ArrayList) bookList;
	}
	
	public ArrayList searchBook(String keyword) {
		ArrayList searchList = new ArrayList();
		
		for(int i=0; i<bookList.size(); i++) {
			if (((Book)(bookList.get(i))).getTitle().contains(keyword)) {
				searchList.add(bookList.get(i));
			}
		}
		return searchList;
	}
	
	public Book deleteBook(String title, String author) {
		Book removeBook = null;
		
		for(int i=0; i<bookList.size(); i++) {
			if (((Book) bookList.get(i)).getTitle().equals(title) && (((Book) bookList.get(i)).getAuthor().equals(author))) {
				removeBook = (Book) bookList.get(i);
				bookList.remove(i);
				break;
			}
		}
		
		return removeBook;
	}
	
	@SuppressWarnings("unchecked")
	public int ascBook() {
		Collections.sort(bookList, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		
		return 1;
	}
}
