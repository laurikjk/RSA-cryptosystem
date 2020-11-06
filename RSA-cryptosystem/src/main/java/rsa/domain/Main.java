package rsa.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import rsa.domain.KeyGenerator;
import rsa.domain.Encryption;
import rsa.domain.PrivateKey;
import rsa.domain.PublicKey;
import java.math.BigInteger;

/**
 * 
 * @author LauriKajakko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        KeyGenerator g = new KeyGenerator(1024);
        PrivateKey priv = g.getPrivateKey();
        PublicKey pub = g.getPublicKey();
        
        BigInteger message = new BigInteger("1234");
        
        Encryption e = new Encryption();
        
        System.out.println("Message: " + message);
        
        BigInteger secret = e.encrypt(pub, message);
        System.out.println("Encrypted " + secret);
        
        System.out.println("Decrypted: " + e.decrypt(priv, secret));
        
        
    }
    
}
