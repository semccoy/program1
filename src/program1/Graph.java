package program1;

import java.awt.*;
import java.util.ArrayList;
import javalib.funworld.*;
import javalib.worldimages.*;

public class Graph extends World implements Constants {

    public Graph(ArrayList<Double> al) {
        // bitmap the arraylist

        if (!al.isEmpty()) {
            doThings();
        }
    }

    public static void doThings() {
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                System.out.println(al.get(w + h));
            }
        }
    }

    WorldImage border = new RectangleImage(base, width - 400, height - 400, Color.red);

    public WorldImage makeImage() {
        return new OverlayImages(universe,
                new OverlayImages(background, border));
    }

    public World onKeyEvent(String key) {
        if (key.equals("r")) {
            System.out.println("thanks for hitting " + key);
        } else if (key.equals("x")) {
            playOnHuh.increaseBy(-1);
        }
        // return refreshed image?
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
