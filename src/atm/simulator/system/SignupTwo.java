package atm.simulator.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener
{
	JTextField fnameTF, passportTF;
	JButton next;
	JRadioButton scyes, scno, eayes, eano;
	JComboBox raceJB, categoryJB, incomeJB, educationJB, occupationJB;
	String formno, ssn ;
	
	
	public SignupTwo(String formno, String ssn) {
		
		this.formno = formno;
		this.ssn = ssn;
		
		//Add Title to the Frame
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		setLayout(null);
		
		JLabel form = new JLabel("APPLICATION FORM NO. "+ formno);
		form.setFont(new Font("Raleway", Font.BOLD, 35));
		form.setBounds(250, 40, 550, 40);
		add(form);
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 25));
		additionalDetails.setBounds(370, 100, 380, 30);
		add(additionalDetails);
		
		JLabel fname = new JLabel("Father's name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(200, 150, 150, 25);
		add(fname);
		
		fnameTF = new JTextField();
		fnameTF.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTF.setBounds(360, 150, 400, 25);
		add(fnameTF);
		
		JLabel passport = new JLabel("Passport No:");
		passport.setFont(new Font("Raleway", Font.BOLD, 20));
		passport.setBounds(200, 200, 150, 25);
		add(passport);
		
		passportTF = new JTextField();
		passportTF.setFont(new Font("Raleway", Font.BOLD, 14));
		passportTF.setBounds(360, 200, 400, 25);
		add(passportTF);
		
		JLabel race = new JLabel("Race:");
		race.setFont(new Font("Raleway", Font.BOLD, 20));
		race.setBounds(200, 250, 100, 25);
		add(race);
		
		String valRace[] = {"","American Indian", "Alaska Native", "Asian", "Black or African American", "Native Hawaiian", "Other Pacific Islander", "White", "Other"};  
		raceJB = new JComboBox(valRace);
		raceJB.setBackground(Color.WHITE);
		raceJB.setBounds(360, 250, 400, 25);
		add(raceJB);
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(200, 300, 150, 25);
		add(category);
		
		String valCategory[] = {"","Hispanic", "Latino", "Other"};  
		categoryJB = new JComboBox(valCategory);
		categoryJB.setBackground(Color.WHITE);
		categoryJB.setBounds(360, 300, 400, 25);
		add(categoryJB);
		
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(200, 350, 150, 25);
		add(income);
		
		String valIncome[] = {"","Less than $52,200", "$52,200 - $156,600", "More than $156,600"};  
		incomeJB = new JComboBox(valIncome);
		incomeJB.setBackground(Color.WHITE);
		incomeJB.setBounds(360, 350, 400, 25);
		add(incomeJB);
		
		JLabel education = new JLabel("Education:");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(200, 400, 150, 25);
		add(education);
		
		String valEducation[] = {"","High school or equivalent","Bachelors degree", "Masters degree", "Doctorate", "Professional", "Associate degree"};  
		educationJB = new JComboBox(valEducation);
		educationJB.setBackground(Color.WHITE);
		educationJB.setBounds(360, 400, 400, 25);
		add(educationJB);
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(200, 450, 150, 25);
		add(occupation);
		
		String valOccupation[] = {"","Salaried","Self Employeed", "Business", "Doctorate", "Student", "Retired", "Other"};  
		occupationJB = new JComboBox(valOccupation);
		occupationJB.setBackground(Color.WHITE);
		occupationJB.setBounds(360, 450, 400, 25);
		add(occupationJB);
		
		JLabel seniorCitizen = new JLabel("Senior Citizen:");
		seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorCitizen.setBounds(200, 500, 150, 25);
		add(seniorCitizen);
		
		scyes = new JRadioButton("Yes");
		scyes.setFont(new Font("Raleway", Font.BOLD, 18));
		scyes.setBackground(Color.WHITE);
		scyes.setBounds(360, 500, 100, 25);
		add(scyes);
		
		scno = new JRadioButton("No");
		scno.setFont(new Font("Raleway", Font.BOLD, 18));
		scno.setBackground(Color.WHITE);
		scno.setBounds(480, 500, 150, 25);
		add(scno);
		
		ButtonGroup seniorCitizenBG = new ButtonGroup();
		seniorCitizenBG.add(scyes);
		seniorCitizenBG.add(scno);
		
		JLabel existAcnt = new JLabel("Existing Acnt:");
		existAcnt.setFont(new Font("Raleway", Font.BOLD, 19));
		existAcnt.setBounds(200, 550, 150, 25);
		add(existAcnt);
		
		eayes = new JRadioButton("Yes");
		eayes.setFont(new Font("Raleway", Font.BOLD, 18));
		eayes.setBackground(Color.WHITE);
		eayes.setBounds(360, 550, 100, 25);
		add(eayes);
		
		eano = new JRadioButton("No");
		eano.setFont(new Font("Raleway", Font.BOLD, 18));
		eano.setBackground(Color.WHITE);
		eano.setBounds(480, 550, 150, 25);
		add(eano);
		
		ButtonGroup existAcntBG = new ButtonGroup();
		existAcntBG.add(eayes);
		existAcntBG.add(eano);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 16));
		next.setBounds(650, 620, 110, 30);
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
		new SignupTwo("", ""); 
		
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{	
		try 
		{	
			String fname = fnameTF.getText();
			if(fname.equals("")) {
				JOptionPane.showMessageDialog(null, "Father's name is Required!");
				fnameTF.requestFocus();
				return;
			}
			
			String passportNo = passportTF.getText();
			if(passportNo.equals("")) {
				JOptionPane.showMessageDialog(null, "Passport Number is Required!");
				passportTF.requestFocus();
				return;
			}
			
			String race = (String)raceJB.getSelectedItem();
			if(race.equals("")) {
				JOptionPane.showMessageDialog(null, "Race is Required!");
				raceJB.requestFocus();
				return;
			}
			
			String category = (String)categoryJB.getSelectedItem();
			if(category.equals("")) {
				JOptionPane.showMessageDialog(null, "Category is Required!");
				categoryJB.requestFocus();
				return;
			}
			
			String income = (String)incomeJB.getSelectedItem();
			if(income.equals("")) {
				JOptionPane.showMessageDialog(null, "Income Details are Required!");
				incomeJB.requestFocus();
				return;
			}
			
			String education = (String)educationJB.getSelectedItem();
			if(education.equals("")) {
				JOptionPane.showMessageDialog(null, "Educational Details are Required!");
				educationJB.requestFocus();
				return;
			}
			
			String occupation = (String)occupationJB.getSelectedItem();
			if(occupation.equals("")) {
				JOptionPane.showMessageDialog(null, "Occupational Details are Required!");
				occupationJB.requestFocus();
				return;
			}
			
			String seniorCitizen = "";
			if(scyes.isSelected()) {
				seniorCitizen = "Yes";
			}
			else if (scno.isSelected()){
				seniorCitizen = "No";
			}
			if(seniorCitizen.equals("")) {
				JOptionPane.showMessageDialog(null, "Senior Citizen Status is Required!");
				scyes.requestFocus();
				return;
			}
			
			String existAcnt = "";
			if(eayes.isSelected()) {
				existAcnt = "Yes";
			}
			else if (eano.isSelected()){
				existAcnt = "No";
			}
			if(existAcnt.equals("")) {
				JOptionPane.showMessageDialog(null, "Please indicate if you have an Existing Account!");
				eayes.requestFocus();
				return;
			}
					
			//Connecting with Database
			Conn c = new Conn();
			String query = "UPDATE Customer SET fname ='"+fname+"', passportNo = '"+passportNo+"', race ='"+race+"', category = '"+category+"', income = '"+income+"', education = '"+education+"', occupation = '"+occupation+"', seniorCitizen = '"+seniorCitizen+"', existAcnt = '"+existAcnt+"' WHERE ssn = '"+ssn+"'";
			c.s.executeUpdate(query);
			c.s.close();
			
			setVisible(false);
			new SignupThree(formno, ssn).setVisible(true);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
