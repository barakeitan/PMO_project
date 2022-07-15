package books;

import java.awt.Color;

public class GeographyBook extends BookBase {

	public GeographyBook(int bookIndex) {
		super("Geography", bookIndex, Color.green);
		addPages(13);
	}

	@Override
	public BookBase clone() {
		return new GeographyBook(bookIndex);
	}

}
