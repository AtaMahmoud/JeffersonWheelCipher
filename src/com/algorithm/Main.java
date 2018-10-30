package com.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        System.out.print("Rings Number : ");
        int ringsumbers=input.nextInt();
        System.out.print("Plain Text: ");
        String plainText=input.next();

	    WheelAlgorithm wa=new WheelAlgorithm(ringsumbers,plainText);
	    wa.Encrypt();
        wa.printCipherTexts();

        System.out.println("*** Decrypt Cipher Text ***");
        System.out.print("Cipher Text : ");
        String cipherText=input.next().trim();
        System.out.print("Cipher Text number : ");
        int cipherTextNumber=input.nextInt();

        wa.decrypte(cipherText,cipherTextNumber);
        wa.printPlainText();
    }
}
