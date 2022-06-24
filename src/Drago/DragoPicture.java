package Drago;

import Visual.UserCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Managers.CommandManager.ts;
import static Visual.EnterVisual.t1;

public class DragoPicture extends JFrame {
    Graphics g;

    public DragoPicture() {
        super("Здравствуй, мир XXI века!");
        setSize(1000, 1000);
        setLayout(null);
        for (Dragon dragon : ts) {
            int y = (int) dragon.getCoordinates().getY();
            JButton button = new JButton();
            add(button);
            button.setLayout(null);
            button.setLocation(dragon.getCoordinates().getX() + 187, 480 - y);
            button.setSize(10, 10);
            button.addActionListener(new ActionListener() {
                Graphics g = new DebugGraphics();

                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, dragon, "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            setVisible(true);
            setLocationRelativeTo(null);
        }
    }

    public void paint(Graphics g) {
        UserCheck userCheck = new UserCheck();
        for (Dragon dragon : ts) {
            int y = (int) dragon.getCoordinates().getY();
            g.setColor(Color.black);
            g.fillArc(dragon.getCoordinates().getX() + 183, 510 - y, 30, 30, -45, 90);
            g.fillArc(dragon.getCoordinates().getX() + 183, 510 - y, 30, 30, 135, 90);
            g.setColor(userCheck.CheckUser(dragon));
            g.fillArc(dragon.getCoordinates().getX() + 188, 486 - y, 20, 70, -120, 60);
        }
    }


}