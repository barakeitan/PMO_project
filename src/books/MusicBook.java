package books;

import java.awt.Color;

public class MusicBook extends BookBase {

	public MusicBook(int bookIndex) {
		super(" Music ", bookIndex, Color.yellow);
		addPages(10);
	}

}
