package com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.dao.CarDAO;
import com.dao.CustCombo;
import com.entity.Entity;


public class CustomerHistory  extends JFrame {
	private JComboBox cb1;
	Entity e2=new Entity();
	
	 private String[] tempType = { "" }; 
	
	private JLabel FromWhat;
	public static JPanel P1,P2;
	private JTextArea txtarea;
	
	
	
	public void CreateUi(){
		this.setBackground(Color.black);
		cb1=new JComboBox(tempType);
		txtarea=new JTextArea();
		FromWhat=new JLabel();
	
		P1=new JPanel();
		P1.setLayout(new GridLayout(2,2));
		P2=new JPanel();
		 try {
			CustCombo c=new CustCombo();
			 
            ArrayList<Entity> al=c.getName();
            
            for(Entity temp:al){
            	String item=temp.getEmpName();
            	cb1.addItem(item);
            }
            
        

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);
    }
		
		//
		
		 cb1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                //
	                // Get the source of the component, which is our combo
	                // box.
	                //
	            	txtarea.setText("");
	                JComboBox comboBox = (JComboBox)event.getSource();
	                String v="";
	                String selected = comboBox.getSelectedItem().toString();
	                try{
	                	CustCombo c=new CustCombo();
	       			 
	                    ArrayList<Entity> al=c.getName();
	                    
	                    for(Entity temp:al){
	                    	v= v+ temp.getEmpName()+"\t"+temp.getEmpMoobileNo()+"\t"+temp.getEmpSalary()+"\n";
	                    }
	                    txtarea.setText(v);
	                    }
	                    
	                    catch(Exception e){
	                    	}
	                    
	               

	            }
	        });
		P1.add(FromWhat);
		P1.add(cb1);
		
		P2.add(txtarea);
		this.dispose();
	}
	
	public static void main(String[] args){
		
		CustomerHistory bf=new CustomerHistory();
		bf.setBackground(Color.BLACK);;

	
		
		bf.setSize(500,500);
		bf.CreateUi();
		bf.setLayout(new BorderLayout());
		bf.setLocation(300,200);
		bf.setVisible(true);
		bf.add(P1,BorderLayout.NORTH);
		bf.add(P2,BorderLayout.CENTER);
	//	bf.add(p3,BorderLayout.SOUTH);
		bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
		}
 
}
