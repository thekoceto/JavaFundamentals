package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_MatchDates {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String regex = "(?<day>\\d{2})([-.\\/])(?<month>[A-Z][a-z]{2})(\\2)(?<year>\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find())
            System.out.printf("Day: %s, Month: %s, Year: %s%n",
                    matcher.group("day"),
                    matcher.group("month"),
                    matcher.group("year"));
    }
}
