package com.company;

import java.util.Scanner;

public class _04_Caesar_Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String newText = "";

        for (int i = 0; i < input.length(); i++) {
            char originalLetter = input.charAt(i);
            int newLetterNum = input.charAt(i)+3;
            char changeLetter =(char) newLetterNum;

            newText += changeLetter;
        }
        System.out.println(newText);
    }
}
