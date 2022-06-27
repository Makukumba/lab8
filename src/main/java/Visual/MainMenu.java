package Visual;

import Drago.DragoPicture;
import Managers.CommandManager;
import Managers.Commander;
import Visual.Ru.SimpleGuiRu;
import commands.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

import static Managers.Commander.*;
import static Visual.EnterVisual.*;

public class MainMenu extends JFrame {
    CommandManager cm;
    JButton j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, back, table, graph;
    JLabel Datelabel;
    ResourceBundle bundle;
    public MainMenu(CommandManager cm, ResourceBundle bundle) {
        this.bundle = bundle;
        this.cm = cm;
        setTitle(bundle.getString("User")+": " + UserName);
        //setLayout(new FlowLayout());
        j1 = new JButton("help");
        j2 = new JButton("info");
        j3 = new JButton("show");
        j4 = new JButton("add");
        j5 = new JButton("update");
        j6 = new JButton("remove");
        j7 = new JButton("clear");
        j8 = new JButton("save");
        j9 = new JButton("execute_script");
        j10 = new JButton("exit");
        j11 = new JButton("add_if_max");
        j12 = new JButton("add_if_min");
        j13 = new JButton("remove_lower");
        j14 = new JButton("remove_by_description");
        j15 = new JButton("print_head");
        j16 = new JButton("show_users");
        back = new JButton("<<");
        table = new JButton(bundle.getString("Table"));
        graph = new JButton(bundle.getString("Graph"));
        Datelabel = new JLabel(bundle.getString("Date"));

        Box box1 = Box.createHorizontalBox();
        box1.add(j1);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(j2);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(j3);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(j4);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(j5);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(j6);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(j7);
        j1.setPreferredSize(j5.getPreferredSize());
        j2.setPreferredSize(j5.getPreferredSize());
        j3.setPreferredSize(j5.getPreferredSize());
        j4.setPreferredSize(j5.getPreferredSize());
        j6.setPreferredSize(j5.getPreferredSize());
        j7.setPreferredSize(j5.getPreferredSize());

        Box box2 = Box.createHorizontalBox();
        box2.add(j8);
        box2.add(Box.createHorizontalStrut(8));
        box2.add(j9);
        box2.add(Box.createHorizontalStrut(8));
        box2.add(j10);
        box2.add(Box.createHorizontalStrut(8));
        box2.add(j11);
        box2.add(Box.createHorizontalStrut(8));
        box2.add(j12);

        Box box3 = Box.createHorizontalBox();
        box3.add(j13);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(j14);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(j15);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(j16);

        Box box4 = Box.createHorizontalBox();
        box4.add(back);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(table);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(graph);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(Datelabel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(42));
        mainBox.add(box4);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);

        j1.addActionListener(new HelpButton());
        j2.addActionListener(new InfoButton());
        j3.addActionListener(new ShowButton());
        j4.addActionListener(new AddButton());
        j5.addActionListener(new UpdateButton());
        j6.addActionListener(new RemoveButton());
        j7.addActionListener(new ClearButton());
        j8.addActionListener(new SaveButton());
        j9.addActionListener(new ScriptButton());
        j10.addActionListener(new ExitButton());
        j11.addActionListener(new Add_if_maxButton());
        j12.addActionListener(new Add_if_minButton());
        j13.addActionListener(new Remove_lower_button());
        j14.addActionListener(new D_RemoveButton());
        j15.addActionListener(new PrintHeadButton());
        j16.addActionListener(new UsersButton());
        back.addActionListener(new BackButton());
        table.addActionListener(new TableButton());
        graph.addActionListener(new GraphButton());
        cm.read();
    }

    private class HelpButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Commander commander = new Commander(cm);
            HelpCommand helpCommand = new HelpCommand(commander.commands);
            helpCommand.execute();
        }
    }

    private class InfoButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            InfoCommand infoCommand = new InfoCommand(cm,bundle);
            infoCommand.execute();
        }
    }

    private class AddButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            VisualAdd visualAdd = new VisualAdd(cm,bundle);
            setVisible(false);
        }
    }

    private class UsersButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ShowUsersCommand showUsersCommand = new ShowUsersCommand(bundle);
            try {
                showUsersCommand.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClearButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ClearCommand clearCommand = new ClearCommand(cm);
            try {
                clearCommand.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class SaveButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SaveCommand saveCommand = new SaveCommand(cm);
            try {
                saveCommand.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ExitButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ExitCommand exitCommand = new ExitCommand(cm);
            exitCommand.execute();
        }
    }

    private class BackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            SimpleGuiRu simpleGuiRu = new SimpleGuiRu(bundle);
            setVisible(false);
        }
    }

    private class Add_if_maxButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            VisualIfMax visualIfMax = new VisualIfMax(cm,bundle);
            setVisible(false);
        }
    }

    private class Add_if_minButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            VisualIfMin visualIfMin = new VisualIfMin(cm,bundle);
            setVisible(false);
        }
    }

    private class PrintHeadButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Print_field_descending_head p = new Print_field_descending_head(cm);
            try {
                p.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class RemoveButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Remover remover = new Remover(cm,bundle);
            setVisible(false);
        }
    }

    private class D_RemoveButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            D_Remover remover = new D_Remover(cm,bundle);
            setVisible(false);
        }
    }

    private class Remove_lower_button implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Lower_Remover lower_remover = new Lower_Remover(cm,bundle);
            setVisible(false);
        }
    }

    private class UpdateButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            UpId upId = new UpId(cm,bundle);
            setVisible(false);
        }
    }

    private class ShowButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ShowCommand showCommand = new ShowCommand(cm);
            try {
                showCommand.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ScriptButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Execute_script execute_script = new Execute_script(commands);
            try {
                execute_script.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class TableButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            DragonTable dragonTable = new DragonTable();
        }
    }

    private class GraphButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            DragoPicture dragoPicture = new DragoPicture();
        }
    }
}