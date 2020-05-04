package com.company;

import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class _06_ExtractEmails {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        String regex = "(?<user>[\\s][a-z]+[.\\-\\_]?[a-z]+)@(?<host>[a-z]+[\\.-][a-z]+\\.?[a-z]+\\.*[a-z]*)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
            System.out.println(matcher.group().substring(1));

    }
}