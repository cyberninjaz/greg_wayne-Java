import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class WonderbreadDestroyers {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Wonderbread Destroyers!");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            File f = new File("./" + "HomeDepotThemeSong.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.setLoopPoints(0, -1);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JLabel label1 = new JLabel("Destroy The Wonderbread");
        label1.setOpaque(true);
        label1.setBackground(Color.BLACK);
        label1.setForeground(Color.RED);
        label1.setHorizontalAlignment(JLabel.CENTER);
        Font f1=new Font("Stencil",Font.BOLD,33);
        label1.setFont(f1);
        frame.add(label1,BorderLayout.NORTH);

        CustomComponent c = new CustomComponent();
        frame.add(c, BorderLayout.CENTER);

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}