package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener
{

	JButton amt20, amt50, amt100, amt150, amt200, amt500, amt1000, back;
	String ssn, pin;
	public FastCash(String ssn, String pin) 
	{
		setLayout(null);
		
		this.ssn = ssn;
		this.pin = pin;
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image img2 = img1.getImage().getScaledInstance(900, 915, Image.SCALE_DEFAULT);
		img1 =  new ImageIcon(img2);
		JLabel label = new JLabel(img1);
		label.setBounds(0, 0, 900, 850);
		add(label);
		
		JLabel text = new JLabel("Please select withdrawl amount");
		text.setBounds(192, 310, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 18));
		text.setForeground(Color.GREEN);
		label.add(text);
		
		amt50 = new JButton("50$");
		amt50.setBounds(170, 395, 150, 28);
		amt50.addActionListener(this);
		label.add(amt50);
		
		amt200 = new JButton("200$");
		amt200.setBounds(355, 395, 150, 24);
		amt200.addActionListener(this);
		label.add(amt200);
		
		amt100 = new JButton("100$");
		amt100.setBounds(170, 430, 150, 24);
		amt100.addActionListener(this);
		label.add(amt100);
		
		amt500 = new JButton("500$");
		amt500.setBounds(355, 430, 150, 24);
		amt500.addActionListener(this);
		label.add(amt500);
		
		amt150 = new JButton("150$");
		amt150.setBounds(170, 465, 150, 24 );
		amt150.addActionListener(this);
		label.add(amt150);
		
		amt1000 = new JButton("1000$");
		amt1000.setBounds(355, 465, 150, 24);
		amt1000.addActionListener(this);
		label.add(amt1000);
		
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
		String amount = "";
		Float balance;
		if (ae.getSource() == back) {
			setVisible(false);
			new Transactions(ssn, pin);
		}
		else
		{
			amount = ((JButton)ae.getSource()).getText().toString();
			int len = amount.length();
			amount = amount.substring(0, len - 1);
			
			try 
			{	
				Conn conn = new Conn();
				String query = "SELECT balance from Accounts WHERE SSN = '"+ssn+"'";
				ResultSet result = conn.s.executeQuery(query);
				if(result.next()) {
					balance = Float.parseFloat(result.getString(1));
					if(balance - Float.parseFloat(amount) >= 0)
					{
						balance -= Float.parseFloat(amount);
						query = "UPDATE Accounts SET balance = '"+balance.toString()+"' WHERE ssn = '" +ssn+ "'";
						conn.s.executeUpdate(query);
						Date date = new Date();
						query = "INSERT INTO Transactions(ssn, amount, type, date) VALUES ('" + ssn + "', '" +amount+ "', 'Withdraw', '" + date + "')";
						conn.s.executeUpdate(query);
						conn.s.close();
						
						JOptionPane pane = new JOptionPane(amount + "$ successfully withdrawn from your account!");
						JDialog d = pane.createDialog((JFrame)null, "Message");
						d.setLocation(485,320);
					    d.setVisible(true);
						
						setVisible(false);
						new Transactions(ssn, pin);
					}
					else 
					{
						JOptionPane pane = new JOptionPane("Insufficient balance! Please try with a smaller amount!");
						JDialog d = pane.createDialog((JFrame)null, "Message");
						d.setLocation(470,320);
					    d.setVisible(true);
					}
				}
				else 
				{
					JOptionPane pane = new JOptionPane("Unable to complete transaction at the moment.\n                    Please try again later!");
					JDialog d = pane.createDialog((JFrame)null, "Message");
					d.setLocation(485,320);
				    d.setVisible(true);
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static void main(String args[]) 
	{
		new FastCash("1234567890", "2968");
	}


}
