/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.domain;

import java.math.BigInteger;

/**
 *
 * @author LauriKajakko
 */
public class PublicKey {
    
    private BigInteger n;
    private BigInteger e;
    
    /**
     * Public Key for RSA-algorithm
     * 
     * @param n modulus for private and public keys
     * @param e exponent used for RSA-algorithm
     */
    public PublicKey(BigInteger e, BigInteger n) {
        this.n = n;
        this.e = e;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    @Override
    public String toString() {
        return this.getN() + ":" + this.getE();
    }
    
}
