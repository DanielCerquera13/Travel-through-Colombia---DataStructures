package lnterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.views.AbstractView;

import dataStructures.Vertex;
import model.City;

public class MapPanel extends JPanel {

	public static final Image BACKGROUND = Toolkit.getDefaultToolkit().createImage("./imgs/map3.png");

	private InitialPanel initial;

	public MapPanel(InitialPanel initial) {
		this.initial = initial;

		setLayout(null);
		BevelBorder border = (BevelBorder) BorderFactory.createBevelBorder(1, Color.BLACK, Color.GRAY);
		Border b = BorderFactory.createTitledBorder(border, "Map");
		setBorder(b);

		// cities = new JLabel[31];

		tooltip();

	}

	public void tooltip() {

		City[] cities = initial.getWindow().getTravel().getCities();

		JLabel[] labels = new JLabel[32];

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			labels[i].setBounds(cities[i].getX(), cities[i].getY(), 8, 8);
			labels[i].setBackground(new Color(0, 0, 0, 0));
			labels[i].setToolTipText(cities[i].getName());
			add(labels[i]);
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(BACKGROUND, 130, 10, null);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.WHITE);
		City[] cities = initial.getWindow().getTravel().getCities();

		for (int i = 0; i < cities.length; i++) {
			g2.fillOval(cities[i].getX(), cities[i].getY(), 7, 7);
		}

		for (int i = 0; i < cities.length; i++) {
			if (initial.getInfo().getComboFrom().getSelectedIndex() == i) {

				g2.setColor(Color.RED.brighter().brighter().brighter().brighter().brighter().brighter().brighter());
				g2.fillOval(cities[i].getX(), cities[i].getY(), 10, 10);

			}
			if (initial.getInfo().getComboTo().getSelectedIndex() == i) {

				g2.setColor(Color.GREEN.brighter().brighter().brighter().brighter().brighter());
				g2.fillOval(cities[i].getX(), cities[i].getY(), 10, 10);
			}
		}
		
		
		int from = initial.getInfo().getComboFrom().getSelectedIndex();
		int to= initial.getInfo().getComboTo().getSelectedIndex();
		
	
		
		if(from != -1 && to != -1) {
	   ArrayList <Vertex<City>> path = initial.getWindow().getTravel().getPath(new Vertex<City>(cities[from]), new Vertex<City>(cities[to]));  	
         
	   for (int i = 0; i < path.size()-1; i++) {
		   g2.setColor(Color.CYAN.brighter());
		   g2.setStroke(new BasicStroke(3));
		   g2.drawLine( path.get(i).getValue().getX(),path.get(i).getValue().getY(), path.get(i+1).getValue().getX(),path.get(i+1).getValue().getY());
	   }   
	}
		
		repaint();
	}

}
