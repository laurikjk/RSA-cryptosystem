package rsa.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import rsa.algorithms.ExtendedEuclideanAlgorithm;
import rsa.algorithms.MillerRabin;
import rsa.algorithms.ProbablePrime;

import java.math.BigInteger;
import java.util.Random;

/**
 * 
 * @author LauriKajakko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProbablePrime p = new ProbablePrime(1024, 10, new Random());

        BigInteger test = p.generateLargePrime();

        System.out.println(test);

        MillerRabin millerRabin = new MillerRabin();

        boolean test2 = millerRabin.test(new BigInteger("90324590832490832598"), 10);

        System.out.println("test2: " + test2);

        boolean testwithnormal = test.isProbablePrime(100);

        System.out.println(testwithnormal);

        KeyGenerator kg = new KeyGenerator(1024);



    }
}
