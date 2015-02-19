package program1;

import java.util.ArrayList;
import static program1.Utilities.*;

public class ScatteredRandom implements Constants {

    static ArrayList<Double> temp = new ArrayList<Double>();

    ScatteredRandom() {
    }

    public static void populateAL() {
        srHuh.increaseBy(1);
        genPeriodList(srPeriod.score);
        for (int i = 0; i < width * height; i++) {
            al.add(temp.get(i % srPeriod.score));
        }
    }

    public static void genPeriodList(int length) {
        for (int i = 0; i < length; i++) {
            temp.add(randomDouble(0,1));
        }

    }
}
