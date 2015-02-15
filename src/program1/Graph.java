package program1;

import java.awt.*;
import java.util.ArrayList;
import javalib.funworld.*;
import javalib.worldimages.*;

public class Graph extends World implements Constants {

    WorldImage temp = new OverlayImages(background, background);

    public Graph(ArrayList<Double> al) {
        if (!al.isEmpty()) {
            drawPixels();
        }
    }

    public WorldImage drawPixels() {
        int pos = 0;
        for (int w = 0; w < 50; w++) {
            for (int h = 0; h < 50; h++) {
                // random number rounded down to an int that can be used to color the pixel
                int opacity = (int) Math.floor(al.get(pos) * 256);
                pos++;
                RectangleImage pixel = new RectangleImage(
                        new Posn(base.x + w, base.y + h), 1, 1,
                        new Color(opacity, opacity, opacity));
                temp = new OverlayImages(temp, pixel);
            }
        }
        return temp;
    }

    public WorldImage makeImage() {
        return new OverlayImages(universe,
                new OverlayImages(background, drawPixels()));
    }

    public World onKeyEvent(String key) {
        if (key.equals("r")) {
            System.out.println("thanks for hitting " + key);
        } else if (key.equals("x")) {
            playOnHuh.increaseBy(-1);
        }
        return new Graph(this.al);
    }

    public WorldEnd worldEnds() {
        String finalText = "Thanks for testing this out";
        if (playOnHuh.score != 1) {
            return new WorldEnd(true, new OverlayImages(this.makeImage(),
                    new TextImage(new Posn(width / 2, height / 2 + 150), finalText, 30, Color.white)));
        } else {
            return new WorldEnd(false, this.makeImage());
        }
    }

}
