package com.algorithm;

import java.util.Collections;

public class WheelAlgorithm {
    private int ringsNumber;
    private Ring[] decryptionRings;
    private String plainText;
    private Ring[] encryptionRings;

    public WheelAlgorithm(int ringsNumber, String plainText) {
        this.ringsNumber = ringsNumber;
        this.plainText = plainText.toLowerCase();

        decryptionRings = new Ring[ringsNumber];
        encryptionRings = new Ring[ringsNumber];

        for (int i = 0; i < ringsNumber; i++) {
            encryptionRings[i] = new Ring();
            decryptionRings[i] = new Ring();
            for (char c = 'a'; c <= 'z'; c++) {
                encryptionRings[i].cells.add(c);
            }
            Collections.shuffle(encryptionRings[i].cells);
            for (char c : encryptionRings[i].cells) {
                decryptionRings[i].cells.add(c);
            }
        }
    }

    public void Encrypt() {
        char[] plainTextChars = plainText.toCharArray();
        for (int i = 0; i < plainTextChars.length; i++) {
            int rotateDistance = encryptionRings[i].cells.indexOf(plainTextChars[i]);
            Collections.rotate(encryptionRings[i].cells, -rotateDistance);
        }
    }

    public void printCipherTexts() {
        System.out.println("Plaint Text : " + plainText);
        System.out.println("Cipher Texts :- ");
        for (int i = 1; i <= 25; i++) {
            System.out.print("Cipher Text #" + i + " :");
            for (int j = 0; j < plainText.length(); j++) {

                System.out.print(encryptionRings[j].cells.get(i));
            }
            System.out.println();
        }
    }

    public void decrypte(String cipherText, int cipherTextNumber) {
        char[] cipherTextChars = cipherText.toCharArray();
        for (int j = 0; j < cipherTextChars.length; j++) {
            int cipherCharIndex = decryptionRings[j].cells.indexOf(cipherTextChars[j]);
            int distance = 0;
            if (cipherTextNumber > cipherCharIndex) {
                distance = cipherCharIndex + (decryptionRings[j].cells.size() - cipherTextNumber);
            } else {
                distance = cipherTextNumber + (decryptionRings[j].cells.size() - cipherCharIndex);
            }
            Collections.rotate(decryptionRings[j].cells, -distance);
        }
    }

    public void printPlainText() {
        System.out.print("Plain Text :  ");
        for (int j = 0; j < plainText.length(); j++) {
            System.out.print(encryptionRings[j].cells.get(0));
        }
    }

}
