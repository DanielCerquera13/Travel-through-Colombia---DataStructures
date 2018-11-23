package lnterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

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
	public InfoPanel(InitialPanel initial) {
		this.initial = initial;

		setLayout(null);
		  BevelBorder border=  (BevelBorder) BorderFactory.createBevelBorder(1, Color.BLACK, Color.GRAY);
		  Border b= BorderFactory.createTitledBorder(border, "Info");

	       setBorder(b);

         from  = new JLabel("From:");
         to = new JLabel("To:");
         String[] arreglo = {"a","b"};

         comboFrom = new JComboBox<String>(arreglo);
         
         comboFrom.addActionListener(this);
         comboTo = new JComboBox<>();
         comboTo.addActionListener(this);
         distance = new JLabel("Distance:");
         txtDistance = new JLabel("1500");
         kms = new JLabel("Kms");
         route= new JButton("Route");
         route.addActionListener(this);
         route.setActionCommand(ROUTE);
         travel = new JButton("Travel Colombia");
         travel.addActionListener(this);
         travel.setActionCommand(TRAVEL);
         
         components();
	}
	
	public void components() {
		
		 from.setFont(new Font("Garamond", 1, 18));
		 from.setForeground(Color.WHITE);
		 from.setBounds(104, 89, 160, 150);
		 
		 
		 to.setFont(new Font("Garamond", 1, 20));
		 to.setForeground(Color.WHITE);
		 to.setBounds(124, 130, 160, 150);
		 
		 comboFrom.setFont(new Font("Garamond", 1, 20));
		 comboFrom.setForeground(Color.WHITE);
		 comboFrom.setBounds(216, 117, 180, 100);
		 comboFrom.setSelectedIndex(-1);


		 
		 comboTo.setFont(new Font("Garamond", 1, 20));
		 comboTo.setForeground(Color.WHITE);
		 comboTo.setBounds(216, 158, 180, 100);
		 
		 distance.setFont(new Font("Garamond", 1, 20));
		 distance.setForeground(Color.WHITE);
		 distance.setBounds(140, 220, 160, 150);
		 
		 txtDistance.setFont(new Font("Garamond", 1, 20));
		 txtDistance.setForeground(Color.WHITE);
		 txtDistance.setBounds(244, 220, 160, 150);
		 
		 kms.setFont(new Font("Garamond", 1, 20));
		 kms.setForeground(Color.WHITE);
		 kms.setBounds(310, 220, 160, 150);
		 
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
