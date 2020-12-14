package View;

import Classes.Article;
import Controleur.ControleurArticle;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public  class Stock extends JFrame {
    private JPanel MailPanel;
    private JTabbedPane tabbedPane1;
    public  JTable table_Article;
    private JTextField Txt_Desc;
    private JTextField Txt_Desg;
    private JTextField Txt_QTE;
    private JButton validerButton;
    private JButton supprimerButton;
    private JButton modifierButton;
    private JTextField Txt_Chercher;
    private JLabel Lbl_chercher;
    private JLabel Lbl_stock;
    public   JTable Table_Categorie;
    private JTextField Txt_Nom_Categorie;
    private JTextField Txt_Desg_Categorie;
    private JButton Bnt_Ajouter_Categorie;
    private JButton Bnt_Modif_Categorie;
    private JButton Bnt_Supprimer_Categorie;
    private JComboBox comboBox1;


    ControleurArticle cA = new ControleurArticle();
    public Stock() throws SQLException {
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/View/Icons/stk.png"));
        Lbl_stock.setIcon(new ImageIcon("src/View/Icons/mar.png"));
        cA.chargerArticle();
        table_Article.setModel(cA.mTableModel);
       Lbl_chercher.setIcon(new ImageIcon("src/View/Icons/chercher.png"));
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(Stock.EXIT_ON_CLOSE);
        setContentPane(MailPanel);
        setVisible(true);
        setSize(new Dimension(1200,700));
        setResizable(false);
        setLocationRelativeTo(null);



        validerButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String qt = Txt_QTE.getText();
                String des =Txt_Desc.getText();
                String deg =  Txt_Desg.getText();
                boolean in ;
                  try
                  {
                   Integer.parseInt(qt);
                   in = true;
                  }catch(Exception ex)
                  {
                    in= false;
                  }

                if(des.isEmpty()|| deg.isEmpty() || in== false ){
                    JOptionPane.showMessageDialog( new  JFrame() ,"Empty Value Or incorrect type ","Verification of Data",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Article A = new Article();
                A.setDescription(des);
                A.setDesignation(deg);
                A.setQte(Integer.parseInt(qt));
                ControleurArticle Ca = new ControleurArticle();
                Ca.Ajouter(A);
                System.out.println("donner envoyer");
                cA.chargerArticle();
                table_Article.setModel(cA.mTableModel);
                Txt_QTE.setText("");
                Txt_Desc.setText("");;
                Txt_Desg.setText("");
            }
        });

        modifierButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table_Article.getSelectedRow();
                if(row<0){
                    JOptionPane.showMessageDialog( new  JFrame() ,"u must to select a Row","Verification",JOptionPane.WARNING_MESSAGE);
                    return;}
                String ref = table_Article.getModel().getValueAt(row, 0).toString();
                String desc = table_Article.getModel().getValueAt(row, 2).toString();
                String desg = table_Article.getModel().getValueAt(row, 1).toString();
                String qte = table_Article.getModel().getValueAt(row, 3).toString();
                  ModifARTICLE mo = new ModifARTICLE();
            mo.Myref = Integer.parseInt(ref);
            mo.Txt_Desc.setText(desc);
            mo.Txt_Desg.setText(desg);
            mo.Txt_QTE.setText(qte);

                mo.setVisible(true);
                mo.addWindowListener(new java.awt.event.WindowAdapter() {
                    @SneakyThrows
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        cA.chargerArticle();
                        table_Article.setModel(cA.mTableModel);
                    }
                });

            }
        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table_Article.getSelectedRow();
                if(row<0){
                    JOptionPane.showMessageDialog( new  JFrame() ,"u must to select a Row","Verification",JOptionPane.WARNING_MESSAGE);
                    return;}
                int ref = Integer.parseInt( table_Article.getModel().getValueAt(row, 0).toString());
                ControleurArticle c = new ControleurArticle();
                try {
                    c.Supprimer(ref);
                    cA.chargerArticle();
                    table_Article.setModel(cA.mTableModel);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        Txt_Chercher.addKeyListener(new KeyAdapter() {
            @SneakyThrows
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                ControleurArticle conto = new ControleurArticle();
                conto.ChercherArticle(Txt_Chercher.getText().toString());
                table_Article.setModel(conto.mTableModel);
            }
        });




    }
    public  void  chargerTbale() throws SQLException {
        ControleurArticle cA = new ControleurArticle();
        cA.chargerArticle();
        this.table_Article.setModel(cA.mTableModel);
    }
    public static void main(String[] args) throws SQLException {
        Stock a = new Stock();
    }
}
