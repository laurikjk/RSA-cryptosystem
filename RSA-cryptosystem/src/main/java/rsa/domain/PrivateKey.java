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
public class PrivateKey {
    
    private BigInteger n;
    private BigInteger d;
    
    /**
     * Private Key for RSA-algorithm
     * 
     * @param n modulus for private and public keys
     * @param d exponent used for RSA-algorithm
     */
    public PrivateKey(BigInteger d, BigInteger n) {
        this.n = n;
        this.d = d;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getD() {
        return d;
    }

    @Override
    public String toString() {
        return this.getD() + ":" + this.getN();
    }
    
}
