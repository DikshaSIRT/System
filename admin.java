package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {

    JButton AddStaff,AddBook, add_Drivers, logout, back;
    admin(){

       AddStaff = new JButton( "ADD Staff");
       AddStaff.setBounds(250,150,200,30);
       AddStaff.setBackground(Color.WHITE);
       AddStaff.setForeground(Color.BLACK);
       AddStaff.setFont(new Font("Tahoma", Font.BOLD, 15));
       AddStaff.addActionListener(this);
        add(AddStaff);

       AddBook = new JButton( "ADD Book");
       AddBook.setBounds(250,290,200,30);
       AddBook.setBackground(Color.WHITE);
       AddBook.setForeground(Color.BLACK);
       AddBook.setFont(new Font("Tahoma", Font.BOLD, 15));
       AddBook.addActionListener(this);
        add(AddBook);
        logout = new JButton( "Logout");
        logout.setBounds(600,600,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma", Font.BOLD, 15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton( "Back");
        back.setBounds(400,600,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        back.addActionListener(this);
        add(back);
       

        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==AddStaff){
            new AddStaff();
        } else if (e.getSource() ==AddBook) {
            new AddBook();
        } else if (e.getSource() == logout){
            System.exit(102);
        } else if (e.getSource() == back) {
            new Dashboard();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new admin();
    }
}
