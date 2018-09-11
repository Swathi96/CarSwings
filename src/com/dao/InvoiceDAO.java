package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Entity;
import com.entity.InvoiceEntity;

public class InvoiceDAO {
	Connection  con=null;
	Statement s=null;
	ResultSet rst=null;
	PreparedStatement p=null;

	public void insertinvoice(InvoiceEntity ie) {
		// TODO Auto-generated method stub
		try {
			System.out.println("invoice no  "+ ie.getInvoiceno()+"cust id " + ie.getCusid()+ "oid"+ ie.getOid()+" amount" + ie.getAmount()+"  status:" + ie.getStatus());
			Class.forName("com.mysql.jdbc.Driver");
			String query="insert into invoice values(?,?,?,?,?)";
			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
			p = con.prepareStatement(query); 
			p.setInt(1, ie.getInvoiceno());
			p.setInt(2, ie.getCusid());
			p.setInt(4, ie.getAmount());
			p.setInt(3, ie.getOid());
			p.setInt(5, 0);
			int rst=p.executeUpdate();
			System.out.println(rst);
			
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
			
		}
		
	public int insertinvoiceStatus(int ino,int stat){
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String query="UPDATE invoice SET status=? WHERE invoiceno=?";
			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
			p = con.prepareStatement(query);//Statement(); 
		p.setInt(1, stat);
		p.setInt(2, ino);
			int result=p.executeUpdate();
		System.out.println("status update--->" + result);
//			
		if(result>0)
			return 1;
		}
			catch(SQLException e1){
				System.out.println("payment issue");
				e1.printStackTrace();
				
				}
			catch(ClassNotFoundException e2){e2.printStackTrace();
			}
			finally{
				System.out.println("in finally");
				
			}
			return 0;
		
	

	}

	public ArrayList<InvoiceEntity> getinvoices(InvoiceEntity ie ) {
		// TODO Auto-generated method stub
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			int stat=0;
			String query="select * from invoice where status="+ stat;
			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
			s = con.createStatement(); 
//			p.setInt(1, 0);
//			int result=p.executeUpdate();
//			System.out.println("no of invoices are--->" + result);
			rst=s.executeQuery(query);
			ArrayList<InvoiceEntity> ae = new ArrayList<>(); 
			int count=0;
			while(rst.next()){
				ie.setInvoiceno(rst.getInt(1));
				ie.setCusid(rst.getInt(2));
				ie.setOid(rst.getInt(3));
				ie.setAmount(rst.getInt(4));
				ie.setStatus(rst.getInt(5));
				ae.add(ie);
				System.out.println(++count);
				
			}
			return ae;
			
			
		}
			catch(SQLException e1){
				System.out.println("no invoices");
				e1.printStackTrace();
				
				}
			catch(ClassNotFoundException e2){e2.printStackTrace();
			}
			finally{
				System.out.println("in finally");
				
			}
			
		return null;
	}

	public ArrayList<Integer> getemployeeid()throws Exception {
		// TODO Auto-generated method stub
		try {
			//System.out.println("invoice no  "+ ie.getInvoiceno()+"cust id " + ie.getCusid()+ "oid"+ ie.getOid()+" amount" + ie.getAmount()+"  status:" + ie.getStatus());
			Class.forName("com.mysql.jdbc.Driver");
			String query="select empid from customerfeedback";
			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
			s=con.createStatement();
			rst=s.executeQuery(query);
			ArrayList<Integer> al=new ArrayList<>();
			while(rst.next()){
				int empid=rst.getInt(1);
				al.add(empid);
			}
			return al;
		
			
		}
			catch(SQLException e1){
				System.out.println("no employees");
				e1.printStackTrace();
				
				}
		return null;
	}
	
}
