package ConfigApp;

import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnexion extends JFrame{

    private OracleDataSource ods ;
    private static Connection connection;
    private static MyConnexion instance;

    private MyConnexion()  {
        try {
            ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@//DESKTOP-6EFAGB6:1521/XE");
            ods.setUser("abdelkalek");
            ods.setPassword("abdelkalek");
            connection = ods.getConnection();
            System.out.println("Connexion OK");
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(new JFrame(),"Erreur De Connexion"+exc.getMessage(),"Erreur De connction",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static MyConnexion getInstance() {
        if(instance == null){
            instance = new MyConnexion();
        }
        return instance;
    }
    public static Connection getConnection() {
        return connection;
    }
}
