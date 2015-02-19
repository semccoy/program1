package program1;

import javax.swing.*;

public class Program1 extends JPanel implements Constants {

    public static void main(String[] args) throws Exception {
        Tests.testAll();

//         uncomment one at a time
//        MersenneTwister.populateAL();
//        BaileyCrandall.populateAL();
//        RANDU.populateAL();
//        JavaRandom.populateAL();
//        ReallyBadRandom.populateAL();
//        ScatteredRandom.populateAL();

        Graph.go();

    }

}
