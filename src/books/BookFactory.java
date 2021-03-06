package books;

import java.util.ArrayList;
import java.util.List;

public class BookFactory {
	private List<BookBase> bookList;
	
	private static BookFactory instance;
	
	public static BookFactory GetInstance() {
		if (instance != null) {
			return instance;
		}
		return instance = new BookFactory();
	}
	
	private BookFactory() {
		setBookList();
	}
	
	public List<String> getAllBookNames() {
		List<String> bookNamesList = new ArrayList<String>();
		for (BookBase book : bookList) {
			bookNamesList.add(book.getName());
		}
		return bookNamesList;
	}
	
	public List<BookBase> getBookList() {
		return bookList;
	}
	
	private void setBookList() {
		BookBase cookbook = new RecipesBook("Notebook1");
		BookBase mathbook = new MathBook("Notebook1");
		BookBase historybook = new HistoryBook("Notebook1");
		BookBase grammerbook = new GrammerBook("Notebook1");
		BookBase musicbook = new MusicBook("Notebook1");
		BookBase geographyBook = new GeographyBook("Notebook1");
		BookBase medicinesBook = new MedicinesBook("Notebook1");
		BookBase physicsBook = new PhysicsBook("Notebook1");

		this.bookList = new ArrayList<BookBase>();
		bookList.add(cookbook);
		bookList.add(mathbook);
		bookList.add(historybook);
		bookList.add(grammerbook);
		bookList.add(musicbook);
		bookList.add(geographyBook);
		bookList.add(medicinesBook);
		bookList.add(physicsBook);
	}
	
	public BookBase createBook(String bookType, String bookName) {
		for (BookBase book : bookList) {
			if (book.getBookType().equals(bookType)) {
				BookBase newBook = book.clone();
				newBook.setName(bookName);
				return newBook;
			}
		}
		return null;
	}

	public BookBase createBook(String bookName, int bookIndex) {
		for (BookBase book : bookList) {
			if (book.getName().equals(bookName)) {
				BookBase newBook = book.clone();
				newBook.setBookIndex(bookIndex);
				return newBook;
			}
		}
		return null;
	}
}
