package books;

import java.awt.Color;

public class HistoryBook extends BookBase {

	public HistoryBook(String name) {
		super("History", name, Color.GRAY);
		addPages(12);
	}

	@Override
	public BookBase clone() {
		return new HistoryBook(name);
	}
}
