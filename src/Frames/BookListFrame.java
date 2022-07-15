package Frames;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Logic.FileManager;
import books.BookBase;
import books.Page;

public class BookListFrame extends JFrame {
	private JPanel panel;
	private JPanel controlBtnPanel;
	private JPanel notebookButtonsPanel;
	private List<BookBase> bookList;
	
	public BookListFrame(String bookName) {
		this.bookList = FileManager.getAllBookList(bookName);
		this.panel = new MenuPanel();
		this.controlBtnPanel = new JPanel();
		setSize(370, 400);
		createControlButtons();
		createButtons();
		panel.setBackground(new Color(150, 255, 255));
		controlBtnPanel.setBackground(new Color(231, 154, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notebookButtonsPanel.setOpaque(false);
		//this.add(notebookButtonsPanel, BorderLayout.NORTH);
		//this.panel.add(controlBtnPanel);
		this.add(panel);
		this.add(controlBtnPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void createControlButtons() {
		final JButton addBtn = new JButton("Add new book");
		addBtn.setEnabled(true);
        final JButton removeBtn = new JButton("Remove last");
        final JButton menuBtn = new JButton("back to menu");
        addBtn.addActionListener(new ActionListener() {
			
        	/**
        	 * waiting for click on previews button
        	 */
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
        removeBtn.addActionListener(new ActionListener() {
			
        	/**
        	 * waiting for click on next button
        	 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        menuBtn.addActionListener(new ActionListener() {
			
        	/**
        	 * waiting for click on next button
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
	
	/**
	 * creating the buttons
	 */
	public void createButtons() {
		notebookButtonsPanel = new JPanel();
		int index = 1;
		for (BookBase bookBase : bookList) {
			JButton btn = new JButton(String.format("Notebook %d", index++));
			btn.setBackground(bookBase.getColor());
			btn.setFont(new Font("Arial", Font.PLAIN, 28));
			panel.add(btn, BorderLayout.CENTER);
			System.out.println("add");
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					NotebookFrame notebookFrame = new NotebookFrame(bookBase);
				}
			});
		}
	}
}
