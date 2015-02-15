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
        for (int x = 0; x < paneX; x++) {
            for (int y = 0; y < paneY; y++) {
                g.setColor(randomColor());
                g.drawLine(x, y, x, y);
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

     //    public WorldImage drawPixels() {
//        int pos = 0;
//        for (int loop = 0; loop < 10; loop++) {
//            for (int w = 0; w < width; w++) {
//                // random number rounded down to an int that can be used to color the pixel
//                int opacity = (int) Math.floor(al.get(pos) * 256);
//                pos++;
//                RectangleImage pixel = new RectangleImage(
//                        new Posn(base.x + w, base.y + loop), 1, 1,
//                        new Color(opacity, opacity, opacity));
//                temp = new OverlayImages(temp, pixel);
//            }
//            BaileyCrandall.go();
//
//        }
//
//        return temp;
//    }
}
