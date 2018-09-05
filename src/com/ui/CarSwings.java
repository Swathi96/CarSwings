package com.ui;
import javax.swing.*;

import com.dao.CarDAO;
import com.entity.Entity;

import java.awt.*;
import java.awt.event.*;

public class CarSwings extends JFrame implements ActionListener{
	
	private JTextField tid,tpwd;
	private JComboBox ttype;
	public static JPanel P1,P2;
	private JButton submit;
	private static final String[] type = { "admin", "accounts", "sales" }; 
	public void CreateUi(){	
		tid=new JTextField();
		tpwd=new JTextField();
		ttype=new JComboBox(type);
		P1=new JPanel();
		P1.setLayout(new GridLayout(2,2));
		P2=new JPanel();
		submit=new JButton("submit");		
		submit.addActionListener(this);	
		
		P1.add(tid);
		P1.add(tpwd);
		P1.add(ttype);
		P2.add(submit);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit){
			try{
				CarDAO c=new CarDAO();
				Entity ent=new Entity();
				String id=tid.getText();
				String pwd=tpwd.getText();
				ent.setEmpPassword(pwd);
				ent.setEmpID(Integer.parseInt(id));
				ent.setEmpDesignation((String)ttype.getSelectedItem());
				//tb.setText(c.insertCarList());
				System.out.println(ent.getEmpID()+"pwd" + ent.getEmpPassword() +"etype " + ent.getEmpDesignation());
				boolean bool=c.loginCheck(ent);
				System.out.println(bool);
				if(bool)
				JOptionPane.showMessageDialog(null,"Welcome ADMIN");
				if(bool)
					JOptionPane.showMessageDialog(null,"check details again");
			}
			catch(Exception nfe){
				JOptionPane.showMessageDialog(null,"Exception");
			
			
			}
		}
		else{
			
		}
				
	}
	public static void main(String[] args){
	
	/*CarSwings bf=new CarSwings();
	bf.setSize(300,200);
	bf.CreateUi();
	bf.setLayout(new BorderLayout());
	bf.setLocation(300,200);
	bf.setVisible(true);
	bf.add(P1,BorderLayout.CENTER);
	bf.add(P2,BorderLayout.SOUTH);
	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
	*/
	}

}
