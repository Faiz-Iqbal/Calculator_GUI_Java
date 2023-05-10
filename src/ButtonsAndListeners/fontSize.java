package ButtonsAndListeners;

//For using Labels, Frames and Panels etc
import javax.swing.*; 
import java.awt.*;	
import java.awt.event.*; 

public class fontSize extends JFrame implements ActionListener {
	//Declaring variables, Panels, Buttons, Labels and fonts to be used later on
	private int fontSizeval = 18;
	private JPanel fontDisplay, fontButtons;
	private JButton increase, decrease;
	private JLabel letter, fontSize;
	private Font F = new Font("Sans-Serif",Font.PLAIN,18);

	//Creating a constructor for fontSize
	public fontSize () {
		//Set panel and frame layouts
		setLayout(new GridLayout(2,2));
		fontDisplay = new JPanel (new GridLayout (1,2));

		//Create a textbox for letter X that will change size using buttons
		letter = new JLabel ("X", JLabel.RIGHT);
		letter.setFont(F);
		fontDisplay.add(letter);

		//Create a textbox for Number 18 that will display the size X is at
		fontSize = new JLabel ("18", JLabel.LEFT);
		fontSize.setFont(F);
		fontDisplay.add(fontSize);

		//Buttons called and properties set
		sizeButtons();
		fontButtons = new JPanel (new FlowLayout (1,5,5));
		fontButtons.add(increase);
		fontButtons.add(decrease);

		//Create an action listener that constantly checks if the user has pressed
		increase.addActionListener(this);
		decrease.addActionListener(this);

		//Display JPanels FOnt and buttons
		add(fontDisplay);
		add(fontButtons);


	}
	//Create new buttons
	public void sizeButtons() {
		increase = new JButton ("Increase");
		decrease = new JButton ("Decrease");
	}

	//Conditional statement that allows the increase and decrease of font
	//and does not allow the user to go below 0 font size
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == increase) {
			fontSize.setText("" + fontSizeval);
			fontSizeval++;
			letter.setFont(new Font ("Sans-Serif",Font.PLAIN,fontSizeval));

		} else if (e.getSource() == decrease && fontSizeval >=0) {
			fontSize.setText("" + fontSizeval);
			fontSizeval--;
			letter.setFont(new Font ("Sans-Serif",Font.PLAIN,fontSizeval));
		}

	}
}
