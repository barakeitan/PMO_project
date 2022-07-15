package books;

import java.awt.Color;

public class RecipesBook extends BookBase implements Inotablale{

	public RecipesBook() {
		super("Recipes", Color.ORANGE);
		addPages(20);
	}

	public RecipesBook(BookBase base)
	{
		super(base.name, base.color, base.pages);
		addPages(20);
	}

	@Override
	public int OpenNotebook(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CloseNotebook(Boolean SaveContent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StringBuffer ReadPage(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int WritePage(Page page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int WriteNotebook(BookBase book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookBase ReadNotebook(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int CreateNewNotebook(String path, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int DeleteNotebook(String Path) {
		// TODO Auto-generated method stub
		return 0;
	}
}
