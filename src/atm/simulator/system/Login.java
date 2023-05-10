package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signup, clear;
	JTextField cardNoTF;
	JPasswordField pinTF;
	public Login()
	{	
		//Add Title to the Frame
		setTitle("Automated Teller Machine");
		
		//Removes default layout applied by JFrames
		setLayout(null);
		
		//Adding icon to the Frame
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image img2 = img1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
		img1 =  new ImageIcon(img2);
		JLabel label = new JLabel(img1);
		label.setBounds(150, 90, 180, 180);
		add(label);
		
		//Adding text fields to the Frame
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 50));
		text.setBounds(350, 170, 500, 40);
		add(text);
		
		JLabel cardNo = new JLabel("Card No.");
		cardNo.setFont(new Font("Raleway", Font.BOLD, 32));
		cardNo.setBounds(250, 320, 150, 40);
		add(cardNo);
		
		cardNoTF = new JTextField();
		cardNoTF.setBounds(410, 320, 300, 40);
		cardNoTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardNoTF);
		
		JLabel pin = new JLabel("        PIN");
		pin.setFont(new Font("Raleway", Font.BOLD, 32));
		pin.setBounds(250, 420, 150, 40);
		add(pin);
		
		pinTF = new JPasswordField();
		pinTF.setBounds(410, 420, 300, 40);
		pinTF.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTF);
		
		login = new JButton("Login");
		login.setBounds(250, 520, 200, 40);
		login.setFont(new Font("Raleway", Font.BOLD, 16));
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("Clear");
		clear.setBounds(500, 520, 200, 40);
		clear.setFont(new Font("Raleway", Font.BOLD, 16));
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("Sign Up");
		signup.setBounds(350, 585, 250, 40);
		signup.setFont(new Font("Raleway", Font.BOLD, 16));
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		
		//Setting Frame size and location
		setSize(1000, 800);
		setVisible(true);
		setLocation(300, 10);
				
		// Set background for the Frame
		getContentPane().setBackground(Color.WHITE);
		
	}

	public static void main(String[] args)
	{
		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		
		if (ae.getSource() == login)
		{
			String ssn = "";
			String cardNumber = cardNoTF.getText();
			if(cardNumber.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter Card Number!");
				cardNoTF.requestFocus();
				return;
			}
			
			String pin = "" + pinTF.getText();
			if(pin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter PIN!");
				pinTF.requestFocus();
				return;
			}
			
			try
			{
				Conn conn = new Conn();
				String query = "SELECT * FROM Login WHERE cardNumber = '" + cardNumber + "' AND pin = '" + pin + "'";
				ResultSet result = conn.s.executeQuery(query);
				if(result.next()) {
					
					ssn = result.getString(1);
					setVisible(false);
					new Transactions(ssn, pin).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN!");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		else if (ae.getSource() == signup)
		{	
			setVisible(false);
			new SignupOne();
		}
		else if (ae.getSource() == clear)
		{
			cardNoTF.setText("");
			pinTF.setText("");
		}
	}

}
