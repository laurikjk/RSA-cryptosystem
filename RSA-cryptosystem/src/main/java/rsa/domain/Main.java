package rsa.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

        MessageConverter mc = new MessageConverter();

        System.out.println(mc.convertBigInteger(new BigInteger("00970098009901000101")));

    }
    
}
