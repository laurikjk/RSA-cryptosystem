package rsa.algorithms;

import java.util.Random;

public class RandomNumber extends Random {

    /**
     * @return random number based on system nanotime
     */
    @Override
    public int nextInt() {
        long res = System.nanoTime() % 10_000;
        res += (System.nanoTime() % 10_000) * 10_000;
        res += (System.nanoTime() % 10_000) * 100_000_000;
        res = res % 1_000_000_000;
        int result = (int)(res & Integer.MAX_VALUE);
        return result;
    }

}
