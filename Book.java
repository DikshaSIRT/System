package System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Book extends JFrame {

    JTable table;
    JButton back;

    Book(){
        JPanel panel = new JPanel();
        panel.setBounds(2,5,800,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conn c = new conn();
            String bookInfo = "select * from book";
            ResultSet resultSet = c.statement.executeQuery(bookInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e ){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel book = new JLabel("ISBN.");
        book.setBounds(12,15,80,19);
        book.setForeground(Color.WHITE);
        book.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(book);


        JLabel availability = new JLabel("Availability");
        availability.setBounds(119,15,80,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(availability);

        JLabel Name = new JLabel("Book Name");
        Name.setBounds(216,15,150,19);
        Name.setForeground(Color.WHITE);
        Name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Name);


        JLabel Price = new JLabel("Price");
        Price.setBounds(330,15,80,19);
        Price.setForeground(Color.WHITE);
        Price.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(Price);


        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(805,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Book();
    }
}
