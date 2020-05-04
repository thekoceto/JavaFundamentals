package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_RageQuit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        StringBuilder result = new StringBuilder();
        String regex = "(?<symbols>[^\\d]+)(?<number>[\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            int steps = Integer.parseInt(matcher.group("number"));
            while (steps-- > 0)
                result.append(matcher.group("symbols").toUpperCase());
        }
        System.out.println("Unique symbols used: " + result.chars().distinct().count());
        System.out.println(result);
    }
}