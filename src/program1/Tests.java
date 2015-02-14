package program1;

import java.util.ArrayList;
import javalib.funworld.*;

public class Tests extends Utilities implements Constants {

    public static void testAll() {
        for (int i = 0; i < numberOfTests; i++) {
            testScoreIncrementing(new Score());

            testWorldEnd(new Graph(new ArrayList<Double>()));

            bcTest();

        }
        System.out.println("All tests passed " + numberOfTests + " times! :)\n");
    }

    // makes sure bc is generating numbers in the range [0,1)
    public static void bcTest() {
        BaileyCrandall bc = new BaileyCrandall();
        double d = 0.0;
        for (int k = 0; k < 100; k++) {
            for (int i = 0; i < 1000; i++) {
                d = bc.nextDouble();
                if (d >= 1) {
                    throw new RuntimeException("bcTest - d >= 1");
                } else if (d < 0) {
                    throw new RuntimeException("bcTest - d < 0");
                }
            }
        }
    }

    public static void testScoreIncrementing(Score testScore) {
        int oldScore = testScore.score;
        int randomInt = randomInt(-1000, 1000);
        testScore.increaseBy(randomInt);
        if (!(testScore.score == oldScore + randomInt)) {
            throw new RuntimeException("score incrementing failed");
        }
    }

    public static void testWorldEnd(World testWorld) {

        // did world end after hitting x and not end without
        if (testWorld.onKeyEvent("x") instanceof Graph) {
            if (!testWorld.worldEnds().worldEnds) {
                throw new RuntimeException("world didn't end after hitting x");
            }
        } else {
            throw new RuntimeException("world ended without hitting x");
        }
        playOnHuh.score = 1;

        // would hitting a non-x key end the world
        if (testWorld.onKeyEvent(randomString(1)).equals("x")) {
            testWorldEnd(testWorld);
        } else {
            if (testWorld.worldEnds().worldEnds) {
                throw new RuntimeException("world ended after not hitting x");
            }
        }
        playOnHuh.score = 1;
    }
}
