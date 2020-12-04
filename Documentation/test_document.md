# Test Document

### Coverage report

<img src=https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/images/Screenshot%20from%202020-12-04%2016-23-38.png />

* There is an end to end test that uses message conversion and RSA 
* Miller-Rabin is also tested separately
* xgcd needs unit testing
* There is some unnecessary branches that might need removing

### Performance tests:

Here is a test of the times it takes to decrypt and encrypt messages. Tested with a small message and a 117byte one.

<img src=https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/images/performancetest_week4.png />

(the test above was made into junit tests and will be refactored to their own class)
