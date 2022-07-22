package books;

import java.awt.Color;

public class GeographyBook extends BookBase {

	public GeographyBook(String name) {
		super("Geography", name, Color.green);
		addPages(13);
	}

	@Override
	public BookBase clone() {
		return new GeographyBook(name);
	}

}
