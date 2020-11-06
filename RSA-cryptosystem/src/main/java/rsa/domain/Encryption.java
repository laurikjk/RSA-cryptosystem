/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.domain;

import java.math.BigInteger;
import rsa.domain.PrivateKey;
import rsa.domain.PublicKey;

/**
 * 
 * @author LauriKajakko
 */
public class Encryption {
    
    /**
     * 
     * @param publicKey public key for encryption
     * @param message message to encrypt
     * @return encrypted message
     */
    public BigInteger encrypt(PublicKey publicKey, BigInteger message) {
        return message.modPow(publicKey.getE(), publicKey.getN());
    }
    
    /**
     * 
     * @param privateKey private key for decryption
     * @param message message to decrypt
     * @return decrypted message
     */
    public BigInteger decrypt(PrivateKey privateKey, BigInteger message) {
        return message.modPow(privateKey.getD(), privateKey.getN());
    }
    
}
