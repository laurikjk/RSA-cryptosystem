package rsa.ui;

import rsa.domain.KeyGenerator;

import java.util.Scanner;

public class TextUi {

    private Scanner scanner;

    public TextUi() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        String action;
        while(true) {
            printInfo();
            System.out.print("> ");
            action = scanner.nextLine();
            if (action.equals("exit")) handleExit();
            if (action.equals("1")) handleCaseOne();
        }
    }

    public void handleCaseOne() {
        KeyGenerator kg = new KeyGenerator(1024);
        System.out.println(kg.getPublicKey());
        System.out.println(kg.getPrivateKey());

    }

    public void printInfo() {
        System.out.println("\nWhat would you like to do? (1-3)");
        System.out.println("\t 1. Create keys");
        System.out.println("\t 2. Encrypt a message");
        System.out.println("\t 3. Decrypt a message");
        System.out.println("\t Type 'exit' to exit the program\n");
    }

    public void handleExit() {
        System.exit(0);
    }
}
