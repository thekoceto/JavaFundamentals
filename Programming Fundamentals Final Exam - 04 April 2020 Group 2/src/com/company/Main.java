package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String regex = "\\d";
        String text = "@##Che4s6E@##";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int groupCount = matcher.groupCount();
        System.out.println("Number of group = " + groupCount);

        while (matcher.find()) {
            for (int i = 0; i <= groupCount; i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}