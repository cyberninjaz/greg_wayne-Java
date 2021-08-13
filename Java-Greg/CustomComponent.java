import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import javax.sound.sampled.*;


public class CustomComponent extends JComponent implements MouseListener, MouseMotionListener {

    private static BufferedImage img = null;
    private static BufferedImage won = null;
    private static Clip mis = null;
    static {
        try {
            img = ImageIO.read(new File("Explosion2.jpg"));
            won = ImageIO.read(new File("Wonderbread.jpg"));
            File f = new File("./" + "Missile1.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
            mis = AudioSystem.getClip();
            mis.open(audioIn);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }



    private boolean onScreen = false;
    private int x = 0;
    private int y = 0;
    private int r = 10;

    private ArrayList<Integer> explosionX = new ArrayList<>();
    private ArrayList<Integer> explosionY = new ArrayList<>();

    public CustomComponent() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GRAY);
        g.fillRect(0, 0,600,600);

        g.drawImage(won,18,0,450,450,null);

        g.setColor(Color.GREEN);
        for (int i = 0; i < explosionX.size(); i++){
            int x = explosionX.get(i);
            int y = explosionY.get(i);
            g.drawImage(img, x-img.getWidth()/2, y-img.getHeight()/2, img.getWidth(), img.getHeight(), null);
        }

        if (onScreen) {
            g.setColor(Color.BLACK);
            g.drawOval(x - r, y - r, 2 * r, 2 * r);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        onScreen = true;
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        onScreen = false;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        explosionX.add(e.getX());
        explosionY.add(e.getY());
        mis.stop();
        mis.setMicrosecondPosition(0);
        mis.start();
        this.repaint();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent event) {}

    @Override
    public void mouseMoved(MouseEvent event) {
        x = event.getX();
        y = event.getY();
        this.repaint();
    }
}