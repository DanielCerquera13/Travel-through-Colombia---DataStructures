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
         comboFrom = new JComboBox<>();
         comboFrom.addActionListener(this);
         comboTo = new JComboBox<>();
         comboTo.addActionListener(this);
         distance = new JLabel("Distance:");
         txtDistance = new JLabel("");
         kms = new JLabel("Kms");
         route= new JButton(ROUTE);
         route.addActionListener(this);
         route.setActionCommand(ROUTE);
         travel = new JButton(TRAVEL);
         travel.addActionListener(this);
         travel.setActionCommand(TRAVEL);
	}
	
	public void components() {
		
		 from.setFont(new Font("Garamond", 1, 20));
		 from.setForeground(Color.WHITE);
		 
		 to.setFont(new Font("Garamond", 1, 20));
		 to.setForeground(Color.WHITE);
		 
		 comboFrom.setFont(new Font("Garamond", 1, 20));
		 comboFrom.setForeground(Color.WHITE);
		 
		 comboTo.setFont(new Font("Garamond", 1, 20));
		 comboTo.setForeground(Color.WHITE);
		 
		 distance.setFont(new Font("Garamond", 1, 20));
		 distance.setForeground(Color.WHITE);
		 
		 txtDistance.setFont(new Font("Garamond", 1, 20));
		 txtDistance.setForeground(Color.WHITE);
		 
		 kms.setFont(new Font("Garamond", 1, 20));
		 kms.setForeground(Color.WHITE);
		 
		 route.setFont(new Font("Garamond", 1, 20));
		 route.setForeground(Color.WHITE);
		 
		 travel.setFont(new Font("Garamond", 1, 20));
		 travel.setForeground(Color.WHITE);
		 
		 
		 
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
