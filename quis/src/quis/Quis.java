/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Login extends JFrame
        implements ActionListener {

    private JLabel judul;
    private JButton btnlogin;
    private JButton btnexit;
    private JLabel user;
    private JLabel pass;
    private JTextField user1;
    private JTextField pass1;

    public Login() {
        judul = new JLabel("LOGIN");
        btnlogin = new JButton("Login");
        btnexit = new JButton("Exit");
        user = new JLabel("Username");
        pass = new JLabel ("Password");
        user1 = new JTextField();
        pass1 = new JTextField();
        btnlogin.addActionListener(this);
        btnexit.addActionListener(this);
        user1.addActionListener(this);
        pass1.addActionListener(this);
        setLayout(null);
        add(judul);
        add(btnlogin);
        add(btnexit);
        add(user);
        add(pass);
        add(user1);
        add(pass1);
        setSize(400,200);
        judul.setBounds(190,10,120,20);
        user.setBounds(10,50,120,20);
        user1.setBounds(150,50,120,20);
        pass.setBounds(10,90,120,20);
        pass1.setBounds(150,90,120,20);
        btnlogin.setBounds(110,130,80,20);
        btnexit.setBounds(225,130,80,20);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnlogin) {
              JOptionPane.showMessageDialog(null, "Berhasil Masuk!", "Hasil",JOptionPane.INFORMATION_MESSAGE);     
                 new isi();
            
              
        }
        if (e.getSource() == btnexit) {
             
        }
    }
}
public class Quis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Login();
    }
    
}
