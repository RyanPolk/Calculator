package cp213;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Assignment 3 - Calculator application
 * @author: Ryan Polkiewicz (ID: 170731180)
 * @Email: polk1180@mylaurier.ca
 * @Date: October 24, 2018 
 */
public class Calculator {
	/**
	 * Action Listener associated with all numbers and mathematical actions. 
	 */
	private class ActionButtonListener implements ActionListener {
		private String value = "";
		
		//Constructor
		public ActionButtonListener(final String value) {
		    this.value = value;
		}

		@Override
		public void actionPerformed(final ActionEvent evt) {
		    txtInput.setText(txtInput.getText() + value);
		}
	}
	
	/**
	 *Action Listener associated with the 'C' button
	 */
	private class ClearButtonListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent evt) {
		    //Sets Input and Output text fields to blank
		    txtInput.setText("");
		    txtOutput.setText("");
		}
	}
	
	/**
	 *Action Listener associated with the '=' button
	 */
	private class EqualButtonListener implements ActionListener {
		@Override
		public void actionPerformed(final ActionEvent evt) {
			int count = 0;
			int position = 0;
			char sChar = ' ';
			int sPosition = 0;
			String text = "";
			double result = 0;
			
			try {
				for (char ch: txtInput.getText().toCharArray()) {
					position++;
					if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
						count++;
						sChar = ch;
						sPosition = position;
					}
				}
				
				if (count > 1 || count == 0) 
					txtOutput.setText("");
				else {
					text = txtInput.getText();
					
					switch (sChar) {
						case '+':
							result = Double.parseDouble(text.substring(0, sPosition-1)) + Double.parseDouble(text.substring(sPosition, text.length()));
							break;
						case '-':
							result = Double.parseDouble(text.substring(0, sPosition-1)) - Double.parseDouble(text.substring(sPosition, text.length()));
							break;
						case '*':
							result = Double.parseDouble(text.substring(0, sPosition-1)) * Double.parseDouble(text.substring(sPosition, text.length()));
							break;
						case '/':
							result = Double.parseDouble(text.substring(0, sPosition-1)) / Double.parseDouble(text.substring(sPosition, text.length()));
							break;
					}
					txtOutput.setText(String.valueOf(result));
				}
			}
			catch (Exception e) {
				txtOutput.setText("");
			}
		}
	}
	
	// -------------------------------------------------------------------------------
	//All variables associated with GUI construction
	private final JFrame main = new JFrame("Calculator");
	private final JPanel input = new JPanel();
	private final JLabel txtInput = new JLabel();
	private final JPanel output = new JPanel();
	private final JLabel txtOutput = new JLabel();
	private final JPanel controls = new JPanel();
	private final JButton btnZero = new JButton("0");
	private final JButton btnOne = new JButton("1");
	private final JButton btnTwo = new JButton("2");
	private final JButton btnThree = new JButton("3");
	private final JButton btnFour = new JButton("4");
	private final JButton btnFive = new JButton("5");
	private final JButton btnSix = new JButton("6");
	private final JButton btnSeven = new JButton("7");
	private final JButton btnEight = new JButton("8");
	private final JButton btnNine = new JButton("9");
	private final JButton btnClear = new JButton("C");
	private final JButton btnPlus = new JButton("+");
	private final JButton btnMinus = new JButton("-");
	private final JButton btnMultiply = new JButton("*");
	private final JButton btnDivide = new JButton("/");
	private final JButton btnEquals = new JButton("=");
	// -------------------------------------------------------------------------------
	
	/**
	 * Main method which starts the program
	 * @param args
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Calculator calc = new Calculator();
	}
	
	/**
	 * Constructor for calculator class, calls setup for GUI.
	 */
	public Calculator() {
		this.setForm();
		this.registerListeners();
	}
	
	/**
	 * Set's up JFrame, JPanels, JLabels, and JButtons.
	 */
	public void setForm() {
		///main frame setup
		main.setSize(300, 390);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//input panel setup
		input.setBackground(Color.lightGray);
		input.setBorder(new TitledBorder(new LineBorder(Color.black, 2),"Input"));
		input.setPreferredSize(new Dimension(300, 85));
		input.add(txtInput);
		//output panel setup
		output.setBackground(Color.lightGray);
		output.setBorder(new TitledBorder(new LineBorder(Color.black, 2),"Output"));
		output.setPreferredSize(new Dimension(300, 100));
		output.add(txtOutput);
		//controls panel setup
		controls.setBackground(Color.lightGray);
		controls.setPreferredSize(new Dimension(300,200));
		controls.setLayout(new GridLayout(4, 5));
		//Adding of all button controls
		controls.add(btnSeven);
		controls.add(btnEight);
		controls.add(btnNine);
		controls.add(btnDivide);
		controls.add(btnClear);
		controls.add(btnFour);
		controls.add(btnFive);
		controls.add(btnSix);
		controls.add(btnMultiply);
		controls.add(new JButton());
		controls.add(btnOne);
		controls.add(btnTwo);
		controls.add(btnThree);
		controls.add(btnMinus);
		controls.add(new JButton());
		controls.add(new JButton());
		controls.add(btnZero);
		controls.add(new JButton());
		controls.add(btnPlus);
		controls.add(btnEquals);
		//More main Frame setup
		main.add(input, BorderLayout.PAGE_START);
		main.add(output, BorderLayout.CENTER);
		main.add(controls, BorderLayout.PAGE_END);
		main.setVisible(true);
	}
	
	/**
	 * Assigns all buttons to listeners related to their specified task
	 */
	private void registerListeners() {
		//Add Action listeners.
		this.btnZero.addActionListener(new ActionButtonListener("0"));
		this.btnOne.addActionListener(new ActionButtonListener("1"));
		this.btnTwo.addActionListener(new ActionButtonListener("2"));
		this.btnThree.addActionListener(new ActionButtonListener("3"));
		this.btnFour.addActionListener(new ActionButtonListener("4"));
		this.btnFive.addActionListener(new ActionButtonListener("5"));
		this.btnSix.addActionListener(new ActionButtonListener("6"));
		this.btnSeven.addActionListener(new ActionButtonListener("7"));
		this.btnEight.addActionListener(new ActionButtonListener("8"));
		this.btnNine.addActionListener(new ActionButtonListener("9"));
		this.btnPlus.addActionListener(new ActionButtonListener("+"));
		this.btnMinus.addActionListener(new ActionButtonListener("-"));
		this.btnMultiply.addActionListener(new ActionButtonListener("*"));
		this.btnDivide.addActionListener(new ActionButtonListener("/"));
		//Add Clear listener
		this.btnClear.addActionListener(new ClearButtonListener());
		//Add Equal listener
		this.btnEquals.addActionListener(new EqualButtonListener());
   }
}
