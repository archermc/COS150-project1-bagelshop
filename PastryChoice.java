import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class PastryChoice extends JPanel {
	
	// variable initialization
	private JList<String> pastryList;
	private String[] pastryArray = { "Apricot Danish", "Prune Danish", "Croissant", "English Muffin", "Blueberry Muffin" };
	private static String tastyTreat; // yum
	private static double treatPrice;
	
	// constructor that creates the list, assigns it Single Selection Mode, adds the listener to it, and adds it to the panel
	public PastryChoice() {
		
		pastryList = new JList<String>(pastryArray);
		pastryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pastryList.addListSelectionListener(new PastryListListener());
		
		add(pastryList);
		setBorder(BorderFactory.createTitledBorder("Pastry"));
	}
	
	// getter for pastry description
	public static String getPastryDescription() {
		return tastyTreat;
	}
	
	// getter for pastry price
	public static double getPastryTotal() {
		return treatPrice;
	}
	
	// assigns a different price and desription to different pastry delights
	// uses !e.getValueIsAdjusting so that the price isn't taken twice
	private class PastryListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				// casts object reference to a string
				String selectedName = (String)pastryList.getSelectedValue();
				switch (selectedName) {
				case("Apricot Danish"): {
					tastyTreat = selectedName;
					treatPrice = 2.35;
					break;
				}
				case("Prune Danish"): {
					tastyTreat = selectedName;
					treatPrice = 2.65;
					break;
				}
				case("Croissant"): {
					tastyTreat = selectedName;
					treatPrice = 1.95;
					break;
				}
				case("English Muffin"): {
					tastyTreat = selectedName;
					treatPrice = 2.05;
					break;
				}
				case("BlueberryMuffin"): {
					tastyTreat = selectedName;
					treatPrice = 2.05;
					break;
				}
				}
			}
		}
	}
}