
package rsa.domain;


import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * 
 * @author LauriKajakko
 */
public class KeyGenerator {
    private BigInteger p;
    private BigInteger q;
    private BigInteger phi;
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;
    
    private SecureRandom random;
    
    private PublicKey publicKey;
    private PrivateKey privateKey;
    
    
    /**
     * 
     * @param size Size of the key
     */
    public KeyGenerator(int size) {
        
        random = new SecureRandom();
        
        p = BigInteger.probablePrime(size/2, random);
        q = BigInteger.probablePrime(size/2, random);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537");
        n = p.multiply(q);
        d = e.modInverse(phi);

        publicKey = new PublicKey(e, n);
        privateKey = new PrivateKey(d, n);
    }
    
    /**
     * 
     * @return private key 
     */
    public PrivateKey getPrivateKey() {
        return privateKey;
    }
    
    /**
     * 
     * @return public key 
     */
    public PublicKey getPublicKey() {
        return publicKey;
    }
    
    
    
}
