package program1;

import javax.swing.*;

public class Program1 extends JPanel implements Constants {

    public static void main(String[] args) throws Exception {
        Tests.testAll();
//        BaileyCrandall.populateAL();
        ReallyBadRandom.populateAL();
//        JavaRandom.populateAL();
        
        Graph.go();
    }

}
