package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String regex = "([#$%*&])(?<name>[A-Za-z]+)\\1=(?<length>[\\d]+)!!(?<geohash>[^\\n]*)";
        Pattern pattern = Pattern.compile(regex);
        while (true){
            Matcher matcher = pattern.matcher(console.nextLine());
            if (matcher.find()){
                String geohash = matcher.group("geohash");
                int length = Integer.parseInt(matcher.group("length"));
                if (geohash.length() == length){
                    System.out.printf("Coordinates found! %s -> %s%n", matcher.group("name"), encript(geohash, length));
                    break;
                }
                else
                    System.out.println("Nothing found!");
            }else
                System.out.println("Nothing found!");
        }
    }

    private static String encript(String cipher, int key) {
        String plain = "";
        for (char ch : cipher.toCharArray() )
            plain += (char)(ch + key);
        return plain;
    }
}
