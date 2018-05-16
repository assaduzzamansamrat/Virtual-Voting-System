package pkg1;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import java.awt.*;




public class Result{
	private JFrame messageFrame;
	private String cid1="454568857";
	private String cid2="454568858";
	private int candidate_1_totalvote;
	private int candidate_2_totalvote;
	private String winnerpropic;
	private JLabel propic;
	private String winnersymbol;
	private JLabel symbol;
	private int winner;
	private int loser;
	private JLabel m;
	private Boolean flag=false;
	
public Result(){
		System.out.println("Hello from Candidate registration gui");
		messageWindow();	
	}
	
	public void messageWindow(){
		messageFrame=new JFrame("Mesage");
		messageFrame.setLayout(null);
		messageFrame.setVisible(true);
		messageFrame.setResizable(false);
		messageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		    	//addimage
		
		 try {
            messageFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test7.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
			
		
		
         m=new JLabel();
		 m.setBounds(130,280,500,50);
		 messageFrame.add(m);

         try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.votinghistory WHERE candidateid='"+cid1+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					String tvc1=rs.getString("TotalVote");
				    candidate_1_totalvote=Integer.parseInt(tvc1);
					System.out.println(""+candidate_1_totalvote);
					
				}
				
              }
					 
								
								 
	        
			catch(Exception ex)
			{
				ex.printStackTrace();
	
			}
			
			
			
			
			
			
			
			

         try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.votinghistory WHERE candidateid='"+cid2+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					String tvc2=rs.getString("TotalVote");
				    candidate_2_totalvote=Integer.parseInt(tvc2);
					System.out.println(""+candidate_2_totalvote);
					
				}
				
              }
					 
								
								 
	        
			catch(Exception ex)
			{
				ex.printStackTrace();
	
			}
			
		
		if(candidate_1_totalvote>candidate_2_totalvote){
			
			
			
			try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.candidateinfo WHERE Cid='"+cid1+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					winnerpropic=rs.getString("Cphoto");
				    winnersymbol=rs.getString("CSign");
					
				}
				   winner=candidate_1_totalvote;
			       loser=candidate_2_totalvote;
              }
					 
								
								 
	     
			catch(Exception ex)
			{
				ex.printStackTrace();
	
			}
			
			
			
			
			
		}
		else if(candidate_2_totalvote>candidate_1_totalvote){
			
			
				
			
			try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM votingsystem.candidateinfo WHERE Cid='"+cid2+"'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					winnerpropic=rs.getString("Cphoto");
				    winnersymbol=rs.getString("CSign");
					
				}
				
					winner=candidate_2_totalvote;
			        loser=candidate_1_totalvote;
				
              }
					 
		
								 
	        
			catch(Exception ex)
			{
				ex.printStackTrace();
	
			}
			
		}
		else{
			System.out.println("Equal");
			flag=false;
		}
		
      	
		//propic
		        String  pp="G:/oop1/Voting System/resources/VProfilepic/"+winnerpropic+"";
				ImageIcon ii=new ImageIcon(pp);
				Image image=ii.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	           	propic=new JLabel(new ImageIcon(image));
				propic.setBounds(110,20,200,200);
			    messageFrame.add(propic);
				
				
				
				 String  sp="G:/oop1/Voting System/resources/Symbol/"+winnersymbol+"";
				ImageIcon i=new ImageIcon(sp);
				Image image_1=i.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
	           	symbol=new JLabel(new ImageIcon(image_1));
				symbol.setBounds(450,20,200,200);
			    messageFrame.add(symbol);
				
				
				
				
				
				
				
				
				
				
		if(flag.equals(false)){		
		m.setForeground(Color.white);
	    m.setText("Total Vote of Winner is :   '"+winner+"'      And Total Vote of Another Candidate is :   '"+loser+"'");
        }
		else if(flag.equals(true)){
		m.setForeground(Color.white);
	    m.setText("Total Vote of Each Candidate is :   '"+candidate_1_totalvote+"'");
		}
		
		messageFrame.pack();
	    messageFrame.setBounds(250,100,800,500);
		
		
	}
	 

}