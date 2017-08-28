package com.kcs.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.kcs.database.User;
import com.kcs.database.UserDao;

@SuppressWarnings("serial")
public class RegistrationForm extends JFrame {
	
	JTextArea textArea = new JTextArea(0,10);
 
    JPanel panelFirstName = new JPanel();
    JPanel panelLastName = new JPanel();
    JPanel panelEMail = new JPanel();
	JPanel panelAddress = new JPanel();
	JPanel panelPhone = new JPanel();
	JPanel panelUName = new JPanel();
	JPanel panelPass = new JPanel();
    JPanel panelButtons = new JPanel();
    
    TextField firstName, lastName, email, address, phone, uname;
    JPasswordField pass;

    JButton submit, cancel, close;
    
    public static boolean validateFirstName(String firstNameStr) { 
		final Pattern VALID_FIRST_NAME = 
			    Pattern.compile("^[a-zA-Z]{3,20}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_FIRST_NAME.matcher(firstNameStr);
		return matcher.find();
	}
    
    public static boolean validateLastName(String lastNameStr) { 
		final Pattern VALID_LAST_NAME = 
			    Pattern.compile("^[a-zA-Z]{3,20}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_LAST_NAME.matcher(lastNameStr);
		return matcher.find();
	}
    
    public static boolean validateEMail(String emailStr) { 
		final Pattern VALID_EMAIL = 
			    Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL.matcher(emailStr);
		return matcher.find();
	}
    
    public static boolean validatePhone(String phoneStr) { 
		final Pattern VALID_PHONE = 
			    Pattern.compile("^[0-9]{8,12}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_PHONE.matcher(phoneStr);
		return matcher.find();
	}
    
    public static boolean validateUName(String unameStr) { 
		final Pattern VALID_UNAME = 
			    Pattern.compile("^[a-zA-Z0-9._%+-]{3,20}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_UNAME.matcher(unameStr);
		return matcher.find();
	}
    
    public static boolean validatePass(String passStr) { 
		final Pattern VALID_PASS = 
			    Pattern.compile("^[a-zA-Z0-9._%+-]{3,20}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_PASS.matcher(passStr);
		return matcher.find();
	}
    
    public RegistrationForm() {
        create();
        setTitle("Registracijos forma");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);				
		setResizable(false);
    }    

    public void cleanFields() {
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        address.setText("");
        phone.setText("");
        uname.setText("");
        pass.setText("");
	}
    
    public void create() {

        Container container = getContentPane();
        container.setLayout(new GridLayout(9, 0, 10, 0));
        container.setBackground(Color.lightGray);
        
        textArea.setEditable(false);
        textArea.setBackground(Color.lightGray);
        textArea.setForeground(Color.black);
        
        panelFirstName.setBorder(new TitledBorder("Vardas: *"));
        firstName = new TextField("", 20);
        panelFirstName.add(firstName);
        container.add(panelFirstName);
        
        panelLastName.setBorder(new TitledBorder("Pavardë:"));
        lastName = new TextField("", 20);
        panelLastName.add(lastName);
        container.add(panelLastName);
        
        panelEMail.setBorder(new TitledBorder("El. paðtas:"));
        email = new TextField("", 20);
        panelEMail.add(email);
        container.add(panelEMail);
        
        panelAddress.setBorder(new TitledBorder("Adresas:"));
        address = new TextField("", 20);
        panelAddress.add(address);
        container.add(panelAddress);
        
        panelPhone.setBorder(new TitledBorder("Tel. numeris:"));
        phone = new TextField("", 20);
        panelPhone.add(phone);
        container.add(panelPhone);
        
        panelUName.setBorder(new TitledBorder("Vartotojo vardas:"));
        uname = new TextField("", 20);
        panelUName.add(uname);
        container.add(panelUName);
        
        panelPass.setBorder(new TitledBorder("Slaptaþodis:"));
        pass = new JPasswordField("", 15);
        panelPass.add(pass);
        container.add(panelPass);
        
        submit 	= new JButton ("Patvirtinti");
        cancel 	= new JButton ("Atðaukti");
        close 	= new JButton ("Uþdaryti");
        panelButtons.add(submit);
        panelButtons.add(cancel);
        panelButtons.add(close);
        container.add(panelButtons);
	    
        UserDao dao = new UserDao();

        submit.addActionListener(new ActionListener()
        {
        	  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
        	  {
        		  String firstName2 = firstName.getText().toString();
        		  String lastName2 = lastName.getText().toString();
        		  String email2 = email.getText().toString();
        		  String phone2 = phone.getText().toString();
        		  String uname2 = uname.getText().toString();
        		  String pass2 = pass.getText().toString();
        		  
        		  User user = new User();
        		  
        		  if(!validateFirstName(firstName2)) {
            			JOptionPane.showMessageDialog(null, "Blogai ivestas vardas", "Error", JOptionPane.ERROR_MESSAGE);
        		  } else if(!validateLastName(lastName2)) {
              			JOptionPane.showMessageDialog(null, "Blogai ávesta pavardë", "Error", JOptionPane.ERROR_MESSAGE);
        		  } else if(!validateEMail(email2)) {
                		JOptionPane.showMessageDialog(null, "Blogai ávestas el. paðto adresas", "Error", JOptionPane.ERROR_MESSAGE);
        		  } else if(!validatePhone(phone2)) {
                		JOptionPane.showMessageDialog(null, "Blogai ávestas telefono numeris", "Error", JOptionPane.ERROR_MESSAGE);
        		  } else if(!validateUName(uname2)) {
              			JOptionPane.showMessageDialog(null, "Blogai ávestas vartotojo vardas", "Error", JOptionPane.ERROR_MESSAGE);
        		  } else if(!validatePass(pass2)) {
              			JOptionPane.showMessageDialog(null, "Blogai ávestas slaptaþodis", "Error", JOptionPane.ERROR_MESSAGE);
        		  } else {// cia kai pravaliduoja sekmingai
            		  user.setFirstName(firstName.getText());
            		  user.setLastName(lastName.getText());
            		  user.setEmail(email.getText());
            		  user.setAddress(address.getText());
            		  user.setPhone(phone.getText());
            		  user.setUname(uname.getText());
            		  user.setPass(pass.getText());
        			  
        			  dao.addUser(user);
            		  JOptionPane.showMessageDialog(container, "Jûsø registracija buvo sëkminga!", "Info" , JOptionPane.INFORMATION_MESSAGE);
            		  cleanFields();
        		  }
        		  
        	      
        	  }
        	
        });
        
        cancel.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  @SuppressWarnings("unused")
				LoginForm start = new LoginForm();
        		  dispose();      	    
        	  }
        	
        });
        
        close.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  dispose();      	    
        	  }
        	
        });
        
       
    }
    
}