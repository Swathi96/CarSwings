package com.ui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminUIreport extends JFrame {
    private JButton brepgenerator = new JButton();

    public AdminUIreport() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(627, 537));
        brepgenerator.setText("Generate Report");
        brepgenerator.setBounds(new Rectangle(380, 440, 195, 25));
        brepgenerator.setFont(new Font("Times New Roman", 1, 20));
        brepgenerator.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    brepgenerator_actionPerformed(e);
                }
            });
        this.getContentPane().add(brepgenerator, null);
    }

    private void brepgenerator_actionPerformed(ActionEvent e) {
        //call report generation UI
    	 GenerateReport bf=new GenerateReport();
 		bf.setSize(500,500);
     	
     	bf.setLayout(new BorderLayout());
     	bf.setLocation(300,200);
     	bf.setVisible(true);
     	//bf.add(p1,BorderLayout.NORTH);
     	//bf.add(p2,BorderLayout.CENTER);

     	bf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

