package books;

/**
 * 
 * @author Gal
 * Page is being read
 */
public class Page {
	private int pageNum;
	private String text;
	
	/**
	 * 
	 * @param pageNum page number
	 * @param text written text
	 */
	public Page(int pageNum, String text) {
		this.pageNum = pageNum;
		this.text = text;
	}

	/**
	 * 
	 * @return page number
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * 
	 * @param pageNum
	 * sets page number
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * 
	 * @return text of the page
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text 
	 * sets text of the page
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
