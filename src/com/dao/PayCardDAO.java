package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.entity.InvoiceEntity;
import com.entity.PayCard;

public class PayCardDAO {
	Connection  con=null;
	Statement s=null;
	ResultSet rs=null;
	PreparedStatement p=null;

	public int insertpayed(PayCard ie) throws ParseException {
		// TODO Auto-generated method stub
		try {
			//System.out.println("invoice no  "+ ie.getInvoiceno()+"cust id " + ie.getCusid()+ "oid"+ ie.getOid()+" amount" + ie.getAmount()+"  status:" + ie.getStatus());
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(ie.getSlno()+"cno " + ie.getCardno()+";int cvv="+ ie.getCvv());//+"; String cdate="+i.getD()+";int ino="+i.getInvoiceno());
			String query="insert into card values(?,?,?,?,?)";//,cno,cvv,cdate,ino)";
			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
			System.out.println("p = con.prepareStatement(query); ");
			p = con.prepareStatement(query); 	
			p.setInt(1, ie.getSlno());
			p.setInt(2, ie.getCardno());
			p.setInt(3, ie.getCvv());
			String dateed="2020-08-12";
			p.setString(4,dateed );
			p.setInt(5, ie.getInvoiceno());
			System.out.println("int rst=p.executeUpdate(); inno-->"+ie.getInvoiceno() );
			int rst=p.executeUpdate();
			System.out.println(rst);
			
			if(rst>0){
				System.out.println("inserted");
			}
			return 1;
		}
			catch(SQLException e1){
				System.out.println("not inserted");
				e1.printStackTrace();
				
				}
			catch(ClassNotFoundException e2){e2.printStackTrace();
			}
			finally{
				System.out.println("payment finally");
				
			}
		return 0;	
}
}