package View;

import lombok.SneakyThrows;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModifCategorie extends JFrame {
    public JTextField Txt_Desc_Cate;
    public JTextField Txt_Nom_categorie;
    private JButton Bnt_Modifier_Categorie;
    private JButton Annuler_bnt;
    private JPanel Mainpane;
    public int code_c;
  public  ModifCategorie()
  {
      setIconImage(Toolkit.getDefaultToolkit().getImage("src/View/Icons/conf.png"));
      setContentPane(Mainpane);
      setVisible(true);
      setSize(new Dimension(450,300));
      setResizable(false);
      setLocationRelativeTo(null);
      Bnt_Modifier_Categorie.addActionListener(new ActionListener() {
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

                      if(Txt_Nom_categorie.getText().isEmpty()|| Txt_Desc_Cate.getText().isEmpty() ){
                          JOptionPane.showMessageDialog( new  JFrame() ,"Empty Value Or incorrect type ","Verification of Data",JOptionPane.WARNING_MESSAGE);
                          return;
                      }
                      int j  = stmt.executeUpdate("update categories set NOM_CATEGORIE='"+Txt_Nom_categorie.getText()+"' , DESCRIPTION='"+Txt_Desc_Cate.getText()+"' where CODE_CATEGORIE="+code_c+"");
                  }catch (Exception Ex )
                  {
                      System.out.println("Erreur  Connection Modif categorie :"+Ex.getMessage());
                  }
                  /* Close the result set, statement, and the connection */
                  finally {
                      if (rset != null) rset.close();
                      if (stmt != null) stmt.close();
                      if (conn != null) conn.close();
                  }
                  JOptionPane.showMessageDialog( new  JFrame() ,"categorie Modifier avec  succès ","Modification Notice",JOptionPane.INFORMATION_MESSAGE);
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
}
