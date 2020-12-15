package Controleur;
import Classes.user;
import ConfigApp.MyStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Contorleur_USER {
    public boolean connecter(user u) throws SQLException {
            try {
                ResultSet rset = new MyStatement().exeQuery("SELECT COUNT(*) FROM users where login='"+u.getLogin()+"'  and password='"+u.getPassword()+"'");
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
                   return  false;
    }

}
