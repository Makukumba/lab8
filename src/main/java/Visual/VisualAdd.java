package Visual;

import Drago.Dragon;
import Managers.CommandManager;
import commands.AddCommand;
import commands.InfoCommand;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import static Visual.EnterVisual.UserName;

public class VisualAdd extends JFrame {
    CommandManager cm;
    JTextField Name, X, Y, Desc, Age, Weight, Head;
    JComboBox comboBox;
    ResourceBundle bundle;
    public VisualAdd(CommandManager cm, ResourceBundle bundle) {
        this.cm = cm;
        this.bundle = bundle;
        setTitle("Добавить дракона");
        Box box1 = Box.createHorizontalBox();
        JLabel NameLabel = new JLabel(bundle.getString("Имя дракона")+":");
        Name = new JTextField(15);
        box1.add(NameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(Name);

        Box box2 = Box.createHorizontalBox();
        JLabel XLabel = new JLabel(bundle.getString("Координата X")+":");
        X = new JTextField(15);
        box2.add(XLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(X);

        Box box3 = Box.createHorizontalBox();
        JLabel YLabel = new JLabel(bundle.getString("Координата Y")+":");
        Y = new JTextField(15);
        box3.add(YLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(Y);

        Box box4 = Box.createHorizontalBox();
        JLabel DescLabel = new JLabel(bundle.getString("Описание дракона")+":");
        Desc = new JTextField(15);
        box4.add(DescLabel);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(Desc);

        Box box5 = Box.createHorizontalBox();
        JLabel AgeLabel = new JLabel(bundle.getString("Возраст дракона")+":");
        Age = new JTextField(15);
        box5.add(AgeLabel);
        box5.add(Box.createHorizontalStrut(6));
        box5.add(Age);

        Box box6 = Box.createHorizontalBox();
        JLabel WeightLabel = new JLabel(bundle.getString("Вес дракона")+":");
        Weight = new JTextField(15);
        box6.add(WeightLabel);
        box6.add(Box.createHorizontalStrut(6));
        box6.add(Weight);

        Box box7 = Box.createHorizontalBox();
        JLabel CharLabel = new JLabel(bundle.getString("Характер дракона")+":");
        String[] elements = {
                "Cunning",
                "Evil",
                "Chaotic"
        };
        comboBox = new JComboBox(elements);
        box7.add(CharLabel);
        box7.add(Box.createHorizontalStrut(6));
        box7.add(comboBox);

        Box box8 = Box.createHorizontalBox();
        JLabel HeadLabel = new JLabel(bundle.getString("Количество глаз")+":");
        Head = new JTextField(15);
        box8.add(HeadLabel);
        box8.add(Box.createHorizontalStrut(6));
        box8.add(Head);

        Box box9 = Box.createHorizontalBox();
        JButton button1 = new JButton(bundle.getString("Добавить дракона"));
        JButton button2 = new JButton("<<");
        box9.add(button1);
        box9.add(Box.createHorizontalStrut(6));
        box9.add(button2);

        NameLabel.setPreferredSize(HeadLabel.getPreferredSize());
        XLabel.setPreferredSize(HeadLabel.getPreferredSize());
        YLabel.setPreferredSize(HeadLabel.getPreferredSize());
        DescLabel.setPreferredSize(HeadLabel.getPreferredSize());
        AgeLabel.setPreferredSize(HeadLabel.getPreferredSize());
        WeightLabel.setPreferredSize(HeadLabel.getPreferredSize());
        CharLabel.setPreferredSize(HeadLabel.getPreferredSize());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box5);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box6);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box7);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box8);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box9);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        button1.addActionListener(new AddButton());
        button2.addActionListener(new BackButton());
    }

    private class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            MainMenu mainMenu = new MainMenu(cm,bundle);
            setVisible(false);
        }
    }

    private class AddButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
                int index = comboBox.getSelectedIndex();
                VisualChecker v = new VisualChecker();
                Dragon dragon = new Dragon(null, v.VName(Name.getText()), v.VCoord(X.getText(),Y.getText()), v.CREATIONDATE(),
                        v.VDesc(Desc.getText()), v.Vage(Age.getText()), v.Vweight(Weight.getText()), v.VChar(index), v.VdragonHead(Head.getText()), UserName);
                if (v.Errorcounter() == false) {
                    v.ErrorMessage();
                } else {
                    AddCommand addCommand = new AddCommand(cm,dragon);
                    addCommand.execute();
                }
        }
    }
}
