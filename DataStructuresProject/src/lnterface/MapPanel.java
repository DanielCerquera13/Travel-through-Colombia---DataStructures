package lnterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MapPanel extends JPanel {
	
	public static final Image BACKGROUND = Toolkit.getDefaultToolkit()
			.createImage("./imgs/map.jpg");

    
	private InitialPanel initial;
	public MapPanel(InitialPanel initial) {
		this.initial = initial;

		setLayout(null);
	       BevelBorder border=  (BevelBorder) BorderFactory.createBevelBorder(1, Color.BLACK, Color.GRAY);
	        Border b= BorderFactory.createTitledBorder(border, "Map");
	       setBorder(b);

         
       
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(BACKGROUND, 130, 10, null);

		
		repaint();
	}
}
