package rsa.algorithms;

import java.math.BigInteger;

public class MillerRabin {

    // BigInteger.TWO doesn't work
    private final BigInteger two = new BigInteger("2");

    /**
     *         (n - 1) / ( 2^r ) = d
     *         where n is primeCandidate,
     *         r is a integer
     *         and d is an odd integer
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
        BigInteger d = primeCandidate.subtract(BigInteger.ONE);
        int r = 0;
        while (d.equals(BigInteger.ZERO)) {
            r++;
            d = d.divide(two);
        }

        for (int i = 0; i < rounds; i++) {
            BigInteger a = rand(primeCandidate.subtract(two));
            BigInteger x = a.modPow(d, primeCandidate);
            if (x.equals(BigInteger.ONE) || x.equals(primeCandidate.subtract(BigInteger.ONE))) continue;
            for (int j = 0; j < r; j++) {
                x = x.modPow(two, primeCandidate);
                if (x.equals(BigInteger.ONE)) return false;
                if (x.equals(primeCandidate.subtract(BigInteger.ONE))) continue;
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
        RandomNumber secrnd = new RandomNumber();
        BigInteger rnd;
        do {
            rnd = new BigInteger(max.bitLength(), secrnd);
        } while (rnd.compareTo(two) < 0 || rnd.compareTo(max) >= 0);
        return rnd;
    }

}
