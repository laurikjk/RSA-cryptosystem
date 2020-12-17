package rsa.ui;

import rsa.algorithms.ExtendedEuclideanAlgorithm;
import rsa.algorithms.MillerRabin;
import rsa.algorithms.ProbablePrime;
import rsa.domain.KeyGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class PerformanceTester {

    private long t1;
    private long t2;
    private KeyGenerator kg;

    public void run() throws IOException {
        FileWriter fw = new FileWriter("smallkey.csv");
        FileWriter fw1 = new FileWriter("midkey.csv");
        FileWriter fw2 = new FileWriter("largekey.csv");
        long[] times1024 = new long[1000];
        for (int i = 0; i < 1000; i++) {
            t1 = System.nanoTime();
            kg = new KeyGenerator(1024);
            t2 = System.nanoTime();
            times1024[i] = t2 - t1;
            System.out.println("Done: " + i);
        }
        long[] times2048 = new long[100];
        for (int i = 0; i < 100; i++) {
            t1 = System.nanoTime();
            kg = new KeyGenerator(2048);
            t2 = System.nanoTime();
            times2048[i] = t2 - t1;
            System.out.println("Done: " + i);
        }
        long[] times4096 = new long[10];
        for (int i = 0; i < 10; i++) {
            t1 = System.nanoTime();
            kg = new KeyGenerator(4096);
            t2 = System.nanoTime();
            times4096[i] = t2 - t1;
            System.out.println("Done: " + i);
        }
        System.out.println("Results with 1024:");
        for (int i = 0; i < 1000; i++) {
            fw.write(times1024[i] + ",");
        }
        System.out.println("Results with 2048");
        for (int i = 0; i < 100; i++) {
            fw1.write(times2048[i] + ",");
        }
        System.out.println("Results with 4096");
        for (int i = 0; i < 10; i++) {
            fw2.write(times4096[i] + ",");
        }
        fw.close();
        fw1.close();
        fw2.close();
    }
}
