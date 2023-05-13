package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class CheckBalance extends JFrame implements ActionListener 
{
	String ssn, pin;
	JLabel pinL, label, text;
	JButton checkBalance, back;
	JPasswordField pinPF;
	public CheckBalance(String ssn, String pin) 
	{
		setLayout(null);
		
		this.ssn = ssn;
		this.pin = pin;
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img2 = img1.getImage().getScaledInstance(900, 915, Image.SCALE_DEFAULT);
		img1 =  new ImageIcon(img2);
		label = new JLabel(img1);
		label.setBounds(0, 0, 900, 850);
		add(label);
		
		text = new JLabel("Check Balance:");
		text.setBounds(265, 265, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 18));
		text.setForeground(Color.GREEN);
		label.add(text);
		
		pinL = new JLabel("Enter PIN:");
		pinL.setBounds(185, 350, 180, 25);
		pinL.setFont(new Font("System", Font.BOLD, 16));
		pinL.setForeground(Color.WHITE);
		label.add(pinL);
		
		pinPF = new JPasswordField();
		pinPF.setFont(new Font("System", Font.BOLD, 25));
		pinPF.setBounds(300, 350, 180, 25);
		label.add(pinPF);
		
		checkBalance = new JButton("GET BALANCE");
		checkBalance.setBounds(355, 465, 150, 24);
		checkBalance.addActionListener(this);
		label.add(checkBalance);
		
		back = new JButton("BACK");
		back.setBounds(355, 500, 150, 24);
		back.addActionListener(this);
		label.add(back);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(ssn, pin).setVisible(true);;
		}
		else if(ae.getSource() == checkBalance) 
		{
			String testpin = pinPF.getText();
			if(testpin.equals("")) {
				JOptionPane pane = new JOptionPane("PIN is required!");
				JDialog d = pane.createDialog((JFrame)null, "Message");
				d.setLocation(500,350);
			    d.setVisible(true);
			    
			    pinPF.requestFocus();
				return;
			}
			else if (!testpin.equals(pin)) 
			{
				JOptionPane pane = new JOptionPane("Invalid PIN!");
				JDialog d = pane.createDialog((JFrame)null, "Message");
				d.setLocation(500,350);
			    d.setVisible(true);
			    
			    pinPF.setText("");
			    pinPF.requestFocus();
				return;				
			}
			else {
				try 
				{
					String balance;
					Conn conn = new Conn();
					String query = "SELECT balance FROM Accounts WHERE ssn = '" +ssn+ "'";
					ResultSet result = conn.s.executeQuery(query);
					if(result.next()) 
					{
						balance = result.getString(1);
						pinPF.hide();
						checkBalance.hide();
						pinL.setText("Your account balance is " + balance + "$");
						pinL.setBounds(200, 340, 400, 25);
					}
					else {
						throw new SQLException("Failed to retrieve balance!");
					}
					
				}
				catch(Exception e) {
					System.out.println(e);
					JOptionPane pane = new JOptionPane("Unable to fetch balance at the moment.\n                  Please try again later!");
					JDialog d = pane.createDialog((JFrame)null, "Message");
					d.setLocation(500,350);
				    d.setVisible(true);
				    
				    setVisible(false);
					new Transactions(ssn, pin);
				}
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		new CheckBalance("1234567890", "2968");
	}

}
