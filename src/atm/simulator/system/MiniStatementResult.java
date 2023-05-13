package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatementResult extends JFrame
{

	public MiniStatementResult (String ssn, String pin) {
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel bank = new JLabel("E-Bank");
		bank.setFont(new Font("Calibri", Font.BOLD, 20));
		bank.setBounds(160, 30, 100, 25);
		add(bank);
		
		JLabel name = new JLabel();
		name.setFont(new Font("Calibri", Font.BOLD, 15));
		name.setBounds(20, 90, 300, 20);
		add(name);
		
		try {
			Conn conn = new Conn();
			ResultSet result = conn.s.executeQuery("SELECT name FROM Customer WHERE ssn = '"+ssn+"'");
			while(result.next()) 
			{
				name.setText("Name: " + result.getString("name"));
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel card = new JLabel();
		card.setFont(new Font("Calibri", Font.BOLD, 15));
		card.setBounds(20, 110, 300, 20);
		add(card);
		
		try {
			Conn conn = new Conn();
			ResultSet result = conn.s.executeQuery("SELECT cardNumber FROM Login WHERE ssn = '"+ssn+"'");
			while(result.next()) 
			{
				card.setText("Card Number: " + result.getString("cardNumber").substring(0,4) + "-XXXX-XXXX-" + result.getString("cardNumber").substring(12));
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 140, 400, 300);
		add(mini);
		mini.setText("<html> <table><tr><th>Type</th><th>Date</th><th>&nbsp;&nbsp;Amount</th></tr>");
		try {
			Conn conn = new Conn();
			ResultSet result = conn.s.executeQuery("SELECT * FROM Transactions WHERE ssn = '"+ssn+"' ORDER BY date DESC LIMIT 10");
			while(result.next()) 
			{
				mini.setText(mini.getText() + "<tr><td>&nbsp;" + result.getString("type") + "&nbsp;</td><td>&nbsp;" + result.getString("date") + "&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;" + result.getString("amount") + "</td></tr>");
			}	
			
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			mini.setText(mini.getText() + "</table></html>");
		}
		
		JLabel balance = new JLabel();
		balance.setFont(new Font("Calibri", Font.BOLD, 15));
		balance.setBounds(20, 450, 400, 20);
		add(balance);	
		try 
		{
			Conn conn = new Conn();
			String query = "SELECT balance FROM Accounts WHERE ssn = '" +ssn+ "'";
			ResultSet result = conn.s.executeQuery(query);
			if(result.next()) {
				balance.setText("Your account balance is: " + result.getString("balance") + "$");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
			
		
		setSize(400, 600);
		setLocation(800, 150);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new MiniStatementResult("1234567890", "2968");
	}

}
