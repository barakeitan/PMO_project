package books;

import java.awt.Color;
import java.util.ArrayList;

public class RecipesBook extends BookBase {

	public RecipesBook(int bookIndex) {
		super("Recipes", bookIndex, Color.ORANGE);
		addPages(20);
	}

}
