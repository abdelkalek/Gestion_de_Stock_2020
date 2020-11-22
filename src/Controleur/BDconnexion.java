package Controleur;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class BDconnexion {

    OracleDataSource ods = null;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    public  BDconnexion() throws SQLException {

      //      ods.setURL("jdbc:oracle:thin:abdelkalek/abdelkalek@DESKTOP-6EFAGB6:1521:XE");

        // Create DataSource and connect to the local database
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//DESKTOP-6EFAGB6:1521/XE");
        ods.setUser("abdelkalek");
        ods.setPassword("abdelkalek");
        conn = ods.getConnection();
}
    public void requett() throws SQLException {
        try {
            // Query the employee names
            stmt = conn.createStatement();
            // int j  = stmt.executeUpdate("insert into article values(42,'llsa','zaza')")
            rset = stmt.executeQuery("SELECT DESIGNATION FROM article");

            // Print the name out
            while (rset.next())
                System.out.println(rset.getString("DESIGNATION"));
        }

        /* Close the result set, statement, and the connection */ finally {
            if (rset != null) rset.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }

    }
}
