package pkg1;
import pkg1.AdminGui;
import pkg1.LoginGui;
import pkg1.ModeratorGui;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.*;
import javax.swing.*;


//imageBackground
import java.io.File;
import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import pkg1.setTimeGui;




//Samrat

public class LoginGui {
	private JFrame loginFrame;
	private String dbpassword;
	private String dbuname;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JButton loginButton;
	private JButton Adminlogin;
	private JButton Moderatorlogin;
	private JButton ok;
	private JButton okay;
	private String pass;

	
	
   public LoginGui(){
		
		this.loginFrame = new JFrame("Virtual Voting System");
		this.loginFrame.setVisible(true);
		this.loginFrame.setResizable(false);
		this.loginFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.loginFrame.setLayout(null);
		loginFrame.setResizable(false);
		
		
		
		//addimage
		
		 try {
            loginFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test7.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		
		
		//userNameLabel
        userNameLabel=new JLabel();
        userNameLabel.setBounds(20,140,100,20);
		userNameLabel.setText("Username : ");
		this.loginFrame.add(userNameLabel);
		this.userNameLabel.setForeground(Color.black);
		this.userNameLabel.setVisible(false);
		
		//userNameTextField
		userNameTextField = new JTextField();
		userNameTextField.setBounds(100,140,160,30);
		this.loginFrame.add(userNameTextField);
		userNameTextField.setVisible(false);
		
		
		//passwordLabel
		passwordLabel=new JLabel();
        passwordLabel.setBounds(20,200,100,20);
		passwordLabel.setText("Password : ");
		this.loginFrame.add(passwordLabel);
		this.passwordLabel.setForeground(Color.black);
		passwordLabel.setVisible(false);
		
		//passwordTextField
        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(100,200,160,30);
		this.loginFrame.add(passwordTextField);
		passwordTextField.setVisible(false);
		
		ok=new JButton("Login");
		ok.setBounds(180,250,80,20);
		loginFrame.add(ok);
		ok.setVisible(false);
		
		okay=new JButton("Login");
		okay.setBounds(530,250,80,20);
		loginFrame.add(okay);
		okay.setVisible(false);
	
		
		
		
		
		Adminlogin=new JButton("Admin Login");
		Adminlogin.setBounds(60,50,180,25);
		loginFrame.add(Adminlogin);
		
		
		
        Adminlogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
			userNameLabel.setBounds(20,140,100,20);
			userNameTextField.setBounds(100,140,160,30);
			passwordLabel.setBounds(20,200,100,20);
		    passwordTextField.setBounds(100,200,160,30);
			ok.setBounds(180,250,80,20);
			userNameLabel.setVisible(true);
			userNameTextField.setVisible(true);
			passwordLabel.setVisible(true);
			passwordTextField.setVisible(true);
			ok.setVisible(true);
			okay.setVisible(false);
			ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
			String password=new String(passwordTextField.getPassword());


            try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.admin WHERE Aid=100003");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					dbuname=rs.getString("Ausername");
					dbpassword=rs.getString("Apassword");
					
				}
				
				if(userNameTextField.getText().equals(dbuname) && password.equals(dbpassword)){
						System.out.println("yes");
						AdminGui g1=new AdminGui();
						loginFrame.setVisible(false);
						
					}
				else{
					JOptionPane.showMessageDialog(null,"Wrong Username or Password");
				}
              }
					 
								
								 
	        
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Invalid Input");
				System.out.println("no");
			}
								
								
							

			
				
			}
			});
			
				
				
				
				
				
			}
			
		});
		
		
	    Moderatorlogin=new JButton("Moderator Login");
		Moderatorlogin.setBounds(380,50,180,25);
		loginFrame.add(Moderatorlogin);
		
        Moderatorlogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
			userNameLabel.setBounds(370,140,100,20);
			userNameTextField.setBounds(450,140,160,30);
			passwordLabel.setBounds(370,200,100,20);
			passwordTextField.setBounds(450,200,160,30);
			userNameLabel.setVisible(true);
			userNameTextField.setVisible(true);
			passwordLabel.setVisible(true);
			passwordTextField.setVisible(true);
			ok.setVisible(false);
			okay.setVisible(true);
			okay.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
					String pass_word=new String(passwordTextField.getPassword());


            try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.moderator WHERE Musername='"+userNameTextField.getText()+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					dbuname=rs.getString("Musername");
					dbpassword=rs.getString("Mpassword");
					
				}
				
				if(userNameTextField.getText().equals(dbuname) && pass_word.equals(dbpassword)){
						System.out.println("yes");
						setTimeGui stg=new setTimeGui();
						loginFrame.setVisible(false);
						
					}
				else{
					JOptionPane.showMessageDialog(null,"Wrong Username or Password");
				}
              }
					 
								
								 
	        
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Invalid Input");
				System.out.println("no");
			}
					
					
				}
			});
								
				
				
			}
			
		});


     
	
		
		
		this.loginFrame.pack();
		this.loginFrame.setBounds(200,200,700,400);
		
	}
	
	
	

}
