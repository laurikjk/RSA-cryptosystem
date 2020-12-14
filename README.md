# RSA-cryptosystem

Implementation of RSA-cryptosystem and the algorithms it uses. 

### Documentation

[Definition document](https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/definition.md)

[Test document](https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/test_document.md)

[Instructions](https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/Instructions.md)

[Implementation (toteutusdokumentti)](https://github.com/LauriKajakko/RSA-cryptosystem/blob/main/Documentation/Implementation.md)

### Weekly reports

[Reports directory](https://github.com/LauriKajakko/RSA-cryptosystem/tree/main/Documentation/reports)

### Command Line

#### Testing

Run tests: 
```
mvn test
```

Create coverage report to /target/site/jacoco/index.html :
```
mvn test jacoco:report
```

Create javadoc: 
```
mvn javadoc:javadoc
```

#### Checkstyle

Run checkstyle:
```
 mvn jxr:jxr checkstyle:checkstyle
```

### On versions used

The project uses:
* java 11 
* jacoco 0.8.3
* checkstyle 2.17.
