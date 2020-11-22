package View;

import Classes.user;
import Controleur.Contorleur_USER;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Auth extends  JFrame{
    private JTextField JTF_Login;
    private JPanel left;
    private JPanel mainPanel;
    private JPasswordField Jpwd;
    private JButton Bnt_Connecter;
    private JLabel lbl1;
    private JLabel lbl2;
    public static JLabel Lbl_msgCon;

    public Auth()
{


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

    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    lbl1.setIcon(new ImageIcon("C:\\Users\\abdel\\IdeaProjects\\Gestion_de_Stock_2020\\src\\View\\user.png"));
    lbl2.setIcon(new ImageIcon("C:\\Users\\abdel\\IdeaProjects\\Gestion_de_Stock_2020\\src\\View\\k1.png"));

    setContentPane(mainPanel);
    setVisible(true);
    setSize(new Dimension(660,500));
    setResizable(false);
    setLocationRelativeTo(null);
    Bnt_Connecter.addActionListener(new ActionListener() {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {

            new Contorleur_USER().connecter(new user("asa",JTF_Login.getText(),String.valueOf(Jpwd.getPassword())));
            //setVisible(false); //you can't see me!
        //Destroy the JFrame object
            //dispose();




        }
    });
}
    public static void main(String[] args) {

        Auth a = new Auth();

    }
}
