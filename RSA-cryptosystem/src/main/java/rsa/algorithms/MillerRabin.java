package rsa.algorithms;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabin {

    private final BigInteger ZERO = BigInteger.ZERO;
    private final BigInteger ONE = BigInteger.ONE;
    private final BigInteger TWO = new BigInteger("2");
    private final BigInteger THREE = new BigInteger("3");

    public boolean test(BigInteger primeCandidate, int rounds) {
        //Test small cases first
        int small = primeCandidate.intValue();
        if (small == 1 || small == 4 || small == 6 || small == 8) return false;
        if (small == 2 || small == 3 || small == 5 || small == 7) return true;

        /*
        n                 = 2^r * d + 1
        n - 1             = 2^r * d
        (n - 1) / ( 2^r ) = d
        where n is primeCandidate,
        r is a integer
        and d is an odd integer (optimize later)
         */
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

    private BigInteger rand(BigInteger max) {
        SecureRandom secrnd = new SecureRandom();
        BigInteger rnd;
        do {
            rnd = new BigInteger(max.bitLength(), secrnd);
        } while (rnd.compareTo(TWO) < 0 || rnd.compareTo(max) >= 0);
        return rnd;
    }


    /*
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

        for (int i = 0; i<rounds; i++){

            BigInteger max = primeMinusOne.subtract(BigInteger.ONE);
            SecureRandom secrnd = new SecureRandom();

            System.out.println("max: " +max);

            BigInteger rnd;
            do {
                rnd = new BigInteger(max.bitLength(), secrnd);
            } while (rnd.compareTo(two) <= 0 || rnd.compareTo(max) >= 0);

            BigInteger b = rnd.modPow(m, primeCandidate);
            System.out.println("b: " + b);

            if(b.equals(BigInteger.ONE) || b.equals(primeCandidate.subtract(BigInteger.ONE))) continue;
            System.out.println("wasn't one or n-1");
            //broken-->
            for (int j = 0; j < exponent; j++){
                System.out.println("while loop " + j + " and b value " + b.toString());
                if(b.equals(BigInteger.ONE)) return false;
                if(b.equals(primeCandidate.subtract(new BigInteger("1")))) continue;
                b = b.modPow(two, primeCandidate);
                if(j==exponent-1) return false;
            }

        }
        return true;
    }


     */


}
