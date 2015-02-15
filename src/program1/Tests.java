package program1;

public class Tests extends Utilities implements Constants {

    public static void testAll() {
        for (int i = 0; i < numberOfTests; i++) {
            testScoreIncrementing(new Score());

            bcTest();
            rbrTest();

        }
        System.out.println("All tests passed " + numberOfTests + " times! :)\n");
    }

    public static void testScoreIncrementing(Score testScore) {
        int oldScore = testScore.score;
        int randomInt = randomInt(-1000, 1000);
        testScore.increaseBy(randomInt);
        if (!(testScore.score == oldScore + randomInt)) {
            throw new RuntimeException("score incrementing failed");
        }
    }

    // makes sure bc is generating numbers in the range [0,1)
    public static void bcTest() {
        BaileyCrandall bc = new BaileyCrandall();
        double d = 0.0;
        d = bc.nextDouble();
        if (d >= 1) {
            throw new RuntimeException("bcTest - d >= 1");
        } else if (d < 0) {
            throw new RuntimeException("bcTest - d < 0");
        }
    }

    // makes sure bc is generating numbers in the range [0,1)
    public static void rbrTest() {
        double d = 0.0;
        for (int i = 0; i < width * height; i++) {
            for (double x = 0; x < 10; x++) {
                d = x / 10;
            }
        }
        if (d >= 1) {
            throw new RuntimeException("bcTest - d >= 1");
        } else if (d < 0) {
            throw new RuntimeException("bcTest - d < 0");
        }
    }

}
