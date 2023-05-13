package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener
{
	String formno, ssn;
	JRadioButton acc1, acc2, acc3, acc4;
	JCheckBox sr1, sr2, sr3, sr4, sr5, sr6, ack1, ack2;
	JButton submit, cancel;
	
	public SignupThree(String formno, String ssn) {
		
		this.formno = formno;
		this.ssn = ssn;
		
		//Add Title to the Frame
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		
		setLayout(null);
		
		JLabel form = new JLabel("APPLICATION FORM NO. "+ formno);
		form.setFont(new Font("Raleway", Font.BOLD, 35));
		form.setBounds(250, 40, 550, 40);
		add(form);
		
		JLabel additionalDetails = new JLabel("Page 3: Account Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 25));
		additionalDetails.setBounds(370, 100, 380, 30);
		add(additionalDetails);
		
		JLabel type = new JLabel("Account Type:");
		type.setFont(new Font("Raleway", Font.BOLD, 20));
		type.setBounds(150, 180, 150, 25);
		add(type);
		
		acc1 = new JRadioButton("Savings Account");
		acc1.setFont(new Font("Raleway", Font.ITALIC, 18));
		acc1.setBackground(Color.WHITE);
		acc1.setBounds(210, 230, 200, 25);
		add(acc1);
		
		acc2 = new JRadioButton("Checking Account");
		acc2.setFont(new Font("Raleway", Font.ITALIC, 18));
		acc2.setBackground(Color.WHITE);
		acc2.setBounds(500, 230, 200, 25);
		add(acc2);
		
		acc3 = new JRadioButton("Money Market Account");
		acc3.setFont(new Font("Raleway", Font.ITALIC, 18));
		acc3.setBackground(Color.WHITE);
		acc3.setBounds(210, 270, 250, 25);
		add(acc3);
		
		acc4 = new JRadioButton("Certificate of Deposit (CD)");
		acc4.setFont(new Font("Raleway", Font.ITALIC, 18));
		acc4.setBackground(Color.WHITE);
		acc4.setBounds(500, 270, 250, 25);
		add(acc4);
		
		ButtonGroup accountTypeBG = new ButtonGroup();
		accountTypeBG.add(acc1);
		accountTypeBG.add(acc2);
		accountTypeBG.add(acc3);
		accountTypeBG.add(acc4);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 20));
		card.setBounds(150, 330, 150, 25);
		add(card);
		
		JLabel cardNo = new JLabel("XXXX-XXXX-XXXX-XXXX");
		cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
		cardNo.setBounds(340, 330, 300, 25);
		add(cardNo);
		
		JLabel carddetails = new JLabel("Your 16 digit card number");
		carddetails.setFont(new Font("Raleway", Font.ITALIC, 14));
		carddetails.setBounds(340, 350, 200, 20);
		add(carddetails);
		
		JLabel pinNo = new JLabel("                PIN:");
		pinNo.setFont(new Font("Raleway", Font.BOLD, 20));
		pinNo.setBounds(150, 390, 150, 25);
		add(pinNo);
		
		JLabel pin = new JLabel("XXXX");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(340, 390, 300, 25);
		add(pin);
		
		JLabel pindetails = new JLabel("Your 4 digit PIN number");
		pindetails.setFont(new Font("Raleway", Font.ITALIC, 14));
		pindetails.setBounds(340, 410, 200, 20);
		add(pindetails);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway", Font.BOLD, 20));
		services.setBounds(150, 460, 200, 25);
		add(services);
		
		sr1 = new JCheckBox("ATM Card");
		sr1.setFont(new Font("Raleway", Font.ITALIC, 18));
		sr1.setBackground(Color.WHITE);
		sr1.setBounds(210, 500, 200, 25);
		add(sr1);
		
		sr2 = new JCheckBox("Cheque Book");
		sr2.setFont(new Font("Raleway", Font.ITALIC, 18));
		sr2.setBackground(Color.WHITE);
		sr2.setBounds(500, 500, 200, 25);
		add(sr2);
		
		sr3 = new JCheckBox("Internet Banking");
		sr3.setFont(new Font("Raleway", Font.ITALIC, 18));
		sr3.setBackground(Color.WHITE);
		sr3.setBounds(210, 530, 200, 25);
		add(sr3);
		
		sr4 = new JCheckBox("Mobile Banking");
		sr4.setFont(new Font("Raleway", Font.ITALIC, 18));
		sr4.setBackground(Color.WHITE);
		sr4.setBounds(500, 530, 200, 25);
		add(sr4);
		
		sr5 = new JCheckBox("E-Statement");
		sr5.setFont(new Font("Raleway", Font.ITALIC, 18));
		sr5.setBackground(Color.WHITE);
		sr5.setBounds(210, 560, 200, 25);
		add(sr5);
		
		sr6 = new JCheckBox("Email/SMS Alerts");
		sr6.setFont(new Font("Raleway", Font.ITALIC, 18));
		sr6.setBackground(Color.WHITE);
		sr6.setBounds(500, 560, 200, 25);
		add(sr6);
		
		ack1 = new JCheckBox("I hereby CERTIFY that the information provided in this form is complete, true and correct to the best of my knowledge.");
		ack1.setFont(new Font("Raleway", Font.BOLD, 12));
		ack1.setBackground(Color.WHITE);
		ack1.setBounds(150, 600, 800, 25);
		add(ack1);
		
		ack2 = new JCheckBox("Further, I hereby ACKNOWLEDGE that I have read and understood the Privacy Notice and agree there to as well.");
		ack2.setFont(new Font("Raleway", Font.BOLD, 12));
		ack2.setBackground(Color.WHITE);
		ack2.setBounds(150, 620, 800, 25);
		add(ack2);
		
		submit = new JButton("Submit");
		submit.setBounds(300, 670, 150, 50);
		submit.setFont(new Font("Raleway", Font.BOLD, 20));
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(500, 670, 150, 50);
		cancel.setFont(new Font("Raleway", Font.BOLD, 20));
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		//Setting Frame size and location
		setSize(1000, 800);
		setVisible(true);
		setLocation(300, 10);
						
		// Set background for the Frame
		getContentPane().setBackground(Color.WHITE);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{		
		if (ae.getSource() == cancel)
		{
			try{
				Conn conn = new Conn();
				conn.s.executeUpdate("DELETE * FROM Customer WHERE ssn = '"+ssn+"'");
			}
			catch(Exception e) {
				System.out.println(e);	
			}
			
			setVisible(false);
			new Login();
		}
		else if (ae.getSource() == submit)
		{	
			try 
			{
				String acountType = "";
				if(acc1.isSelected()) {
					acountType = "Savings Account";
				}
				else if (acc2.isSelected()) {
					acountType = "Checking Account";
				}
				else if (acc3.isSelected()) {
					acountType = "Money Market Account";
				}
				else if (acc4.isSelected()) {
					acountType = "Certificate of Deposit";
				}
				
				if(acountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type not selected!");
					acc1.requestFocus();
					return;
				}
				
				
				Random random = new Random();
				String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 8060599100000000L);
				String pin = "" + Math.abs((random.nextInt() % 9000L) + 1000L);
				
				if(cardNumber.equals("") || pin.equals("")) {
					JOptionPane.showMessageDialog(null, "Unable to generate Card Number or PIN at this time!");
					return;
				}
				
				String atmCard = "N", chequeBook = "N", internetBanking = "N", mobileBanking = "N", eStatement = "N", emailSMS = "N";
				if(sr1.isSelected()) {atmCard = "Y";}
				if(sr2.isSelected()) {chequeBook = "Y";}
				if(sr3.isSelected()) {internetBanking = "Y";}
				if(sr4.isSelected()) {mobileBanking = "Y";}
				if(sr5.isSelected()) {eStatement = "Y";}
				if(sr6.isSelected()) {emailSMS = "Y";}
				
				if(atmCard.equals("N") & chequeBook.equals("N") & internetBanking.equals("N") & mobileBanking.equals("N") & eStatement.equals("N") & emailSMS.equals("N")) {
					JOptionPane.showMessageDialog(null, "Please select atleast 1 service!");
					sr1.requestFocus();
					return;
				}
				
				String acknowledgement1 = "N";
				if (ack1.isSelected()) {acknowledgement1 = "Y";}
				if (acknowledgement1.equals("N")) {
					JOptionPane.showMessageDialog(null, "Please certify information validity!");
					ack1.requestFocus();
					return;
				}
				
				String acknowledgement2 = "N";
				if (ack2.isSelected()) {acknowledgement2 = "Y";}
				if (acknowledgement2.equals("N")) {
					JOptionPane.showMessageDialog(null, "Please view the privacy policy and aceept terms and conditions!");
					ack2.requestFocus();
					return;
				}
				
				
				Conn c =  new Conn();
				String query = "UPDATE Customer SET acountType ='"+acountType+"', cardNumber = '"+cardNumber+"', pin ='"+pin+"', atmCard = '"+atmCard+"', chequeBook = '"+chequeBook+"', internetBanking = '"+internetBanking+"', mobileBanking = '"+mobileBanking+"', eStatement = '"+eStatement+"', emailSMS = '"+emailSMS+"' WHERE ssn = '"+ssn+"'";
				c.s.executeUpdate(query);
				query = "INSERT INTO Login(ssn, cardNumber, pin) VALUES ('" + ssn + "', '" + cardNumber + "', '" + pin + "')";
				c.s.executeUpdate(query);
				query = "INSERT INTO Accounts(ssn, balance) VALUES ('" + ssn + "', '0')";
				c.s.executeUpdate(query);
				c.s.close();
				
				JOptionPane.showMessageDialog(null, "Account created succesfully!");
				setVisible(false);
				new Login();
				
			}
			catch(Exception e) 
			{
				System.out.println(e);	
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		new SignupThree("", ""); 
		
	}

}
