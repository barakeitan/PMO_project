package books;

import java.awt.Color;

public class MedicinesBook extends BookBase {

	public MedicinesBook(int bookIndex) {
		super("Medicines", bookIndex, new Color(150, 50, 255));
		addPages(9);
	}
	
	@Override
	public BookBase clone() {
		return new MedicinesBook(bookIndex);
	}
}
