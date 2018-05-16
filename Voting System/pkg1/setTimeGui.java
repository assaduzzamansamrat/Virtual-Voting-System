package pkg1;
import clock.Time_r;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

//imageBackground
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
public class setTimeGui{
	public static JFrame messageFrame;
	private JLabel setVotingtime;
	private JButton Start;
	private int time=0; 
	
public setTimeGui(){
		setTimeWindow();	
	}
	
	public void setTimeWindow(){
		messageFrame=new JFrame("Virtual Voting System");
		messageFrame.setLayout(null);
		messageFrame.setVisible(true);
		messageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
			//addimage
		
		 try {
            messageFrame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("G:/oop1/Voting System/resources/test.jpg")))));
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
	    setVotingtime=new JLabel("Set Voting Time");
		setVotingtime.setBounds(190,30,180,50);
		messageFrame.add(setVotingtime);
		
	    JRadioButton btn1=new JRadioButton("5 minutes");
		JRadioButton btn2=new JRadioButton("15 minutes");
		JRadioButton btn3=new JRadioButton("30 minutes");
		JRadioButton btn4=new JRadioButton("1 hour");
		btn1.setBounds(30,80,100,20);
		btn2.setBounds(150,80,100,20);
		btn3.setBounds(270,80,100,20);
		btn4.setBounds(380,80,100,20);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(btn1);
		bg.add(btn2);
		bg.add(btn3);
		bg.add(btn4);
		
		messageFrame.add(btn1);
		messageFrame.add(btn2);
		messageFrame.add(btn3);
		messageFrame.add(btn4);
		
	    btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			time=5*60;
			}
		});
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			
			time=15*60;
					
		}
		});
		
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			time=30*60;
				
					
		}
		});
		
		
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
			
				time=60*60;
					
		}
		});
		
		Start=new JButton("START VOTE");
		Start.setBounds(320,210,120,25);
		messageFrame.add(Start);
		Start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println("button");
				
				Time_r tr=new Time_r(time);
				
			}
		});
    		

	

		
		messageFrame.pack();
	    messageFrame.setBounds(300,100,500,300);
		
		
	}
	 

}