package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FilenameFilter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import books.BookBase;
import books.BookFactory;

public class BookListFrame extends JFrame {
	private JPanel panel;
	private JPanel controlBtnPanel;
	private JPanel notebookButtonsPanel;
	private List<BookBase> bookList;
	private List<JButton> notebookBtnsList;
	private List<JCheckBox> notebookCheckBoxList;
	// private String bookName;
	private List<BookBase> selectedNoteBooks;
	private JButton removeBtn;
	private String bookType;

	
	public BookListFrame(String bookType) {
		this.bookType = bookType;
		this.bookList = getAllBookList(bookType);

		this.notebookBtnsList = new ArrayList<JButton>();
		this.notebookCheckBoxList = new ArrayList<JCheckBox>();
		this.selectedNoteBooks = new ArrayList<BookBase>();
		this.panel = new MenuPanel();
		this.controlBtnPanel = new JPanel();
		setSize(370, 400);
		addControlButtons();
		addNotebookButtons();
		// addNotebookCheckBox();
		panel.setBackground(new Color(150, 255, 255));
		controlBtnPanel.setBackground(new Color(231, 154, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notebookButtonsPanel.setOpaque(false);
		// this.add(notebookButtonsPanel, BorderLayout.NORTH);
		// this.panel.add(controlBtnPanel);
		this.add(panel);
		this.add(controlBtnPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	private List<BookBase> getAllBookList(String bookType) {
		String folderName = String.format("%s\\%s", BookBase.bookBasePath, bookType);
		List<BookBase> bookList = new ArrayList<BookBase>();
		if (getSubDirectories(folderName) != null) {
			for (String notebookFolder : getSubDirectories(folderName)) {
				System.out.println("notebookFolder = "+notebookFolder);
				BookBase newBook = BookFactory.GetInstance().createBook(bookType, notebookFolder);
				newBook.OpenNotebook(notebookFolder);
				newBook.ReadNotebook(notebookFolder);
				bookList.add(newBook);
				System.out.println(folderName);
			}
		}
		
		if (bookList.size() == 0) {
			BookBase newBook = BookFactory.GetInstance().createBook(bookType, "Notebook1");
			bookList.add(newBook);
			newBook.SaveNotebook();
		}
		return bookList;
	}
	
	private static String[] getSubDirectories(String path) {
		File file = new File(path);
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		return directories;
	}

	public void addControlButtons() {
		final JButton addBtn = new JButton("Add new book");
		addBtn.setEnabled(true);

	    removeBtn = new JButton("Remove");
		removeBtn.setEnabled(false);

		final JButton menuBtn = new JButton("Back to menu");
		
		addBtn.addActionListener(new ActionListener() {
			/**
			 * add new notebook
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = bookList.size() + 1;
				JFrame f=new JFrame();   
				String name=JOptionPane.showInputDialog(f,"Enter Name"); 
				if(!checkIfFileNameExists(name)){
					
					BookBase newBook = BookFactory.GetInstance().createBook(bookType, name);
					// BookBase newBook = BookFactory.GetInstance().createBook(bookType, String.format("Notebook%d", index));
					bookList.add(newBook);
					newBook.SaveNotebook();
					JButton btn = createNotebookButton(newBook, index);
					notebookBtnsList.add(btn);
					panel.add(btn, BorderLayout.CENTER);
	
					JCheckBox checkBox = createNotebookCheckBox(newBook, index);
					notebookCheckBoxList.add(checkBox);
					panel.add(checkBox, BorderLayout.WEST);
	
					panel.revalidate();
				}

			}
		});
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bookList.size() >= 2 && selectedNoteBooks.size() < bookList.size()) {
					if (selectedNoteBooks.size() > 0){
						for (BookBase notebook : selectedNoteBooks) {
							Integer index = bookList.indexOf(notebook);
							System.out.println("book is "+bookList.get(index).getName());
							bookList.get(index).DeleteNotebook();
							// FileManager.deleteNotebook(bookList.get(index));
							bookList.remove(notebook);
							notebookBtnsList.get(index).hide();
							notebookBtnsList.remove(notebookBtnsList.get(index));

							notebookCheckBoxList.get(index).hide();
							notebookCheckBoxList.remove(notebookCheckBoxList.get(index));
						}
					}
					selectedNoteBooks.clear();
					disableOrEnableRemoveBtn();
					// FileManager.deleteNotebook(bookList.get(bookList.size() - 1));
					// bookList.remove(bookList.size() - 1);
					// notebookBtnsList.get(notebookBtnsList.size() - 1).hide();
					// notebookBtnsList.remove(notebookBtnsList.size() - 1);

					// notebookCheckBoxList.get(notebookCheckBoxList.size() - 1).hide();
					// notebookCheckBoxList.remove(notebookCheckBoxList.size() - 1);	
				}
			}
		});
		menuBtn.addActionListener(new ActionListener() {

			/**
			 * back to menu
			 */
			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		controlBtnPanel.add(addBtn);
		controlBtnPanel.add(removeBtn);
		controlBtnPanel.add(menuBtn);
	}

	public JButton createNotebookButton(BookBase bookBase, int index) {
		// JButton btn = new JButton(String.format("Notebook %d", index));
		JButton btn = new JButton(bookBase.getName());
		btn.setBackground(bookBase.getColor());
		btn.setFont(new Font("Arial", Font.PLAIN, 28));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NotebookFrame notebookFrame = new NotebookFrame(bookBase);
			}
		});
		return btn;
	}

	/**
	 * creating the buttons
	 */
	public void addNotebookButtons() {
		notebookButtonsPanel = new JPanel();
		int index = 1;
		for (BookBase bookBase : bookList) {
			JButton btn = createNotebookButton(bookBase, index);
			panel.add(btn, BorderLayout.CENTER);
			this.notebookBtnsList.add(btn);

			JCheckBox checkBox = createNotebookCheckBox(bookBase, index);
			panel.add(checkBox, BorderLayout.WEST);
			this.notebookCheckBoxList.add(checkBox);

			index++;
		}
	}

	/**
	 * creating the CheckBoxs
	 */
	public JCheckBox createNotebookCheckBox(BookBase bookBase, int index) {
		JCheckBox checkBox = new JCheckBox();
		checkBox.setBackground(bookBase.getColor());
		checkBox.setFont(new Font("Arial", Font.PLAIN, 28));

		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("index is " + index);
				System.out.println("is selected " + checkBox.isSelected());

				if (!checkBox.isSelected() && selectedNoteBooks.contains(bookBase)) {
					System.out.println("in condition one");
					selectedNoteBooks.remove(selectedNoteBooks.indexOf(bookBase));
					
				} else if (checkBox.isSelected() && !selectedNoteBooks.contains(bookBase)) {
					System.out.println("in condition two");
					selectedNoteBooks.add(bookBase);
				}
				disableOrEnableRemoveBtn();
			}
		});
		return checkBox;
	}

	// public void addNotebookCheckBox() {
	// 	// notebookButtonsPanel = new JPanel();
	// 	int index = 1;
	// 	for (BookBase bookBase : bookList) {
	// 		JCheckBox checkBox = createNotebookCheckBox(bookBase, index++);
	// 		panel.add(checkBox, BorderLayout.EAST);
	// 		this.notebookCheckBoxList.add(checkBox);
	// 	}
	// }

	public void disableOrEnableRemoveBtn(){
		
		if(selectedNoteBooks.size()>0)
			removeBtn.setEnabled(true);
		else
			removeBtn.setEnabled(false);
	}

	public boolean checkIfFileNameExists(String name){
		for (BookBase book : bookList) {
			if(book.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
}
