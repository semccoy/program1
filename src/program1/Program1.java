package program1;

import javalib.funworld.*;
import javalib.worldimages.*;
import java.awt.*;

public class Program1 extends World implements Constants {

    public static WorldImage universe = new RectangleImage(base, width, height, Color.black);

    public Program1(WorldImage uni) {
        super();
        this.universe = uni;
    }

    public WorldImage makeImage() {
        return universe;
    }

//    public World onKeyEvent(String key) {
//        return new Game2(universe);
//    }
    public static void main(String[] args) throws Exception {
//        Tests.testAll();

        BaileyCrandall.go();

    }
}
