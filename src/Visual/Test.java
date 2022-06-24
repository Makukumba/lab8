package Visual;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame{
    public Test(){
    super("Здравствуй, мир XXI века!");
    JButton button = new JButton();
    setSize(1000,1000);
    add(button);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    button.setLayout(null);
    button.setLocation(190,500);
    button.setSize(10,10);
    setVisible(true);
    setLocationRelativeTo(null);
}

    public void paint(Graphics g) {
        super.paint(g);
       // g.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 30));
        //g.drawString("Hello, XXI Century World!", 100, 150);
        g.setColor(Color.blue);
        g.fillOval( 193, 510 , 10, 10);
        g.setColor(Color.black);
        g.fillArc( 183, 510 , 30, 30, -45, 90);
        g.fillArc( 183, 510 , 30, 30, 135, 90);
        g.fillArc( 188, 486 , 20, 70, -120, 60);

    }
}
