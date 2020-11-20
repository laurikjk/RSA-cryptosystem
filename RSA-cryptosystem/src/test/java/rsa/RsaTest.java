
package rsa;

import rsa.domain.*;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lkajakko
 */
public class RsaTest {
    
    KeyGenerator g;
    Encryption e;
    PrivateKey priv;
    PublicKey pub;
    MessageConverter messageConverter;

    @Before
    public void setUp() {
        g = new KeyGenerator(1024);
        e = new Encryption();
        priv = g.getPrivateKey();
        pub = g.getPublicKey();
        messageConverter = new MessageConverter();
    }
    
    @Test
    public void messageAndDecryptedMessageMatch() {
        BigInteger message = new BigInteger("1234567890");
        System.out.println("Time with a small messsage.\nMessage: \n"+ message + "\n");
        long time1 = System.nanoTime();
        BigInteger encrypted = e.encrypt(pub, message);
        long time2 = System.nanoTime();
        BigInteger decrypted = e.decrypt(priv, encrypted);
        long time3 = System.nanoTime();

        System.out.println("encryption time in nanoseconds: " + (time2-time1));
        System.out.println("decryption time in nanoseconds: " + (time3-time2));
        System.out.println("---\n");

        assertTrue(message.equals(decrypted));
    }

    @Test
    public void messageAndDecryptedMessageMatchWithLargest() {
        BigInteger message = BigInteger.probablePrime(117*8, new Random());
        System.out.println("Time with a 117byte messsage.\nMessage: \n"+ message + "\n");
        long time1 = System.nanoTime();
        BigInteger encrypted = e.encrypt(pub, message);
        long time2 = System.nanoTime();
        BigInteger decrypted = e.decrypt(priv, encrypted);
        long time3 = System.nanoTime();

        System.out.println("encryption time in nanoseconds: " + (time2-time1));
        System.out.println("decryption time in nanoseconds: " + (time3-time2));
        System.out.println("---\n");

        assertTrue(message.equals(decrypted));
    }

    @Test
    public void messageStringToBigIntegerReturnsRightNumber() {
        String message = "abcde";
        assertEquals(new BigInteger("00970098009901000101"), messageConverter.convertString(message));
    }

    @Test
    public void messageBigIntegerToStringReturnsRightString() {
        BigInteger message = new BigInteger("00970098009901000101");
        assertEquals("abcde", messageConverter.convertBigInteger(message));
    }

}
