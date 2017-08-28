package com.kcs.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserForm {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   
   JPanel panelButtons = new JPanel();
   
   JButton back, close;

   public UserForm(){
      prepareGUI();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("User");
      mainFrame.setSize(200,130);
      mainFrame.setLayout(new GridLayout(2, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(512,512);
      
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setVisible(true);				
      mainFrame.setResizable(false);
      
      Icon user = new ImageIcon("user.png");
	  statusLabel.setIcon(user);
	  
	  back = new JButton("Atgal");
      close = new JButton("Uþdaryti");
      panelButtons.add(back);
      panelButtons.add(close);
      mainFrame.add(panelButtons);
      
      back.addActionListener(new ActionListener()
      {
      	  public void actionPerformed(ActionEvent e)
      	  {
      		  LoginForm start = new LoginForm();
      		  mainFrame.dispose();
      	  }
      	
      });
      
      
      close.addActionListener(new ActionListener()
      {
      	  public void actionPerformed(ActionEvent e)
      	  {
      		  mainFrame.dispose();
      	  }
      	
      });
      
   }
  
}