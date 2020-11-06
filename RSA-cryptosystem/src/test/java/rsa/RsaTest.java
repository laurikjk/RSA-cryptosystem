
package rsa;

import rsa.domain.Encryption;
import rsa.domain.KeyGenerator;
import java.math.BigInteger;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rsa.domain.PrivateKey;
import rsa.domain.PublicKey;

/**
 *
 * @author lkajakko
 */
public class RsaTest {
    
    KeyGenerator g;
    Encryption e;
    PrivateKey priv;
    PublicKey pub;
    BigInteger n;
    
    @Before
    public void setUp() {
        g = new KeyGenerator(1024);
        e = new Encryption();
        priv = g.getPrivateKey();
        pub = g.getPublicKey();
    }
    
    
    @Test
    public void messageAndDecryptedMessageMatch() {
        BigInteger message = new BigInteger("1234567890");
        BigInteger encrypted = e.encrypt(pub, message);
        BigInteger decrypted = e.decrypt(priv, encrypted);
        
        assertTrue(message.equals(decrypted));
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
