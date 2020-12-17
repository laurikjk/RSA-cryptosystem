# Implementation

RSA is an asymmetric key cryptosystem. There is a pair of keys: public and private. The message that is being sent is encrypted using the public key and can be decrypted using the private key. 

## Algorithms

### Generating the keys

Key generation ([source](https://simple.wikipedia.org/wiki/RSA_algorithm)):
1. Generate large prime numbers p and q
2. Calculate modulus n = p * q
3. Calculate [totient](https://simple.wikipedia.org/wiki/Euler%27s_totient_function) phi = (p-1)(q-1)
4. Choose integer 1 < e < phi so that e is co-prime with phi
5. Calculate d = e modular inverse phi

#### Generating large primes

We quess random large numbers and check their primality with Miller-Rabin
* Miller-Rabin returns true when the number is probably prime
* Miller-Rabin returns false when the number is definitely composite

Implemented using pseudo-code [here](https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test#Complexity)

#### Computing modular inverse

Modular inverse is computed using Extended Euclidean algorithm. Given a and b it finds x, y and gcd(a,b) where xa + yb = gcd(a,b).

The pseudocode for this is:
```
xgcd(a, b)
    if a == 0:
        return (gcd, 0, 1)
    else:
        b = remainder og b / a
        gcd, x, y = xgcd(b, a)
        return (g, (y - b / a * x), x)

```
The modular inverse of a is calculated with xgcd(mod, a) and getting the returned x.


## Structure 

<img src=https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/images/architecture.png />

## Complexity and performance

### Times with different typical key sizes

<img src=https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/images/RSA%20times.png />

Time is still in nanoseconds.
Bars are means of tested times
* 1000 repetitions with 1024 bit key
* 100 repetitions with 2048 bit key
* 10 repetitions with 4096 bit key

## Possible improvements

* Hashing and padding the message

