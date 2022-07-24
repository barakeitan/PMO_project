package books;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * notebook is a lot of pages
 * 
 * @author Gal
 *
 */
public abstract class BookBase implements Inotable {
	
	public static final String bookBasePath = "C:\\MyBooks";

	private boolean isCreated;

	String name;
	Color color;
	int bookIndex;
	ArrayList<Page> pages;
	File fd;
	String Path;
	String bookType;
	
	/**
	 * 
	 * @param name  of the notebook
	 * @param pages of the notebook
	 */
	public BookBase(String bookType, String name, Color color, ArrayList<Page> pages) {
		this.name = name;
		this.pages = pages;
		this.color = color;
		this.bookType = bookType;
		this.Path = String.format("%s\\%s\\%s", bookBasePath, bookType, name);
		this.fd = new File(this.Path);
		this.isCreated = false;
	}

	/**
	 * 
	 * @param name of the notebook
	 */
	public BookBase(String bookType, String name, Color color) {
		this.name = name;
		this.pages = new ArrayList<Page>();
		this.color = color;
		this.bookType = bookType;
		this.Path = String.format("%s\\%s\\%s", bookBasePath, bookType, name);
		this.fd = new File(this.Path);
		this.isCreated = false;
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
	 *             sets the name of the notebook
	 */
	public void setName(String name) {
		this.name = name;
		this.Path = String.format("%s\\%s\\%s", bookBasePath, this.bookType, name);
		this.fd = new File(this.Path);
	}

	public String getBookType()
	{
		return this.bookType;
	}
	public void setBookType(String bookType)
	{
		this.bookType = bookType;
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
	 *              sets the pages
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

	@Override
	public String ReadPage(int page) {
		String pagePath = String.format("%s\\page%d.txt", this.Path, page);
		
		File pageFile = new File(pagePath);

		try {
			    if (pageFile.isFile()) {
			    	String text = new String(Files.readAllBytes(pageFile.toPath()), StandardCharsets.UTF_8);
			    	this.addPage(text);
			    }
		} catch (Exception e) {
			System.err.println("could not open page");
		}
		
		return null;
	}

	@Override
	public int WritePage(Page page) {
		try {
			String pageName = String.format("page%d.txt", page.getPageNum());
			String fullFileName = String.format("%s\\%s", this.Path, pageName);
			File pageFile = new File(fullFileName);
			createFileIfItNotExist(this.Path, fullFileName);
			FileWriter myWriter = new FileWriter(pageFile);
			myWriter.write(page.getText());
			myWriter.close();
		  } catch (IOException e) {
			System.out.println("some or all notebook could not be saved");
		  }
		return 0;
	}

	public void deletePage(Page page)
	{
		// String pageName = String.format("%s\\page%d.txt", this.Path, page.getPageNum());
		// String pageName = String.format("%s\\%s\\notebook%d\\page%d.txt", bookBasePath, this.getName().replaceAll(" ", ""), this.getBookIndex(),page.getPageNum());
		String pageName = String.format("%s\\%s\\%s\\page%d.txt", bookBasePath, this.getBookType().replaceAll(" ", ""), this.getName(),page.getPageNum());
		File index = new File(pageName);
		System.out.println(index.getName());
		index.delete();
	}

	// private static boolean createFileIfItNotExist(String folderName, String fullFileName) {
	// 	boolean isNewFileCreated = false;
	// 	try {
	// 		File folder = new File(folderName);

	// 		if (!folder.exists()) {
	// 			folder.mkdirs();
	// 		}
	// 	   File myFile = new File(fullFileName);
	// 	   if(!myFile.isFile())
	// 	   {
	// 			myFile.createNewFile();
	// 	   }
		 
	// 	  } catch (IOException e) {
	// 		  System.out.println(e);
	// 	  }
	// 	return isNewFileCreated;
	// }

	private static boolean createFileIfItNotExist(String folderName, String fullFileName) {
		boolean isNewFileCreated = false;
		try {
			File folder = new File(folderName);

			if (!folder.exists()) {
				folder.mkdirs();
			}
		   File myFile = new File(fullFileName);
		   if (myFile.createNewFile()){
		    isNewFileCreated = true;
		   } else{
		    //System.out.println("File already exists.");
		   }
		 
		  } catch (IOException e) {
			  System.out.println(e);
		  }
		return isNewFileCreated;
	}

	@Override
	public int OpenNotebook(String path) {
		int result = 0;
		this.isCreated = true;
		if(!this.fd.exists())
		{
			this.CreateNewNotebook(path);
		}
		else // The folder already exist so it contains files unlike the otherwise empty new notebook
		{
			this.ReadNotebook(path);
		}
		return result;
	}

	@Override
	public int CloseNotebook(Boolean SaveContent) {
		if(SaveContent == true)
		{
			this.SaveNotebook();
		}
		
		return 0;
	}

	@Override
	public int CreateNewNotebook(String name) {
		this.isCreated = true;
		try {
			File notebook = new File(String.format(this.Path, name));
			notebook.mkdir();
		} catch (Exception e) {
			System.err.println("Could not create notebook");
			System.err.println(e.getMessage());
		}
		return 0;
	} 

	@Override
	public int DeleteNotebook() {
		String[]entries = this.fd.list();
		System.out.println("this.path = "+this.Path);
		for(String page: entries){
		    File currentFile = new File(String.format("%s\\%s", this.Path, page));
		    currentFile.delete();
		}
		this.fd.delete();
		this.isCreated = false;
		return 0;
	}

	@Override
	public BookBase ReadNotebook(String path) {
		if(this.isCreated)
		{
			File[] pages = this.fd.listFiles();
			this.resetPages();
			for (int i = 0; i < pages.length; i++) {
				ReadPage(i);
			}
		}	
		return this;
	}

	@Override
	public int SaveNotebook() {
		System.out.println("size = "+this.getPages().size());
		for (int i = 0; i < this.getPages().size(); i++) {
			try {
				  String folderName = String.format("%s\\%s\\%s", bookBasePath, this.getBookType().replaceAll(" ", ""), this.getName());
				  String fileName = String.format("page%d.txt", i);
				  String fullFileName = String.format("%s\\%s", folderName, fileName);
				  System.out.println(createFileIfItNotExist(folderName, fullFileName));
			      FileWriter myWriter = new FileWriter(fullFileName);
			      myWriter.write(this.getPages().get(i).getText());
			      myWriter.close();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
		// Check if the notebook exists
		// if(!this.fd.exists())
		// {
		// 	this.CreateNewNotebook(this.name);
		// 	this.isCreated = true;
		// }
		// for(Page page : this.pages) {
		// 	this.WritePage(page);
		// }
		return 0;
	}
}
