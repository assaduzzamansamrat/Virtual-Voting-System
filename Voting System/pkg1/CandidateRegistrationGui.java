package pkg1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.filechooser.FileFilter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

//imageBackground
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class CandidateRegistrationGui{
	private JFrame candidateRegFrame;
	private JLabel voterId;
	private JTextField voteridTxt; 
	private String division;
	private String district;
	private String subdistrict;
	private JButton Validity;
	private JLabel validitation;
	private String dbdivision;
	private String dbdistrict;
	private String dbsubdistrict;
	private String cfname;
	private String cmname;
	private String clname;
	private String cphoto;
	private String cvid;
	private JButton Confirm;
    private JButton Browsephotobutton;
    private JFileChooser fileChooser ;
	private File file;
	private String fileName;
	private  Path target;
    private  JTextField vphotopathtxt;	
	
	


	
public CandidateRegistrationGui(){
		System.out.println("Hello from Candidate registration gui");
		CandidateregWindow();	
	}
	
	
		//combobox options
	private String[]defaultdistrict={"--Select District--"};
	private String[]defaultsubdistrict={"--Select Subdistrict--"};
	private String[] divisionoptions={"-- Select Division --", "Dhaka", "Chittagong", "Khulna"};
	private String[] districtsofdhakaDivision={"-- Select District --","Dhaka","Faridpur","Gazipur","Gopalganj","Kishorganj","Madaripur","Manikgang","Munshigang","Narayanganj","Narsingdi","Rajbari","Shariatpur","Tangail"};
	private String[] sdtangail={"-- Select SubDistrict --","Tangail Sadar","Basail","Bhuapur","Delduar","Dhanbari","Ghatail","Gopalpur","Kalihati","Madhupur","Mirzapur"};
	
	
	
	public void CandidateregWindow(){
		candidateRegFrame=new JFrame("Candidate registration gui");
		candidateRegFrame.setLayout(null);
		candidateRegFrame.setVisible(true);
		candidateRegFrame.setResizable(false);
		candidateRegFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
			//addimage
		
		 try {
            candidateRegFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test7.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
		
		voterId=new JLabel("Insert Voter ID :");
		voterId.setBounds(60,100,150,20);
		candidateRegFrame.add(voterId);
		
		
		voteridTxt=new JTextField("");
		voteridTxt.setBounds(180,100,150,20);
		candidateRegFrame.add(voteridTxt);
		
		
		  validitation=new JLabel();
	      validitation.setBounds(200,230,200,200);
	      candidateRegFrame.add(validitation);
		  
		  vphotopathtxt=new JTextField("");
		  vphotopathtxt.setBounds(400,100,150,20);
		  candidateRegFrame.add(vphotopathtxt);
	
		
		
		
		 
	 //divisioncombo
	 JComboBox<String> divisionAdrs=new JComboBox<String>(divisionoptions);
	 divisionAdrs.setBounds(60,180,150,20);
	 candidateRegFrame.add(divisionAdrs);
	
	 

	 
	 
	 //district combobox
	 JComboBox<String> tempdistricts=new JComboBox<String>(defaultdistrict);
	 tempdistricts.setBounds(270,180,150,20);
	 candidateRegFrame.add(tempdistricts);
	 
	 //subdistrictcombo
	 
	 JComboBox<String> tempsubdistricts=new JComboBox<String>(defaultsubdistrict);
	 tempsubdistricts.setBounds(480,180,150,20);
	 candidateRegFrame.add(tempsubdistricts);
	 
	 
	 Confirm=new JButton("Confirm");
	 Confirm.setBounds(510,280,120,30);
	 candidateRegFrame.add(Confirm);
	 Confirm.setVisible(false);
	 
	 
	 
	 
	 
	  
	 //photo browse button
	 Browsephotobutton=new JButton("Choose Symbol");
	 Browsephotobutton.setBounds(400,60,150,20);
	 candidateRegFrame.add(Browsephotobutton);
	 
	 
		  Browsephotobutton.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent arg0) {
		 System.out.println("browse photo pressed");
		 fileChooser = new JFileChooser();
	     FileFilter filter = new  FileNameExtensionFilter("*jpg","jpg"); 
         fileChooser.addChoosableFileFilter(filter);
       //  fileChooser.showOpenDialog(Browsephotobutton);
         
 
		 
  //  fileChooser.setCurrentDirectory(new java.io.File("."));
  
    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
  //  fileChooser.setAcceptAllFileFilterUsed(false);
  
  
  
  
  
  
  
  
	 if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	 file = fileChooser.getSelectedFile();
	 fileName = file.getName();
	 target = Paths.get("G:/oop1/Voting System/resources/Symbol", fileName);
     System.out.println("getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
     System.out.println("getSelectedFile() : " + fileChooser.getSelectedFile());
	 vphotopathtxt.setText(file.getAbsolutePath());
	

	  
	  
    } else {
      System.out.println("No Selection ");
    }
  
  
  
  
  

   
		 
		 }
	});
	

	
	
	 
	 
	 
	 //division combo condition action listener
	 divisionAdrs.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent arg0) {
		 System.out.println("divisioncombo pressed");
         division=divisionAdrs.getSelectedItem().toString();		 
		
			 
		 if (divisionAdrs.getSelectedItem().equals("Dhaka")){
			 System.out.println("Ha haha");
			tempdistricts.setVisible(false);
			
			JComboBox<String> districts=new JComboBox<String>(districtsofdhakaDivision);
	        districts.setBounds(270,180,150,20);
	        candidateRegFrame.add(districts);
			
	   
	   
	   //district combo condition action listener
		districts.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0) {
		district=districts.getSelectedItem().toString();

		System.out.println("districtcombo pressed");
		if (districts.getSelectedItem().equals("Tangail")){
			
			tempsubdistricts.setVisible(false);
			
			JComboBox<String> subdistricts=new JComboBox<String>(sdtangail);
	        subdistricts.setBounds(490,180,150,20);
	        candidateRegFrame.add(subdistricts);
			
			
			
			
					subdistricts.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0) {
				subdistrict=subdistricts.getSelectedItem().toString();
			
		}
	});

		
			
			 
			
			
			

		 }
		}
	});

		 }
		 }
	});
	
	
	  Validity=new JButton("Check Validity");
	  Validity.setBounds(510,230,120,30);
	  candidateRegFrame.add(Validity);
	  Validity.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent arg0) {
		  System.out.println("validity pressed");
		  
		    try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM voterinfo WHERE Vid='"+voteridTxt.getText()+ "'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					dbdivision=rs.getString("Vdivision");
					dbdistrict=rs.getString("Vdistrict");
					dbsubdistrict=rs.getString("Vsubdistrict");
					cvid=rs.getString("Vid");
					cfname=rs.getString("Vfirstname");
					cmname=rs.getString("Vmiddlename");
					clname=rs.getString("Vlastname");
					cphoto=rs.getString("Vphotopath");
					System.out.println(""+cphoto);
					  if(division.equals(dbdivision) && district.equals(dbdistrict) && subdistrict.equals(dbsubdistrict)){
						  Confirm.setVisible(true);
	             	     validitation.setText("Candidate is VALID");
						 
						Confirm.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								
								
								 
	         try
					{
						Files.copy(file.toPath(), target);
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query="INSERT INTO votingsystem.candidateinfo (Cfirstname,Cmiddlename,Clastname,Cphoto,Cvid,Cdivision,Cdistrict,Csubdistrict,CSign) VALUES ('"+cfname+"', '"+cmname+"', '"+clname+"', '"+cphoto+"','"+cvid+"', '"+dbdivision+"', '"+dbdistrict+"', '"+dbsubdistrict+"','"+fileName+"')";

						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Candidate successfully added");
						candidateRegFrame.setVisible(false);
						candidateRegFrame.setVisible(true);
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to add user");
					}
								
								
							}
						});
	                   }	

                       else{
						  validitation.setText("Candidate is NOT VALID !!!");
					   }					   
	  
					
				}
				else{
					System.out.println("hello");
				}
				
				}
				
				catch(Exception ex)
				{
					
									
				}			
		  
	  }});
	  
	  
	
		
		
	
		

		
		candidateRegFrame.pack();
	    candidateRegFrame.setBounds(300,100,700,500);
	}
	 

}