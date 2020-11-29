package rsa.algorithms;

import java.math.BigInteger;

public class ExtendedEucledianAlgorithm {

    private BigInteger zero = new BigInteger("0");
    private BigInteger one = new BigInteger("1");


    /**
     * Recursive method for extended euclidean algorithm
     *
     * @param a number
     * @param b number
     * @return returns an array with gcd(a,b), x, y where ax + by = gcd(a,b)
     */
    public BigInteger[] xgcd(BigInteger a, BigInteger b) {
        BigInteger[] quotient = new BigInteger[2];
        BigInteger[] result = new BigInteger[3];

        if (a.equals(zero)) {
            result[0] = b;
            result[1] = zero;
            result[2] = one;
        } else {
            quotient = b.divideAndRemainder(a);
            result = xgcd(quotient[1], a);
            BigInteger y = result[2];
            result[2] = result[1];
            result[1] = y.subtract(b.divideAndRemainder(a)[0].multiply(result[2]));
        }
        return result;
    }

    /**
     * Recursive implementation of euclidean algorithm to find
     * greatest common divisor of m and n.
     *
     * @param m number
     * @param n number
     * @return greatest common divisor of m and n
     */
    public BigInteger gcd(BigInteger m, BigInteger n) {
        if (n.equals(zero)) return m;
        return gcd(n, m.divideAndRemainder(n)[1]);
    }
}
