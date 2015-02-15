package program1;

import java.util.ArrayList;

public interface Constants {

    ArrayList<Double> al = new ArrayList<Double>();

    // testing stuff
    int numberOfTests = 1;

    // functionality stuff
    Score playOnHuh = new Score(1);

    // background stuff
    int width = 1440;
    int height = 800;
    int indentX = 100;
    int indentY = 75;
    int paneX = width - 2 * indentX;
    int paneY = height - 2 * indentY;

}
