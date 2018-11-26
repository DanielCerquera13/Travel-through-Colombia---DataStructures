package lnterface;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import dataStructures.MethodsGraphs;
import dataStructures.Vertex;
import model.City;
import model.Highway;

public class InfoPanel extends JPanel implements ActionListener {
	
	/**
	 * variable constante para el boto  route
	 */
	public final static String ROUTE = "Route";
	/**
	 * variable constante para el boton travel
	 */
	public final static String TRAVEL = "Travel Colombia";
	/**
	 * variable constante para el boton clear
	 */
	public final static String CLEAR = "CLEAR";

	public static final String GRAPH = "GRAPH";
	
	/**
	 * Label para indicar ciudad de inicio
	 */
	private JLabel from;
	/**
	 * Label para indicar ciudad de destino
	 */
	private JLabel to;
	/**
	 * Lista de las ciudades de inicio
	 */
	private JComboBox comboFrom;
	/**
	 * Lista de las ciudades de destino
	 */
	private JComboBox comboTo;
	/**
	 * Label para indicar distancia entre un par de distancia en kilometros
	 */
	private JLabel distance;
	/**
	 * Area donde se visualizara la distancia total
	 */
	private JLabel txtDistance;
	/**
	 * Label para indicar la unidad de medida de la distancia
	 */
	private JLabel kms;
	/**
	 * Boton de la funcionalidad Route
	 */
	private JButton route;
	/**
	 * Boton de la funcionalidad Travel
	 */
	private JButton travel;
	/**
	 * Relacion con el panel InitialPanel
	 */
	private InitialPanel initial;
	/**
	 * arreglo de las ciudades del grafo
	 */
	private String[] cities;
	/**
	 * variable de tipo boolean para indicar cuando pintar el metodo kruskal
	 */
	private boolean global;
	/**
	 * Boton para la funcionalidad Clear
	 */
	private JButton clear;
	
	private JButton graph;
	
	/**
	 * Constructor de la clase InfoPanel
	 * @param initial - panel initialPanel
	 */
	public InfoPanel(InitialPanel initial) {
		this.initial = initial;

		setLayout(null);
		  BevelBorder border=  (BevelBorder) BorderFactory.createBevelBorder(1, Color.BLACK, Color.GRAY);
		  Border b= BorderFactory.createTitledBorder(border, "Info");

	       setBorder(b);

	       global = false;
         from  = new JLabel("From:");
         to = new JLabel("To:");
         clear= new JButton("Clear");
         clear.addActionListener(this);
         clear.setActionCommand(CLEAR);
         combox();
         comboFrom = new JComboBox<String>(cities);
         comboFrom.addActionListener(this);
         comboFrom.setForeground(Color.BLACK);
         comboTo = new JComboBox<>(cities);
         comboTo.addActionListener(this);
         comboTo.setForeground(Color.BLACK);
         
         graph = new JButton("Graph");         
         
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
	/**
	 * Metodo que rellena los comboTo y los comboFrom
	 */
	public void combox () {
		
		 cities = new String[32];
		
		for (int i = 0; i < cities.length; i++) {
			cities[i] = initial.getWindow().getTravel().getCities()[i].getName();
		}
	}
	
	/**
	 * Entrega la variabla global de tipo boolean
	 * @return valor falso verdadero
	 */
	public boolean isGlobal() {
		return global;
	}

	/**
	 * Modifica la variable global
	 * @param global - variable con el nuevo valor boolean
	 */
	public void setGlobal(boolean global) {
		this.global = global;
	}

	/**
	 * Metodo que inicializa los componentes
	 */
	public void components() {
		
		 from.setFont(new Font("Garamond", 1, 18));
		 from.setForeground(Color.WHITE);
		 from.setBounds(84, 117, 160, 40);
		 
		 graph.setFont(new Font("Garamond", 1, 18));
		 graph.setBounds(195, 60, 100, 40);
		 graph.setActionCommand(GRAPH);
		 graph.addActionListener(this);
		 graph.setToolTipText("See all the connections between the cities.");
		 
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
		 
		 clear.setBounds(200, 220, 100, 40);
		 clear.setFont(new Font("Garamond", 1, 20));
		
		 add(from);
		 add(comboFrom);
		 add(to);
		 add(comboTo);
		 add(distance);
		 add(txtDistance);
		 add(kms);
		 add(route);
		 add(travel);
		 add(clear);
		 add(graph);
	}
	
	/**
	 * Retorna el comboFrom
	 * @return comboFrom
	 */
	public JComboBox getComboFrom() {
		return comboFrom;
	}

    /**
     * Retorna el comboTo
     * @return comboTp
     */
	public JComboBox getComboTo() {
		return comboTo;
	}

	
     /**
      * Entrega la distancia entre las ciudades o del Prim
      * @return
      */
	public JLabel getTxtDistance() {
		return txtDistance;
	}
    /**
     * Modifica el valor del Label txtDistance
     * @param txtDistance
     */
	public void setTxtDistance(JLabel txtDistance) {
		this.txtDistance = txtDistance;
	}
     
    /**
     * Metodo paintcomponent 
     */
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
	/**
	 * Metodos de la interface ActionListener
	 */
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
		comboFrom.setSelectedIndex(-1);
		comboTo.setSelectedIndex(-1);
		initial.getMap().repaint();
		MethodsGraphs<City, Highway> m = new MethodsGraphs<>();
		double msj =  m.prim(initial.getWindow().getTravel().getGraphK(), new Vertex<City>(initial.getWindow().getTravel().getCitiesK()[0]));
	    
		txtDistance.setText(Math.round(msj) + "");
	}
	
	else if (a.equals(CLEAR)) {
		
		comboFrom.setSelectedIndex(-1);
		comboTo.setSelectedIndex(-1);
		initial.getMap().repaint();
		global=false;
		txtDistance.setText("----");
		
	}else if(a.equals(GRAPH)) {
		
		JTextArea textArea = new JTextArea(initial.getWindow().getTravel().getGraph().graphToString());
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		textArea.setEditable(false);
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "Graph",  
		                                       JOptionPane.INFORMATION_MESSAGE);
		
	}
	}
	

}
