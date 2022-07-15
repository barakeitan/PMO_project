package books;

import java.awt.Color;

public class GrammerBook extends BookBase {

	public GrammerBook(int bookIndex) {
		super("Grammer", bookIndex, Color.pink);
		addPages(15);
	}

}
