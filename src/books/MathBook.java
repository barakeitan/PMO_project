package books;

import java.awt.Color;

public class MathBook extends BookBase implements Inotablale{

	public MathBook() {
		super("  Math  ", Color.CYAN);
		addPages(15);
	}

	public MathBook(BookBase base)
	{
		super(base.name, base.color, base.pages);
		addPages(15);
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
