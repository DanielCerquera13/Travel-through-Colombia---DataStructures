package lnterface;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MapPanel extends JPanel {
    
	private InitialPanel initial;
	public MapPanel(InitialPanel initial) {
		this.initial = initial;

		setLayout(null);
	       BevelBorder border=  (BevelBorder) BorderFactory.createBevelBorder(1, Color.BLACK, Color.GRAY);
	        Border b= BorderFactory.createTitledBorder(border, "Map");

	       setBorder(b);

         
         
         JButton c = new JButton("fdsdfsd");
         c.setBounds(200, 200, 100, 100);
         add(c);
	}
}
