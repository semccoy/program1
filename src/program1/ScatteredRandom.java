package program1;

import java.util.ArrayList;
import static program1.Utilities.*;

public class ScatteredRandom implements Constants {

    static ArrayList<Double> temp = new ArrayList<Double>();

    ScatteredRandom() {
    }

    public static void populateAL() {
        genPeriodList(srPeriod.score);
        for (int i = 0; i < (width * height - srPeriod.score) / srPeriod.score; i++) {
            al.add(8.0);
        }
    }

    public static void genPeriodList(int length) {
        for (int i = 0; i < length; i++) {
            temp.add(randomDouble(0,1));
        }

    }
}
