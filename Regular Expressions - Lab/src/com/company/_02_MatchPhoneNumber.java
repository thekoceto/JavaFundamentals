package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> phones = new ArrayList<String>();
        String input = console.nextLine();
        String regex = "\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
            phones.add(matcher.group());
        System.out.print(String.join(", ", phones));
    }
}
