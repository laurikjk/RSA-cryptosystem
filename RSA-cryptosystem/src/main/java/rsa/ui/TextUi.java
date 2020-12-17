package rsa.ui;

import rsa.domain.Encryption;
import rsa.domain.KeyGenerator;
import rsa.domain.PrivateKey;
import rsa.domain.PublicKey;
import rsa.utils.MessageConverter;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class TextUi {

    private Scanner scanner;
    private MessageConverter converter;
    private Encryption encryption;

    public TextUi() {
        scanner = new Scanner(System.in);
        converter = new MessageConverter();
        encryption = new Encryption();
    }

    public void run() throws IOException {
        String action;
        printInfo();
        while(true) {
            System.out.println("Type a command or \"info\" for more info: ");
            System.out.print("> ");
            action = scanner.nextLine();
            if (action.equals("exit")) handleExit();
            if (action.equals("info")) printInfo();
            if (action.equals("1")) handleCaseOne();
            if (action.equals("2")) handleCaseTwo();
            if (action.equals("3")) handleCaseThree();
            if (action.equals("4")) handleCaseFour();
        }
    }

    public void handleCaseOne() {
        KeyGenerator kg = new KeyGenerator(2048);
        try {
            FileWriter fileWriter = new FileWriter("keys.txt");
            fileWriter.write(kg.getPublicKey().toString());
            fileWriter.write("\n");
            fileWriter.write(kg.getPrivateKey().toString());
            fileWriter.close();
            System.out.println("\nYour keys are now in file \"keys.txt\" in the same directory as the executable.\n");
        } catch (IOException e) {
            System.out.println("file error");
        }

}

    public void handleCaseTwo() {
        System.out.println("Checking for \"keys.txt\" in this directory...");
        try {
            Scanner scanner = new Scanner(new FileInputStream("keys.txt"));
            String[] publicKeyString = scanner.nextLine().split(":");
            String[] privateKeyString = scanner.nextLine().split(":");
            scanner.close();
            System.out.println("Keys found.");

            Scanner input = new Scanner(System.in);
            System.out.print("Message: ");
            String message = input.nextLine();
            BigInteger converted = converter.convertString(message);
            PublicKey pub = new PublicKey(new BigInteger(publicKeyString[0]), new BigInteger(publicKeyString[1]));
            BigInteger encrypted = encryption.encrypt(pub, converted);
            FileWriter writer = new FileWriter("encrypted.txt");
            writer.write(encrypted.toString());
            writer.close();
            System.out.println("Encrypted message is now in file \"encrypted.txt\" in this directory. \n");


        } catch (IOException e) {
            System.out.println("\"keys.txt\" not found. Try generating keys with command 1. ");
        }
    }

    public void handleCaseThree() {
        System.out.println("Checking for \"keys.txt\" and \"encrypted.txt\" in this directory...");
        try {
            Scanner scanner = new Scanner(new FileInputStream("keys.txt"));
            String[] publicKeyString = scanner.nextLine().split(":");
            String[] privateKeyString = scanner.nextLine().split(":");
            System.out.println("Keys found. Using your private key to decrypt the message. \n");
            scanner = new Scanner((new FileInputStream("encrypted.txt")));
            String encrypted = scanner.nextLine();
            scanner.close();
            PrivateKey priv = new PrivateKey(new BigInteger(privateKeyString[0]), new BigInteger(privateKeyString[1]));
            BigInteger decrypted = encryption.decrypt(priv, new BigInteger(encrypted));
            String conversion = converter.convertBigInteger(decrypted);
            System.out.println("Encrypted message: \n" + encrypted + "\n");
            System.out.println("Decrypted message: \n" + conversion + "\n");


        }catch (IOException e) {
            System.out.println("Required files not found. Try generating them first.");
        }
    }

    public void handleCaseFour() throws IOException {
        PerformanceTester pt = new PerformanceTester();
        pt.run();
    }

    public void printInfo() {
        System.out.println("\nWhat would you like to do? (1-3)");
        System.out.println("\t 1. Create keys");
        System.out.println("\t 2. Encrypt a message");
        System.out.println("\t 3. Decrypt a message");
        System.out.println("\t 4. Run performance test");
        System.out.println("\t Type 'exit' to exit the program");
        System.out.println("\t Type 'info' to print this info\n");
    }

    public void handleExit() {
        System.exit(0);
    }
}
