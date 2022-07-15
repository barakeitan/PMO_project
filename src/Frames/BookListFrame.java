package Frames;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import books.BookBase;
import books.Page;

public class BookListFrame extends JFrame {
	private JPanel panel;
	private JPanel controlBtnPanel;
	private List<BookBase> bookList;
	
	public BookListFrame() {
		this.bookList = new ArrayList<BookBase>();
		this.panel = new MenuPanel();
		this.controlBtnPanel = new JPanel();
		setSize(370, 400);
		createControlButtons();
		panel.setBackground(new Color(150, 255, 255));
		controlBtnPanel.setBackground(new Color(231, 154, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(controlBtnPanel, BorderLayout.SOUTH);
		this.add(panel);
		setVisible(true);
	}
	
	public void createControlButtons() {
		final JButton addBtn = new JButton("Add new book");
		addBtn.setEnabled(true);
        final JButton removeBtn = new JButton("Remove");
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
}
