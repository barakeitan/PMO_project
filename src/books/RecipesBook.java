package books;

import java.awt.Color;

public class RecipesBook extends BookBase {

	public RecipesBook(String name) {
		super("Recipes", name, Color.ORANGE);
		addPages(20);
	}

	
	@Override
	public BookBase clone() {
		return new RecipesBook(name);
	}
}
