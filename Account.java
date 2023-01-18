package govagency;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Account extends JFrame {
    
    private JFrame frame, Sframe;
    private JLabel lblUser, lblPass, SReg, SUser, SPass, SrePass, SEmail;
    private JTextField lgUser, signUser;
    private JPasswordField fldPass, fldrePass, lgPass;
    
    public Account(){
        frame = new JFrame("Philhealth");
        Sframe = new JFrame();
        
        frame.setTitle("PhilHealth");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(350, 370);
        frame.setLocation(900, 250);
        frame.getContentPane().setBackground(Color.GREEN);
        
        ImageIcon icon = new ImageIcon("philhealth.png");
        frame.setIconImage(icon.getImage());
        
        ImageIcon image = new ImageIcon("phil.png");
        JLabel logo = new JLabel();
        logo.setIcon(image);
        logo.setBounds(15, 10, 300, 110);
       
        lblUser = new JLabel("Username: ");
        lblUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblUser.setBounds(30, 140, 120, 30);
        
        lblPass = new JLabel("Password: ");
        lblPass.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblPass.setBounds(35, 190, 120, 30);
        
        lgUser = new JTextField();
        lgUser.setBounds(110, 140, 190, 30);
        
        lgPass = new JPasswordField();
        lgPass.setBounds(110, 190, 190, 30);
              
        JButton login = new JButton("Login");
        login.setBounds(35, 250, 120, 30);
        
        JButton signup = new JButton("Sign-up");
        signup.setBounds(180, 250, 120, 30);
        
        frame.getContentPane().add(logo);
        
        frame.getContentPane().add(lblUser); 
    	frame.getContentPane().add(lgUser);
        
    	frame.getContentPane().add(lblPass);
    	frame.getContentPane().add(lgPass);
        
        frame.getContentPane().add(login);
    	frame.getContentPane().add(signup);
        
        
        
        frame.setLayout(null);
        frame.setVisible(true);
        
        login.addActionListener(new logIn());
        signup.addActionListener(new signUp());
        
      
    }
    
class signUp implements ActionListener {
    @Override
	public void actionPerformed(ActionEvent e) {    
            Sframe.setSize(360,400);
            Sframe.setLocation(900,240);
            Sframe.setTitle("Sign-Up");
            Sframe.setResizable(false);
            frame.dispose();
		
            Sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Sframe.getContentPane().setBackground(Color.GREEN);
            frame.dispose();
            
            ImageIcon icon = new ImageIcon("philhealth.png");
            frame.setIconImage(icon.getImage());
            
            //Label settings for Sign-up
            SReg = new JLabel("Register");
            SReg.setFont(new Font("Times New Roman", Font.BOLD, 30));
            SReg.setBounds(120, 20, 120, 60);
                
            SUser = new JLabel("Username: ");
            SUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
            SUser.setBounds(20, 80, 120, 30);
                
            SPass = new JLabel("Password: ");
            SPass.setFont(new Font("Times New Roman", Font.BOLD, 15));
            SPass.setBounds(20, 140, 120, 30);
                
            SrePass = new JLabel("Confirm Password: ");
            SrePass.setFont(new Font("Times New Roman", Font.BOLD, 15));
            SrePass.setBounds(20, 200, 160, 30);
                       
            //Textfield settings for Sign-up
            signUser = new JTextField ();
            signUser.setBounds(20, 110, 300, 30);
        
            fldPass = new JPasswordField();
            fldPass.setBounds(20, 170, 300, 30);
                
            fldrePass = new JPasswordField();
            fldrePass.setBounds(20, 230, 300, 30);
                    
            Sframe.getContentPane().add(SReg);
                
            Sframe.getContentPane().add(SUser);
            Sframe.getContentPane().add(signUser);
                
            Sframe.getContentPane().add(SPass);
            Sframe.getContentPane().add(fldPass); 
                
            Sframe.getContentPane().add(SrePass);
            Sframe.getContentPane().add(fldrePass);
                
              
            JButton register = new JButton("Register");
            register.setBounds(20, 290, 120, 30);
        
            JButton cancel = new JButton("Cancel");
            cancel.setBounds(200, 290, 120, 30);
       
            
            Sframe.getContentPane().add(register);
            Sframe.getContentPane().add(cancel);
                           
            Sframe.setLayout(null);
            Sframe.setVisible(true);   
            
            register.addActionListener(new Register());
            cancel.addActionListener(new Cancel());
                
        }
}

class Register implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {     
        String name = signUser.getText();
        String pass = new String(fldPass.getPassword());
        String repass = new String (fldrePass.getPassword());
           
        // validate the fields
       if((name.isEmpty() || pass.isEmpty() || repass.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            return;
}
        if(!pass.equals(repass)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match!");
            return;
        }
         //check if user already exists
            try {
                File file = new File("user.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while((line = br.readLine()) != null) {
                    if(line.contains(name)) {
                        JOptionPane.showMessageDialog(null, "Username already exists!");
                        return;
                    }                     
            }
            } catch (IOException ex) {
            
            }
            
        try{
            FileWriter fw = new FileWriter("user.txt", true);
            fw.write("Username: " + signUser.getText() + "\t" + "Password: " + new String(fldPass.getPassword()) + "\n\n");
            fw.close();
            JOptionPane.showMessageDialog(null, "Registration Completed"); 
            Sframe.dispose();
            frame.setVisible(true);
            
                           
        } catch (IOException ae){
            
        }  
            signUser.setText("");
            fldPass.setText("");
            fldrePass.setText("");
            
    }
}

class logIn implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {      
        boolean matched = false;
          
        try {
            FileReader fr = new FileReader("user.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if(line.equals("Username: " + lgUser.getText() + "\t" + "Password: " + new String(lgPass.getPassword()))) {
                    matched = true;
                    break;
                }
            }
            fr.close();
        } catch (IOException ie) {
            // handle the exception
        }
        
        if(matched) {
            frame.dispose();
            GovAgency gov = new GovAgency();
            gov.setVisible(true);
            
        }else if(lgUser.getText().isEmpty() || new String(lgPass.getPassword()).isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            
        }else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password.");
        } 
    }
}
        
class Cancel implements ActionListener {
    @Override
	public void actionPerformed(ActionEvent e) {
            Sframe.dispose(); 
            frame.setVisible(true);
            
            signUser.setText("");
            fldPass.setText("");
            fldrePass.setText("");
            
            
            
            
        }   
}

public static void main(String[] args) {
        Account acc = new Account();    
    }
}

    

