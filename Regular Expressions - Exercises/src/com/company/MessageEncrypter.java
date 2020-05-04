package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countInputs = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < countInputs ; i++) {
            String input = scan.nextLine();
            String regex = "([*@])(?<name>[A-Z][a-z]{2,})(\\1)(: \\[)(?<first>[A-Za-z])(\\]\\|\\[)(?<second>[A-Za-z])(\\]\\|\\[)(?<third>[A-Za-z])(\\]\\|)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int first = (int)matcher.group("first").charAt(0);
                int second = (int)matcher.group("second").charAt(0);
                int third = (int) matcher.group("third").charAt(0);
                String name = matcher.group("name");
                System.out.println(String.format("%s: %d %d %d", name, first, second, third));
            }else {
                System.out.println("Valid message not found!");
            }
        }
    }
}