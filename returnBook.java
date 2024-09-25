package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class returnBook extends JFrame {
    returnBook(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Return book");
        label.setBounds(100,20,100,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel UserId = new JLabel("Student Id");
        UserId.setBounds(30,80,150,30);
        UserId.setFont(new Font("Tahoma",Font.BOLD,14));
        UserId.setForeground(Color.WHITE);
        panel.add(UserId);

        Choice C = new Choice();
        C.setBounds(200,80,150,25);
        panel.add(C);

        JLabel Num = new JLabel("ISBN Number");
        Num.setBounds(30,130,50,30);
        Num.setFont(new Font("Tahoma",Font.BOLD,14));
        Num.setForeground(Color.WHITE);
        panel.add(Num);
        JTextField textField3 = new JTextField();
        textField3.setBounds(200,130,150,30);
       panel.add(textField3);

        JLabel returntime = new JLabel("Return Time");
        returntime.setBounds(30,230,150,30);
        returntime.setFont(new Font("Tahoma",Font.BOLD,14));
        returntime.setForeground(Color.WHITE);
        panel.add(returntime);

        Date date = new Date();

        JLabel labelreturntime = new JLabel(""+date);
        labelreturntime.setBounds(200,230,200,30);
        labelreturntime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelreturntime.setForeground(Color.WHITE);
        panel.add(labelreturntime);


        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from issuBook");
            while (resultSet.next()){
                C.add(resultSet.getString("ID"));
                }
            
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton retrn= new JButton("Return");
        retrn.setBounds(30,300,120,30);
        retrn.setForeground(Color.WHITE);
        retrn.setBackground(Color.BLACK);
        panel.add(retrn);
        retrn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn cv = new conn();
                    cv.statement.executeUpdate("delete from IssuBook where ID = '"+C.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update Book set Available = 'Available' where ISBN = '"+Num.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }catch (Exception E ){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from issuBook where c = '"+C.getSelectedItem()+"'");
                    while (resultSet.next()){
                        Num.setText(resultSet.getString("ISBN"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args) {
        new returnBook();
    }
}
