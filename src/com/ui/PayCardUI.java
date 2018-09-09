package com.ui;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;

import com.dao.InvoiceDAO;
import com.dao.PayCardDAO;
import com.entity.InvoiceEntity;
import com.entity.PayCard;


public class PayCardUI extends JFrame {
    private JLabel lblPayCard = new JLabel();
    private JLabel lblPayCardSlno = new JLabel();
    private JTextField txtPayCardSlno = new JTextField();
    private JLabel lblCardNo = new JLabel();
    private JTextField txtCardNo = new JTextField();
    private JLabel lblExpDate = new JLabel();
    private JTextField txtExpDate = new JTextField();
    private JLabel lblCVV = new JLabel();
    private JTextField txtCVV = new JTextField();
    private JLabel lblBankName = new JLabel();
    private JTextField txtBankname = new JTextField();
    private JLabel lblCardType = new JLabel();
    private JTextField txtCardType = new JTextField();
    private JButton bSubmit = new JButton();
    private JButton bBack = new JButton();
    InvoiceEntity in=new InvoiceEntity();
    InvoiceDAO id=new InvoiceDAO(); 
    PayCard pc=new PayCard();
    PayCardDAO pd=new PayCardDAO();
    int invoiceno;
    public PayCardUI() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public PayCardUI(int invoiceno) {
    	System.out.println("in payment");
        try {
        	String ino=""+invoiceno;
        	this.invoiceno=invoiceno;
        	txtPayCardSlno.setText(ino);
        	txtPayCardSlno.setEditable(false);
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        
    	this.getContentPane().setLayout( null );
        this.setSize(new Dimension(605, 467));
        lblPayCard.setText("PayCard");
        lblPayCard.setBounds(new Rectangle(225, 10, 130, 45));
        lblPayCard.setFont(new Font("Times New Roman", 0, 35));
        lblPayCardSlno.setText("InvoiceNo");
        lblPayCardSlno.setBounds(new Rectangle(65, 85, 110, 30));
        lblPayCardSlno.setRequestFocusEnabled(false);
        lblPayCardSlno.setFont(new Font("Times New Roman", 0, 20));
        txtPayCardSlno.setBounds(new Rectangle(235, 85, 115, 25));
        lblCardNo.setText("CardNo");
        lblCardNo.setBounds(new Rectangle(65, 130, 110, 30));
        lblCardNo.setRequestFocusEnabled(false);
        lblCardNo.setFont(new Font("Times New Roman", 0, 20));
        txtCardNo.setBounds(new Rectangle(235, 130, 115, 25));
        lblExpDate.setText("Exp Date");
        lblExpDate.setBounds(new Rectangle(65, 175, 110, 30));
        lblExpDate.setRequestFocusEnabled(false);
        lblExpDate.setFont(new Font("Times New Roman", 0, 20));
        txtExpDate.setBounds(new Rectangle(235, 175, 115, 25));
        lblCVV.setText("CVV");
        lblCVV.setBounds(new Rectangle(65, 215, 110, 30));
        lblCVV.setRequestFocusEnabled(false);
        lblCVV.setFont(new Font("Times New Roman", 0, 20));
        txtCVV.setBounds(new Rectangle(235, 215, 115, 25));
        lblBankName.setText("Slno");
        lblBankName.setBounds(new Rectangle(65, 255, 110, 30));
        lblBankName.setRequestFocusEnabled(false);
        lblBankName.setFont(new Font("Times New Roman", 0, 20));
        txtBankname.setBounds(new Rectangle(235, 255, 115, 25));
        lblCardType.setText("CardType");
        lblCardType.setBounds(new Rectangle(65, 295, 110, 30));
        lblCardType.setRequestFocusEnabled(false);
        lblCardType.setFont(new Font("Times New Roman", 0, 20));
        txtCardType.setBounds(new Rectangle(235, 295, 115, 25));
        bSubmit.setText("Submit");
        bSubmit.setBounds(new Rectangle(240, 365, 125, 35));
        bSubmit.setFont(new Font("Times New Roman", 0, 20));
        bSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	 pc.setCardno(Integer.parseInt(txtCardNo.getText()));
                 pc.setCvv(Integer.parseInt(txtCVV.getText()));
                 pc.setD(txtExpDate.getText());
                 pc.setSlno(Integer.parseInt(txtBankname.getText()));
                 pc.setInvoiceno(Integer.parseInt(txtPayCardSlno.getText()));
            	if(!txtCardNo.getText().equals("")){
            	 {
            		 try {
            	 
					if(pd.insertpayed(pc)==1)
					{
            	  int stat= id.insertinvoiceStatus(invoiceno,1);
            	  if(stat==1)
            	 JOptionPane.showMessageDialog(null, "Payment successful");}
					else{
						 JOptionPane.showMessageDialog(null, "Payment unsuccessful");}
					}
            	 
            	 catch (ParseException e) {
 					// TODO Auto-generated catch block
 					System.out.println("Parse");
 					e.printStackTrace();
 				}
            }
            }
            }
         });
        
        
        bBack.setText("Back");
        bBack.setBounds(new Rectangle(45, 400, 75, 21));
        bBack.setFont(new Font("Times New Roman", 0, 20));
        this.getContentPane().add(bBack, null);
        this.getContentPane().add(bSubmit, null);
        this.getContentPane().add(txtCardType, null);
        this.getContentPane().add(lblCardType, null);
        this.getContentPane().add(txtBankname, null);
        this.getContentPane().add(lblBankName, null);
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
//	    public static void main(String[] arg){
//	    	PayCardUI bf=new PayCardUI();
//	    	bf.setSize(500,500);
//	    	
//	    	bf.setLayout(new BorderLayout());
//	    	bf.setLocation(300,200);
//	    	bf.setVisible(true);
//	    	//bf.add(p1,BorderLayout.NORTH);
//	    	//bf.add(p2,BorderLayout.CENTER);
//	
//	    	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	    	
//	    	
//	    }
}