package books;

import java.awt.Color;

public class MathBook extends BookBase {

	public MathBook(int bookIndex) {
		super("  Math  ", bookIndex, Color.CYAN);
		addPages(15);
	}

	@Override
	public BookBase clone() {
		return new MathBook(bookIndex);
	}
}
