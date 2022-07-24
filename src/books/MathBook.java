package books;

import java.awt.Color;

public class MathBook extends BookBase {

	public MathBook(String name) {
		super("Math", name, Color.CYAN);
		addPages(15);
	}

	@Override
	public BookBase clone() {
		return new MathBook(name);
	}
}
