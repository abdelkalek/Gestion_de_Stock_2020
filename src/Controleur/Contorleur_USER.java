package Controleur;
import Classes.user;
import View.Stock;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import javax.swing.text.View;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import View.Auth;

public class Contorleur_USER {

    public void connecter(user u) throws SQLException {
        OracleDataSource ods = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        String log = "";
        String pwd= "";

            //      ods.setURL("jdbc:oracle:thin:abdelkalek/abdelkalek@DESKTOP-6EFAGB6:1521:XE");
            // Create DataSource and connect to the local database
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//DESKTOP-6EFAGB6:1521/XE");
            ods.setUser("abdelkalek");
            ods.setPassword("abdelkalek");
            conn = ods.getConnection();
            try {
                // Query the employee names
                stmt = conn.createStatement();
           //     int j  = stmt.executeUpdate("insert into users values(10,'Raed','Raed')");
        rset = stmt.executeQuery("SELECT login,password FROM users");
                // Print the name out
                while (rset.next()) {
                    log =   rset.getString("login");
                    pwd = rset.getString("password");
                }
            }catch (Exception Ex )
            {
                System.out.println(Ex.getMessage());

            }
            /* Close the result set, statement, and the connection */
        finally {
                if (rset != null) rset.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
        System.out.println(u.getLogin());
        System.out.println(u.getPassword());
        System.out.println(log);
        System.out.println(pwd);

        if((u.getLogin().equals(log)) && (u.getPassword().equals(pwd)))
         {
             Stock s = new Stock();
         }
        else
            {
                new Auth().Lbl_msgCon.setText("User doesn't exist");
            }
    }
}
