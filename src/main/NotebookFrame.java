package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import books.BookBase;
import books.Page;

/**
 * 
 * @author Gal
 * the frame of notebook
 */
public class NotebookFrame extends JFrame{
	private JTextArea textArea;
	private BookBase notebook;
	private int pageCount;
	private JLabel titleLabel;
	private JPanel panel;
	
	/**
	 * Constructor that reset the notebook frame
	 */
	public NotebookFrame(BookBase notebook) {
		this.panel = new JPanel();
		this.notebook = notebook;
		this.pageCount = 0;
		this.textArea = new JTextArea(notebook.getPages().get(pageCount).getText(), 10, 15);
		setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.notebook = notebook;
		addTitle();
		addPageCount();
		createButtons();
		addTextArea();
		panel.setBackground(notebook.getColor());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(this.panel);
		setVisible(true);
	}
	
	/**
	 * creating the buttons
	 */
	public void createButtons() {
		final JButton prevBtn = new JButton("prev page");
		prevBtn.setEnabled(false);
        final JButton nextBtn = new JButton("next page");
        final JButton menuBtn = new JButton("back to menu");
        prevBtn.addActionListener(new ActionListener() {
			
        	/**
        	 * waiting for click on previews button
        	 */
			@Override
			public void actionPerformed(ActionEvent e) {
					Page currentPage = notebook.getPages().get(pageCount);
					Page prevPage = notebook.getPages().get(pageCount - 1);
					currentPage.setText(textArea.getText());
					--pageCount;
					if (pageCount == 0) {
						prevBtn.setEnabled(false);
					}
					nextBtn.setEnabled(true);
					System.out.println(pageCount);
					textArea.setText(prevPage.getText());
					titleLabel.setText("Page " + (pageCount + 1));
					setVisible(true);
			}
		});
        nextBtn.addActionListener(new ActionListener() {
			
        	/**
        	 * waiting for click on next button
        	 */
			@Override
			public void actionPerformed(ActionEvent e) {
					Page currentPage = notebook.getPages().get(pageCount);
					Page nextPage = notebook.getPages().get(pageCount + 1);
					currentPage.setText(textArea.getText());
					++pageCount;
					if (pageCount == notebook.getPages().size() - 1) {
						nextBtn.setEnabled(false);
					}
					prevBtn.setEnabled(true);
					textArea.setText(nextPage.getText());
					System.out.println(pageCount);
					titleLabel.setText("Page " + (pageCount + 1));
					setVisible(true);
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
        this.add(nextBtn, BorderLayout.EAST);
        this.add(prevBtn, BorderLayout.WEST);
        this.add(menuBtn, BorderLayout.SOUTH);
	}
	
	/**
	 * adds new text area to the frame 
	 */
	public void addTextArea() {
		JTextArea text1 = textArea;
		this.panel.add(text1);
		JScrollPane sPane = new JScrollPane(text1);
		sPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sPane.setSize(100, 100);
		sPane.setBounds(100, 100, 200, 200);
		this.panel.add(sPane, BorderLayout.CENTER);
	}
	
	/**
	 * adds new title to the frame 
	 */
	public void addTitle() {
		titleLabel = new JLabel(notebook.getName());
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.panel.add(titlePanel);
	}
	
	
	public void addPageCount() {
		titleLabel = new JLabel("Page " + (pageCount + 1));
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 27));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.panel.add(titlePanel);
	}
}
