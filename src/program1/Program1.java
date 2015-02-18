package program1;

import javax.swing.*;

public class Program1 extends JPanel implements Constants {

    public static void main(String[] args) throws Exception {
        Tests.testAll();
        
        // only leave one of these uncommented at a time:
//        BaileyCrandall.populateAL();
//        ReallyBadRandom.populateAL();
//        JavaRandom.populateAL();
        RANDU.populateAL();
//        for (int i = 0; i < al.size(); i++) {
//            System.out.println(al.get(i));
//        }
        
        Graph.go();

    }

}
