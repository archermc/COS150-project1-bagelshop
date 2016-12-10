import javax.swing.*;

@SuppressWarnings("serial")
public class ProductReel extends JPanel {
	
	// variable initialization
	private JTextArea tapeReel;
	// finds the line separator character in case user is using a different operating system than PC
	private String lineSeparator = System.getProperty( "line.separator" );
	private JScrollPane textScroll;
	
	// constructor which calls the method to build the tape and add it to the panel
	public ProductReel() {
		buildProductPanel();
		add(textScroll);
	}
	
	// a method that allows any method to append the reel.  Overloaded method to accept String and double arguments
	public void appendSetter(String text) {
		text = text + lineSeparator;
		tapeReel.append(text);
	}
	
	// the method that accepts double arguments casts the double to a string before appending it to the reel
	public void appendSetter(double number) {
		String numString = Double.toString(number);
		numString = numString + lineSeparator;
		tapeReel.append(numString);
	}
	
	// method that builds the reel panel and adds it to a scroll bar
	private void buildProductPanel() {
		tapeReel = new JTextArea(19,40);
		tapeReel.setEditable(false);
		tapeReel.setWrapStyleWord(true);
		tapeReel.setLineWrap(true);
		tapeReel.setBorder(BorderFactory.createEtchedBorder());
		
		textScroll = new JScrollPane(tapeReel);

	}
	
	// a method that allows any other object to clear the tape reel of all text
	public void clearReel() {
		tapeReel.setText("");
	}
}