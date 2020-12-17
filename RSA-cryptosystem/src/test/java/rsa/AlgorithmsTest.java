package rsa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import rsa.algorithms.ExtendedEuclideanAlgorithm;
import rsa.algorithms.MillerRabin;

import java.math.BigInteger;
import java.util.Random;

public class AlgorithmsTest {

    private MillerRabin millerRabin;
    private String[] primes = { "2", "3", "7", "31", "127", "8191", "131071", "524287", "2147483647", "2305843009213693951", "618970019642690137449562111", "162259276829213363391578010288127", "170141183460469231731687303715884105727"};
    private String[]  nonPrimes = {"1", "4", "6", "10", "65538", "3341", "2932021007403", "226673591177742970257405" };

    @Before
    public void setUp() {
        millerRabin = new MillerRabin();
    }

    @Test
    public void millerRabinReturnsTrueWithPrimes() {
        for (String prime : primes) {
            BigInteger candidate = new BigInteger(prime);
            boolean pass = millerRabin.test(candidate, 10);
            assertTrue(pass);
        }
    }

    @Test
    public void millerRabinReturnsFalseWithNonPrimes() {
        for (String nonPrime : nonPrimes) {
            BigInteger candidate = new BigInteger(nonPrime);
            boolean pass = millerRabin.test(candidate, 10);
            assertTrue(!pass);
        }
    }

    //We can test only primes because in RSA there is only primes given to modinverse
    //There is no need for checking non invertible
    @Test
    public void modularInverseReturnsSameAsModInverse() {
        Random random = new Random();
        ExtendedEuclideanAlgorithm eea = new ExtendedEuclideanAlgorithm();
        for (int i = 0; i < 10; i++){
            BigInteger toTest = BigInteger.probablePrime(2048, random);
            BigInteger testMod = BigInteger.probablePrime(2048, random);
            assertTrue(toTest.modInverse(testMod).equals(eea.modularInverse(toTest, testMod)));
        }
    }
}
