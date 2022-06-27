package Visual;

import Users.Hash;
import Visual.Ru.SimpleGuiRu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

import static Managers.Connector.getDBConnection;

public class RegVisual  extends JFrame {
    JTextField t1, t2;
    JLabel l1, l2;
    JButton button,button1;
    ResourceBundle bundle;
    public RegVisual(ResourceBundle bundle) {
        this.bundle = bundle;
        setTitle(bundle.getString("Registration"));
        Box box1 = Box.createHorizontalBox();
        l1 = new JLabel(bundle.getString("Login"));
        t1 = new JTextField(15);
        box1.add(l1);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(t1);
        //l1 = new JLabel("Введите логин");
        //t1 = new JTextField(10);
        Box box2 = Box.createHorizontalBox();
        l2 = new JLabel(bundle.getString("Password"));
        t2 = new JPasswordField(15);
        box2.add(l2);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(t2);
        Box box3 = Box.createHorizontalBox();
        button = new JButton(bundle.getString("Registration"));
        button1 = new JButton("<<");
        box3.add(Box.createHorizontalGlue());
        box3.add(button1);
        box3.add(Box.createHorizontalStrut(37));
        box3.add(button);
        l1.setPreferredSize(l2.getPreferredSize());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        button.addActionListener(new ButtonEventListener());
        button1.addActionListener(new BackButton());
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int a = 1;
            while (a == 1) {
                Connection dbConnection = null;
                Statement statement = null;
                Hash hash= new Hash();

                String insertTableSQL = "INSERT INTO USERS"
                        + "(LOGIN, PASSWORD) " + "VALUES"
                        + "('" + t1.getText() + "', '" + hash.hashPassword(t2.getText()) + "')";
                try {
                    dbConnection = getDBConnection();
                    statement = dbConnection.createStatement();
                    // выполнить SQL запрос
                    statement.executeUpdate(insertTableSQL);
                    JOptionPane.showMessageDialog(null, bundle.getString("Successful registration"), "Message", JOptionPane.INFORMATION_MESSAGE);

                    a = 0;
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Повторите попытку ");
                    a = 1;
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (dbConnection != null) {
                        try {
                            dbConnection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            SimpleGuiRu simpleGuiRu = new SimpleGuiRu(bundle);
            setVisible(false);
        }
    }
    private class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SimpleGuiRu simpleGuiRu = new SimpleGuiRu(bundle);
            setVisible(false);
        }
    }
}
