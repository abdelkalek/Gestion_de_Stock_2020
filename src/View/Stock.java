package View;
import Classes.Article;
import Classes.Categorie;
import Controleur.Conrtoleur_Categorie;
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
    private JComboBox Combo_list_Categorie;
    private JTextField Txt_cher_Cate;
    private JLabel Lbl_cherCategorie;
    ControleurArticle cA = new ControleurArticle();
    Conrtoleur_Categorie CC = new Conrtoleur_Categorie();

    public void Onlaod(){
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
    setSize(new Dimension(1200, 700));
    setResizable(false);
    setLocationRelativeTo(null);

    }
    public void ChargerTables() throws SQLException {
         setIconImage(Toolkit.getDefaultToolkit().getImage("src/View/Icons/stk.png"));
         Lbl_stock.setIcon(new ImageIcon("src/View/Icons/mar.png"));
         Lbl_chercher.setIcon(new ImageIcon("src/View/Icons/chercher.png"));
         Lbl_cherCategorie.setIcon(new ImageIcon("src/View/Icons/chercher.png"));
         //charger Comobox Article par categorie
          cA.remplirComboArtcile_Cate();
          cA.chargerArticle();
        Combo_list_Categorie.setModel(cA.mComboBox);
        //fin charger cobobox artice categorie
         //Charger table Article//
         table_Article.setModel(cA.mTableModel);
        //charger table Categorie
         CC.chargerCategorie();
         Table_Categorie.setModel(CC.mTableModel);
     }



    public Stock() throws SQLException {
        Onlaod();
        ChargerTables();
        /// Begin OF Article Jtab panel ///
        validerButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String qt = Txt_QTE.getText();
                String des = Txt_Desc.getText();
                String deg = Txt_Desg.getText();
                boolean in;
                try {
                    Integer.parseInt(qt);
                    in = true;
                } catch (Exception ex) {
                    in = false;
                }
                if (des.isEmpty() || deg.isEmpty() || in == false) {
                    JOptionPane.showMessageDialog(new JFrame(), "Empty Value Or incorrect type of data ", "Verification of Data", JOptionPane.WARNING_MESSAGE);
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
                Txt_Desc.setText("");
                Txt_Desg.setText("");
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table_Article.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Sélectionner  un enregistrement :)", "Verification", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String ref = table_Article.getModel().getValueAt(row, 0).toString();
                String desg = table_Article.getModel().getValueAt(row, 1).toString();
                String desc = table_Article.getModel().getValueAt(row, 2).toString();
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
                if (row < 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Sélectionner  un enregistrement :)", "Verification", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int ref = Integer.parseInt(table_Article.getModel().getValueAt(row, 0).toString());
                ControleurArticle c = new ControleurArticle();
                try {
                    c.Supprimer(ref);
                    cA.chargerArticle();
                    table_Article.setModel(cA.mTableModel);
                } catch (Exception ex) {
                    System.out.println(" Erreur delete ");
                }

            }
        });

        Txt_Chercher.addKeyListener(new KeyAdapter() {
            @SneakyThrows
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                cA.ChercherArticle(Txt_Chercher.getText().toString());
                table_Article.setModel(cA.mTableModel);
            }
        });
        /// End OF Article Jtab panel ///
        //Begin oF CATEGORIE jTABLPANEL/////
        Bnt_Ajouter_Categorie.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nom_cate = Txt_Nom_Categorie.getText();
                String desg_cate = Txt_Desg_Categorie.getText();


                if (Nom_cate.isEmpty() || desg_cate.isEmpty() ) {
                    JOptionPane.showMessageDialog(new JFrame(), "Remplir le formulaire svp ou verifier le Type de donnees :) ", "Verification of Data", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Categorie C = new Categorie();
            C.setNomc(Nom_cate);
            C.setDesigantion(desg_cate);
            CC.Ajouter(C);
            System.out.println("donner envoyer");
                CC.chargerCategorie();
                Table_Categorie.setModel(CC.mTableModel);
                Txt_Nom_Categorie.setText("");
                Txt_Desg_Categorie.setText("");

            }
        });
        Bnt_Modif_Categorie.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = Table_Categorie.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Sélectionner  un enregistrement :)", "Verification", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String code_c  = Table_Categorie.getModel().getValueAt(row,0).toString();
                String nom_c =   Table_Categorie.getModel().getValueAt(row, 1).toString();
                String desc_c =  Table_Categorie.getModel().getValueAt(row, 2).toString();

                ModifCategorie mc= new ModifCategorie();
                mc.code_c = Integer.parseInt(code_c);
                mc.Txt_Nom_categorie.setText(nom_c);
                mc.Txt_Desc_Cate.setText(desc_c);
                mc.addWindowListener(new java.awt.event.WindowAdapter() {
                    @SneakyThrows
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        CC.chargerCategorie();
                        Table_Categorie.setModel(CC.mTableModel);
                    }
                });

            }
        });
        Bnt_Supprimer_Categorie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Table_Categorie.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(new JFrame(), "Sélectionner  un enregistrement :)", "Verification", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int ref = Integer.parseInt(Table_Categorie.getModel().getValueAt(row, 0).toString());
                ControleurArticle c = new ControleurArticle();
                try {
                    CC.Supprimer(ref);
                    CC.chargerCategorie();
                    Table_Categorie.setModel(CC.mTableModel);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        Txt_cher_Cate.addKeyListener(new KeyAdapter() {
            @SneakyThrows
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                CC.ChercherArticle(Txt_cher_Cate.getText().toString());
                Table_Categorie.setModel(CC.mTableModel);
            }
        //End oF CATEGORIE jTABLPANEL/////



        });
        //End OF  oF CATEGORIE jTABLPANEL/////

    }public static void main(String[] args) throws SQLException {
        Stock a = new Stock();
    }
}
