package atm.simulator.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTF, ssnTF, emailTF, addressTF, cityTF, stateTF, zipcodeTF;
	JButton next;
	JRadioButton male, female, other, married, unmarried;
	JDateChooser dobDC;
	
	public SignupOne() {
		
		//Add Title to the Frame
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
		
		setLayout(null);
		
		Random rn = new Random();
		random = Math.abs((rn.nextLong() % 9000L) + 1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
		formno.setFont(new Font("Raleway", Font.BOLD, 35));
		formno.setBounds(250, 40, 550, 40);
		add(formno);
		
		JLabel personelDetails = new JLabel("Page 1: Personal Details");
		personelDetails.setFont(new Font("Raleway", Font.BOLD, 25));
		personelDetails.setBounds(370, 100, 380, 30);
		add(personelDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(200, 150, 100, 25);
		add(name);
		
		nameTF = new JTextField();
		nameTF.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTF.setBounds(360, 150, 400, 25);
		add(nameTF);
		
		JLabel fname = new JLabel("SSN:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(200, 200, 150, 25);
		add(fname);
		
		ssnTF = new JTextField();
		ssnTF.setFont(new Font("Raleway", Font.BOLD, 14));
		ssnTF.setBounds(360, 200, 400, 25);
		add(ssnTF);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(200, 250, 150, 25);
		add(dob);
		
		dobDC = new JDateChooser();
		dobDC.setBounds(360, 250, 200, 25);
		dobDC.setForeground(new Color(105, 105, 105));
		add(dobDC);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(200, 300, 100, 25);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setFont(new Font("Raleway", Font.BOLD, 18));
		male.setBackground(Color.WHITE);
		male.setBounds(360, 300, 100, 25);
		add(male);
		
		female = new JRadioButton("Female");
		female.setFont(new Font("Raleway", Font.BOLD, 18));
		female.setBackground(Color.WHITE);
		female.setBounds(480, 300, 100, 25);
		add(female);
		
		other = new JRadioButton("Other");
		other.setFont(new Font("Raleway", Font.BOLD, 18));
		other.setBackground(Color.WHITE);
		other.setBounds(630, 300, 100, 25);
		add(other);
		
		ButtonGroup genderbg = new ButtonGroup();
		genderbg.add(male);
		genderbg.add(female);
		genderbg.add(other);
		
		JLabel email = new JLabel("Email Id:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(200, 350, 100, 25);
		add(email);
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTF.setBounds(360, 350, 400, 25);
		add(emailTF);
		
		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(200, 400, 150, 25);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setFont(new Font("Raleway", Font.BOLD, 18));
		married.setBackground(Color.WHITE);
		married.setBounds(360, 400, 100, 25);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
		unmarried.setBackground(Color.WHITE);
		unmarried.setBounds(480, 400, 150, 25);
		add(unmarried);
		
		ButtonGroup mariatalBG = new ButtonGroup();
		mariatalBG.add(married);
		mariatalBG.add(unmarried);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(200, 450, 150, 25);
		add(address);
		
		addressTF = new JTextField();
		addressTF.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTF.setBounds(360, 450, 400, 25);
		add(addressTF);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(200, 500, 100, 25);
		add(city);
		
		cityTF = new JTextField();
		cityTF.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTF.setBounds(360, 500, 400, 25);
		add(cityTF);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(200, 550, 100, 25);
		add(state);
		
		stateTF = new JTextField();
		stateTF.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTF.setBounds(360, 550, 400, 25);
		add(stateTF);
		
		JLabel zipcode = new JLabel("Zipcode:");
		zipcode.setFont(new Font("Raleway", Font.BOLD, 20));
		zipcode.setBounds(200, 600, 100, 25);
		add(zipcode);
		
		zipcodeTF = new JTextField();
		zipcodeTF.setFont(new Font("Raleway", Font.BOLD, 14));
		zipcodeTF.setBounds(360, 600, 400, 25);
		add(zipcodeTF);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 16));
		next.setBounds(450, 660, 130, 30);
		next.addActionListener(this);
		add(next);	
		
		
		//Setting Frame size and location
		setSize(1000, 800);
		setVisible(true);
		setLocation(300, 10);
		
		// Set background for the Frame
		getContentPane().setBackground(Color.WHITE);
		
	}

	public static void main(String[] args)
	{
		new SignupOne(); 
		
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{	
		try 
		{
			String formno = "" +  random;
			
			String name = nameTF.getText();
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required!");
				nameTF.requestFocus();
				return;
			}
			
			String ssn = ssnTF.getText();
			if(ssn.equals("")) {
				JOptionPane.showMessageDialog(null, "Social Security Number is required!");
				ssnTF.requestFocus();
				return;
			}
			
			String dob = ((JTextField) dobDC.getDateEditor().getUiComponent()).getText();
			if(dob.equals("")) {
				JOptionPane.showMessageDialog(null, "Date of Birth is Required!");
				dobDC.requestFocus();
				return;
			}
			
			String gender = "";
			if(male.isSelected()) {
				gender = "Male";
			}
			else if(female.isSelected()) {
				gender = "Female";
			}
			else if(other.isSelected()){
				gender = "Other";
			}
			
			if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "Gender is Required!");
				male.requestFocus();
				return;
			}
			
			String email = emailTF.getText();
			if(email.equals("")) {
				JOptionPane.showMessageDialog(null, "Email Id is Required!");
				emailTF.requestFocus();
				return;
			}
			
			String mariatal = "";
			if(married.isSelected()) {
				mariatal = "Married";
			}
			else if (unmarried.isSelected()){
				mariatal = "Unmarried";
			}
			if(mariatal.equals("")) {
				JOptionPane.showMessageDialog(null, "Mariatal Status is Required!");
				married.requestFocus();
				return;
			}
			
			String address =  addressTF.getText();
			if(address.equals("")) {
				JOptionPane.showMessageDialog(null, "Address is Required!");
				addressTF.requestFocus();
				return;
			}
			
			String city = cityTF.getText();
			if(city.equals("")) {
				JOptionPane.showMessageDialog(null, "City is Required!");
				cityTF.requestFocus();
				return;
			}
			
			String state = stateTF.getText();
			if(state.equals("")) {
				JOptionPane.showMessageDialog(null, "State is Required!");
				stateTF.requestFocus();
				return;
			}
			
			String zip = zipcodeTF.getText();
			if(zip.equals("")) {
				JOptionPane.showMessageDialog(null, "Zipcode is Required!");
				zipcodeTF.requestFocus();
				return;
			}
			
			//Connecting with Database
			Conn c = new Conn();
			String query = "INSERT INTO Customer(formno, name, ssn, dob, gender, email, mariatal, address, city, state, zip) VALUES ('"+formno+"', '"+name+"', '"+ssn+"', '"+dob+"', '"+gender+"', '"+email+"', '"+mariatal+"', '"+address+"', '"+city+"', '"+state+"', '"+zip+"' )";
			c.s.executeUpdate(query);
			c.s.close();
			
			setVisible(false);
			new SignupTwo(formno, ssn).setVisible(true);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}