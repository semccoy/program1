package program1;

// source: https://github.com/gkop/randCrush
// see: http://www.hep.wisc.edu/~dasu/classes/physics601/lecture5/IBMStory.pdf
import java.math.BigInteger;

public class RANDU implements Constants {

    int a, c;
    long x, m;

    public RANDU() {
        a = 65539;
        c = 0;
        m = (new BigInteger("2")).pow(31).longValue();
        reset();
    }

    public double nextDouble() {
        x = (x * a + c) % m;
        double nextDouble = (double) x / m;
        return nextDouble;
    }

    public void reset() {
        x = 123456789;
    }

    public static void populateAL() {
        randuHuh.increaseBy(1);
        RANDU rdu = new RANDU();
        for (int i = 0; i < width * height; i++) {
            al.add(rdu.nextDouble());
        }
    }
}
