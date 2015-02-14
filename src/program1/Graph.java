package program1;

import acm.graphics.*;
import java.awt.*;
import java.util.ArrayList;
import javalib.funworld.*;
import javalib.worldimages.*;

public class Graph extends World implements Constants {

    public Graph(ArrayList<Double> al) {
        // bitmap the arraylist

        GRect background = new GRect(0, 0, width, height);
        background.setFilled(true);
        background.setColor(Color.white);

        GRect border = background;
        border.setFilled(false);
        border.setColor(Color.black);

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
            playOn.increaseBy(-1);
        }
        // return refreshed image?
        return new Graph(this.al);
    }

    public WorldEnd worldEnds() {
        String finalText = "Thanks for testing this out";
        if (playOn.score != 1) {
            return new WorldEnd(true, new OverlayImages(this.makeImage(),
                    new TextImage(new Posn(width / 2, height / 2 + 150), finalText, 30, Color.white)));
        } else {
            return new WorldEnd(false, this.makeImage());
        }
    }

}
