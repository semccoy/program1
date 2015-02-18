package program1;

import javax.swing.*;

public class Program1 extends JPanel implements Constants {

    public static void main(String[] args) throws Exception {
        Tests.testAll();

        // only leave one of these uncommented at a time:
//        BaileyCrandall.populateAL();
//        RANDU.populateAL();
//        JavaRandom.populateAL();
        ReallyBadRandom.populateAL();
        
        
            Graph.go();
        

    }

}
