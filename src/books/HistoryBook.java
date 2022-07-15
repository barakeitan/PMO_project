package books;

import java.awt.Color;

public class HistoryBook extends BookBase {

	public HistoryBook(int bookIndex) {
		super("History", bookIndex, Color.GRAY);
		addPages(12);
	}

}
