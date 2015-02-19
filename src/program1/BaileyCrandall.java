package program1;

// source: http://javarng.googlecode.com/svn/trunk/com/modp/random/BaileyCrandall.java
// this is just some random number generator someone posted online
// the plan is to compare it with some of the ones we talked about in class
public class BaileyCrandall implements Constants {

    /**
     * Constant: 3<sup>33</sup>
     */
    private static final double POW3_33 = 5559060566555523.0;

    /**
     * Constant: Math.floor((3<sup>33</sup>)/2)
     */
    private static final double POW3_33_DIV_2 = 2779530283277761.0;

    /**
     * Constant: 2<sup>53</sup>
     */
    private static final long POW2_53 = 9007199254740992L;

    // the iterates
    private double d1;

    // tmp variables
    private double[] dd1 = new double[2];

    private double[] dd2 = new double[2];

    private double[] dd3 = new double[2];

    /**
     * Constructor. Seed set to current time.
     */
    public BaileyCrandall() {
        setSeed(System.currentTimeMillis());
    }

    /**
     * Constructor with seed.
     *
     * @param seed
     */
    public BaileyCrandall(final long seed) {
        setSeed(seed);
    }

    /**
     * Resets internal state with new seed
     */
    public void setSeed(long seed) {
        if (seed < POW3_33 + 100) {
            seed += POW3_33 + 100;
        }
        seed &= (POW2_53 - 1L);
        setSeedRaw(seed);
    }

    /**
     * Set the raw seed or state to match original fortran code
     *
     * @param seed 3<sup>33</sup>+100 <= seed < 2<sup>53</sup>
     */
    public void setSeedRaw(final long seed) {
        // TBD: add check, throw exception
        ddmuldd(expm2((double) seed - POW3_33, POW3_33), POW3_33_DIV_2, dd1);
        dddivd(dd1, POW3_33, dd2);
        ddmuldd(Math.floor(dd2[0]), POW3_33, dd2);
        ddsub(dd1, dd2, dd3);
        d1 = dd3[0];
    }

    /**
     * Compute the next iterate. This is mostly useful for unit tests.
     *
     */
    public void nextIterate() {
        dd1[0] = POW2_53 * d1;
        dd1[1] = 0.0;
        dddivd(dd1, POW3_33, dd2);
        ddmuldd(POW3_33, Math.floor(dd2[0]), dd2);
        ddsub(dd1, dd2, dd3);
        d1 = dd3[0];
        if (d1 < 0.0) {
            d1 += POW3_33;
        }
    }

    /**
     * Get the internal iterate (or state) Used for debugging and validation.
     *
     * @return double
     */
    public double getIterate() {
        return d1;
    }

    /**
     * Returns a random value in the half-open interval [0,1) as per java spec.
     *
     * @return double result
     */
    public double nextDouble() {
        double result = (d1 - 1.0) / (POW3_33 - 1.0);
        nextIterate();
        return result;
    }

    /**
     * Returns a random value in (0,1) NOT [0,1) as commonly done in java.
     *
     * @return double result
     */
    public double nextDoubleOpen() {
        double result = d1 / POW3_33;
        nextIterate();
        return result;
    }

    /**
     * Get n random bits as an integer
     *
     * @param numBits number of bits
     * @return an integer
     */
    public int next(final int numBits) {

        // floating point method
        // return (int) Math.round(nextDouble() * (1 << numBits -1));
        // direct inspection of iterate bits 0-51 are the mantissa
        // and should be random
        return (int) ((Double.doubleToRawLongBits(nextDouble()) & 0x000fffffffffffffL) >> (52 - numBits));
    }

    /**
     * Computes 2^p mod am
     *
     * @param p exponent
     * @param am modulus
     * @return result
     */
    private double expm2(final double p, final double am) {
        double ptl = 1;
        while (ptl < p) {
            ptl *= 2;
        }
        ptl /= 2;

        double p1 = p;
        double r = 1.0;
        double[] ddm = {am, 0.0};
        while (true) {
            if (p1 >= ptl) {
                // r = (2*r) mod am
                ddmuldd(2.0, r, dd1);
                if (dd1[0] > am) {
                    // dd1 -= ddm
                    ddsub(dd1, ddm, dd2);
                    dd1[0] = dd2[0];
                    dd1[1] = dd2[1];
                }
                r = dd1[0];
                p1 -= ptl;
            }
            ptl *= 0.5;
            if (ptl >= 1.0) {
                /*
                 * r*r mod am == r*r - floor(r*r / am) * am
                 */
                ddmuldd(r, r, dd1);
                dddivd(dd1, am, dd2);
                ddmuldd(am, Math.floor(dd2[0]), dd2);
                ddsub(dd1, dd2, dd3);
                r = dd3[0];
                if (r < 0.0) {
                    r += am;
                }
            } else {
                return r;
            }
        }
    }

    /**
     * Used to split doubles into hi and lo words
     */
    private static final double SPLIT = 134217729.0;

    /**
     * Double precision multiplication
     *
     * @param a in: double
     * @param b in: double
     * @param c out: double double
     */
    private final static void ddmuldd(final double a, final double b, double[] c) {
        double cona = a * SPLIT;
        double conb = b * SPLIT;
        double a1 = cona - (cona - a);
        double b1 = conb - (conb - b);
        double a2 = a - a1;
        double b2 = b - b1;
        double s1 = a * b;
        c[0] = s1;
        c[1] = (((a1 * b1 - s1) + a1 * b2) + a2 * b1) + a2 * b2;
        return;
    }

    /**
     * Double Precision division
     *
     * Double-double / double = double double
     *
     * @param a In: double double
     * @param b In: double
     * @param c Out: double double
     */
    private final static void dddivd(final double[] a, final double b, double[] c) {
        double t1 = a[0] / b;
        double cona = t1 * SPLIT;
        double conb = b * SPLIT;
        double a1 = cona - (cona - t1);
        double b1 = conb - (conb - b);
        double a2 = t1 - a1;
        double b2 = b - b1;
        double t12 = t1 * b;
        double t22 = (((a1 * b1 - t12) + a1 * b2) + a2 * b1) + a2 * b2;
        double t11 = a[0] - t12;
        double e = t11 - a[0];
        double t21 = ((-t12 - e) + (a[0] - (t11 - e))) + a[1] - t22;
        double t2 = (t11 + t21) / b;
        double s1 = t1 + t2;
        c[0] = s1;
        c[1] = t2 - (s1 - t1);
        return;
    }

    /**
     * Double-Precision subtraction a-b = c
     *
     * @param a in: double-double
     * @param b in: double-double
     * @param c out: double-double result
     */
    private final static void ddsub(final double[] a, final double[] b, double[] c) {
        double t1 = a[0] - b[0];
        double e = t1 - a[0];
        double t2 = ((-b[0] - e) + (a[0] - (t1 - e))) + a[1] - b[1];
        double s1 = t1 + t2;
        c[0] = s1;
        c[1] = t2 - (s1 - t1);
        return;
    }

    public static void populateAL() {
        bcHuh.increaseBy(1);
        BaileyCrandall bc = new BaileyCrandall();
        for (int i = 0; i < width * height; i++) {
            al.add(bc.nextDouble());
        }
    }
}
