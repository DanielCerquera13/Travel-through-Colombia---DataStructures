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
	
  /**
   * Constante para la imagen de fondo
   */
	public static final Image BACKGROUND = Toolkit.getDefaultToolkit()
			.createImage("./imgs/flag.jpeg");

	
	/**
	 * Relacion con el panel MapPanel
	 */
	private MapPanel map;
	/**
	 * Relacion con el panel InfoPanel
	 */
	private InfoPanel info;
	/**
	 * Relacion con el frame MainWindow
	 */
	private MainWindow window;
	
     
	/**
	 * Constructor de la clase InitialPanel
	 * @param window - Relacion con el frame
	 */
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
	
	 
	/**
	 * Entrega el frame Window
	 * @return frame window
	 */
	public MainWindow getWindow() {
		return window;
	}


	

    /**
     * Entrega el panel MapPanel
     * @return - relacion con el MapPanel
     */
	public MapPanel getMap() {
		return map;
	}


	

    /**
     * Entrega el panel InfoPanel
     * @return relacion con el InfoPanel
     */
	public InfoPanel getInfo() {
		return info;
	}



    /**
     * Metodo paintComponent
     */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(BACKGROUND, 0, 0, null);

		
		repaint();
	}
	
}
