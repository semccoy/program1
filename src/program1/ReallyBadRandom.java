package program1;

class ReallyBadRandom implements Constants {

    ReallyBadRandom() {
    }
    
    public static void populateAL() {
        for (int i = 0; i < width * height - 10; i++) {
            for (double x = 0; x < 10; x++) {
                al.add(x / 10);
            }
        }
    }

}
