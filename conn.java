package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection con ;
    Statement statement;
    public conn() {
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Std","root","Diksha@20025");
       statement=con.createStatement();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
