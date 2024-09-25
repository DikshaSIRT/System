package System;

 import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentInfo extends JFrame {
    StudentInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,960,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,950,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {

            conn c = new conn();
            String q = "select * from student inner join issuBook on student.s2=issuBook.c";
            // String q1="select name from book where book.ID=student.s2";
            ResultSet resultSet = c.statement.executeQuery(q);
            // ResultSet result = c.statement.executeQuery(q1);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            // table.setModel(DbUtils.resultSetToTableModel(result));

        }catch (Exception e ){
            e.printStackTrace();
        }

        JLabel id = new JLabel("ID");
        id.setBounds(31,11,100,14);
        id.setForeground(Color.WHITE);
        id.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(100,11,100,14);
        number.setForeground(Color.WHITE);
        number.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(210,11,100,14);
        name.setForeground(Color.WHITE);
        name.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(300,11,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(390,11,100,25);
        country.setForeground(Color.WHITE);
        country.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(country);

        JLabel book = new JLabel("book");
        book.setBounds(490,11,120,14);
        book.setForeground(Color.WHITE);
        book.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(book);


        JLabel Deposit = new JLabel("Deposit");
        Deposit.setBounds(680,11,100,25);
        Deposit.setForeground(Color.WHITE);
        Deposit.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Deposit);

        JButton back = new JButton("Back");
        back.setBounds(425,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(970,600);
        setLocation(300,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentInfo();
    }
}
