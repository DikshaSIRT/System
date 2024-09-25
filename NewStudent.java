package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewStudent extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber ,TextName, TextCollege,TextAge;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;

    JButton add,back;
    NewStudent(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource(""));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imglabel = new JLabel(imageIcon1);
        imglabel.setBounds(550,150,200,200);
        panel.add(imglabel);

        JLabel labelName = new JLabel("New student");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma", Font.BOLD,20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelID = new JLabel("Id :");
        labelID.setBounds(35,66,200,14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"Aadhar Card", "Voter Id", "Enrollment"});
        comboBox.setBounds(271,66,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35,101,200,14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,101,150,20);
        panel.add(textFieldNumber);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(35,141,200,14);
        labelname.setForeground(Color.WHITE);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelname);
        TextName = new JTextField();
        TextName.setBounds(271,141,150,20);
        panel.add(TextName);


        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,181,200,14);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3,45,48));
        r1.setBounds(271,181,80,12);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3,45,48));
        r2.setBounds(350,181,80,12);
        panel.add(r2);

      JLabel labelCo = new JLabel("College/School:");
        labelCo.setBounds(35,200,200,14);
        labelCo.setForeground(Color.WHITE);
        labelCo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelCo);
        TextCollege = new JTextField();
        TextCollege.setBounds(271,200,150,20);
        panel.add(TextCollege);
        JLabel labelA = new JLabel("Age :");
        labelA.setBounds(35,340,200,14);
        labelA.setForeground(Color.WHITE);
        labelA.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(labelA);
        TextAge = new JTextField();
        TextAge.setBounds(271,340,150,20);
        panel.add(TextAge);
        add = new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260,430,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setLayout(null);
        setLocation(500,150);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            conn c = new conn();
            String radioBTn = null;
            if (r1.isSelected()){
                radioBTn = "Male";
            } else if (r2.isSelected()) {
                radioBTn = "Female";
            }

            String s1 = (String)comboBox.getSelectedItem();
            String s2 =  textFieldNumber.getText();
            String s3 =  TextName.getText();
            String s4 =  radioBTn;
            String s5 =  TextCollege.getText();
            String s9 = TextAge.getText();
            try {

                String q ="insert into student values('"+s1+"', '"+s2+"','"+s3+"','"+s4+"', '"+s5+"','"+s9+"')";
                 c.statement.executeUpdate(q);
               
                JOptionPane.showMessageDialog(null, "added Successfully");
                setVisible(false);

            }catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new NewStudent();
    }
}
