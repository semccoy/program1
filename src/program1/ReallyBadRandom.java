package program1;

class ReallyBadRandom implements Constants {

    ReallyBadRandom() {
    }

    public static void populateAL() {
        rbrHuh.increaseBy(1);
        for (int i = 0; i < (width * height - rbrPeriod.score) / rbrPeriod.score; i++) {
            for (double x = 0; x < rbrPeriod.score; x++) {
                al.add(x / rbrPeriod.score);
            }
        }
    }
}
