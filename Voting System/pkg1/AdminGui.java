package pkg1;
import pkg1.RegistrationGui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.sql.*;
import db.DBConPro;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

//imageBackground
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AdminGui{
	private JFrame adminGuiFrame;
	private JButton createsessionButton;
    private JButton changeUserPasswordButton;
    private JButton moderatorButton;
	private JButton addcanbutton;
	private JTextField sessionid;
	private JTextField cidTxt;
	private JTextField sidTxt;
	private JButton ok;
	private JButton okk;
	private JButton okkk;
	private JTextField musername;
	private JPasswordField mpassword;
   // private JComboBox timeCombo;	
    private JButton regVoter; 
	private JButton regcandidate;
	private JTextField dltvoter;
	private JButton okay;
public AdminGui(){
		System.out.println("Hello from Candidate registration gui");
		adminWindow();	
	}
	
	public void adminWindow(){
		adminGuiFrame=new JFrame("Admin gui");
		adminGuiFrame.setLayout(null);
		adminGuiFrame.setVisible(true);
		adminGuiFrame.setResizable(false);
		adminGuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
       	//addimage
		
		 try {
            adminGuiFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test7.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
		//createsessionButton
		createsessionButton=new JButton("Delete Moderator");
		createsessionButton.setBounds(30,50,180,25);
		adminGuiFrame.add(createsessionButton);
		
		sessionid=new JTextField("insert Moderator username");
		sessionid.setBounds(30,100,180,25);
		adminGuiFrame.add(sessionid);
		sessionid.setVisible(false);
		
		okkk=new JButton("Done");
		okkk.setBounds(140,150,70,25);
		adminGuiFrame.add(okkk);
		okkk.setVisible(false);
		
		
		cidTxt=new JTextField("Insert Candidate ID here");
		cidTxt.setBounds(350,250,180,25);
		adminGuiFrame.add(cidTxt);
		cidTxt.setVisible(false);
		
		sidTxt=new JTextField("insert session ID here");
		sidTxt.setBounds(350,280,180,25);
		adminGuiFrame.add(sidTxt);
		sidTxt.setVisible(false);
		
		ok=new JButton("Done");
		ok.setBounds(460,330,70,25);
		adminGuiFrame.add(ok);
		ok.setVisible(false);
		
		dltvoter=new JTextField("insert voter id here");
		dltvoter.setBounds(350,100,180,25);
		adminGuiFrame.add(dltvoter);
		dltvoter.setVisible(false);
		
		
		okay=new JButton("Done");
		okay.setBounds(460,150,70,25);
		adminGuiFrame.add(okay);
		okay.setVisible(false);
		
		
		
		regVoter=new JButton("Register Voter");
		regVoter.setBounds(620,50,180,25);
		adminGuiFrame.add(regVoter);
		
		regcandidate=new JButton("Register Candidate");
		regcandidate.setBounds(620,200,180,25);
		adminGuiFrame.add(regcandidate);
		
		regcandidate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			    CandidateRegistrationGui crg1=new CandidateRegistrationGui();
				
			}
		});
		
		
		regVoter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				RegistrationGui rg1=new RegistrationGui();				
				
			}
			
		});
		
		createsessionButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			System.out.println("Button pressed");
			sessionid.setVisible(true);
			okkk.setVisible(true);
			
			
			okkk.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
					
					
					
					
			try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query= "DELETE  FROM votingsystem.moderator WHERE Musername ='"+sessionid.getText()+"'";	
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Moderator successfully deleted");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to delete Moderator");
					}
					
	
					
				}	
			});
			
	
			
			
			
			
			
			
		}
		});
		
		//change user pass button
		changeUserPasswordButton=new JButton("Delete Voter");
		changeUserPasswordButton.setBounds(350,50,180,25);
		adminGuiFrame.add(changeUserPasswordButton);
		
		
		changeUserPasswordButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				dltvoter.setVisible(true);
				okay.setVisible(true);
				
				okay.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
					
					
									
			     try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query= "DELETE  FROM votingsystem.voterinfo WHERE  Vid='"+dltvoter.getText()+"'";	
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Voter successfully deleted");
						dltvoter.setText("");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to delete Voter");
					}
					
					
					
					
				}
					
				});
				
				
				
				
			}
		});
		
		
		
		//add moderator
		moderatorButton=new JButton("Add Moderator");
		moderatorButton.setBounds(30,200,180,25);
		adminGuiFrame.add(moderatorButton);
		
		
		
		musername=new JTextField("Insert username Here");
		musername.setBounds(30,250,180,25);
		adminGuiFrame.add(musername);
		musername.setVisible(false);
		
		mpassword=new JPasswordField("Insert password");
		mpassword.setBounds(30,300,180,25);
		adminGuiFrame.add(mpassword);
		mpassword.setVisible(false);
		
		okk=new JButton("Done");
		okk.setBounds(140,340,70,20);
		adminGuiFrame.add(okk);
		okk.setVisible(false);
		
		moderatorButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			musername.setVisible(true);
			mpassword.setVisible(true);
			okk.setVisible(true);
			
			
			
		    okk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				
				
	 try
					{
						String mps=new String(mpassword.getPassword());
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query="INSERT INTO votingsystem.moderator (Musername,Mpassword) VALUES ('"+musername.getText()+"', '"+mps+"')";
                        
						stmt.executeUpdate(query);
						musername.setText("");
						mpassword.setText("");
						JOptionPane.showMessageDialog(null,"Moderator successfully added");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to add Moderator");
					}

				
				
			}
			});

				
				
			}
		});
		
		
		
		
		
		
		//add candidate
		addcanbutton=new JButton("Add Candidate in session");
		addcanbutton.setBounds(350,200,180,25);
		adminGuiFrame.add(addcanbutton);
		
		addcanbutton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			
	     
		  cidTxt.setVisible(true);
		  sidTxt.setVisible(true);
		  ok.setVisible(true);
		  
		  ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				 try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT Cid FROM candidateinfo WHERE Cid='"+cidTxt.getText()+ "'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					int totalvote=0;
																
	            try
					{
						
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmnt=(Statement) con.createStatement();
						String query_a="INSERT INTO votingsystem.votinghistory(sessionid,candidateid,Total Vote) VALUES ('"+sidTxt.getText()+"', '"+cidTxt.getText()+"','"+totalvote+"')";

						stmnt.executeUpdate(query_a);
						JOptionPane.showMessageDialog(null,"successfully added");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to add");
					}
					
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong Candidate id or sessionid");
				}
				}
				
				catch(Exception ex)
				{
					
									
				}	
				
				
				
				
				
				

					
				
				
				
				
				
			}  
		  }
		  );
			
			
		}});

		
		adminGuiFrame.pack();
	    adminGuiFrame.setBounds(300,200,850,450);
		
		
	}
	 

}