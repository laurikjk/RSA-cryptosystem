/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA.domain;

import java.math.BigInteger;

/**
 *
 * @author lkajakko
 */
public class Encryption {
    
    public BigInteger encrypt(BigInteger publicKey, BigInteger message, BigInteger n){
        return message.modPow(publicKey, n);
    }
    
    public BigInteger decrypt(BigInteger privateKey, BigInteger message, BigInteger n){
        return message.modPow(privateKey, n);
    }
    
}
