package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.entity.InvoiceEntity;

public class CustomerfeedbackDAO {
	Connection con=null;
	Statement s=null;
	ResultSet rst=null;
	PreparedStatement p=null;

	public ArrayList<Integer> getcustomerid() {
		// TODO Auto-generated method stub
		try {
			//System.out.println("invoice no  "+ ie.getInvoiceno()+"cust id " + ie.getCusid()+ "oid"+ ie.getOid()+" amount" + ie.getAmount()+"  status:" + ie.getStatus());
			Class.forName("com.mysql.jdbc.Driver");
			String query="select customerid from customerfeedback";
			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
			s=con.createStatement();
			rst=s.executeQuery(query);
			ArrayList<Integer> al=new ArrayList<>();
			while(rst.next()){
				int cusid=rst.getInt(1);
				al.add(cusid);
			}
			return al;
		
			
		}
			catch(SQLException e1){
				System.out.println("no employees");
				e1.printStackTrace();
				
				}
			catch(ClassNotFoundException e2){e2.printStackTrace();
			}
			finally{
				System.out.println("in finally");
				
			}
			return null;
		}

	public DefaultTableModel displaytable(int customerid) {
		// TODO Auto-generated method stub
		try {
			//System.out.println("invoice no  "+ ie.getInvoiceno()+"cust id " + ie.getCusid()+ "oid"+ ie.getOid()+" amount" + ie.getAmount()+"  status:" + ie.getStatus());
			DefaultTableModel model=new DefaultTableModel();//(new String[]{"carid","feedback","rating","cusid","feedbackno"},0);
			model.addRow(new String[]{"carid","feedback","rating","cusid","feedbackno"});
			Class.forName("com.mysql.jdbc.Driver");
			String query="select * from customerfeedback where customerid=?";
			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
			p=con.prepareStatement(query);//Statement();
			p.setInt(1, customerid);
			rst=p.executeQuery();
			
			while(rst.next()){
				int carid=rst.getInt(1);
				String feedback=rst.getString(2);
				int rating=rst.getInt(3);
				int cusid=rst.getInt(4);
				int feedbackno=rst.getInt(5);
				model.addRow(1,new object[]{carid,feedback,rating,cusid,feedbackno});
			}
			return model;
		
			
		}
			catch(SQLException e1){
				System.out.println("no employees");
				e1.printStackTrace();
				
				}
			catch(ClassNotFoundException e2){e2.printStackTrace();
			}
			finally{
				System.out.println("in finally");
				
			}
			return null;
		return null;
	}
}
