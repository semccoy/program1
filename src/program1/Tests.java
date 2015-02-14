package program1;

public class Tests {
    
    public static void testAll() {
        bcTest();
    }

    public static void bcTest() {
        BaileyCrandall bc = new BaileyCrandall();
        double d = 0.0;
        for (int k = 0; k < 100; k++) {
            for (int i = 0; i < 1000; i++) {
                d = bc.nextDouble();
                if (d >= 1) {
                    throw new RuntimeException("bcTest - d >= 1");
                } 
                else if (d < 0) {
                    throw new RuntimeException("bcTest - d < 0");
                }
            }
        }
    }
}
