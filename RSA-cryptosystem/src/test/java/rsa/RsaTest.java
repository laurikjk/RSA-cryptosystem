
package rsa;

import rsa.datastructures.BigInt;
import rsa.domain.*;

import java.math.BigInteger;
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
        BigInteger encrypted = e.encrypt(pub, message);
        BigInteger decrypted = e.decrypt(priv, encrypted);
        
        assertTrue(message.equals(decrypted));
    }

    @Test
    public void messageStringToBigIntegerReturnsRightNumber() {
        String message = "abcde";
        assertEquals(new BigInteger("970098009901000101"),messageConverter.convertString(message));
    }

    @Test
    public void messageBigIntegerToStringReturnsRightString() {
        BigInteger message = new BigInteger("00970098009901000101");
        assertEquals("abcde", messageConverter.convertBigInteger(message));
    }
}
