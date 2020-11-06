/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.domain;


import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * 
 * @author LauriKajakko
 */
public class KeyGenerator {
    BigInteger p;
    BigInteger q;
    BigInteger phi;
    BigInteger n;
    BigInteger e;
    BigInteger d;
    
    SecureRandom random;
    
    BigInteger publicKey;
    BigInteger privateKey;
    
    
    /**
     * 
     * @param size of the key 
     */
    public KeyGenerator(int size) {
        
        random = new SecureRandom();
        while(true){
            p = BigInteger.probablePrime(size/2, random);
            q = BigInteger.probablePrime(size/2, random);
            phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
            e = new BigInteger("65537");
            n = p.multiply(q);
            d = e.modInverse(phi);

            publicKey = e;
            privateKey = d;
            
            if(e.gcd(phi).equals(BigInteger.ONE)){
                break;
            }
        }
    }
    
    /**
     * 
     * @return private key 
     */
    public BigInteger getPrivateKey() {
        return privateKey;
    }
    
    /**
     * 
     * @return public key 
     */
    
    public BigInteger getPublicKey() {
        return publicKey;
    }
    /**
     * 
     * @return n
     */
    public BigInteger getn() {
        return n;
    }
    
    
}
