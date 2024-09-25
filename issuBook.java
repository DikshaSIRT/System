package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class issuBook extends JFrame {
    JRadioButton r1, r2;
    JComboBox t3;
    JLabel date;
    issuBook(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label1  = new JLabel("Issu book info");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2  = new JLabel("ID :");
        label2.setBounds(25,88,46,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(150,85,140,20);
        panel.add(c);

        try {
            conn C = new conn();
            ResultSet resultSet = C.statement.executeQuery("select * from student");
            while (resultSet.next()){
                c.add(resultSet.getString("s2"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3  = new JLabel("ISBN");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(150,129,140,20);
       panel.add(textField3);

        JLabel label4  = new JLabel("Name :");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
            
        JTextField textField4 = new JTextField();
        textField4.setBounds(150,174,140,20);
        panel.add(textField4);

        JLabel label5  = new JLabel("Status :");
        label5.setBounds(25,230,97,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        t3 =new JComboBox(new String[] {"Available", "Issued"});
        t3.setBounds(150,230,140,20);
        t3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);
        
        Date date1 = new Date();

        date = new JLabel("Date :  "+date1);
        date.setBounds(25 ,270,300,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(date);


        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             try {
                 conn C  = new conn();
                 String ID =  c.getSelectedItem();
                 String ISBN = textField3.getText();
                 String name = textField4.getText()
                 ;
                 String Status = (String) t3.getSelectedItem();
                 String Date =  date.getText();
                 String q = "insert into issuBook values(''"+ID+"','"+ISBN+"','"+name+"','"+Status+"','"+Date+"')";
                 String q1 = "update book set Available = 'Issued' WHERE ISBN = '"+ISBN+"'";
                
                 C.statement.executeUpdate(q);
                 C.statement.executeUpdate(q1);
                 JOptionPane.showMessageDialog(null, "Updated Successfully");
                 setVisible(false);

             }catch (Exception E){
                 E.printStackTrace();
             }
            }
        });



        JButton back = new JButton("Back");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setLayout(null);
        setSize(970,520);
        setLocation(400,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new issuBook();
    }
}
