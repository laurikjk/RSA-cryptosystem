package RSA.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RSA.domain.KeyGenerator;

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
        System.out.println(g.getPrivateKey());
        System.out.println(g.getPublicKey());
        System.out.println(g.getn());
    }
    
}
