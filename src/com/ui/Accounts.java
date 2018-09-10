
package com.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import com.dao.AccountsDAO;
import com.dao.InvoiceDAO;
import com.entity.AccountsEntity;
import com.entity.EmployeeAttendance;
import com.entity.InvoiceEntity;
import com.entity.PayCard;

public class Accounts  extends JFrame {
	EmployeeAttendance ea=new EmployeeAttendance();
AccountsDAO ad=new AccountsDAO();
AccountsEntity ae=new AccountsEntity();
    private JLabel lblPayCard = new JLabel();
    private JLabel lblPayCardSlno = new JLabel();
    private JComboBox txtPayCardSlno = new JComboBox();
    private JLabel lblBillNo = new JLabel();
    private JTextField txtBillNo = new JTextField();
   
    private JButton bSubmit = new JButton();
    private JButton bBack = new JButton();
    InvoiceEntity in=new InvoiceEntity();
    InvoiceDAO id=new InvoiceDAO(); 
    
    
    public Accounts() {
       
        	Connection  con=null;
        	Statement s=null;
        	ResultSet rst=null;
        	PreparedStatement p=null,p2=null;
        	Date d=new Date();
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(d);
        	cal.set(Calendar.MILLISECOND, 0);
        	final Calendar calendar = Calendar.getInstance();
        	final Date date = calendar.getTime();
        	String full = new SimpleDateFormat("yyyy-MM-dd").format(date);
        	//System.out.println(full);
        	//String full="2018-09-11";
        		// TODO Auto-generated method stub
        		try {
        			//System.out.println("invoice no  "+ ie.getInvoiceno()+"cust id " + ie.getCusid()+ "oid"+ ie.getOid()+" amount" + ie.getAmount()+"  status:" + ie.getStatus());
        			Class.forName("com.mysql.jdbc.Driver");
        			String s1="Select adate from empattendance where cusid=1";
        			String query="insert into Empattendance(slno,cusid,checkin,adate) values(2,1,?,?)";
        			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
        			p = con.prepareStatement(query); 
        			p.setString(1,new java.sql.Timestamp(cal.getTimeInMillis()).toString());
        			p.setString(2, full);
        			s=con.createStatement();
        			rst=s.executeQuery(s1);
        			if(rst.next()){
        				System.out.println(" lalala" + (rst.getString(1)));
        				
        				if(full.equals(rst.getString(1))){
        					System.out.println(full+" in if equals" + (rst.getString(1)));
        				}
        				else{
        					int result=	p.executeUpdate();
        	        		if(result>0){
        	        			System.out.println("inserted next day");
        	        		}
        				}
        			}
        			
        			else{
        		int result=	p.executeUpdate();
        		if(result>0){
        			System.out.println("inserted");
        		}
        			}
        		}
        		catch (Exception e) {
                	System.out.println("employee date not inserted");
                    e.printStackTrace();
                }
        		try{
        	InvoiceDAO id=new InvoiceDAO();
        	
        	ArrayList<InvoiceEntity> arr=id.getinvoices(in);
        	for(InvoiceEntity in: arr){
        		String items=""+in.getInvoiceno();
        		txtPayCardSlno.addItem(items);
        	}
        	
            jbInit();
        } catch (Exception e) {
        	System.out.println("accounts");
            e.printStackTrace();
        }
    }
    
    private void jbInit() throws Exception {
        
    	this.getContentPane().setLayout( null );
        this.setSize(new Dimension(605, 467));
        lblPayCard.setText("Accounts");
        lblPayCard.setBounds(new Rectangle(225, 10, 130, 45));
        lblPayCard.setFont(new Font("Times New Roman", 0, 35));
        lblPayCardSlno.setText("InvoiceNo");
        lblPayCardSlno.setBounds(new Rectangle(65, 85, 110, 30));
        lblPayCardSlno.setRequestFocusEnabled(false);
        lblPayCardSlno.setFont(new Font("Times New Roman", 0, 20));
        txtPayCardSlno.setBounds(new Rectangle(235, 85, 115, 25));
        bSubmit.setText("Submit");
        bSubmit.setBounds(new Rectangle(240, 365, 125, 35));
        bSubmit.setFont(new Font("Times New Roman", 0, 20));
        bSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	// ae.setBillno(Integer.parseInt(txtBillNo.getText()));
                try{
            	ae.setInvoice(Integer.parseInt(txtPayCardSlno.getSelectedItem().toString()));
                

            	PayCardUI bf=new PayCardUI(Integer.parseInt(txtPayCardSlno.getSelectedItem().toString()));
            	 bf.setSize(500,500);
             	
             	bf.setLayout(new BorderLayout());
             	bf.setLocation(300,200);
             	bf.setVisible(true);
             	//bf.add(p1,BorderLayout.NORTH);
             	//bf.add(p2,BorderLayout.CENTER);

             	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
                catch(NullPointerException n){
                	JOptionPane.showMessageDialog(null, "NO PAYMENTS LEFT");
                }
            
            }
         });
        
        
        bBack.setText("Back");
        bBack.setBounds(new Rectangle(45, 400, 75, 21));
        bBack.setFont(new Font("Times New Roman", 0, 20));
        bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	// ae.setBillno(Integer.parseInt(txtBillNo.getText()));
            	Connection  con=null;
            	Statement s=null;
            	ResultSet rst=null;
            	PreparedStatement p=null;
            	Date d1=new Date();
            	Calendar cal = Calendar.getInstance();
            	cal.setTime(d1);
            	cal.set(Calendar.MILLISECOND, 0);
            	final Calendar calendar = Calendar.getInstance();
            	final Date date = calendar.getTime();
            	String full = new SimpleDateFormat("yyyy-MM-dd").format(date);
            	//String full="2018-09-11";
            		// TODO Auto-generated method stub
            		try {
            			//System.out.println("invoice no  "+ ie.getInvoiceno()+"cust id " + ie.getCusid()+ "oid"+ ie.getOid()+" amount" + ie.getAmount()+"  status:" + ie.getStatus());
            			Class.forName("com.mysql.jdbc.Driver");
            			//String s2="select adate from empattendance where cusid=1";
            			String query="update empattendance set checkout = ? where cusid = 1";
            			con=DriverManager.getConnection("jdbc:mysql://localhost:4000/Cars","root","root123");
            			p = con.prepareStatement(query); 
            			p.setString(1,new java.sql.Timestamp(cal.getTimeInMillis()).toString());
//            			s=con.createStatement();
//            			rst=s.executeQuery(s2);
            			
            			
            		int result=	p.executeUpdate();
            		if(result>0){
            			System.out.println("check out inserted");
            		}
            		}
            		catch (Exception e) {
                    	System.out.println("employee date not inserted");
                        e.printStackTrace();
                    }
            } 
            });
        this.getContentPane().add(bBack, null);
        this.getContentPane().add(bSubmit, null);
       // this.getContentPane().add(txtPayCardSlno, null);
        this.getContentPane().add(txtBillNo, null);
        this.getContentPane().add(lblBillNo, null);
        this.getContentPane().add(txtPayCardSlno, null);
        this.getContentPane().add(lblPayCardSlno, null);
        this.getContentPane().add(lblPayCard, null);
           }
    public static void main(String[] arg){
    	Accounts bf=new Accounts();
    	bf.setSize(500,500);
    	
    	bf.setLayout(new BorderLayout());
    	bf.setLocation(300,200);
    	bf.setVisible(true);
    	//bf.add(p1,BorderLayout.NORTH);
    	//bf.add(p2,BorderLayout.CENTER);

    	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	
    }
}