package govagency;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;


public class GovAgency extends JFrame { 
   private JLabel lblLogo, lblID, lblFName, lblLName, lblMName, lblBirth, lblPhone, lblAddress, lblEmail, lblMember, lblGender;
   private JTextField tfID, tfFName, tfBirth, tfPhone, tfAddress, tfEmail;
   private JComboBox<String> cbMember, cbSex;
   private JButton create,read, update, delete, clear;
   private JScrollPane scrollPane;
   private DefaultTableModel model;
   private JTable table;
   
    GovAgency(){
        //Frame settings
        this.setTitle("PhilHealth");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(720,890);
        this.setLocation(700, 100);
        this.getContentPane().setBackground(Color.GREEN);
        
        ImageIcon image = new ImageIcon("philhealth.png");
        this.setIconImage(image.getImage());    
        
        //Label settings 
        ImageIcon icon = new ImageIcon("phil.png");
        lblLogo = new JLabel();
        lblLogo.setIcon(icon);
        lblLogo.setBounds(200, 20, 300, 110);
       
        lblID = new JLabel("Member ID: ");
        lblID.setBounds(20, 140, 120, 30);
        
        lblFName = new JLabel("Full Name:");
        lblFName.setBounds(330, 140, 120, 30);
        
        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(20, 190, 120, 30);
       
        lblBirth = new JLabel("BirthDate:");
        lblBirth.setBounds(20, 240, 120, 30);
        
        lblPhone = new JLabel("Mobile No. :");
        lblPhone.setBounds(250, 240, 120, 30);
        
        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(460, 240, 120, 30);
        
        lblMember = new JLabel("Membership:");
        lblMember.setBounds(240, 290, 120, 30);
        
        lblGender = new JLabel("Gender:");
        lblGender.setBounds(20, 290, 120, 30);
        
        //Text Field settings
        tfID = new JTextField();
        tfID.setBounds(100, 140, 200, 30);
       
        tfFName = new JTextField();
        tfFName.setBounds(400, 140, 260, 30);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(100, 190, 560, 30);
     
        tfBirth = new JTextField();
        tfBirth.setBounds(100, 240, 120, 30);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(320, 240, 120, 30);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(500, 240, 160, 30);
        
        //Combobox settings
        cbMember = new JComboBox <>(new String[]{"Individual membership", "Dependent membership", "Group membership"});
        cbMember.setBounds(320, 290, 170, 30);
        
        cbSex = new JComboBox <>(new String[]{"Male", "Female"});
        cbSex.setBounds(100, 290, 120, 30);
        
        //button settings
        create = new JButton("Submit");
        create.setBounds(130, 340, 200, 40);
           
        read = new JButton("Read");
        read .setBounds(20, 770, 200, 40);
        
        update = new JButton("Update");
        update.setBounds(250, 770, 200, 40);
        
        delete = new JButton("Delete");
        delete.setBounds(480, 770, 200, 40); 
        
        clear = new JButton("Clear");
        clear.setBounds(400, 340, 200, 40);
        
         //scrollpane settings
        scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 400, 660, 350);
        
        //table settings
        table = new JTable();
        table.setBackground(Color.green);
        model = new DefaultTableModel();
        Object[]column = {"Member ID", "Full Name", "Address", "Birthdate", "Mobile No.", "Email", "Gender", "Membership"};
        final Object[]row = new Object[8];
        model.setColumnIdentifiers(column);
        table.setModel(model);
        scrollPane.setViewportView(table);
        
         //to add to the frame
        getContentPane().add(lblLogo);
       
        getContentPane().add(lblID);
        getContentPane().add(tfID);
           
        getContentPane().add(lblFName);
        getContentPane().add(tfFName);
         
        getContentPane().add(lblBirth);
        getContentPane().add(tfBirth);
        
        getContentPane().add(lblPhone);
        getContentPane().add(tfPhone);
        
        getContentPane().add(lblAddress);
        getContentPane().add(tfAddress);
        
        getContentPane().add(lblEmail);
        getContentPane().add(tfEmail);
        
        getContentPane().add(lblMember);
        getContentPane().add(cbMember);
        
        getContentPane().add(lblGender);
        getContentPane().add(cbSex);
      
        getContentPane().add(create);
        getContentPane().add(read);
        getContentPane().add(update);
        getContentPane().add(delete);
        getContentPane().add(clear);
        
        getContentPane().add(scrollPane);
        
        this.setLayout(null);   
        
        //to show the data when click the row in the table
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int i = table.getSelectedRow();
        
                tfID.setText(model.getValueAt(i, 0).toString());
                tfFName.setText(model.getValueAt(i, 1).toString());
                tfAddress.setText(model.getValueAt(i, 2).toString());
                tfBirth.setText(model.getValueAt(i, 3).toString());
                tfPhone.setText(model.getValueAt(i, 4).toString());
                tfEmail.setText(model.getValueAt(i, 5).toString());
                cbSex.setSelectedItem(model.getValueAt(i, 6).toString()); 
                cbMember.setSelectedItem(model.getValueAt(i, 7).toString());
            }
        });
         
        //Create settings
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(tfID.getText().equals("") || tfID.getText().equals("") || tfFName.getText().equals("") || tfAddress.getText().equals("") || tfBirth.getText().equals("")  || tfPhone.getText().equals("") || tfEmail.getText().equals("") || cbSex.getSelectedIndex() == -1 || cbMember.getSelectedIndex() == -1)
                {
                    JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
                }else{
                    row[0] = tfID.getText();
                    row[1] = tfFName.getText();
                    row[2] = tfAddress.getText();
                    row[3] = tfBirth.getText();
                    row[4] = tfPhone.getText();
                    row[5] = tfEmail.getText();
                    row[6] = (String) cbSex.getSelectedItem();
                    row[7] = (String) cbMember.getSelectedItem();
                    model.addRow(row);  
                
                    try{
                        FileWriter Writer = new FileWriter("MemberInfo.txt", true);
                        Writer.write( "ID: " + tfID.getText() + "\nFull Name: " + tfFName.getText() + "\nAddress: " + tfAddress.getText() + "\nBirth Date: " + tfBirth.getText() + "\nPhone Number: " + tfPhone.getText() + "\nEmail: " + tfEmail.getText() + "\nSex: " + cbSex.getSelectedItem() + "\nMember: " + cbMember.getSelectedItem() + "\n\n");
                        Writer.close();
                        JOptionPane.showMessageDialog(null, "Saved Successfully"); 
                
                    }catch(Exception e){
                    
                        }                   
                        tfID.setText("");
                        tfFName.setText("");
                        tfAddress.setText("");
                        tfBirth.setText("");
                        tfPhone.setText("");
                        tfEmail.setText("");
                        cbSex.setSelectedIndex(-1);
                        cbMember.setSelectedIndex(-1);
                    }           
                }  
        });
        
        //Read settings
        read.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                int rd = table.getSelectedRow();
                if(tfID.getText().equals("") || tfFName.getText().equals("") || tfAddress.getText().equals("") || tfBirth.getText().equals("")  || tfPhone.getText().equals("") || tfEmail.getText().equals("") || cbSex.getSelectedIndex() == -1 || cbMember.getSelectedIndex() == -1)
                {  
                    JOptionPane.showMessageDialog(null, "Please Fill Complete Information");      
                }if (rd >= 0) {
                String message = "ID: " + tfID.getText() + "\nFull Name: " + tfFName.getText() + "\nAddress: " + tfAddress.getText() + "\nBirth Date: " + tfBirth.getText() + "\nPhone Number: " + tfPhone.getText() + "\nEmail: " + tfEmail.getText() + "\nSex: " + cbSex.getSelectedItem() + "\nMember: " + cbMember.getSelectedItem();
                    JOptionPane.showMessageDialog(null, message, "Member Information", JOptionPane.INFORMATION_MESSAGE); 
                }else{
                    JOptionPane.showMessageDialog(null, "Please Select a Row to Read");
                }
            }
        });
        
        //Update settings
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int updt = table.getSelectedRow();
        
                if(updt == -1){
                    JOptionPane.showMessageDialog(null, "Please Select a Row to Update");

                } else if(tfID.getText().equals("") || tfFName.getText().equals("") || tfAddress.getText().equals("") || tfBirth.getText().equals("")  || tfPhone.getText().equals("") || tfEmail.getText().equals("") || cbSex.getSelectedIndex() == -1 || cbMember.getSelectedIndex() == -1)
                {  
                    JOptionPane.showMessageDialog(null, "Please Fill Complete Information");

                }else{
                    model.setValueAt(tfID.getText(), updt, 0);
                    model.setValueAt(tfFName.getText(), updt, 1);
                    model.setValueAt(tfAddress.getText(), updt, 2);
                    model.setValueAt(tfBirth.getText(), updt, 3);
                    model.setValueAt(tfPhone.getText(), updt, 4);
                    model.setValueAt(tfEmail.getText(), updt, 5);
                    model.setValueAt(cbSex.getSelectedItem(), updt, 6);
                    model.setValueAt(cbMember.getSelectedItem(), updt, 7); 
            
                    try{
                        FileWriter Writer = new FileWriter("MemberInfo.txt", false); //set to false to overwrite the existing file
                        for (int i = 0; i < model.getRowCount(); i++) {
                            Writer.write( "ID: " + model.getValueAt(i, 0) + "\nFull Name: " + model.getValueAt(i, 1) + "\nAddress: " + model.getValueAt(i, 2) + "\nBirth Date: " + model.getValueAt(i, 3) + "\nPhone Number: " + model.getValueAt(i, 4) + "\nEmail: " + model.getValueAt(i, 5) + "\nSex: " + model.getValueAt(i, 6) + "\nMember: " + model.getValueAt(i, 7) + "\n\n");
                        }
                            Writer.close();
    
                    }catch(Exception e){
    
                    }   
                        JOptionPane.showMessageDialog(null, "Updated Successfully");

                        tfID.setText("");
                        tfFName.setText("");
                        tfAddress.setText("");
                        tfBirth.setText("");
                        tfPhone.setText("");
                        tfEmail.setText("");
                        cbSex.setSelectedIndex(-1);
                        cbMember.setSelectedIndex(-1);
                           
                }

            }
        });
        
        //Delete settings
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int del = table.getSelectedRow();
        
                if(del >= 0) {
                    model.removeRow(del);

                    tfID.setText("");
                    tfFName.setText("");
                    tfAddress.setText("");
                    tfBirth.setText("");
                    tfPhone.setText("");
                    tfEmail.setText("");
                    cbSex.setSelectedIndex(-1);
                    cbMember.setSelectedIndex(-1);

                    try {
                        FileWriter Writer = new FileWriter("MemberInfo.txt", false); //set to false to overwrite the existing file
                        for (int i = 0; i < model.getRowCount(); i++) {
                            Writer.write( "ID: " + model.getValueAt(i, 0) + "\nFull Name: " + model.getValueAt(i, 1) + "\nAddress: " + model.getValueAt(i, 2) + "\nBirth Date: " + model.getValueAt(i, 3) + "\nPhone Number: " + model.getValueAt(i, 4) + "\nEmail: " + model.getValueAt(i, 5) + "\nSex: " + model.getValueAt(i, 6) + "\nMember: " + model.getValueAt(i, 7) + "\n\n");
                        }
                    Writer.close();
                    } catch (IOException e) {
                
                    }
                        JOptionPane.showMessageDialog(null, "Deleted Successfully");
                } else {
                        JOptionPane.showMessageDialog(null, "Please Select a Row to Delete");
                    }
            }
        });
        
        
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                tfID.setText("");
                tfFName.setText("");
                tfAddress.setText("");
                tfBirth.setText("");
                tfPhone.setText("");
                tfEmail.setText("");
                cbSex.setSelectedIndex(-1);  
                cbMember.setSelectedIndex(-1);  
            }
        });
                                 
    }
}