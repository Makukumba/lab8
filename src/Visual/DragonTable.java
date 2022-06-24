package Visual;

import Visual.MyTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;

import static Visual.EnterVisual.t1;

public class DragonTable extends JFrame {
    JTextField filterText;

    TableModel model;

    public DragonTable() {
        JFrame frame = new JFrame("DragonTable");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new MyTableModel() {
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) & (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        JTable table = new JTable(model);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        //getContentPane().add(new JScrollPane(table));
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Filter");
        panel.add(label);
        filterText = new JTextField(5);
        panel.add(filterText);
        frame.add(panel, BorderLayout.NORTH);
        JButton button = new JButton("Filter");
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(700, 400);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String text = filterText.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    System.err.println("Bad regex pattern");
                }
            }
        }
    });
    }
}
