package program1;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import static program1.Utilities.*;

public class Graph extends JPanel implements Constants {

    static Score stagger = new Score(0);

    public void paint(Graphics g) {
        Image img = drawPixels();
        g.drawImage(img, indentX, indentY, this);

    }

    public void paint2(Graphics g) {
        for (int i = 0; i < 3; i++) {
            Image img2 = drawPixels();
            g.drawImage(img2, indentX, indentY, this);

        }
    }

    public static Image drawPixels() {
        BufferedImage bi = new BufferedImage(paneX, paneY, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        int pos = 0;
        for (int x = 0; x < paneX; x++) {
            for (int y = 0; y < paneY; y++) {
                // takes inputs in range [0,1)
                int opacity = (int) Math.floor(al.get(pos + stagger.score) * 256);
                Color darkness = new Color(opacity, opacity, 255);
                g.setColor(darkness);
                g.drawLine(x, y, x, y);
                pos++;

            }
        }
        return bi;
    }

    public static void go() {
        JFrame frame = new JFrame();
        for (int i = 0; i < coolLoops; i++) {
            frame.getContentPane().add(new Graph());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(width, height);
            frame.setVisible(true);
            delay(1000);
            rbrPeriod.increaseBy(periodChange);
            shift();
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void shift() {
        int oldSize = al.size();
        ReallyBadRandom.populateAL();
        int newSize = al.size();
        stagger.increaseBy(newSize - oldSize);
    }

}
