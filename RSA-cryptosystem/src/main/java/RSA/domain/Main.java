package RSA.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RSA.domain.KeyGenerator;
import RSA.domain.Encryption;
import java.math.BigInteger;

/**
 *
 * @author lkajakko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        KeyGenerator g = new KeyGenerator(1024);
        BigInteger priv = g.getPrivateKey();
        BigInteger pub = g.getPublicKey();
        BigInteger n = g.getn();
        BigInteger message = new BigInteger("1234");
        
        Encryption e = new Encryption();
        
        System.out.println("Message: " + message);
        
        BigInteger secret = e.encrypt(pub, message, n);
        System.out.println("Encrypted " + secret);
        
        System.out.println("Decrypted: " + e.decrypt(priv, secret, n));
        
        
    }
    
}
