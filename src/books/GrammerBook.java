package books;

import java.awt.Color;

public class GrammerBook extends BookBase {

	public GrammerBook(String name) {
		super("Grammer", name, Color.pink);
		addPages(15);
	}

	@Override
	public BookBase clone() {
		return new GrammerBook(name);
	}
}
