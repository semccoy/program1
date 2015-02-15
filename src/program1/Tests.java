package program1;

public class Tests extends Utilities implements Constants {

    public static void testAll() {
        for (int i = 0; i < numberOfTests; i++) {
            testScoreIncrementing(new Score());

            bcTest();

        }
        System.out.println("All tests passed " + numberOfTests + " times! :)\n");
    }

    // makes sure bc is generating numbers in the range [0,1)
    public static void bcTest() {
        BaileyCrandall bc = new BaileyCrandall();
        double d = 0.0;
        for (int i = 0; i < 10000; i++) {
            d = bc.nextDouble();
            if (d >= 1) {
                throw new RuntimeException("bcTest - d >= 1");
            } else if (d < 0) {
                throw new RuntimeException("bcTest - d < 0");
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

}
