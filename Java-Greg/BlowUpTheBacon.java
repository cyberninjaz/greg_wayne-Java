import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;


public class BlowUpTheBacon {
    public static void main(String[]args){
        JFrame frame = new JFrame("Blow Up The Bacon!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label1 = new JLabel("Blow Up The Bacon!");
        label1.setOpaque(true);
        label1.setBackground(Color.GRAY);
        label1.setForeground(Color.RED);
        label1.setHorizontalAlignment(JLabel.CENTER);
        Font f1=new Font("College Black",Font.PLAIN,50);
        label1.setFont(f1);
        frame.add(label1,BorderLayout.NORTH);

        JLabel label2 = new JLabel();
        ImageIcon icon1 = new ImageIcon("Bacon.png");
        label2.setIcon(icon1);
        frame.add(label2,BorderLayout.CENTER);

        JButton b = new JButton("PRESS TO BLAST THE BACON!");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.RED);
        b.setHorizontalAlignment(JButton.CENTER);
        b.addActionListener((event)->{

            JLabel label3=new JLabel("BOOM!");
            label3.setOpaque(true);
            label3.setBackground(Color.BLACK);
            label3.setForeground(Color.RED);
            label3.setHorizontalAlignment(JLabel.CENTER);
            Font f2=new Font("Impact",Font.BOLD,100);
            label3.setFont(f2);
            frame.remove(b);  // remove the existing button (b) from the frame (frame)
            frame.remove(label2);
            frame.add(label3,BorderLayout.SOUTH);  // add the new label (label1) to the frame (frame)\
            JLabel label4=new JLabel();
            ImageIcon icon2 = new ImageIcon("Explosion.jpg");
            label4.setIcon(icon2);
            frame.add(label4,BorderLayout.CENTER);
            
            try {
                File f = new File("./" + "Explosion.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            
            frame.pack();  // resize the frame because the label is bigger then the button
            frame.validate();  // because changes where made to the frame while it was visible=true, we need to validate it
        });
        Font f2=new Font("Cambria",Font.PLAIN,20);
        b.setFont(f2);
        frame.add(b,BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}