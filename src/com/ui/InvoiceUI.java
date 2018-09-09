package com.ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.dao.InvoiceDAO;
import com.entity.InvoiceEntity;



public class InvoiceUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPayCard = new JLabel();
    private JLabel lblPayCardSlno = new JLabel();
    private JTextField txtPayCardSlno = new JTextField();
    private JLabel lblCardNo = new JLabel();
    private JTextField txtCardNo = new JTextField();
    private JLabel lblExpDate = new JLabel();
    private JTextField txtExpDate = new JTextField();
    private JLabel lblCVV = new JLabel();
    private JTextField txtCVV = new JTextField();
    private JButton bSubmit = new JButton();
    private JButton bBack = new JButton();
    InvoiceEntity in=new InvoiceEntity();
    InvoiceDAO id=new InvoiceDAO(); 
    public InvoiceUI() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void jbInit() throws Exception {
        
    	this.getContentPane().setLayout( null );
        this.setSize(new Dimension(605, 467));
        lblPayCard.setText("Invoice");
        lblPayCard.setBounds(new Rectangle(225, 10, 130, 45));
        lblPayCard.setFont(new Font("Times New Roman", 0, 35));
        lblPayCardSlno.setText("InvoiceNo");
        lblPayCardSlno.setBounds(new Rectangle(65, 85, 110, 30));
        lblPayCardSlno.setRequestFocusEnabled(false);
        lblPayCardSlno.setFont(new Font("Times New Roman", 0, 20));
        txtPayCardSlno.setBounds(new Rectangle(235, 85, 115, 25));
        lblCardNo.setText("Customer id");
        lblCardNo.setBounds(new Rectangle(65, 130, 110, 30));
        lblCardNo.setRequestFocusEnabled(false);
        lblCardNo.setFont(new Font("Times New Roman", 0, 20));
        txtCardNo.setBounds(new Rectangle(235, 130, 115, 25));
        lblExpDate.setText("order id");
        lblExpDate.setBounds(new Rectangle(65, 175, 110, 30));
        lblExpDate.setRequestFocusEnabled(false);
        lblExpDate.setFont(new Font("Times New Roman", 0, 20));
        txtExpDate.setBounds(new Rectangle(235, 175, 115, 25));
        lblCVV.setText("amount");
        lblCVV.setBounds(new Rectangle(65, 215, 110, 30));
        lblCVV.setRequestFocusEnabled(false);
        lblCVV.setFont(new Font("Times New Roman", 0, 20));
        txtCVV.setBounds(new Rectangle(235, 215, 115, 25));
       
        bSubmit.setText("Submit");
        bSubmit.setBounds(new Rectangle(240, 365, 125, 35));
        bSubmit.setFont(new Font("Times New Roman", 0, 20));
        bSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	 try{
            		 in.setInvoiceno(Integer.parseInt(txtPayCardSlno.getText()));
            	        in.setAmount(Integer.parseInt(txtCVV.getText()));
            	        in.setOid(Integer.parseInt(txtExpDate.getText()));
            	        in.setCusid(Integer.parseInt(txtExpDate.getText()));
                 	id.insertinvoice(in);
                 	JOptionPane.showMessageDialog(null, "Item is placed, invoice is generated, please pay the bill");
                 }
                 catch(Exception ec){
                 	System.out.println("in invoice exception");
                 }
             
            }
         });
        
        
        bBack.setText("Back");
        bBack.setBounds(new Rectangle(45, 400, 75, 21));
        bBack.setFont(new Font("Times New Roman", 0, 20));
        this.getContentPane().add(bBack, null);
        this.getContentPane().add(bSubmit, null);
        
        this.getContentPane().add(txtCVV, null);
        this.getContentPane().add(lblCVV, null);
        this.getContentPane().add(txtExpDate, null);
        this.getContentPane().add(lblExpDate, null);
        this.getContentPane().add(txtCardNo, null);
        this.getContentPane().add(lblCardNo, null);
        this.getContentPane().add(txtPayCardSlno, null);
        this.getContentPane().add(lblPayCardSlno, null);
        this.getContentPane().add(lblPayCard, null);

       
    }
       
//    public static void main(String[] arg){
//    	InvoiceUI bf=new InvoiceUI();
//    	bf.setSize(500,500);
//    	
//    	bf.setLayout(new BorderLayout());
//    	bf.setLocation(300,200);
//    	bf.setVisible(true);
//    	//bf.add(p1,BorderLayout.NORTH);
//    	//bf.add(p2,BorderLayout.CENTER);
//
//    	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
//    	
//    	
//    }
}