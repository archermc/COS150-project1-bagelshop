import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CoffeeChoice extends JPanel {
	
	// variable initializers
	private JPanel sizePanel;
	private JPanel roastPanel;
	private JPanel flavoringPanel;
	
	private JRadioButton sizeTall;
	private JRadioButton sizeGrande;
	private JRadioButton sizeVenti;
	private ButtonGroup sizeGroup;
	
	private JRadioButton roastLight;
	private JRadioButton roastMedium;
	private JRadioButton roastDark;
	private JRadioButton roastDecaf;
	private ButtonGroup roastGroup;
	
	private JCheckBox flavoringVanilla;
	private JCheckBox flavoringMocha;
	private JCheckBox flavoringHazelnut;
	private JCheckBox flavoringRaspberry;
	private JCheckBox flavoringCaramel;
	
	private double sizeTotal = 2.00;
	private double flavoringTotal = 0;
	private static double runningTotal = 2.00;
	
	// sets the default for the coffee
	private static String sizeDescription = "Grande ";
	private static String roastDescription = "Medium Roast ";
	private static String flavoringDescription = "";
	
	// constructor creates the size, roast, and flavoring panel, and places them on a grid layout
	// in vertical order
	public CoffeeChoice() {
		createSizePanel();
		createRoastPanel();
		createFlavoringPanel();
		
		setLayout(new GridLayout(3,1));
		
		add(sizePanel);
		add(roastPanel);
		add(flavoringPanel);
	}
	
	// method that creates the size panel with the radio buttons, adds the listeners to them, and sets
	// them vertically with a border around them
	private void createSizePanel() {
		sizeTall = new JRadioButton("Tall");
		sizeGrande = new JRadioButton("Grande", true);
		sizeVenti = new JRadioButton("Venti");
		
		sizeGroup = new ButtonGroup();
		sizeGroup.add(sizeTall);
		sizeGroup.add(sizeGrande);
		sizeGroup.add(sizeVenti);
		
		sizeTall.addActionListener(new SizeListener());
		sizeGrande.addActionListener(new SizeListener());
		sizeVenti.addActionListener(new SizeListener());
		
		sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(3,1));
		
		sizePanel.add(sizeTall);
		sizePanel.add(sizeGrande);
		sizePanel.add(sizeVenti);
		sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
	}
	
	// creates the roast panel with the various radio buttons (with medium already selected) and
	// adds the listeners and adds them to the panel
	private void createRoastPanel() {
		roastLight = new JRadioButton("Light");
		roastMedium = new JRadioButton("Medium", true);
		roastDark = new JRadioButton("Dark");
		roastDecaf = new JRadioButton("Decaf");
		
		roastGroup = new ButtonGroup();
		roastGroup.add(roastLight);
		roastGroup.add(roastMedium);
		roastGroup.add(roastDark);
		roastGroup.add(roastDecaf);
		
		roastLight.addActionListener(new RoastListener());
		roastMedium.addActionListener(new RoastListener());
		roastDark.addActionListener(new RoastListener());
		roastDecaf.addActionListener(new RoastListener());
		
		roastPanel = new JPanel();
		roastPanel.setLayout(new GridLayout(4,1));
		
		roastPanel.add(roastLight);
		roastPanel.add(roastMedium);
		roastPanel.add(roastDark);
		roastPanel.add(roastDecaf);
		roastPanel.setBorder(BorderFactory.createTitledBorder("Roast"));
	}
	
	// adds check marks with varying flavors to put in your coffee
	private void createFlavoringPanel() {
		flavoringVanilla = new JCheckBox("Vanilla");
		flavoringMocha = new JCheckBox("Mocha");
		flavoringHazelnut = new JCheckBox("Hazelnut");
		flavoringRaspberry = new JCheckBox("Raspberry");
		flavoringCaramel = new JCheckBox("Caramel");
		
		flavoringVanilla.addItemListener(new FlavoringListener());
		flavoringMocha.addItemListener(new FlavoringListener());
		flavoringHazelnut.addItemListener(new FlavoringListener());
		flavoringRaspberry.addItemListener(new FlavoringListener());
		flavoringCaramel.addItemListener(new FlavoringListener());
		
		flavoringPanel = new JPanel();
		flavoringPanel.setLayout(new GridLayout(5,1));
		
		flavoringPanel.add(flavoringVanilla);
		flavoringPanel.add(flavoringMocha);
		flavoringPanel.add(flavoringHazelnut);
		flavoringPanel.add(flavoringRaspberry);
		flavoringPanel.add(flavoringCaramel);
		flavoringPanel.setBorder(BorderFactory.createTitledBorder("Flavoring"));
	}
	
	// the listener for the size panel.  Gives price and descriptive information for different sizes
	private class SizeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sizeTall.isSelected()) {
				sizeTotal = 1.50;
				sizeDescription = "Tall ";
			}
			else if (sizeGrande.isSelected()) {
				sizeTotal = 2.00;
				sizeDescription = "Grande ";
			}
			else if (sizeVenti.isSelected()) {
				sizeTotal = 2.50;
				sizeDescription = "Venti ";
			}
			// saves the total of the coffee currently
			runningTotal = sizeTotal + flavoringTotal;
		}
	}
	
	// listener for the flavoring.  each time it is called, updates the total flavoring cost
	private class FlavoringListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
				flavoringTotal = 0;
				flavoringDescription = "";
				if (flavoringVanilla.isSelected()) {
					flavoringTotal = flavoringTotal + .40;
					flavoringDescription = flavoringDescription + "Vanilla ";
				}
				if (flavoringMocha.isSelected()) {
					flavoringTotal = flavoringTotal + .40;
					flavoringDescription = flavoringDescription + "Mocha ";
				}
				if (flavoringHazelnut.isSelected()) {
					flavoringTotal = flavoringTotal + .40;
					flavoringDescription = flavoringDescription + "Hazelnut ";
				}
				if (flavoringRaspberry.isSelected()) {
					flavoringTotal = flavoringTotal + .40;
					flavoringDescription = flavoringDescription + "Raspberry ";
				}
				if (flavoringCaramel.isSelected()) {
					flavoringTotal = flavoringTotal + .40;
					flavoringDescription = flavoringDescription + "Caramel ";
				}
				// updates the current total
				runningTotal = sizeTotal + flavoringTotal;
		}
	}
	
	// listener for the roast simply to add descriptive information to the reel
	private class RoastListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (roastLight.isSelected()) {
				roastDescription = "Light Roast ";
			}
			if (roastMedium.isSelected()) {
				roastDescription = "Medium Roast ";
			}
			if (roastDark.isSelected()) {
				roastDescription = "Dark Roast ";
			}
			if (roastDecaf.isSelected()) {
				roastDescription = "Decaf ";
			}
		}
	}
	
	// getter for the coffe description
	public static String getCoffeeDescription() {
		return sizeDescription + roastDescription + flavoringDescription + "Coffee";
	}
	
	//getter for the coffee price
	public static double getRunningTotal() {
		return runningTotal;
	}
}