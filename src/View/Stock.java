package View;

import javax.swing.*;
import java.awt.*;

public class Stock extends JFrame {
    private JPanel MailPanel;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton validerButton;
    private JButton supprimerButton;
    private JButton modifierButton;

    public Stock()
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
        setContentPane(MailPanel);
        setVisible(true);
        setSize(new Dimension(1000,600));
        setResizable(false);
    }
    public static void main(String[] args) {
        Stock a = new Stock();
    }
}
