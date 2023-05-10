package ButtonsAndListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
	//Declaring variables, Panels, Buttons, Labels & fonts to be used later on
	JLabel calcDisplay;
	JTextField calcInput;
	JButton allClear,Add,Subtract,Multiply,Divide;
	JPanel displayPanel, calcButtons;
	private Font displayFont = new Font("Serif",Font.PLAIN,40);

	//Create Accumulator to keep track of value, and variables to store the input and results
	String Accumulator; 
	double textValue;
	double resultValue;

	//Constructor for Calculator class
	public Calculator() {

		//Set dimensions and layout for the frame, display and buttons
		setLayout(new GridLayout(2,1));
		displayPanel = new JPanel(new GridLayout(2,1));
		calcButtons = new JPanel(new GridLayout(1,5));

		//Create new text field and label, align, set font and add action listener to constantly check for 
		// user interaction
		calcInput = new JTextField();
		calcInput.setHorizontalAlignment(JTextField.RIGHT);
		calcInput.addActionListener(this);
		calcInput.setFont(displayFont);

		calcDisplay = new JLabel();
		calcDisplay.setHorizontalAlignment(JLabel.RIGHT);
		calcDisplay.setText(String.valueOf(0));
		calcDisplay.setFont(displayFont);

		//Adds calcDisplay and calcInput to the JPanel
		displayPanel.add(calcDisplay);
		displayPanel.add(calcInput);

		//Create buttons for Clear, add, sub, mult, div
		allClear = setUpButton("AC");
		calcButtons.add(allClear);

		Add = setUpButton("+");
		calcButtons.add(Add);

		Subtract = setUpButton("-");
		calcButtons.add(Subtract);

		Multiply = setUpButton("*");
		calcButtons.add(Multiply);

		Divide = setUpButton("/");
		calcButtons.add(Divide);
		//---------------------

		//Display buttons and calculator screen
		add(displayPanel);
		add(calcButtons);
	}

	//Sets parameters for all the buttons in the calculator
	public JButton setUpButton(String s){
		JButton b = new JButton(s);
		b.setFont(displayFont);
		b.setBackground(Color.white);
		b.setSize(2,5);
		b.addActionListener(this);
		return(b);
	}

	public void actionPerformed(ActionEvent e) { 
		if(calcInput.getText()== "") {
			Accumulator = "0";
			calcInput.setText("0");
		}

		//Restricts text value to number
		textValue= Double.parseDouble(calcInput.getText());

		//Sets calculator display to 0 when AC button is clicked 
		if(e.getSource()==allClear) //clears text field
		{
			Accumulator = "0";
			calcInput.setText("");
			calcDisplay.setText(Accumulator);
		}
		//Add function which adds the textvalue to the 
		//previous value that was stored in accumulator 
		else if(e.getSource()==Add) {							
			resultValue = Double.parseDouble(calcDisplay.getText()); 
			textValue = resultValue + textValue;
			Accumulator = Double.toString(textValue);
			calcDisplay.setText(Accumulator);
			calcInput.setText("");

			//Subtraction function which subtracts the textvalue to the 
			//previous value that was stored in accumulator 
		}	else if(e.getSource()==Subtract) {							
			resultValue = Double.parseDouble(calcDisplay.getText());
			textValue = resultValue - textValue;
			Accumulator = Double.toString(textValue);
			calcDisplay.setText(Accumulator);
			calcInput.setText("");

			//Multiplication function which Multiplies the textvalue to the 
			//previous value that was stored in accumulator 
		}	else if(e.getSource()==Multiply)  {							
			resultValue = Double.parseDouble(calcDisplay.getText());
			textValue = resultValue * textValue;
			Accumulator = Double.toString(textValue);
			calcDisplay.setText(Accumulator);
			calcInput.setText("");

			//Division function which divides the textvalue to the 
			//previous value that was stored in accumulator 
		}	else if(e.getSource()==Divide) {							
			resultValue = Double.parseDouble(calcDisplay.getText());
			textValue = resultValue / textValue;
			Accumulator = Double.toString(textValue);
			calcDisplay.setText(Accumulator);
			calcInput.setText("");
		}
	}
}
