package rsa.domain;

import java.math.BigInteger;

/**
 * Convert messages to Big integer for RSA
 */
public class MessageConverter {

    /**
     *
     * @param message as a string
     * @return message as a big integer
     */
    public BigInteger convertString(String message) {
        // do sum
        return new BigInteger("1");
    }

    /**
     *
     * @param message as a big integer
     * @return message as a string
     */
    public String convertNumber(BigInteger message) {
        //do sum
        return "message";
    }

}


