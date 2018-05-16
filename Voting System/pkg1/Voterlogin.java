package pkg1;
import clock.TimeCounter;
import pkg1.VotingGui;
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


//imageBackground
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;





//Samrat

public class Voterlogin {
	public JFrame loginFrame;
	public JLabel userNameLabel;
	public JLabel passwordLabel;
	public JTextField userNameTextField;
	public JPasswordField passwordTextField;
	public JButton loginButton;
	private int votecounter;
	private int vc=0;
	private int v_c=1;
	private String votersubdistrict;
	private String candidateSubdistrict;
	private String cid2="454568858";
	
	
   public Voterlogin(){
		
		this.loginFrame = new JFrame("Virtual Voting System");
		this.loginFrame.setVisible(true);
		this.loginFrame.setBounds(200,100,0,0);
		this.loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
        userNameLabel.setBounds(250,200,100,20);
		userNameLabel.setText("Username : ");
		this.loginFrame.add(userNameLabel);
		this.userNameLabel.setForeground(Color.white);
		
		//userNameTextField
		userNameTextField = new JTextField();
		userNameTextField.setBounds(320,200,160,30);
		this.loginFrame.add(userNameTextField);
		
		//passwordLabel
		passwordLabel=new JLabel();
        passwordLabel.setBounds(250,250,100,20);
		passwordLabel.setText("Password : ");
		this.loginFrame.add(passwordLabel);
		this.passwordLabel.setForeground(Color.white);
		
		//passwordTextField
        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(320,250,160,30);
		this.loginFrame.add(passwordTextField);
		
		
		
			try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.candidateinfo WHERE Cid='"+cid2+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					candidateSubdistrict=rs.getString("Csubdistrict");
					
				}
				
				
              }
					 
		
								 
	        
			catch(Exception ex)
			{
				ex.printStackTrace();
	
			}
	
		
		
		
		
		
		//loginButton
        loginButton = new JButton("Login");
		loginFrame.add(loginButton);
		loginButton.setBounds(400,300,80,30);
		loginButton.addActionListener(new ActionListener()
		{
			
			//Override

			public void actionPerformed(ActionEvent arg0) 
			{
				//Textfield_data_read
			    String userName=userNameTextField.getText();
		        char [] password=passwordTextField.getPassword();
				String str = String.valueOf(password);
				String databasePassword="";
				String databaseUsername="";
				
				System.out.println("printing from login button");
                 try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/medicine_info?useSSL=true", "root", "root");
			    String pass=new String(passwordTextField.getPassword());
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.voterinfo WHERE Vid='"+userNameTextField.getText()+ "'&& password='"+pass+"'");
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					databaseUsername = rs.getString("Vid");
                    databasePassword = rs.getString("password");
					String temp=rs.getString("VoteCounter");
					votecounter=Integer.parseInt(temp);
					votersubdistrict=rs.getString("Vsubdistrict");
				}
				
				if (userName.equals(databaseUsername) && str.equals(databasePassword)) {
                  System.out.println("Successful Login!\n----");
				  if(votecounter!=vc){
					  JOptionPane.showMessageDialog(null,"You Are Not Allowed To Login Today");
					  loginFrame.setVisible(false);
				  }
				  else if(votersubdistrict.equals(candidateSubdistrict)){
					  
				 try
					{
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmnt=(Statement) con.createStatement();
						String quer_y="UPDATE votingsystem.voterinfo SET VoteCounter='"+v_c+"'WHERE Vid='"+databaseUsername+"'";

						stmnt.executeUpdate(quer_y);
						loginFrame.setVisible(false);
						TimeCounter t=new TimeCounter(10);	

					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
					  
					  
					  
				  }
				  else{
					  JOptionPane.showMessageDialog(null,"You are not a voter of this subdistrict");
				  }
				  
				}	
				else{
					JOptionPane.showMessageDialog(null,"Wrong UserName or Password");
				}
		}
	catch(Exception ex){
				ex.printStackTrace();	
									
		  }		
			}		  

});
		
	
		
		
		this.loginFrame.pack();
		loginFrame.setBounds(200,80,800,500);
		
	}
	
	
	

}
