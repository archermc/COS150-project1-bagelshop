import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {

	// variable initializers
	JRadioButton coffeeButton;
	private JRadioButton bagelButton;
	private JRadioButton pastryButton;
	private ButtonGroup radioButtonGroup;
	
	// constructor for the button panel.  creates the buttons, adds listeners to them, and adds them to the panel
	public ButtonPanel() {
		
		coffeeButton = new JRadioButton("Coffee", true);
		bagelButton = new JRadioButton("Bagel");
		pastryButton = new JRadioButton("Pastry");
		
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(coffeeButton);
		radioButtonGroup.add(bagelButton);
		radioButtonGroup.add(pastryButton);
		
		coffeeButton.addActionListener(new ButtonListener());
		bagelButton.addActionListener(new ButtonListener());
		pastryButton.addActionListener(new ButtonListener());
		
		setLayout(new GridLayout(3,1));
		
		add(coffeeButton);
		add(bagelButton);
		add(pastryButton);
		setBorder(BorderFactory.createTitledBorder("Products"));
	}

	// Listener class for the buttons.  Calls the methods to change the panel depending on which button
	// is selected
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (coffeeButton.isSelected()) {
				CoffeeShop.shopFrame.changeToCoffee();
			} else if (bagelButton.isSelected()) {
				CoffeeShop.shopFrame.changeToBagel();
			} else if (pastryButton.isSelected()) {
				CoffeeShop.shopFrame.changeToPastry();
			}
		}
	}
}