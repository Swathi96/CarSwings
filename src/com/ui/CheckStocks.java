package com.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.dao.CarDAO;
import com.entity.Entity;

public class CheckStocks extends JFrame {
	private JRadioButton racc,rcar;
	Entity e2=new Entity();
	private JLabel lblorg,lblcheck;
	private JTextArea txtdetail;
	private static JPanel p1,p2;
	Entity ee=new Entity();
	public void CreateUI(){
		racc=new JRadioButton("accessories");
		txtdetail=new JTextArea(" ");
		JScrollPane scrollArea = new JScrollPane(txtdetail);
		
		racc.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		        // Do something here...
		    	CarDAO c=new CarDAO();
		    	txtdetail.setText("");
		    	JOptionPane.showMessageDialog(null,"create access btn");
		    	try{
		    	ArrayList<Entity> ae=c.displayAcc(e2);
		    	String v="";
		    	if(ae.size()>0){
		    		for(Entity e1:ae){
		    			v=v+e1.getEmpName()+" "+e1.getEmpMoobileNo()+" "+e1.getEmpAddress()+" "+e1.getEmpSalary()+"\n";
		    		}
		    	}
		    	txtdetail.setText(v);
		      }
		    catch(Exception e3){
		    	System.out.println("exception");}
		    }
		    
		  });
		rcar=new JRadioButton("car");
		rcar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		        // Do something here...
		    	
		    	
		    	CarDAO c=new CarDAO();
		    	JOptionPane.showMessageDialog(null,"create car btn");
		    	txtdetail.setText("");
		    	try{
			    	ArrayList<Entity> ae=c.displayCar(e2);
			    	String v="";
			    	if(ae.size()>0){
			    		for(Entity e1:ae){
			    			v=v+e1.getEmpName()+" " +e1.getEmpAddress()+" "+e1.getEmpSalary()+"\n";
			    		}
			    	}
			    	txtdetail.setText(v);
			      }
			    catch(Exception e3){
			    	System.out.println("exception");}
			    }
			    
		      
		  });
		p1=new JPanel();
		//p1.setLayout(new GridLayout(2,2));
		p2=new JPanel();
		p2.setLayout(new GridLayout(2,2));
		lblorg=new JLabel("ORGANIZATION");
		
		ButtonGroup group = new ButtonGroup();
		group.add(racc);
		group.add(rcar);
		p1.add(lblorg);
		p2.add(racc);
		p2.add(rcar);
		p2.add(txtdetail);
		this.dispose();
	}
	
	public static void main(String[] args){
		
		CheckStocks bf=new CheckStocks();
		bf.setSize(500,500);
		bf.CreateUI();
		bf.setLayout(new BorderLayout());
		bf.setLocation(300,200);
		bf.setVisible(true);
		bf.add(p1,BorderLayout.NORTH);
		bf.add(p2,BorderLayout.CENTER);
	//	bf.add(p3,BorderLayout.SOUTH);
		bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
 
}
