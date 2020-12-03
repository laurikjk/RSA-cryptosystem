package rsa.algorithms;

import java.math.BigInteger;

public class ExtendedEuclideanAlgorithm {

    /**
     * Recursive method for extended euclidean algorithm to find gcd(a,b)
     * represented as a linear combination of x and y.
     *
     * ax + by = gcd(a,b)
     *
     *
     * @param a number
     * @param b number
     * @return returns an array with gcd(a,b), x, y where ax + by = gcd(a,b)
     */
    private BigInteger[] xgcd(BigInteger a, BigInteger b) {
        BigInteger[] quotientAndRemainder;
        BigInteger[] result = new BigInteger[3];

        if (a.equals(BigInteger.ZERO)) {
            result[0] = b;
            result[1] = BigInteger.ZERO;
            result[2] = BigInteger.ONE;
        } else {
            quotientAndRemainder = b.divideAndRemainder(a);
            result = xgcd(quotientAndRemainder[1], a);
            BigInteger y = result[2];
            result[2] = result[1];
            result[1] = y.subtract(b.divideAndRemainder(a)[0].multiply(result[2]));
        }
        return result;
    }

    /**
     * Calculates the modular multiplicative inverse with
     * extended euclidean algorithm
     *
     * @param a number
     * @param modulus modulus
     * @return modular multiplicative inverse of a
     */
    public BigInteger modularInverse(BigInteger a, BigInteger modulus) {
        BigInteger[] xgcd = xgcd(a, modulus);
        if (!xgcd[0].equals(BigInteger.ONE)) {
            return new BigInteger("-1");
        }
        return xgcd[1].mod(modulus);
    }
}
