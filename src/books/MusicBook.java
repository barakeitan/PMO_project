package books;

import java.awt.Color;

public class MusicBook extends BookBase {

	public MusicBook(String name) {
		super("Music", name, Color.yellow);
		addPages(10);
	}
	
	@Override
	public BookBase clone() {
		return new MusicBook(name);
	}

}
