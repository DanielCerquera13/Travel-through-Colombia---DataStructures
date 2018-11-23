package lnterface;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame{

 private InitialPanel initial;
	
	public MainWindow() {
	
	setLayout(new BorderLayout());
	setTitle("Traveling");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(1280,768);
	setResizable(false);
	
      initial = new InitialPanel(this);
      add(initial, BorderLayout.CENTER);
	   setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		
	MainWindow window = new MainWindow();	
		
		
	}
	
	
}
