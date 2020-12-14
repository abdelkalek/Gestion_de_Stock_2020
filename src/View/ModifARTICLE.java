package View;

import Controleur.ControleurArticle;
import lombok.SneakyThrows;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifARTICLE  extends JFrame{
    Stock stock;
    private JPanel mainPanel;
    public int Myref ;
    public JTextField Txt_Desc;
    public JTextField Txt_Desg;
    public JTextField Txt_QTE;
    private JButton Bnt_Modifier;
    private JButton Annuler_bnt;

    public ModifARTICLE() throws SQLException {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/View/Icons/conf.png"));
        setContentPane(mainPanel);
        setVisible(true);
        setSize(new Dimension(450,300));
        setResizable(false);
        setLocationRelativeTo(null);
        Bnt_Modifier.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                OracleDataSource ods = null;
                Connection conn = null;
                Statement stmt = null;
                Statement stmt2 = null;
                ResultSet rset = null;
                // Create DataSource and connect to the local database
                ods = new OracleDataSource();
                ods.setURL("jdbc:oracle:thin:@//DESKTOP-6EFAGB6:1521/XE");
                ods.setUser("abdelkalek");
                ods.setPassword("abdelkalek");
                conn = ods.getConnection();
                try {
                    // modifier  un Article avec update
                    stmt = conn.createStatement();
                    boolean in ;
                    try
                    {
                        Integer.parseInt(Txt_QTE.getText());
                        in = true;
                    }catch(Exception ex)
                    {
                        in= false;
                    }

                    if(Txt_Desc.getText().isEmpty()|| Txt_Desg.getText().isEmpty() || in== false ){
                        JOptionPane.showMessageDialog( new  JFrame() ,"Empty Value Or incorrect type ","Verification of Data",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                int j  = stmt.executeUpdate("update Article set DESIGNATION='"+Txt_Desg.getText()+"' , DESCRIPTION='"+Txt_Desc.getText()+"',QTE="+Integer.parseInt(Txt_QTE.getText())+"where REF_PRODUIT="+Myref+"");
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
                JOptionPane.showMessageDialog( new  JFrame() ,"Article Modifier avec  succès ","Modification Notice",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Form Modifier Ok" );
                dispose();
            }

        });


        Annuler_bnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
/*
    public static void main(String[] args) throws SQLException {
        ModifARTICLE a = new ModifARTICLE();
    }

*/
}
