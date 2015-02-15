package program1;

// source: https://github.com/gkop/randCrush
import java.math.BigInteger;

public class RANDU {

    int a, c;
    long x, m;

    public void go() {
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
}
