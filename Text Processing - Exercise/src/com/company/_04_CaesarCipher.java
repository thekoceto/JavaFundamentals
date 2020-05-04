package com.company;

import java.util.Scanner;

public class _04_CaesarCipher {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String plain = console.nextLine();
        String cipher = "";
        for (int i = 0; i < plain.length(); i++)
            cipher += (char)(plain.charAt(i) + 3);
        System.out.println(cipher);
    }
}
