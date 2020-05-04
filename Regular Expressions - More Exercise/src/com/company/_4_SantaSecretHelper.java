package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _4_SantaSecretHelper {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int key = Integer.parseInt(console.nextLine());
        String cipher;
        while (!"end".equals(cipher = console.nextLine())){
            String plain = encript(cipher, key);
            String regex = "@(?<name>[A-Za-z]+)([^@\\-!:>]*)!(?<type>[GN])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(plain);
            if (matcher.find()){
                if (matcher.group("type").equals("G"))
                    System.out.println(matcher.group("name"));
            }
        }
    }

    private static String encript(String cipher, int key) {
        String plain = "";
        for (char ch : cipher.toCharArray() )
            plain += (char)(ch - key);
        return plain;
    }
}