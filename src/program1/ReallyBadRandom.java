package program1;

class ReallyBadRandom implements Constants {

    ReallyBadRandom() {
    }

    public static double nextDouble(double i) {
        return i / 10;
    }

    public static void populateAL() {
        ReallyBadRandom rbr = new ReallyBadRandom();
        for (int i = 0; i < width * height; i++) {
            for (int x = 0; x < 10; x++) {
                al.add(rbr.nextDouble(x));
            }
        }
    }

}
