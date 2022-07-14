package main;

import java.util.ArrayList;
import java.util.List;

import books.RecipesBook;
import books.HistoryBook;
import books.MathBook;
import books.MedicinesBook;
import books.MusicBook;
import books.PhysicsBook;
import books.BookBase;
import books.GeographyBook;
import books.GrammerBook;


public class Main {
	public static void main(String[] args)
	{
			BookBase cookbook = new RecipesBook();
			BookBase mathbook = new MathBook();
			BookBase historybook = new HistoryBook();
			BookBase grammerbook = new GrammerBook();
			BookBase musicbook = new MusicBook();
			BookBase geographyBook = new GeographyBook();
			BookBase medicinesBook = new MedicinesBook();
			BookBase physicsBook = new PhysicsBook();

			List<BookBase> bookList = new ArrayList<BookBase>();
			bookList.add(cookbook);
			bookList.add(mathbook);
			bookList.add(historybook);
			bookList.add(grammerbook);
			bookList.add(musicbook);
			bookList.add(geographyBook);
			bookList.add(medicinesBook);
			bookList.add(physicsBook);

			MenuFrame frame = new MenuFrame(bookList);
	}
}
