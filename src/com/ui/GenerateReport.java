package com.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GenerateReport extends JFrame {
    private JLabel lblReportGeneration = new JLabel();
    private JComboBox cbCustomerID = new JComboBox();
    private JComboBox lblDealerID = new JComboBox();
    private JComboBox cbEmployeeID = new JComboBox();
    private JButton bBack = new JButton();
    private JButton bGenCustFeedback = new JButton();
    private JButton bDealerReport = new JButton();
    private JButton bEmployeesalesreport = new JButton();

    public GenerateReport() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(671, 542));
        lblReportGeneration.setText("Report Generation");
        lblReportGeneration.setBounds(new Rectangle(200, 25, 295, 45));
        lblReportGeneration.setFont(new Font("Times New Roman", 1, 35));
        cbCustomerID.setBounds(new Rectangle(75, 130, 155, 35));
        lblDealerID.setBounds(new Rectangle(75, 245, 155, 35));
        cbEmployeeID.setBounds(new Rectangle(75, 355, 155, 35));
        bBack.setText("Back");
        bBack.setBounds(new Rectangle(55, 455, 90, 30));
        bBack.setFont(new Font("Times New Roman", 1, 20));
        bBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AdminUIreport bf=new AdminUIreport();
                    bf.setSize(500,500);
                	
                	bf.setLayout(new BorderLayout());
                	bf.setLocation(300,200);
                	bf.setVisible(true);
                	

                	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
                	//bBack_actionPerformed(e);
                }
            });
        bGenCustFeedback.setText("Generate Customer Feeback");
        bGenCustFeedback.setBounds(new Rectangle(300, 130, 305, 35));
        bGenCustFeedback.setFont(new Font("Times New Roman", 1, 20));
        bGenCustFeedback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // bBack_actionPerformed(e);
            	CustomerFeedbackReportUI bf=new CustomerFeedbackReportUI();
            		
            	bf.setSize(500,500);
            	
            	bf.setLayout(new BorderLayout());
            	bf.setLocation(300,200);
            	bf.setVisible(true);
            	//bf.add(p1,BorderLayout.NORTH);
            	//bf.add(p2,BorderLayout.CENTER);

            	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        bDealerReport.setText("Generate Dealer Report");
        bDealerReport.setBounds(new Rectangle(300, 245, 305, 35));
        bDealerReport.setFont(new Font("Times New Roman", 1, 20));
        bDealerReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bBack_actionPerformed(e);
            }
        });
        bEmployeesalesreport.setText("Generate Employee Report");
        bEmployeesalesreport.setBounds(new Rectangle(300, 355, 305, 35));
        bEmployeesalesreport.setFont(new Font("Times New Roman", 1, 20));
        bEmployeesalesreport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  bBack_actionPerformed(e);
            	EmployeeSalesReport bf=new EmployeeSalesReport();
            	bf.setSize(500,500);
            	
            	bf.setLayout(new BorderLayout());
            	bf.setLocation(300,200);
            	bf.setVisible(true);
            	//bf.add(p1,BorderLayout.NORTH);
            	//bf.add(p2,BorderLayout.CENTER);

            	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            }
        });
        this.getContentPane().add(bEmployeesalesreport, null);
        this.getContentPane().add(bDealerReport, null);
        this.getContentPane().add(bGenCustFeedback, null);
        this.getContentPane().add(bBack, null);
        this.getContentPane().add(cbEmployeeID, null);
        this.getContentPane().add(lblDealerID, null);
        this.getContentPane().add(cbCustomerID, null);
        this.getContentPane().add(lblReportGeneration, null);
    }

    private void bBack_actionPerformed(ActionEvent e) {
    }
}