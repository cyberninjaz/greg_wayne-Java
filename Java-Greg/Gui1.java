import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui1 {
    public static void main(String[]args){
        JFrame frame = new JFrame("Java Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JLabel label1=new JLabel("This is coded with Java");
        frame.add(label1,BorderLayout.NORTH);

        JLabel label2=new JLabel("Java is a programming language");
        frame.add(label2,BorderLayout.WEST);

        JLabel label3=new JLabel("Its symbol is a cup of coffee");
        frame.add(label3,BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}