package Visual.Ru;

import Managers.CommandManager;
import Managers.Commander;
import VK.VKAuth;
import Visual.EnterVisual;
import Visual.LocalChanger;
import Visual.RegVisual;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class SimpleGuiRu extends JFrame {
    ResourceBundle bundle;
    JButton b1, b2, b3, b4;
    JComboBox j;
    JLabel l1, l2;

    public SimpleGuiRu(ResourceBundle bundle) {
        //  Locale locale = new Locale("de","GR");
        this.bundle = bundle;
        String[] s = {
                "English",
                "Русский",
                "Magyar",
                "Српски"
        };
        setTitle("New Window");
        Box box1 = Box.createHorizontalBox();
        b1 = new JButton(bundle.getString("Enter"));
        b2 = new JButton(bundle.getString("Registration"));
        box1.add(b1);
        Box box2 = Box.createHorizontalBox();
        box2.add(b2);
        b3 = new JButton(bundle.getString("Changer"));
        //Icon icon = new ImageIcon("C:\\Users\\Public\\lab8\\Vkontakte.png");
        b4 = new JButton("VK");
        l1 = new JLabel(bundle.getString("Date"));
        Box box3 = Box.createHorizontalBox();
        box3.add(b3);
        Box box4 = Box.createHorizontalBox();
        box4.add(b4);
        Box box5 = Box.createHorizontalBox();
        box5.add(l1);
        b1.setPreferredSize(b3.getPreferredSize());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(40, 40, 40, 40));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(box5);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        b1.addActionListener(new EnterEventListener());
        b2.addActionListener(new RegEventListener());
        b3.addActionListener(new ChangeButton());
        b4.addActionListener(new VkEnter());
    }

    private class EnterEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            EnterVisual enterVisual = new EnterVisual(bundle);
            setVisible(false);
        }
    }

    private class RegEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            RegVisual regVisual = new RegVisual(bundle);
            setVisible(false);
        }
    }

    private class ChangeButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            LocalChanger changer = new LocalChanger(bundle);
            setVisible(false);
        }
    }

    private class VkEnter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                VKAuth vkAuth = new VKAuth(bundle);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            setVisible(false);
        }
    }
}


