package program1;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import static program1.Utilities.*;

public class Graph extends JPanel implements Constants {

    public void paint(Graphics g) {
        Image img = drawPixels();
        g.drawImage(img, indentX, indentY, this);
    }

    private Image drawPixels() {
        BufferedImage bi = new BufferedImage(paneX, paneY, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        int pos = 0;
        for (int x = 0; x < paneX; x++) {
            for (int y = 0; y < paneY; y++) {
                int opacity = (int) Math.floor(al.get(pos) * 256);
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
        frame.getContentPane().add(new Graph());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
