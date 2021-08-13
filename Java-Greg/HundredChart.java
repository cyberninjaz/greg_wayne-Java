import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HundredChart {
    public static void main(String[]args){
        JFrame frame = new JFrame("                                                                                100 Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(10,10));
        for (int i = 1; i <= 100; i++) {
            JButton b = new JButton("" + i);
            b.setBackground(Color.GRAY);
            b.setForeground(Color.ORANGE);
            Font f=new Font("Cambria",Font.PLAIN,20);
            b.setFont(f);
            frame.add(b);
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}