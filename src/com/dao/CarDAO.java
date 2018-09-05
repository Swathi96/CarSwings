package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.entity.Entity;

public class CarDAO {
	Connection  con=null;
	Statement s=null;
	ResultSet rst=null;
	public ArrayList<Entity> displayAcc(Entity e) throws SQLException ,Exception {
		try {
	
		Class.forName("com.mysql.jdbc.Driver");
		String query="select * from employee";
		con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
		s = con.createStatement(); 
		ResultSet rst = s.executeQuery(query);
		System.out.println(query);
		Entity e1= null;
		ArrayList<Entity> ae=new ArrayList<>();
		while (rst.next()) {
			// retrieve and print the values for the current row
			//System.out.println("in rst.next" + rst.getString(7)+" designation" +rst.getString(5));
			e1=new Entity();
			e1.setEmpName(rst.getString(2));
			e1.setEmpAddress(rst.getString(3));
			e1.setEmpMoobileNo(rst.getInt(4));
			e1.setEmpSalary(rst.getInt(6));
			ae.add(e1);
			}
		return ae;
		}
		catch(SQLException e1){
			System.out.println("sql exception");
			e1.printStackTrace();
			
			}
		catch(ClassNotFoundException e2){e2.printStackTrace();
		}
		finally{
			System.out.println("in finally");
			
		}
		return null;
	}
	public ArrayList<Entity> displayCar(Entity e) throws SQLException ,Exception {
		try {
	
		Class.forName("com.mysql.jdbc.Driver");
		String query="select * from employee";
		con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
		s = con.createStatement(); 
		ResultSet rst = s.executeQuery(query);
		System.out.println(query);
		Entity e1= null;
		ArrayList<Entity> ae=new ArrayList<>();
		while (rst.next()) {
			// retrieve and print the values for the current row
			//System.out.println("in rst.next" + rst.getString(7)+" designation" +rst.getString(5));
			e1=new Entity();
			e1.setEmpName(rst.getString(2));
			e1.setEmpAddress(rst.getString(3));
			e1.setEmpMoobileNo(rst.getInt(4));
			e1.setEmpSalary(rst.getInt(6));
			ae.add(e1);
			}
		return ae;
		}
		catch(SQLException e1){
			System.out.println("sql exception");
			e1.printStackTrace();
			
			}
		catch(ClassNotFoundException e2){e2.printStackTrace();
		}
		finally{
			System.out.println("in finally");
			
		}
		return null;
	}
}