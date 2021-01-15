package Controleur;
import Classes.Article;
import Classes.Categorie;
import Classes.user;
import ConfigApp.MyStatement;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

    public class ControleurArticle {
    public DefaultTableModel mTableModel;
    public DefaultComboBoxModel mComboBox;
   public void remplirComboArtcile_Cate()  {
        try {
            String sql = "SELECT NOM_CATEGORIE FROM categories ";
            ResultSet rset = new MyStatement().exeQuery(sql);
            mComboBox = new DefaultComboBoxModel();
            String Nomc;
            while (rset.next()) {
                Nomc = rset.getString("NOM_CATEGORIE");
                System.out.println(Nomc);
                mComboBox.addElement(Nomc);
            }
        } catch (Exception Ex) {
            System.out.println("Erreur  Connection :" + Ex.getMessage());

        }
    }
    //Charger Table Article
    public void chargerArticle(){
        try {
            String sql = "SELECT * FROM Article";
            ResultSet rset = new MyStatement().exeQuery(sql);
            //header of Table
            Object columnNames[] = {"Ref", "DESIGNATION", " DESCRIPTION", "QTE"};
            mTableModel = new DefaultTableModel(columnNames, 0);
            Object[] row;
            while (rset.next()) {
                row = new Object[]{rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4)};
                mTableModel.addRow(row);
            }
        } catch (Exception Ex) {
            System.out.println("Erreur  Connection :" + Ex.getMessage());

        }
    }
    public void Ajouter(Article a)  {
        // Create DataSource and connect to the local database
        try {
            String sql = "SELECT MAX(REF_PRODUIT) FROM Article";
            ResultSet rset = new MyStatement().exeQuery(sql);
            rset.next();
            int r= rset.getInt(1);
            a.setId(r+1);
            // Ajouter un Article
            System.out.println(a.getId()+","+a.getDesignation()+","+a.getDescription()+","+a.getQte());
       new  MyStatement().exeUpdate("insert into Article values("+a.getId()+",'"+a.getDesignation()+"','"+a.getDescription()+"',"+a.getQte()+")");
        }catch (Exception Ex )
        {
            System.out.println("Erreur  Connection :"+Ex.getMessage());
        }
    }
    public void Supprimer(int n) {
        // Create DataSource and connect to the local database
        try {
            // modifier  un Article avec update
       new MyStatement().exeUpdate("delete  Article  where REF_PRODUIT="+n+"");
        }catch (Exception Ex )
        {
            System.out.println("Erreur  Connection :"+Ex.getMessage());
        }
        // Close the result set, statement, and the connection
        System.out.println("Article Supprimer Ok" );
    }
    public void ChercherArticle(String chaine){
        try {
            ResultSet rset=  new MyStatement().exeQuery("SELECT * FROM Article where DESIGNATION like '%"+chaine+"%' or DESCRIPTION like '%"+chaine+"%'");
            Object columnNames[] = {"Ref",  "DESIGNATION", " DESCRIPTION","QTE"};
            mTableModel  = new DefaultTableModel(columnNames,0);
            Object[] rows;
            while (rset.next())
            {
                // add the values to the temporary row
                rows = new Object[]{rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4)};
                // add the temp row to the table
                mTableModel.addRow(rows);
            }
        }catch (Exception Ex )
        {
            System.out.println("Erreur  Connection :"+Ex.getMessage());
        }
    }
}