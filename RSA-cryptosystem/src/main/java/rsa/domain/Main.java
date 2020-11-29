package rsa.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import rsa.algorithms.ExtendedEuclideanAlgorithm;

import java.math.BigInteger;

/**
 * 
 * @author LauriKajakko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ExtendedEuclideanAlgorithm eea = new ExtendedEuclideanAlgorithm();

        BigInteger[] test = new BigInteger[3];
        test = eea.xgcd(new BigInteger("42823"), new BigInteger("6409"));


        System.out.println(test[0]);
        System.out.println(test[1]);
        System.out.println(test[2]);


    }
    
}
