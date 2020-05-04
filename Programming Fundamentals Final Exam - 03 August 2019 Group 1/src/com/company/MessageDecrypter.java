package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<a>\\d+)]\\|\\[(?<b>\\d+)]\\|\\[(?<c>\\d+)]\\|$";
        Pattern pattern = Pattern.compile(regex);
        int steps = Integer.parseInt(scan.nextLine());
        while (steps-- > 0){            String input = scan.nextLine();

            Matcher matcher = pattern.matcher(input);
            if (matcher.find())
                System.out.println( matcher.group("tag") + ": "
                        + (char) Integer.parseInt (matcher.group ("a"))
                        + (char) Integer.parseInt (matcher.group ("b"))
                        + (char) Integer.parseInt (matcher.group ("c")));
            else
                System.out.println("Valid message not found!");
        }
    }
}