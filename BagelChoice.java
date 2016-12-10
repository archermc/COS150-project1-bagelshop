import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BagelChoice extends JPanel {
	
	// variable initialization
	private JPanel bagelPanel;
	private ButtonGroup bagelGroup;
	private JRadioButton bagelWhite;
	private JRadioButton bagelWheat;
	private JRadioButton bagelSalt;
	private JRadioButton bagelSesame;
	private JRadioButton bagelPoppy;
	
	private JPanel spreadPanel;
	private ButtonGroup spreadGroup;
	private JRadioButton spreadCreamCheese;
	private JRadioButton spreadLowFatCreamCheese;
	private JRadioButton spreadGarlicCreamCheese;
	private JRadioButton spreadButter;
	private JRadioButton spreadJam;
	
	private JPanel toppingsPanel;
	private ButtonGroup toppingsGroup;
	private JRadioButton toppingsLox;
	private JRadioButton toppingsNovaLox;
	
	// initializes these as the default values for the bagel description
	private static String bagelDescription = "White Bagel with ";
	private static String spreadDescription = "Cream Cheese Spread";
	private static String toppingsDescription = "";
	
	// intializes these as the default values for the bagel price
	private double bagelPrice = 1.37;
	private static double bagelTotal = 1.37;
	
	// constructor creates each panel, and then creates a grid layout and adds the panels vertically
	public BagelChoice() {
		createBagelPanel();
		createSpreadPanel();
		createToppingsPanel();
		
		setLayout(new GridLayout(3,1));
		
		add(bagelPanel);
		add(spreadPanel);
		add(toppingsPanel);
	}
	
	// creates the bagel panel with the white bagel as the default option
	private void createBagelPanel() {
		bagelWhite = new JRadioButton("White", true);
		bagelWheat = new JRadioButton("Wheat");
		bagelSalt = new JRadioButton("Salt");
		bagelSesame = new JRadioButton("Sesame");
		bagelPoppy = new JRadioButton("Poppy");
		
		bagelGroup = new ButtonGroup();
		bagelGroup.add(bagelWhite);
		bagelGroup.add(bagelWheat);
		bagelGroup.add(bagelSalt);
		bagelGroup.add(bagelSesame);
		bagelGroup.add(bagelPoppy);
		
		bagelWhite.addActionListener(new BagelListener());
		bagelWheat.addActionListener(new BagelListener());
		bagelSalt.addActionListener(new BagelListener());
		bagelSesame.addActionListener(new BagelListener());
		bagelPoppy.addActionListener(new BagelListener());
		
		bagelPanel = new JPanel();
		bagelPanel.setLayout(new GridLayout(5,1));
		
		bagelPanel.add(bagelWhite);
		bagelPanel.add(bagelWheat);
		bagelPanel.add(bagelSalt);
		bagelPanel.add(bagelSesame);
		bagelPanel.add(bagelPoppy);
		bagelPanel.setBorder(BorderFactory.createTitledBorder("Bagel"));
	}
	
	// creates the spread panel with the cream cheese option as the default selected
	private void createSpreadPanel() {
		
		spreadCreamCheese = new JRadioButton("Cream Cheese", true);
		spreadLowFatCreamCheese = new JRadioButton("Low Fat Cream Cheese");
		spreadGarlicCreamCheese = new JRadioButton("Garlic Cream Cheese");
		spreadButter = new JRadioButton("Butter");
		spreadJam = new JRadioButton("Jam");
		
		spreadGroup = new ButtonGroup();
		spreadGroup.add(spreadCreamCheese);
		spreadGroup.add(spreadLowFatCreamCheese);
		spreadGroup.add(spreadGarlicCreamCheese);
		spreadGroup.add(spreadButter);
		spreadGroup.add(spreadJam);
		
		spreadCreamCheese.addActionListener(new SpreadListener());
		spreadLowFatCreamCheese.addActionListener(new SpreadListener());
		spreadGarlicCreamCheese.addActionListener(new SpreadListener());
		spreadButter.addActionListener(new SpreadListener());
		spreadJam.addActionListener(new SpreadListener());
		
		spreadPanel = new JPanel();
		spreadPanel.setLayout(new GridLayout(5,1));
		
		spreadPanel.add(spreadCreamCheese);
		spreadPanel.add(spreadLowFatCreamCheese);
		spreadPanel.add(spreadGarlicCreamCheese);
		spreadPanel.add(spreadButter);
		spreadPanel.add(spreadJam);
		spreadPanel.setBorder(BorderFactory.createTitledBorder("Spread"));
	}
	
	// creates the toppings panel and adds the toppings to the panel.  I changed the original format of
	// check boxes to radio buttons, as it didn't make sense to have both lox and nova lox on your bagel
	private void createToppingsPanel() {
		
		toppingsLox = new JRadioButton("Lox");
		toppingsNovaLox = new JRadioButton("Nova Lox");
		
		toppingsGroup = new ButtonGroup();
		toppingsGroup.add(toppingsLox);
		toppingsGroup.add(toppingsNovaLox);
		
		toppingsLox.addActionListener(new ToppingsListener());
		toppingsNovaLox.addActionListener(new ToppingsListener());
		
		toppingsPanel = new JPanel();
		toppingsPanel.setLayout(new GridLayout(2,1));
		
		toppingsPanel.add(toppingsLox);
		toppingsPanel.add(toppingsNovaLox);
		
		toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
	}
	
	// Action listener for the bagel panel that assigns certain values to the bagelDescription
	// variable based on which bagel you choose
	private class BagelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (bagelWhite.isSelected()) {
				bagelDescription = "White Bagel with ";
			}
			if (bagelWheat.isSelected()) {
				bagelDescription = "Wheat Bagel with ";
			}
			if (bagelSalt.isSelected()) {
				bagelDescription = "Salt Bagel with ";
			}
			if (bagelSesame.isSelected()) {
				bagelDescription = "Sesame Bagel with ";
			}
			if (bagelPoppy.isSelected()) {
				bagelDescription = "Poppy Bagel with ";
			}
		}
	}
	
	// Action listener for the spread panel that assigns different values to the spreadDescription
	// variable based on the choice of the radio button
	private class SpreadListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (spreadCreamCheese.isSelected()) {
				spreadDescription = "Cream Cheese Spread ";
			}
			if (spreadLowFatCreamCheese.isSelected()) {
				spreadDescription = "Low Fat Cream Cheese Spread ";
			}
			if (spreadGarlicCreamCheese.isSelected()) {
				spreadDescription = "Garlic Cream Cheese Spread ";
			}
			if (spreadButter.isSelected()) {
				spreadDescription = "Butter Spread ";
			}
			if (spreadJam.isSelected()) {
				spreadDescription = "Jam Spread ";
			}
		}
	}
	
	// action listener for the toppings that changes topppingsDescription based on which Lox is chosen
	private class ToppingsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (toppingsLox.isSelected()) {
				toppingsDescription = "and Lox ";
			}
			if (toppingsNovaLox.isSelected()) {
				toppingsDescription = "and Nova Lox";
			}
			// if a lox is chosen, add 50 cents to bagel price
			bagelTotal = bagelPrice + .50;
		}
	}
	
	// getter for the bagel price
	public static double getBagelPrice() {
		return bagelTotal;
	}
	
	//getter for the bagel description
	public static String getBagelDescription() {
		return bagelDescription + spreadDescription + toppingsDescription;
	}
}