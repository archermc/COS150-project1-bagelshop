import javax.swing.*;

@SuppressWarnings("serial")
public class DescriptionPanel extends JPanel {
	
	// variable initializer
	private JLabel titleLabel;
	
	// constructor that simply creates a JLabel and adds it to the panel
	public DescriptionPanel() {
		titleLabel = new JLabel("Order Entry Screen");
		add(titleLabel);
	}
}
