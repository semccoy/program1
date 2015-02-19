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

    public static Image drawPixels() {
        BufferedImage bi = new BufferedImage(paneX, paneY, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        int pos = 0;
        for (int x = 0; x < paneX; x++) {
            for (int y = 0; y < paneY; y++) {
                // takes inputs in range [0,1)
                int opacity = (int) Math.floor(al.get(pos + stagger.score) * 256);
                Color darkness = new Color(opacity, opacity, opacity);
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

            // for looping images
            delay(1000);
            rbrPeriod.increaseBy(periodChange);
            srPeriod.score = randomInt(10000, 15000);
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
        if (mtHuh.score > 0) {
            MersenneTwister.populateAL();
        }
        if (rbrHuh.score > 0) {
            ReallyBadRandom.populateAL();
        }
        if (bcHuh.score > 0) {
            BaileyCrandall.populateAL();
        }
        if (jrHuh.score > 0) {
            JavaRandom.populateAL();
        }
        if (srHuh.score > 0) {
            ScatteredRandom.populateAL();
        }
        if (randuHuh.score > 0) {
            RANDU.populateAL();
        }
        int newSize = al.size();
        stagger.increaseBy(newSize - oldSize);
    }
}
