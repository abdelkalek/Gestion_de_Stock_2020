package ConfigApp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyStatement {
    MyConnexion mc = MyConnexion.getInstance();
    public boolean exeUpdate(String sql){
        try {
            Statement statement = mc.getConnection().createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public ResultSet exeQuery(String sql){
        try {

            Statement statement = mc.getConnection().createStatement();
            ResultSet rs;
            rs = statement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MyStatement.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
