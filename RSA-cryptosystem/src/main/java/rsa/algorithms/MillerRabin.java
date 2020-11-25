package rsa.algorithms;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabin {

    private final BigInteger ZERO = BigInteger.ZERO;
    private final BigInteger ONE = BigInteger.ONE;
    private final BigInteger TWO = new BigInteger("2");
    private final BigInteger THREE = new BigInteger("3");

    /**
     *         n                 = 2^r * d + 1
     *         n - 1             = 2^r * d
     *         (n - 1) / ( 2^r ) = d
     *         where n is primeCandidate,
     *         r is a integer
     *         and d is an odd integer (optimize later)
     *
     * @param primeCandidate number to test for primality
     * @param rounds how many rounds of testing
     * @return boolean of is the number probable prime
     */
    public boolean test(BigInteger primeCandidate, int rounds) {
        //Test small cases first
        int small = primeCandidate.intValue();
        if (small == 1 || small == 4 || small == 6 || small == 8) return false;
        if (small == 2 || small == 3 || small == 5 || small == 7) return true;

        //Miller-Rabin
        BigInteger d = primeCandidate.subtract(ONE);
        int r = 0;
        while (d.equals(ZERO)) {
            r++;
            d = d.divide(TWO);
        }

        for (int i = 0; i < rounds; i++){
            BigInteger a = rand(primeCandidate.subtract(TWO));
            BigInteger x = a.modPow(d, primeCandidate);
            if (x.equals(ONE) || x.equals(primeCandidate.subtract(ONE))) continue;
            for (int j = 0; j < r; j++) {
                x = x.modPow(TWO, primeCandidate);
                if (x.equals(ONE)) return false;
                if (x.equals(primeCandidate.subtract(ONE))) continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 
     * @param max value for random number
     * @return random number
     */
    private BigInteger rand(BigInteger max) {
        SecureRandom secrnd = new SecureRandom();
        BigInteger rnd;
        do {
            rnd = new BigInteger(max.bitLength(), secrnd);
        } while (rnd.compareTo(TWO) < 0 || rnd.compareTo(max) >= 0);
        return rnd;
    }

}
