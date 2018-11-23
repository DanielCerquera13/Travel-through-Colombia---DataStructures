package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class InitialPanel  extends JPanel {
	

	public static final Image BACKGROUND = Toolkit.getDefaultToolkit()
			.createImage("./imgs/flag.jpeg");

	
	private MapPanel map;
	private InfoPanel info;
	private MainWindow window;
     
	public InitialPanel(MainWindow window) {
		
		
	this.window = window;	
	setLayout(null);
	map = new MapPanel(this);
	info = new InfoPanel(this);
	
	
    map.setBounds(0, 0, 800, 760);
	map.setBackground(new Color(125,125,125,125));

    info.setBounds(801, 0, 480, 760);
	info.setBackground(new Color(125,125,125,125));

	 
	add(map);
	add(info);
	
	   
	}
	
	 
	public MainWindow getWindow() {
		return window;
	}


	public void setWindow(MainWindow window) {
		this.window = window;
	}


	public MapPanel getMap() {
		return map;
	}


	public void setMap(MapPanel map) {
		this.map = map;
	}


	public InfoPanel getInfo() {
		return info;
	}


	public void setInfo(InfoPanel info) {
		this.info = info;
	}


	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(BACKGROUND, 0, 0, null);

		
		repaint();
	}
	
}
