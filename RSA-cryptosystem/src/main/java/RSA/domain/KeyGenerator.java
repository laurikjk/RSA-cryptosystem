/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA.domain;


import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author lkajakko
 */




public class KeyGenerator {
    BigInteger p;
    BigInteger q;
    BigInteger phi;
    BigInteger n;
    BigInteger e;
    
    SecureRandom random;
    
    BigInteger publicKey;
    BigInteger privateKey;
    
    
    
    public KeyGenerator(int N) {
        
        random = new SecureRandom();
        while(true){
            p = BigInteger.probablePrime(N/2, random);
            q = BigInteger.probablePrime(N/2, random);
            phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
            e = new BigInteger("65537");
            n = p.multiply(q);

            publicKey = e;
            privateKey = publicKey.modInverse(phi);
            
            if(e.gcd(phi).equals(BigInteger.ONE)){
                
                break;
            }
        }
    }
    
    public BigInteger getPrivateKey() {
        return privateKey;
    }
    
    public BigInteger getPublicKey() {
        return publicKey;
    }
    
    public BigInteger getn() {
        return n;
    }
    
    
}
