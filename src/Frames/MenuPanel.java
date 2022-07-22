package Frames;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	    try {
			g.drawImage(ImageIO.read(new File("images/background.jpg")), 0, 0, 400, 370, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
