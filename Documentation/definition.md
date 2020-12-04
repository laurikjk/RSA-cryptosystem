# Project definition

Project for course "Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit" at the University of Helsinki.

I'm implementing RSA-cryptosystem. It generates private and public keypairs to
encrypt and decrypt messages.

Study programme: "Tietojenkäsittelytieteen kandiohjelma"

Project language: English

## Algorithms and Data structures

* probable prime numbers for p and g (miller-rabin)
* inverse mod (extended Euclidean algorithm)
* Random
  * to generate a secure random number for probable prime

Note: 
* BigInteger not implemented by me. This has been discussed with the instructor.
 * BigInteger and only it's methods mod, multiply, substract etc. are allowed
 * It's algorithms mentioned above are going to be implemented by me


## Problem

* Generation of public and private keys
* Encryption and decryption of a message
* (Padding the message)
* (SHA)


## Time and space complexity

* Miller-Rabin is O(k log^3 n) (wikipedia)

## Sources

https://en.wikipedia.org/wiki/RSA_(cryptosystem)

https://www.youtube.com/watch?v=oOcTVTpUsPQ&t=591s

https://introcs.cs.princeton.edu/java/99crypto/

https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test#Complexity
