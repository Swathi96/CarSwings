package com.ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.dao.CustomerfeedbackDAO;

public class CustomerFeedbackReportUI extends JFrame {
    private JLabel lblCustfeedReport = new JLabel();
    private JTable tCustomerfeedbackTable = new JTable();
    CustomerfeedbackDAO cd=new CustomerfeedbackDAO();
    public CustomerFeedbackReportUI(int customerid) {
        try {
        	DefaultTableModel model=cd.displaytable(customerid);
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
    	
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(655, 536));
        lblCustfeedReport.setText("Customer Feedback Report");
        lblCustfeedReport.setBounds(new Rectangle(115, 25, 420, 55));
        lblCustfeedReport.setFont(new Font("Times New Roman", 1, 35));
        tCustomerfeedbackTable.setBounds(new Rectangle(45, 110, 555, 370));
        this.getContentPane().add(tCustomerfeedbackTable, null);
        this.getContentPane().add(lblCustfeedReport, null);
    }
}