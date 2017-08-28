package com.kcs.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.kcs.database.User;
import com.kcs.database.UserDao;

public class LoginForm extends JFrame {

	private boolean succeeded;

    JTextArea textArea = new JTextArea(0,10);

	JPanel panelUName = new JPanel();
	JPanel panelPass = new JPanel();
    JPanel panelButtons = new JPanel();

    TextField uname;
    JPasswordField pass;

    JButton login, reg, close;
    
	User info;
	UserDao dao;
    
    public LoginForm() {
        create();
        setTitle("Login forma");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);				
		setResizable(false);
    }

    public void cleanFields() {
        uname.setText("");
        pass.setText("");
    }

    public void create() {

        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 0, 10, 0));
        container.setBackground(Color.lightGray);
        
        textArea.setEditable(false);
        textArea.setBackground(Color.lightGray);
        textArea.setForeground(Color.black);

        panelUName.setBorder(new TitledBorder("Vartotojo vardas:"));
        uname = new TextField("", 20);
        panelUName.add(uname);
        container.add(panelUName);
        
        panelPass.setBorder(new TitledBorder("Slaptaþodis:"));
        pass = new JPasswordField("", 15);
        panelPass.add(pass);
        container.add(panelPass);

        login 	= new JButton ("Prisijungti");
        reg 	= new JButton ("Registruotis");
        close 	= new JButton ("Uþdaryti");
        panelButtons.add(login);
        panelButtons.add(reg);
        panelButtons.add(close);
        container.add(panelButtons);
	    
        dao = new UserDao();     
       
        login.addActionListener(new ActionListener()
        {
			  public void actionPerformed(ActionEvent ae) {
				  String Uname = uname.getText();
				  String Pass = pass.getText();
				  
				  info = dao.validateUserCredentials(Uname, Pass);
				  
				  if(info != null) {
					  JOptionPane.showMessageDialog(null,"Sveikiname sëkmingai prisijungus!");
					  UserForm start = new UserForm();
					  dispose();
				  } else if(Uname.equals("admin") && Pass.equals("admin")) {
					  JOptionPane.showMessageDialog(null,"O, ''Adminas'' :D");
					  AdminForm start = new AdminForm();
					  dispose();
				  } else {
					  JOptionPane.showMessageDialog(null,"Blogai ávestas vartotojo vardas ir/arba slaptaþodis. Bandykite dar kartà.");
				  }
					  
			  }
        					  
        });
        
        reg.addActionListener(new ActionListener()
        {
        	  public void actionPerformed(ActionEvent e)
        	  {
        		  RegistrationForm start = new RegistrationForm();
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