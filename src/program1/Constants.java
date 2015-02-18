package program1;

import java.util.ArrayList;
import static program1.Utilities.*;

public interface Constants {

    ArrayList<Double> al = new ArrayList<Double>();

    // amazing stuff
    int coolLoops = 2; // number of times the image updates (default = 1)
    int periodChange = 0; // can make this whatever

    // testing stuff
    int numberOfTests = 1;

    // functionality stuff
    Score rbrPeriod = new Score(10);
    Score srPeriod = new Score(randomInt(10000,15000));
    Score playOnHuh = new Score(1);

    // background stuff
    int width = 1440;
    int height = 800;
    int indentX = 100;
    int indentY = 75;
    int paneX = width - 2 * indentX;
    int paneY = height - 2 * indentY;

}
