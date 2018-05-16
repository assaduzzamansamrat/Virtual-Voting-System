package pkg1;

import pkg1.Message;
import java.awt.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.util.*;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

//import javax.swing.JButtonGroup;
import clock.TimeCounter;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.*;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

//imageBackground
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class VotingGui{
	public JFrame votingframe;
	private JLabel chooseCandidate;
	private JButton confirmVote;
	private JLabel timecounter;;
    private JLabel symbolLabel_1;	
	private JLabel symbolLabel_2;
	private int candidate1Counter=0;
	private int candidate2Counter=0;
	private JRadioButton c1;
	private String id="454568857";
	private String id_1="454568858";
	private String dbphoto;
	private String pp;
	private JRadioButton c2;
	private ButtonGroup group;
	private JLabel Message;
	private Boolean flag;
	//private JButtonGroup group=new JButtonGroup();
	public VotingGui(){
		System.out.println("Hello from Voting gui");
		VotingWindow();
		
	}
	

	
	public void VotingWindow(){
		
		
		//creating frame
		votingframe=new JFrame();
		votingframe.setTitle("Virtual Voting System");
		votingframe.setResizable(false);
		votingframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		votingframe.setVisible(true);
		votingframe.setLayout(null);
		votingframe.setResizable(false);
		
		
		 try {
            votingframe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test7.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		

		 
		JRadioButton btn1=new JRadioButton("Bangladesh Nationalist Party(BNP)");
		JRadioButton btn2=new JRadioButton("Bangladesh Awamileague(BAL)");
		btn1.setBounds(60,350,250,20);
		btn2.setBounds(470,350,250,20);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(btn1);
		bg.add(btn2);
		
		votingframe.add(btn1);
		votingframe.add(btn2);
		
		Message=new JLabel("Confirm Your Vote Within 1 Minute");
		Message.setBounds(280,30,300,50);
		Message.setForeground(Color.white);
		votingframe.add(Message);
		
	    btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				
				flag=true;
				System.out.println(""+flag);
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				System.out.println("hello world");	
				flag=false;
				System.out.println("hello"+flag);
				
					
		}
		});
    		





            try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.votinghistory WHERE candidateid='"+id+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					String tvc1=rs.getString("TotalVote");
				    candidate1Counter=Integer.parseInt(tvc1);
					System.out.println(""+candidate1Counter);
					
				}
				
              }
					 
								
								 
	        
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Invalid Input");
	
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
            try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.votinghistory WHERE candidateid='"+id_1+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					String tvc2=rs.getString("TotalVote");
				    candidate2Counter=Integer.parseInt(tvc2);
					System.out.println(""+candidate2Counter);
					
				}
				
              }
					 
								
								 
	        
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Invalid Input");
	
			}
								
								
							

						
	
		
	
		
		
		
		
		 try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM candidateinfo WHERE Cid='"+id+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					dbphoto=rs.getString("CSign");
					pp="G:/oop1/Voting System/resources/Symbol/"+dbphoto+"";
					System.out.println(""+pp);
	        
		        
				//symbolLabel_1
				ImageIcon ii=new ImageIcon(pp);
				Image image=ii.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	           	symbolLabel_1=new JLabel(new ImageIcon(image));
				symbolLabel_1.setBounds(30,75,300,250);
				votingframe.add(symbolLabel_1);
		
				
				
		 
				
				votingframe.setVisible(false);
		        votingframe.setVisible(true);
		
					
					
					
				}
			 }				
								
								 
	   
			 catch(Exception ex)
			{
						JOptionPane.showMessageDialog(null,"User does not exist");
			}
								
								
		
		
		
		
		
		
		
		
		
	
			
		
		 try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM candidateinfo WHERE Cid='"+id_1+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					dbphoto=rs.getString("CSign");
					String pp1="G:/oop1/Voting System/resources/Symbol/"+dbphoto+"";
					System.out.println(""+pp1);
	
        		
				
				
					
	        	
		        
				//symbolLabel_2
				
				
				
			
				ImageIcon ii=new ImageIcon(pp1);
				Image image1=ii.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	           	symbolLabel_2=new JLabel(new ImageIcon(image1));
				symbolLabel_2.setBounds(450,50,300,300);
				votingframe.add(symbolLabel_2);
				
				
			
			
				votingframe.setVisible(false);
		        votingframe.setVisible(true);
		
					
					
					
				}
			 }				
								
								 
	   
			 catch(Exception ex)
			{
						JOptionPane.showMessageDialog(null,"User does not exist");
			}
		
		
	
		

	
		  	
	    
		
	

		
		//add confirmbutton
		confirmVote=new JButton("Confirm");
		confirmVote.setBounds(680,400,80,30);
		votingframe.add(confirmVote);
		
		
		
		
		
		
		
	 
		//action event
		confirmVote.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			System.out.println("Confirm button pressed from voting gui");
			
			if(flag.equals(true)){
				candidate1Counter=candidate1Counter+1;
				
				System.out.println("inside flag");
				
		
				 try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query="UPDATE votingsystem.votinghistory SET TotalVote='"+candidate1Counter+"'WHERE candidateid='"+id+"'";

						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Thank You For Your Valuable Vote ");
						votingframe.setVisible(false);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
		
				
				
				
				
				
				
			}
			else{
				candidate2Counter=candidate2Counter+1;
				
				
				
					 try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query="UPDATE votingsystem.votinghistory SET TotalVote='"+candidate2Counter+"'WHERE candidateid='"+id_1+"'";

						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Thank You For Your Valuable Vote ");
						votingframe.setVisible(false);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
		
			}
			

			
				
		}
			
			
			
			
			
		});
		
		
		
		

		
		
		
		
	   
		
		//frame packing
		votingframe.pack();
		votingframe.setBounds(200,100,820,490);
		
	}
	}

	

	
	
	