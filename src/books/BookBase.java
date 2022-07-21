package books;

import java.awt.Color;
import java.util.ArrayList;

/**
 * notebook is a lot of pages
 * @author Gal
 *
 */
public abstract class BookBase {
	String name;
	Color color;
	int bookIndex;
	ArrayList<Page> pages;
	
	/**
	 * 
	 * @param name of the notebook
	 * @param pages of the notebook
	 */
	public BookBase(String name, int bookIndex, Color color, ArrayList<Page> pages) {
		this.name = name;
		this.pages = pages;
		this.color = color;
		this.bookIndex = bookIndex;
	}
	
	/**
	 * 
	 * @param name of the notebook
	 */
	public BookBase(String name, int bookIndex, Color color) {
		this.name = name;
		this.pages = new ArrayList<Page>();
		this.color = color;
		this.bookIndex = bookIndex;
	}

	/**
	 * 
	 * @return name of the notebook
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * sets the name of the notebook
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void resetPages() {
		this.pages = new ArrayList<Page>();
	}
	
	/**
	 * 
	 * @return pages
	 */
	public ArrayList<Page> getPages() {
		return pages;
	}

	/**
	 * 
	 * @param pages
	 * sets the pages
	 */
	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}
	
	public int getBookIndex() {
		return this.bookIndex;
	}
	
	public void setBookIndex(int bookIndex) {
		this.bookIndex = bookIndex;
	}
	
	/**
	 * adding page
	 */
	public void addPage() {
		this.addPage("");
	}
	
	/**
	 * adding page
	 */
	public void addPage(String context) {
		Page page = new Page(pages.size(), context);
		pages.add(page);
	}
	public void addPages(int numOfPages) {
		for (int i = 0; i < numOfPages; i++) {
			addPage();
		}
	}
	public abstract BookBase clone();
	}
