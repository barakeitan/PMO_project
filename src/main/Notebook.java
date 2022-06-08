package main;

import java.util.ArrayList;

/**
 * notebook is a lot of pages
 * @author Gal
 *
 */
public class Notebook {
	String name;
	ArrayList<Page> pages;
	
	/**
	 * 
	 * @param name of the notebook
	 * @param pages of the notebook
	 */
	public Notebook(String name, ArrayList<Page> pages) {
		this.name = name;
		this.pages = pages;
	}
	
	/**
	 * 
	 * @param name of the notebook
	 */
	public Notebook(String name) {
		this.name = name;
		this.pages = new ArrayList<Page>();
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
	
	/**
	 * adding page
	 */
	public void addPage() {
		Page page = new Page(pages.size(), "");
		pages.add(page);
	}
	}
