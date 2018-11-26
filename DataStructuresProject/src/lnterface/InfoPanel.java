package lnterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import dataStructures.Vertex;
import model.City;

public class InfoPanel extends JPanel implements ActionListener {
	
	public final static String ROUTE = "Route";
	public final static String TRAVEL = "Travel Colombia";
	
	private JLabel from;
	private JLabel to;
	private JComboBox comboFrom;
	private JComboBox comboTo;
	private JLabel distance;
	private JLabel txtDistance;
	private JLabel kms;
	private JButton route;
	private JButton travel;
	private InitialPanel initial;
	private String[] cities;
	private boolean global;
	public InfoPanel(InitialPanel initial) {
		this.initial = initial;

		setLayout(null);
		  BevelBorder border=  (BevelBorder) BorderFactory.createBevelBorder(1, Color.BLACK, Color.GRAY);
		  Border b= BorderFactory.createTitledBorder(border, "Info");

	       setBorder(b);

	       global = false;
         from  = new JLabel("From:");
         to = new JLabel("To:");

         combox();
         comboFrom = new JComboBox<String>(cities);
         comboFrom.addActionListener(this);
         comboFrom.setForeground(Color.BLACK);
         comboTo = new JComboBox<>(cities);
         comboTo.addActionListener(this);
         comboTo.setForeground(Color.BLACK);
         
         
         distance = new JLabel("Distance:");
         txtDistance = new JLabel("-----");
         kms = new JLabel("Kms");
         route= new JButton("Route");
         route.addActionListener(this);
         route.setActionCommand(ROUTE);
         travel = new JButton("Travel Colombia");
         travel.addActionListener(this);
         travel.setActionCommand(TRAVEL);
         
         components();
	}
	
	public void combox () {
		
		 cities = new String[32];
		
		for (int i = 0; i < cities.length; i++) {
			cities[i] = initial.getWindow().getTravel().getCities()[i].getName();
		}
	}
	
	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public void components() {
		
		 from.setFont(new Font("Garamond", 1, 18));
		 from.setForeground(Color.WHITE);
		 from.setBounds(84, 117, 160, 40);
		 
		 
		 to.setFont(new Font("Garamond", 1, 20));
		 to.setForeground(Color.WHITE);
		 
		 to.setBounds(84, 166, 160, 40);
		 
		 comboFrom.setFont(new Font("Garamond", 1, 20));
		 comboFrom.setForeground(Color.BLACK);
		 comboFrom.setBounds(180, 117, 290, 40);
		 comboFrom.setSelectedIndex(-1);


		 
		 comboTo.setFont(new Font("Garamond", 1, 20));
		 comboTo.setForeground(Color.BLACK);
		 comboTo.setBounds(180, 168, 290, 40);
		 comboTo.setSelectedIndex(-1);
		 
		 distance.setFont(new Font("Garamond", 1, 20));
		 distance.setForeground(Color.WHITE);
		 distance.setBounds(140, 220, 160, 150);
		 
		 txtDistance.setFont(new Font("Garamond", 1, 20));
		 txtDistance.setForeground(Color.WHITE);
		 txtDistance.setBounds(244, 220, 160, 150);
		 
		 kms.setFont(new Font("Garamond", 1, 20));
		 kms.setForeground(Color.WHITE);
		 kms.setBounds(320, 220, 160, 150);
		 
		 route.setFont(new Font("Garamond", 1, 16));
		 
		 travel.setFont(new Font("Garamond", 1, 16));
		 
		 route.setBounds(198, 445, 100, 60);
		 
		 travel.setBounds(158, 630, 180, 60);
		 
		 
		
		 add(from);
		 add(comboFrom);
		 add(to);
		 add(comboTo);
		 add(distance);
		 add(txtDistance);
		 add(kms);
		 add(route);
		 add(travel);
		 
	}
	
	
	public JComboBox getComboFrom() {
		return comboFrom;
	}

	public void setComboFrom(JComboBox comboFrom) {
		this.comboFrom = comboFrom;
	}

	public JComboBox getComboTo() {
		return comboTo;
	}

	public void setComboTo(JComboBox comboTo) {
		this.comboTo = comboTo;
	}

	public JLabel getTxtDistance() {
		return txtDistance;
	}

	public void setTxtDistance(JLabel txtDistance) {
		this.txtDistance = txtDistance;
	}
     

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

         
		Graphics2D g2 = (Graphics2D) g;
	      
		g2.setColor(Color.RED.brighter().brighter());
		g2.fillOval(60, 133, 10, 10);
		g2.setColor(Color.GREEN.brighter().brighter());
		g2.fillOval(60,180,10,10);
		
		City[] cities = initial.getWindow().getTravel().getCities();

		int from = comboFrom.getSelectedIndex();
		int to = comboTo.getSelectedIndex();

		if(comboFrom.getSelectedIndex() != -1 && comboTo.getSelectedIndex() !=-1 ) {
		ArrayList<Vertex<City>> path = initial.getWindow().getTravel().getPath(new Vertex<City>(cities[from]), new Vertex<City>(cities[to]));
		String msj = "";
		double value = 0.0;
		for (int i = 0; i < path.size()-1; i++) {
			value += initial.getWindow().getTravel().getGraph().edgesBetween(path.get(i).getValue(), path.get(i+1).getValue()).get(0).getCost();
		     
			
		} 
		 msj+= Math.round(value);
		    
		txtDistance.setText(msj);
		
		}
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String a = e.getActionCommand();
		
	if	(a.equals(ROUTE)) {
		
		
		City[] cities = initial.getWindow().getTravel().getCities();

		int from = comboFrom.getSelectedIndex();
		int to = comboTo.getSelectedIndex();
		
		if(from == -1 || to == -1) {
			
			JOptionPane.showMessageDialog(this, "El origen y el destino deben ser seleccionados", "No seleccionado", JOptionPane.ERROR_MESSAGE);
		}
	
		
		else if(from == 10 || from == 24 || from ==21 || from==13 ) {
			JOptionPane.showMessageDialog(this, "Desde esta ciudad origen no hay vias terrestres hacia otra ciudad del País", "No hay vias", JOptionPane.ERROR_MESSAGE);

		}
		else if ( to ==10 || to == 24 || to==21  || to == 13) {
			JOptionPane.showMessageDialog(this, "No hay vias terrestres hacia la ciudad de destino", "No hay vias", JOptionPane.ERROR_MESSAGE);

		}
		else {
		
	   String message=	initial.getWindow().getTravel().stringPath(new Vertex<City>(cities[from]), new Vertex<City>(cities[to]));
	   //System.out.println(message);
	  // System.out.println(to );
	    JOptionPane.showMessageDialog(this, message, "Route", JOptionPane.INFORMATION_MESSAGE);
		}
		
	
	}
	   
	else if (a.equals(TRAVEL)) {
		
		global = true;
	}
	
	}
	

}
