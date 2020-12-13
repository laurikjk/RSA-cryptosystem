package rsa.utils;

import rsa.algorithms.ExtendedEuclideanAlgorithm;
import rsa.algorithms.MillerRabin;
import rsa.algorithms.ProbablePrime;
import rsa.domain.KeyGenerator;

import java.math.BigInteger;
import java.util.Random;

public class PerformanceTester {

    private long t1;
    private long t2;
    private KeyGenerator kg;
    private ExtendedEuclideanAlgorithm eea;
    private ProbablePrime probablePrime;

    public PerformanceTester() {
        eea = new ExtendedEuclideanAlgorithm();
    }

    public void run() {

        // Whole RSA test
        System.out.println("Starting key generation with 1024bit key size....");
        long[] times1024 = new long[10];
        for (int i = 0; i<10; i++){
            t1 = System.nanoTime();
            kg = new KeyGenerator(1024);
            t2 = System.nanoTime();
            times1024[i] = t2-t1;
        }

        System.out.println("Starting key generation with 2048bit key size....");
        long[] times2048 = new long[10];
        for (int i = 0; i<10; i++){
            t1 = System.nanoTime();
            kg = new KeyGenerator(2048);
            t2 = System.nanoTime();
            times2048[i] = t2-t1;
        }

        System.out.println("Starting key generation with 4096bit key size....");
        long[] times4096 = new long[10];
        for (int i = 0; i<10; i++){
            t1 = System.nanoTime();
            kg = new KeyGenerator(4096);
            t2 = System.nanoTime();
            times4096[i] = t2-t1;
        }

        System.out.println("Results with different key sizes: ");
        for(int i = 0; i<10; i++) {
            System.out.println("1k: " + times1024[i]);
            System.out.println("2k: " + times2048[i]);
            System.out.println("4k: " + times4096[i]);
        }








    }
}
