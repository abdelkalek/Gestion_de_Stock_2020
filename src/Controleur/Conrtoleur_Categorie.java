package Controleur;

import Classes.Article;
import Classes.Categorie;
import oracle.jdbc.pool.OracleDataSource;


import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Conrtoleur_Categorie {
    public DefaultTableModel mTableModel ;
    public void chargerCategorie() throws SQLException {
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
            stmt2 = conn.createStatement();
            rset = stmt2.executeQuery("SELECT * FROM Categories");
            // 2 dimension array to hold table contents
            // it holds temp values for now
            Object rowData[][] = {{"Row1-Column1", "Row1-Column2", "Row1-Column3"}};
            // array to hold column names
            Object columnNames[] = {"Code_Categorie",  "Nom_Categorie", " Description"};
            // create a table model and table based on it

            mTableModel  = new DefaultTableModel(rowData, columnNames);
            // remove the temp row
            mTableModel.removeRow(0);
            Object[] rows;
            while (rset.next())
            {
                // add the values to the temporary row
                rows = new Object[]{rset.getInt(1), rset.getString(2), rset.getString(3)};
                // add the temp row to the table
                mTableModel.addRow(rows);

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
    }
    public void Ajouter(  Categorie c) throws SQLException {
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
            stmt2 = conn.createStatement();
            rset = stmt2.executeQuery("SELECT MAX(Code_Categorie) FROM Categories");
            rset.next();
            int r= rset.getInt(1);
            c.setId(r+1);
            // Ajouter un Categorie
            stmt = conn.createStatement();
            int j  = stmt.executeUpdate("insert into Categories values("+c.getId()+",'"+c.getNomc()+"','"+c.getDesigantion()+"')");

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

    }
    public void Supprimer(int n ) throws SQLException {
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
            int j  = stmt.executeUpdate("delete  categories  where CODE_CATEGORIE="+n+"");
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
        System.out.println("Article Supprimer Ok" );
    }
    public void ChercherArticle(String chaine) throws SQLException {
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
            stmt2 = conn.createStatement();
            rset = stmt2.executeQuery("SELECT * FROM categories where NOM_CATEGORIE like '%"+chaine+"%' or DESCRIPTION like '%"+chaine+"%'");
            // 2 dimension array to hold table contents
            // it holds temp values for now
            Object rowData[][] = {{"Row1-Column1", "Row1-Column2", "Row1-Column3"}};
            // array to hold column names
            Object columnNames[] = {"CODE CATEGORIE",  "NOM  de CATEGORIE", " DESCRIPTION"};
            // create a table model and table based on it
            mTableModel  = new DefaultTableModel(rowData, columnNames);
            // remove the temp row
            mTableModel.removeRow(0);
            Object[] rows;
            while (rset.next())
            {
                // add the values to the temporary row
                rows = new Object[]{rset.getInt(1), rset.getString(2), rset.getString(3)};
                // add the temp row to the table
                mTableModel.addRow(rows);

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
    }

}
