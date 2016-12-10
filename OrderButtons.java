import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class OrderButtons extends JPanel {
	
	// variable initializers
	private JButton enterItemButton;
	private JButton totalOrderButton;
	private JButton newOrderButton;
	private double coffeeRunningTotal;
	private String coffeeDescription;
	private double bagelTotal;
	private String bagelDescription;
	private double subtotal = 0;
	// generates a number formatter based on the local currency
	private NumberFormat formatter = NumberFormat.getCurrencyInstance();
	// sets the sales tax as final as it will not change
	private final double SALES_TAX = 0.08;
	private double total;
	private String pastryDescription;
	private double pastryTotal;
	
	// creates the order buttons and adds their individual listeners to them as well as
	// adding them to the OrderButton panel
	public OrderButtons() {
		enterItemButton = new JButton("Enter Item");
		totalOrderButton = new JButton("Total Order");
		newOrderButton = new JButton("New Order");
		
		enterItemButton.addActionListener(new EnterItemListener());
		totalOrderButton.addActionListener(new TotalOrderListener());
		newOrderButton.addActionListener(new NewOrderListener());

		add(enterItemButton);
		add(totalOrderButton);
		add(newOrderButton);
	}
	
	// enters the item onto the reel based on whether it is coffee, a bagel, or a pastry
	private class EnterItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (CoffeeShop.currentSelected) {
			case("coffee"): {
				coffeeRunningTotal = CoffeeChoice.getRunningTotal();
				coffeeDescription = CoffeeChoice.getCoffeeDescription();
				CoffeeShop.tapePanel.appendSetter(coffeeDescription);
				CoffeeShop.tapePanel.appendSetter(formatter.format(coffeeRunningTotal));
				// subtotal keeps a running total of the total amount of money
				subtotal = subtotal + coffeeRunningTotal;
				break;
			}
			case ("bagel"): {
				bagelTotal = BagelChoice.getBagelPrice();
				bagelDescription = BagelChoice.getBagelDescription();
				CoffeeShop.tapePanel.appendSetter(bagelDescription);
				CoffeeShop.tapePanel.appendSetter(formatter.format(bagelTotal));
				subtotal = subtotal + bagelTotal;
				break;
			}
			case ("pastry"): {
				pastryTotal = PastryChoice.getPastryTotal();
				pastryDescription = PastryChoice.getPastryDescription();
				CoffeeShop.tapePanel.appendSetter(pastryDescription);
				CoffeeShop.tapePanel.appendSetter(formatter.format(pastryTotal));
				subtotal = subtotal + pastryTotal;
				break;
			}
			}
		}
	}

	// multiplies the subtotal by the sales tax + 1 and appends it to the reel
	private class TotalOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			total = subtotal * (1 + SALES_TAX);
			CoffeeShop.tapePanel.appendSetter(formatter.format(total));
		}
	}
	
	// clears the reel by calling the clearReel() method and sets the subtotal and total to 0
	private class NewOrderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CoffeeShop.tapePanel.clearReel();
			subtotal = 0;
			total = 0;
		}
	}
}