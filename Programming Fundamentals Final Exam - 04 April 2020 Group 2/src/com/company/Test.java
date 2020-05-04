package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String input = "@##Che4s6E@##";

        Matcher matcher = Pattern.compile("\\d").matcher(input);
        System.out.print("Product group: ");
        if (matcher.groupCount()>0){
            while(matcher.find())
                System.out.print(matcher.group());
        } else
            System.out.print("00");
    }
}