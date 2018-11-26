package lnterface;

import java.awt.*;
import javax.swing.*;

import model.TravelingProgram;

public class MainWindow extends JFrame{

	/**
	 * Relacion con el Panel InitialPanel
	 */
 private InitialPanel initial;
  /**
   * Relacion con el modelo
   */
 private TravelingProgram travel;
	
	public MainWindow() {
	
	setLayout(new BorderLayout());
	setTitle("Traveling");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(1280,768);
	setResizable(false);
	
	//setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("./imgs/Carro.png").getImage(), new Point(0, 0), "Car Cursor"));
	
	
	
	  travel = new TravelingProgram();
      initial = new InitialPanel(this);
      add(initial, BorderLayout.CENTER);
	   setVisible(true);
	
	}
	
	
	/**
	 * Entrega la relacioon con el modelo
	 * @return - relacion con el modelo
	 */
	public TravelingProgram getTravel() {
		return travel;
	}



	public static void main(String[] args) {
		
	MainWindow window = new MainWindow();	
		
		
	}
	
	
}
