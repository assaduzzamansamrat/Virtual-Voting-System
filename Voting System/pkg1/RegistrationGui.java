package pkg1;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
	//imageBackground
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class RegistrationGui{
	private JFrame RegFrame;
	private JLabel vdetailsLabel;
	private JLabel fnameLabel;
	private  JLabel dateLabel;
	private JLabel mnameLabel;
	private JLabel addressLabel;
	private JLabel vfirstnameLabel;
	private JLabel vmiddlenameLabel;
	private JLabel dobLabel;
	private JLabel vaddressLabel;
	private JTextField dobTxt;
	private JLabel vlastnameLabel;
	private JTextField vfirstNameTxt;
	private JTextField fathersNameTxt;
	private JTextField mothersNameTxt;
	private JTextField vphotopathtxt;
	private JTextField vmiddleNameTxt;
	private JTextField vlastNameTxt;
	private JButton Browsephotobutton;
	private JLabel passwordLabel;
	private JPasswordField passwordTxt;
	private JButton confirmButton;
	private JFileChooser fileChooser ;
	private File file;
	private String fileName;
	private  Path target;
	private String vFName;
	private String vMname;
	private String vLname;
	private String dob;
	private String fathersName;
	private String mothersName;
	private String userPassword;
	private String division;
	private String district;
	private String subdistrict;
	private JComboBox subdistricts;
	private JLabel IDnoLabel;
	private JButton ShowID;
	private JLabel IDno;
	private String sex;
	

	
	public RegistrationGui(){
		System.out.println("Hello from package reg gui");
		window();
		Clock();

	
	}
	//combobox options
	private String[]defaultdistrict={"--Select District--"};
	private String[]defaultsubdistrict={"--Select Subdistrict--"};
	private String[] divisionoptions={"-- Select Division --", "Dhaka", "Chittagong", "Khulna"};
	private String[] districtsofdhakaDivision={"-- Select District --","Dhaka","Faridpur","Gazipur","Gopalganj","Kishorganj","Madaripur","Manikgang","Munshigang","Narayanganj","Narsingdi","Rajbari","Shariatpur","Tangail"};
	private String[] sdtangail={"-- Select SubDistrict --","Tangail Sadar","Basail","Bhuapur","Delduar","Dhanbari","Ghatail","Gopalpur","Kalihati","Madhupur","Mirzapur"};
	
	//Frame 
	
	public void window(){
		RegFrame=new JFrame();
		RegFrame.setTitle("VID Registration form");
		RegFrame.setDefaultCloseOperation(RegFrame.HIDE_ON_CLOSE);
		RegFrame.setVisible(true);
		RegFrame.setLayout(null);
		RegFrame.setResizable(false);
		
		
		//addimage
		
		 try {
            RegFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test5.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		

	
	//vname label
		vdetailsLabel=new JLabel("Voter Details :");
		vdetailsLabel.setBounds(15,15,100,60);
		RegFrame.add(vdetailsLabel);
		
	
	//vfirstnameLabel
		vfirstnameLabel=new JLabel("First Name");
		vfirstnameLabel.setBounds(50,40,100,60);
		RegFrame.add(vfirstnameLabel);

	//vfirstNameTxtfield
		vfirstNameTxt=new JTextField("");
		vfirstNameTxt.setBounds(140,60,130,25);
		RegFrame.add(vfirstNameTxt);	
		
    //vmiddlenameLabel
	    vmiddlenameLabel=new JLabel("Middle Name");
		vmiddlenameLabel.setBounds(290,40,100,60);
		RegFrame.add(vmiddlenameLabel);
	
     //vmiddleNameTxt
	 vmiddleNameTxt=new JTextField("");
	 vmiddleNameTxt.setBounds(370,60,130,25);
	 RegFrame.add(vmiddleNameTxt);
	 
	 //vlastnameLabel
	 vlastnameLabel=new JLabel("Last Name");
	 vlastnameLabel.setBounds(530,40,100,60);
	 RegFrame.add(vlastnameLabel);
	 
	 
	 //vlastNameTxt
	 vlastNameTxt=new JTextField("");
	 vlastNameTxt.setBounds(600,60,130,25);
	 RegFrame.add(vlastNameTxt);
	 
	 //fnameLabel
		fnameLabel=new JLabel("Fathers Name");
		fnameLabel.setBounds(50,320,100,60);
		RegFrame.add(fnameLabel);
		
	
	 //mnameLabel
		mnameLabel=new JLabel("Mothers Name");
		mnameLabel.setBounds(380,320,100,60);
		RegFrame.add(mnameLabel);
		
	 //Date of birth
	 
	 dobLabel=new JLabel("Date of Birth");
	 dobLabel.setBounds(50,100,100,60);
	 RegFrame.add(dobLabel);
	 
	 //dob txt
	 dobTxt=new JTextField("dd/mm/yyyy");
	 dobTxt.setBounds(140,120,130,25);
	 RegFrame.add(dobTxt);
	 
	 //address label
	 addressLabel=new JLabel("Address");
	 addressLabel.setBounds(50,180,130,20);
	 RegFrame.add(addressLabel);
	 
	 //divisioncombo
	 JComboBox<String> divisionAdrs=new JComboBox<String>(divisionoptions);
	 divisionAdrs.setBounds(140,180,150,20);
	 RegFrame.add(divisionAdrs);
	 

	 
	 
	 //district combobox
	 JComboBox<String> tempdistricts=new JComboBox<String>(defaultdistrict);
	 tempdistricts.setBounds(340,180,150,20);
	 RegFrame.add(tempdistricts);
	 
	 //subdistrictcombo
	 
	 JComboBox<String> tempsubdistricts=new JComboBox<String>(defaultsubdistrict);
	 tempsubdistricts.setBounds(540,180,150,20);
	 RegFrame.add(tempsubdistricts);
	 
	 //division combo condition action listener
	 divisionAdrs.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent arg0) {
		 System.out.println("divisioncombo pressed");
         division=divisionAdrs.getSelectedItem().toString();		 
		
			 
		 if (divisionAdrs.getSelectedItem().equals("Dhaka")){
			 System.out.println("Ha haha");
			tempdistricts.setVisible(false);
			
			JComboBox<String> districts=new JComboBox<String>(districtsofdhakaDivision);
	        districts.setBounds(340,180,150,20);
	        RegFrame.add(districts);
			
	   
	   
	   //district combo condition action listener
		districts.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0) {
		district=districts.getSelectedItem().toString();

		System.out.println("districtcombo pressed");
		if (districts.getSelectedItem().equals("Tangail")){
			
			tempsubdistricts.setVisible(false);
			
			JComboBox<String> subdistricts=new JComboBox<String>(sdtangail);
	        subdistricts.setBounds(540,180,150,20);
	        RegFrame.add(subdistricts);
			
			
			
			
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
	
  	 
    						
     dateLabel=new JLabel();
	 dateLabel.setBounds(500,10,200,20);
	 RegFrame.add(dateLabel);
	
	 
	 
	 
	 
	 //father's name txt
	 fathersNameTxt=new JTextField("Full name");
	 fathersNameTxt.setBounds(140,340,130,25);
	 RegFrame.add(fathersNameTxt);
	 
	 //mothersNameTxt
	 mothersNameTxt=new JTextField("Full name");
	 mothersNameTxt.setBounds(480,340,130,25);
	 RegFrame.add(mothersNameTxt);
	 
	 //votterphotopath txtfield
     vphotopathtxt=new JTextField("");
     vphotopathtxt.setBounds(140,240,130,25);
     RegFrame.add(vphotopathtxt);	 
	 
	 //password label
	 passwordLabel=new JLabel("Set Password");
	 passwordLabel.setBounds(50,380,100,60);
	 RegFrame.add(passwordLabel);
	 
	 //password txt
	 passwordTxt=new JPasswordField("");
	 passwordTxt.setBounds(140,400,130,25);
	 RegFrame.add(passwordTxt);
	 
     IDno=new JLabel("ID :");
	 IDno.setBounds(160,450,120,20);
	 RegFrame.add(IDno);
	 
	 IDnoLabel=new JLabel("");
	 IDnoLabel.setBounds(200,450,120,20);
	 RegFrame.add(IDnoLabel);
	 
	 ShowID=new JButton("Show ID no");
	 ShowID.setBounds(380,450,170,25);
	 RegFrame.add(ShowID);
	 	
	 
	 
	 

	 
	  
	 
	 
	 
	 //photo browse button
	 Browsephotobutton=new JButton("Choose Photo");
	 Browsephotobutton.setBounds(140,280,130,20);
	 RegFrame.add(Browsephotobutton);
	 
	 
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
	 target = Paths.get("G:/oop1/Voting System/resources/VProfilepic", fileName);
     System.out.println("getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
     System.out.println("getSelectedFile() : " + fileChooser.getSelectedFile());
	 vphotopathtxt.setText(file.getAbsolutePath());
	

	  
	  
    } else {
      System.out.println("No Selection ");
    }
  
  
  
  
  

   
		 
		 }
	});
	
	
		JRadioButton btn1=new JRadioButton("Male");
		JRadioButton btn2=new JRadioButton("Female");
		btn1.setBounds(400,250,80,20);
		btn2.setBounds(490,250,80,20);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(btn1);
		bg.add(btn2);
		
		RegFrame.add(btn1);
		RegFrame.add(btn2);
		
		
	    btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				sex="Male";
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			sex="Female";
				
					
		}
		});
    		

	

	
	
	
	
	
	
		 //confirm button
	 confirmButton=new JButton("Confirm Registration");
	 confirmButton.setBounds(580,450,170,25);
	 RegFrame.add(confirmButton);
	 
	  confirmButton.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent arg0) {
			 
			 vFName=vfirstNameTxt.getText();
			 vMname=vmiddleNameTxt.getText();
			 vLname=vlastNameTxt.getText();
			 dob=dobTxt.getText();
			 fathersName=fathersNameTxt.getText();
			 mothersName=mothersNameTxt.getText();
			 String userPassword=new String(passwordTxt.getPassword());
			 String photopath=file.getAbsolutePath();
			 System.out.println(""+photopath);
			
			 
			 
			System.out.println(""+division);
			 System.out.println(""+district);
			 System.out.println(""+subdistrict);
			
		
		 
		 
		

  
	 try
					{
						Files.copy(file.toPath(), target);
						int votecounter=0;
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");
						Statement stmt=(Statement) con.createStatement();
						String query="INSERT INTO votingsystem.voterinfo (Vfirstname,Vmiddlename,Vlastname,DOB,Vdivision,Vdistrict,Vsubdistrict,Vphotopath,Vfathersname,Vmothersname,Password,VoteCounter,Vsex) VALUES ('"+vFName+"', '"+vMname+"', '"+vLname+"', '"+dob+"', '"+division+"', '"+district+"', '"+subdistrict+"', '"+fileName+"', '"+fathersName+"', '"+mothersName+"', '"+userPassword+"','"+votecounter+"','"+sex+"')";

						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"User successfully added");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Failed to add user");
					}

		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 }
	});
	
	
	 
	 ShowID.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent arg0) {
			 System.out.println("Show id pressed");
		  try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/votingsystem?useSSL=true", "root", "root");	 
				Statement stmt=(Statement) con.createStatement();
				String query=("SELECT * FROM voterinfo WHERE Vfirstname='"+vfirstNameTxt.getText()+ "'");
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					IDnoLabel.setText(rs.getString("Vid"));
					System.out.println("ID : "+rs.getString("Vid"));
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null," No Data Found");
				}
				}
				
				catch(Exception ex)
				{
					
									
				}				 
			
			 
		 }
		 });
	 
	 
	
	
	
	
	
	 //	frame packing	
		RegFrame.pack();
		RegFrame.setBounds(200,100,800,550);
		
    
}

		 public void Clock(){
		 Thread clock=new Thread(){
			public void run(){
				try{
					while(true){
						Calendar cal=new GregorianCalendar();
						int day=cal.get(Calendar.DAY_OF_MONTH);
						int month=cal.get(Calendar.MONTH);
						int year=cal.get(Calendar.YEAR);
						
						int second=cal.get(Calendar.SECOND);
						int minute=cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR);
					   
					    dateLabel.setText("Time  "+hour+": "+minute+": "+second+"   Date "+year+"/"+month+"/"+day);
						sleep(1000);

					}
				}
				catch(InterruptedException e){
					  e.printStackTrace();
					}
				}
		 };
		 clock.start();
}


	
} 