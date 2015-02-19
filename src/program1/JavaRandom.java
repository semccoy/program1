package program1;

import static program1.Utilities.*;

public class JavaRandom implements Constants {

    JavaRandom() {
    }

    public static void populateAL() {
        jrHuh.increaseBy(1);
        for (int i = 0; i < width * height; i++) {
            al.add(randomDouble(0, 1));
        }
    }
}
