import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CoffeeShop extends JFrame {
	
	// variable initialization
	static ButtonPanel radioButtonPanel;
	static OrderButtons lowerButtons;
	static DescriptionPanel topDescPanel;
	static CoffeeChoice coffeePanel;
	static ProductReel tapePanel;
	static String currentSelected;
	static BagelChoice bagelPanel;
	static PastryChoice pastryPanel;
	static CoffeeShop shopFrame;
	
	// window dimensions
	private final int WINDOW_WIDTH = 600;
	private final int WINDOW_HEIGHT = 450;
	
	// constructor to set title, size, close operation, build the panel, and change the look and feel
	public CoffeeShop() {
		setTitle("Red Giraffe Coffee Order Entry Screen");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		// changes the look and feel to the windows theme
		try
		{
		  UIManager.setLookAndFeel(
		    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception e)
		{
		  JOptionPane.showMessageDialog(null,
		       "Error setting the look and feel.");
		  System.exit(0);
		}
		// sets visibility to true
		setVisible(true);
	}

	public static void main(String[] args) {
		// instantiates the GUI
		shopFrame = new CoffeeShop();
	}
	
	// builds the Frame using the various panels created
	private void buildPanel() {
		// sets the product selection buttons to the left
		radioButtonPanel = new ButtonPanel();
		add(radioButtonPanel, BorderLayout.WEST);
		
		// sets the order function buttons on the bottom of the screen
		lowerButtons = new OrderButtons();
		add(lowerButtons, BorderLayout.SOUTH);
		
		// sets the panel with the description at the top of the screen
		topDescPanel = new DescriptionPanel();
		add(topDescPanel, BorderLayout.NORTH);
		
		// sets the center coffee panel by default in the center
		coffeePanel = new CoffeeChoice();
		add(coffeePanel, BorderLayout.CENTER);
		// sets the currentSelected variable to "coffee" to keep track of which panel is in the center
		currentSelected = "coffee";
		
		// places the tape reel in the right side of the frame
		tapePanel = new ProductReel();
		add(tapePanel, BorderLayout.EAST);
	}
	
	// the method that changes the center panel to the Bagel panel
	// behaves differently depending on which panel is in the center
	public void changeToBagel() {
		if (currentSelected == "coffee") {
			coffeePanel.setVisible(false);
			remove(coffeePanel);
			bagelPanel = new BagelChoice();
			add(bagelPanel, BorderLayout.CENTER);
			bagelPanel.setVisible(true);
			currentSelected = "bagel";
		} else if (currentSelected == "pastry") {
			pastryPanel.setVisible(false);
			remove(pastryPanel);
			bagelPanel = new BagelChoice();
			add(bagelPanel, BorderLayout.CENTER);
			bagelPanel.setVisible(true);
			currentSelected = "bagel";
		}
	}
	
	// method that changes the panel to the pastry panel
	public void changeToPastry() {
		if (currentSelected == "coffee") {
			coffeePanel.setVisible(false);
			remove(coffeePanel);
			pastryPanel = new PastryChoice();
			add(pastryPanel, BorderLayout.CENTER);
			pastryPanel.setVisible(true);
			currentSelected = "pastry";
		} else if (currentSelected == "bagel") {
			bagelPanel.setVisible(false);
			remove(bagelPanel);
			pastryPanel = new PastryChoice();
			add(pastryPanel, BorderLayout.CENTER);
			pastryPanel.setVisible(true);
			currentSelected = "pastry";
		}
	}
	
	// method that changes the center panel to the coffee panel
	public void changeToCoffee() {
		if (currentSelected == "bagel") {
			bagelPanel.setVisible(false);
			remove(bagelPanel);
			coffeePanel = new CoffeeChoice();
			add(coffeePanel, BorderLayout.CENTER);
			coffeePanel.setVisible(true);
			currentSelected = "coffee";
		} else if (currentSelected == "pastry") {
			pastryPanel.setVisible(false);
			remove(pastryPanel);
			coffeePanel = new CoffeeChoice();
			add(coffeePanel, BorderLayout.CENTER);
			coffeePanel.setVisible(true);
			currentSelected = "coffee";
		}
	}
 }