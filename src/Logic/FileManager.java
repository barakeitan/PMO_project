package Logic;
import books.BookFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import books.BookBase;
import books.Page;

public class FileManager {
	public final static String BOOKS_PATH = "C:\\MyBooks";
	
	public static void saveNotebook(BookBase book)
	{
		for (int i = 0; i < book.getPages().size(); i++) {
			try {
				  String folderName = String.format("%s\\%s\\notebook%d", FileManager.BOOKS_PATH, book.getName().replaceAll(" ", ""), book.getBookIndex(), i);
				  String fileName = String.format("page%d.txt", i);
				  String fullFileName = String.format("%s\\%s", folderName, fileName);
				  FileManager.createFileIfItNotExist(folderName, fullFileName);
			      FileWriter myWriter = new FileWriter(fullFileName);
			      myWriter.write(book.getPages().get(i).getText());
			      System.out.println(book.getPages().get(i).getText());
			      myWriter.close();
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		}
	}
	
	
	
	public static List<BookBase> getAllBookList(String bookName) {
		String folderName = String.format("%s\\%s", FileManager.BOOKS_PATH, bookName.replaceAll(" ", ""));
		List<BookBase> bookList = new ArrayList<BookBase>();
		int index = 1;
		if (getSubDirectories(folderName) != null) {
			for (String notebookFolder : getSubDirectories(folderName)) {
				BookBase newBook = BookFactory.GetInstance().createBook(bookName, index++);
				readNotebook(newBook);
				bookList.add(newBook);
			}
		}
		
		if (bookList.size() == 0) {
			BookBase newBook = BookFactory.GetInstance().createBook(bookName, index++);
			bookList.add(newBook);
			saveNotebook(newBook);
		}
		return bookList;
	}
	
	private static String[] getSubDirectories(String path) {
		File file = new File(path);
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		return directories;
	}
	
	public static void readNotebook(BookBase book)
	{
		String folderName = String.format("%s\\%s\\notebook%d", FileManager.BOOKS_PATH, book.getName().replaceAll(" ", ""), book.getBookIndex());
		
		File folder = new File(folderName);
		File[] listOfFiles = folder.listFiles();

		try {
			for (File file : listOfFiles) {
			    if (file.isFile()) {
			    	String text = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
			    	book.addPage(text);
			    }
			}
		} catch (Exception e) {
		}
	}
	
	private static boolean createFileIfItNotExist(String folderName, String fullFileName) {
		boolean isNewFileCreated = false;
		try {
			File folder = new File(folderName);

			if (!folder.exists()) {
				folder.mkdirs();
			}
		   File myFile = new File(fullFileName);
		   if (myFile.createNewFile()){
		    System.out.println("File is created!");
		    isNewFileCreated = true;
		   } else{
		    //System.out.println("File already exists.");
		   }
		 
		  } catch (IOException e) {
			  System.out.println(e);
		  }
		return isNewFileCreated;
	}
	
}
