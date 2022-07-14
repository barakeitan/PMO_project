package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import books.BookBase;

/**
 * 
 * @author Gal
 * the frame of menu
 */
public class MenuFrame extends JFrame{
	private JPanel panel;
	private List<BookBase> books;
	
	/**
	 * Constructor that reset the notebook frame
	 */
	public MenuFrame(List<BookBase> books) {
		this.panel = new MenuPanel();
		this.books = books;
		setSize(370, 400);
		addTitle();
		addInfo();
		createButtons();
		panel.setBackground(new Color(150, 255, 255));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		setVisible(true);
	}
	
	/**
	 * creating the buttons
	 */
	public void createButtons() {
		ArrayList<JPanel> buttonsPanel = new ArrayList<JPanel>();
		int count = 0;
		for (BookBase bookBase : books) {
			if (count % 3 == 0) {
				buttonsPanel.add(new JPanel());
			}
			JButton btn = new JButton(bookBase.getName());
			btn.setBackground(bookBase.getColor());
			buttonsPanel.get(buttonsPanel.size() - 1).add(btn, BorderLayout.CENTER);
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					NotebookFrame frame = new NotebookFrame(bookBase);
				}
			});
			count++;
		}
		for (JPanel jPanel : buttonsPanel) {
			panel.add(jPanel);
		}
	}
	
	
	/**
	 * adds new title to the frame 
	 */
	public void addTitle() {
		JLabel titleLabel = new JLabel("Book store");
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        panel.add(titlePanel);
	}
	
	/**
	 * adds new info to the frame 
	 */
	public void addInfo() {
		JLabel infoLabel1 = new JLabel("Welcome to the bookstore!");
		infoLabel1.setOpaque(true);
		infoLabel1.setBackground(Color.white);
		infoLabel1.setFont(new Font(Font.SERIF, Font.BOLD, 22));
		JLabel infoLabel2 = new JLabel("Select any book you like");
		infoLabel2.setFont(new Font(Font.SERIF, Font.BOLD, 22));
		infoLabel2.setOpaque(true);
		infoLabel2.setBackground(Color.white);
		panel.add(infoLabel1);
		panel.add(infoLabel2);
	}
	
}
