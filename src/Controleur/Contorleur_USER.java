package Controleur;
import Classes.user;
import View.Stock;
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Contorleur_USER {

    public boolean connecter(user u) throws SQLException {
        OracleDataSource ods = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        String log = "";
        String pwd= "";
            // Create DataSource and connect to the local database
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//DESKTOP-6EFAGB6:1521/XE");
            ods.setUser("abdelkalek");
            ods.setPassword("abdelkalek");
            conn = ods.getConnection();
            try {
                // Query the employee names
                   stmt = conn.createStatement();
             //   int j  = stmt.executeUpdate("insert into users values(10,'Abdelkalek','123')");
               //  rset = stmt.executeQuery("SELECT login,password FROM users");
                rset = stmt.executeQuery("SELECT COUNT(*) FROM users where login='"+u.getLogin()+"'  and password='"+u.getPassword()+"'");
                rset.next();
                int r= rset.getInt(1);
                if(r==1)
                {
                    return true;
                }

            }catch (Exception Ex )
            {
                System.out.println("Erreur  Connection :"+Ex.getMessage());

            }
            /* Close the result set, statement, and the connection */
        finally {
                if (rset != null) rset.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
return  false;
    }

}
