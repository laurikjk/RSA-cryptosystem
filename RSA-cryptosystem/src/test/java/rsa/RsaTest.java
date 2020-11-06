
package rsa;

import rsa.domain.Encryption;
import rsa.domain.KeyGenerator;
import java.math.BigInteger;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lkajakko
 */
public class RsaTest {
    
    KeyGenerator g;
    Encryption e;
    BigInteger priv;
    BigInteger pub;
    BigInteger n;
    
    @Before
    public void setUp() {
        g = new KeyGenerator(1024);
        e = new Encryption();
        priv = g.getPrivateKey();
        pub = g.getPublicKey();
        n = g.getn();
    }
    
    @Test
    public void messageAndDecryptedMessageMatch() {
        BigInteger message = new BigInteger("1234567890");
        BigInteger encrypted = e.encrypt(pub, message, n);
        BigInteger decrypted = e.decrypt(priv, encrypted, n);
        
        assertTrue(message.equals(decrypted));
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
