package rsa.algorithms;

import java.math.BigInteger;
import java.util.Random;

public class ProbablePrime {

    private MillerRabin millerRabin;
    private int bitSize;
    private int certainty;
    private Random random;

    /**
     * Calculates a probable prime
     *
     *
     * @param bitSize size of strong probable prime
     * @param certainty how many rounds of testing with miller-rabin
     * @param random random
     */
    public ProbablePrime(int bitSize, int certainty, Random random) {
        millerRabin = new MillerRabin();
        this.certainty = certainty;
        this.bitSize = bitSize;
        this.random = random;
    }

    public BigInteger generateLargePrime() {
        BigInteger candidate = new BigInteger(bitSize, random);
        while (!millerRabin.test(candidate, certainty)) {
            candidate = new BigInteger(bitSize, random);
        }
        return candidate;
    }

}
