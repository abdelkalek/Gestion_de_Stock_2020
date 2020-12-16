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
    setSize(new Dimension(660,600));
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Bnt_Connecter.addActionListener(new ActionListener() {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
             Contorleur_USER CU = new Contorleur_USER();
            if( CU.connecter(new user(JTF_Login.getText(),String.valueOf(Jpwd.getPassword()))))
            {
                Stock s = new Stock();
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog( new  JFrame() ,"Your login name or password is invalid Try Again","Verification",JOptionPane.WARNING_MESSAGE);
            }
        }
    });
}
    public static void main(String[] args) {
        Auth a = new Auth();
    }
}
