package books;

import java.awt.Color;

public class PhysicsBook extends BookBase {

	public PhysicsBook(String name) {
		super("Physics", name, new Color(0, 200, 255));
		addPages(16);
	}

	
	@Override
	public BookBase clone() {
		return new PhysicsBook(name);
	}
}
