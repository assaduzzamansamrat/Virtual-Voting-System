package pkg1;
import javax.swing.*;
import pkg1.Voterlogin;
import clock.TimeCounter;
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


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import java.awt.*;




public class ModeratorGui{
	public JFrame ModeratorFrame;
	private JLabel insertid;
	private JTextField idtxt;
	private JButton validity;
	private JButton stopvote;
	private JLabel propic;
	private JButton gp;
	private String dbphoto;
    private	String pp;
	private JButton Clear;
	
public ModeratorGui(){
		System.out.println("Hello from Candidate registration gui");
		ModeratorWindow();	
}
	public void ModeratorWindow(){
		
			
	
		
		
		
		ModeratorFrame=new JFrame("Moderator");
		ModeratorFrame.setLayout(null);
		ModeratorFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ModeratorFrame.setVisible(true);
	
        ModeratorFrame.setResizable(false);		
	     	//addimage
		
		 try {
            ModeratorFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test7.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
			
		
		
		Clear=new JButton("Clear");
		Clear.setBounds(450,240,80,25);
		ModeratorFrame.add(Clear);
		
		Clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				propic.setVisible(false);
				
			}
		});
	
		
        insertid=new JLabel("Insert Voter ID :");
		insertid.setBounds(30,20,180,25);
		ModeratorFrame.add(insertid);
		
		idtxt=new JTextField();
		idtxt.setBounds(140,20,130,25);
		ModeratorFrame.add(idtxt);
		
		validity=new JButton("Check");
		validity.setBounds(185,55,80,25);
		ModeratorFrame.add(validity);
		
			validity.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				System.out.println("hello ");
				 try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM voterinfo WHERE Vid='"+idtxt.getText()+ "'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					dbphoto=rs.getString("Vphotopath");
					pp="G:/oop1/Voting System/resources/VProfilepic/"+dbphoto+"";
					
				System.out.println(""+pp);
				
				
				
				//propic
				ImageIcon ii=new ImageIcon(pp);
				Image image=ii.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	           	propic=new JLabel(new ImageIcon(image));
				propic.setBounds(330,20,200,200);
         		ModeratorFrame.add(propic);
				ModeratorFrame.setVisible(false);
				idtxt.setText("");
				ModeratorFrame.setVisible(true);
					
					
					
				}
				
				else{
					JOptionPane.showMessageDialog(null,"User does not exist");
				}
			 }				
								
								 
				catch(Exception ex){					
						ex.printStackTrace();
					}
								
								
		
				
				
			}
			
		});
		
		
	
		
		
		
		stopvote=new JButton("Stop Vote");
		stopvote.setBounds(40,300,200,25);
		ModeratorFrame.add(stopvote);
		stopvote.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				System.exit(0);
			}
			
		});
		
		gp=new JButton("Give Voting Permission");
		gp.setBounds(330,300,200,25);
		ModeratorFrame.add(gp);
		
	gp.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
	    propic.setVisible(false);
		Voterlogin vl=new Voterlogin();
			
		}
	});
		
		
					
		

	   ModeratorFrame.pack();
	   ModeratorFrame.setBounds(300,200,600,400);
		
		
	}
	 

}