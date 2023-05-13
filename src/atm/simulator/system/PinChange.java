package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener
{
	String ssn, pin;
	JLabel text, oldPin, newPin, label, constraint1, constraint2;
	JButton confirm, back;
	JPasswordField oldPinTF, newPinTF;
	public PinChange(String ssn, String pin)
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
		
		text = new JLabel("Change PIN:");
		text.setBounds(285, 265, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 18));
		text.setForeground(Color.GREEN);
		label.add(text);
		
		oldPin = new JLabel("Old PIN:");
		oldPin.setBounds(185, 325, 180, 25);
		oldPin.setFont(new Font("System", Font.BOLD, 16));
		oldPin.setForeground(Color.WHITE);
		label.add(oldPin);
		
		oldPinTF = new JPasswordField();
		oldPinTF.setFont(new Font("System", Font.BOLD, 25));
		oldPinTF.setBounds(300, 325, 180, 25);
		label.add(oldPinTF);
		
		newPin = new JLabel("New PIN:");
		newPin.setBounds(185, 365, 180, 25);
		newPin.setFont(new Font("System", Font.BOLD, 16));
		newPin.setForeground(Color.WHITE);
		label.add(newPin);
		
		newPinTF = new JPasswordField();
		newPinTF.setFont(new Font("System", Font.BOLD, 25));
		newPinTF.setBounds(300, 365, 180, 25);
		label.add(newPinTF);
		
		constraint1 = new JLabel("- PIN can only be numeric");
		constraint1.setFont(new Font("System", Font.BOLD, 12));
		constraint1.setBounds(185, 395, 180, 25);
		constraint1.setForeground(Color.YELLOW);
		label.add(constraint1);
		
		constraint2 = new JLabel("- PIN can only have 4 digits");
		constraint2.setFont(new Font("System", Font.BOLD, 12));
		constraint2.setBounds(185, 415, 220, 25);
		constraint2.setForeground(Color.YELLOW);
		label.add(constraint2);
		
		confirm = new JButton("CHANGE PIN");
		confirm.setBounds(355, 465, 150, 24);
		confirm.addActionListener(this);
		label.add(confirm);
		
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
		else if(ae.getSource() == confirm) 
		{
			String oldPin = oldPinTF.getText();
			if(oldPin.equals("")) 
			{
				JOptionPane pane = new JOptionPane("Old Pin is required!");
				JDialog d = pane.createDialog((JFrame)null, "Message");
				d.setLocation(500,350);
			    d.setVisible(true);
			    
			    oldPinTF.requestFocus();
				return;
			}
			if(pinChecker(oldPin))
			{
				JOptionPane pane = new JOptionPane("Invalid Old Pin!");
				JDialog d = pane.createDialog((JFrame)null, "Message");
				d.setLocation(500,350);
			    d.setVisible(true);
			    
			    oldPinTF.setText("");
			    newPinTF.setText("");
			    oldPinTF.requestFocus();
				return;
			}
			
			String newPin = newPinTF.getText();
			if(newPin.equals("")) 
			{
				JOptionPane pane = new JOptionPane("Please enter new pin value!");
				JDialog d = pane.createDialog((JFrame)null, "Message");
				d.setLocation(500,350);
			    d.setVisible(true);
			    
			    newPinTF.requestFocus();
				return;
			}
			if(pinChecker(newPin))
			{
				JOptionPane pane = new JOptionPane("Invalid New Pin!");
				JDialog d = pane.createDialog((JFrame)null, "Message");
				d.setLocation(500,350);
			    d.setVisible(true);
			    
			    oldPinTF.setText("");
			    newPinTF.setText("");
			    oldPinTF.requestFocus();
				return;
			}
			
			if(oldPin.equals(pin))
			{	
				JOptionPane pane = null;
				try {
					Conn conn = new Conn();
					String query = "UPDATE Customer SET pin = '" +newPin+ "' WHERE ssn = '" +ssn+ "'";
					conn.s.executeUpdate(query);
					query = "UPDATE Login SET pin = '" +newPin+ "' WHERE ssn = '" +ssn+ "'";
					conn.s.executeUpdate(query);
					conn.s.close();
					pin = newPin;
					pane = new JOptionPane("Pin changed successfully!");
					
				}
				catch (SQLException e) {
					System.out.println(e);
					pane = new JOptionPane("Unable to change pin at the moment. Please try again later!");
				}
				finally {
					JDialog d = pane.createDialog((JFrame)null, "Message");
					d.setLocation(500,350);
				    d.setVisible(true);
				    
				    setVisible(false);
					new Transactions(ssn, pin);
				}
			}
			else
			{
				JOptionPane pane = new JOptionPane("Incorrect old pin value!");
				JDialog d = pane.createDialog((JFrame)null, "Message");
				d.setLocation(500,350);
			    d.setVisible(true);
			    
			    oldPinTF.setText("");
			    newPinTF.setText("");
			    oldPinTF.requestFocus();
				return;
			}
			
			
			
		}
		
	}
	
	private boolean pinChecker(String pin) {
		
		if(pin == null || pin.equals("") || pin.length() != 4) {
			return true;
		}
		try
		{
	        int d = Integer.parseInt(pin);
	        if(d <= 999 || d >= 10000)
	        {
	        	return true;
	        }
	    } 
		catch (NumberFormatException nfe) {
	        return true;
	    }
		return false;
	}
	
	public static void main(String[] args) {
		new PinChange("1234567890", "2968");
	}

}
