package books;

import java.awt.Color;

public class GeographyBook extends BookBase implements Inotablale{

	public GeographyBook() {
		super("Geography", Color.green);
		addPages(13);
	}

	public GeographyBook(BookBase base)
	{
		super(base.name, base.color, base.pages);
		addPages(13);
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
