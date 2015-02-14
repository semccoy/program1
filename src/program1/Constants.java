package program1;

import java.awt.Color;
import java.util.ArrayList;
import javalib.worldimages.*;

public interface Constants {
    ArrayList<Double> al = new ArrayList<Double>();
    
    Score playOnHuh = new Score(1);
    
    // testing stuff
    int numberOfTests = 100;
    
    // background stuff
    int width = 1440;
    int height = 800;
    Posn base = new Posn(width / 2, height / 2);
    WorldImage background = new RectangleImage(base, width - 200, height - 200, Color.gray);
    WorldImage universe = new RectangleImage(base, width, height, Color.black);
    
}