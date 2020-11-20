package rsa.algorithms;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabin {

    public boolean test(BigInteger primeCandidate, int rounds){
        BigInteger primeMinusOne = primeCandidate.subtract(BigInteger.ONE);
        System.out.println("primeminusone: " + primeMinusOne);

        BigInteger two = new BigInteger("2");

        int exponent = 0;

        //step 1
        while(true){
            if (!primeMinusOne.mod(two.pow(exponent)).equals(new BigInteger("0"))) {
                exponent--;
                break;
            }
            exponent++;
        }
        System.out.println("two pow: " + two.pow(exponent));
        System.out.println("exponent: " + exponent);

        BigInteger m = primeCandidate.divide(two.pow(exponent));
        System.out.println("m: " + m);

        //step 2 pick 2 <= a < n-1
        BigInteger max = primeMinusOne.subtract(BigInteger.ONE);
        SecureRandom secrnd = new SecureRandom();

        System.out.println("max: " +max);

        //step 3

        for (int i = 0; i<rounds; i++){
            BigInteger rnd;
            do {
                rnd = new BigInteger(max.bitLength(), secrnd);
            } while (rnd.compareTo(two) <= 0 || rnd.compareTo(max) >= 0);

            BigInteger b = rnd.modPow(m, primeCandidate);
            System.out.println("b: " + b);

            if(b.equals(BigInteger.ONE) || b.equals(primeCandidate.subtract(BigInteger.ONE))) continue;

            //broken-->
            int j = 0;
            while(true){
                if(b.equals(BigInteger.ONE)) return false;
                if(b.equals(new BigInteger("-1"))) continue;
                b = b.modPow(two, primeCandidate);
                j++;
                if (j == exponent) return false;
            }

        }
        return true;
    }



}
