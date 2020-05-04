package com.company;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_PostOffice {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<Integer, Integer> ascii = new TreeMap<>();
        String[] input = console.nextLine().split("\\|");
        String[] messages = input[2].split(" ");
        String regex = "([#$%*&])(?<capital>[A-Z]+)(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input[0]);
        matcher.find();
        String capital = matcher.group("capital");

        regex = "(\\d{2}):(\\d{2})";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input[1]);
        while (matcher.find())
            ascii.put(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));

        for (char ch : capital.toCharArray()) {
            int length = ascii.get((int)ch) + 1;
            for (String word : messages ) {
                if (word.charAt(0)==ch && word.length() == length){
                    System.out.println(word);
                    break;
                }
            }
        }
    }
}
