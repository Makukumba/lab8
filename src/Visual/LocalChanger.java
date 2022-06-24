package Visual;

import Visual.Ru.SimpleGuiRu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalChanger extends JFrame {
    JButton b1;
    JComboBox comboBox;
    ResourceBundle bundle;

    public LocalChanger(ResourceBundle bundle) {
        this.bundle = bundle;
        setTitle("Change Locale");
        setVisible(true);
        Box box1 = Box.createHorizontalBox();
        String[] s = {
                "English",
                "Русский",
                "Magyar",
                "Српски"
        };
        comboBox = new JComboBox(s);
        box1.add(comboBox);
        Box box2 = Box.createHorizontalBox();
        b1 = new JButton(bundle.getString("Change"));
        box2.add(b1);
        b1.setPreferredSize(comboBox.getPreferredSize());
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(40, 40, 40, 40));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(20));
        mainBox.add(box2);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(new ButtonEventListener());
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (comboBox.getSelectedIndex() == 0) {
                bundle = ResourceBundle.getBundle("Resources.resource", new Locale("en", "CA"));
            } else if (comboBox.getSelectedIndex() == 1) {
                bundle = ResourceBundle.getBundle("Resources.resource", new Locale("ru", "RU"));
            } else if (comboBox.getSelectedIndex() == 2) {
                bundle = ResourceBundle.getBundle("Resources.resource", new Locale("hu", "HU"));
            } else if (comboBox.getSelectedIndex() == 3) {
                bundle = ResourceBundle.getBundle("Resources.resource", new Locale("rs", "RS"));
            }
            SimpleGuiRu simpleGuiRu = new SimpleGuiRu(bundle);
            setVisible(false);
        }
    }
}
