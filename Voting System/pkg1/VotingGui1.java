package pkg1;

import javax.swing.*;
import java.awt.*;

public class VotingGui1 extends JFrame{
	public VotingGui1(){
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.GRAY);
		
		JRadioButton btn1=new JRadioButton("Male");
		JRadioButton btn2=new JRadioButton("Female");
		btn1.setBounds(20,20,150,20);
		btn2.setBounds(20,50,150,20);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(btn1);
		bg.add(btn2);
		
		this.add(btn1);
		this.add(btn2);
		this.setVisible(true);
		
	}
}