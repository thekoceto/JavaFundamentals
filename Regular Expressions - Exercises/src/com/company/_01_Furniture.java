package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_Furniture {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double total = 0.0;
        String regex = "^>+([A-Z{0,}a-z]+)+<<(\\d+\\.?\\d+)+!([\\d+]+)\\b";
        String input;
        System.out.println("Bought furniture:");
        while (!"Purchase".equals(input = console.nextLine())){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String furniture = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                double quantity = Double.parseDouble(matcher.group(3));
                System.out.println(furniture);
                total += price * quantity;
            }
        }
        System.out.printf("Total money spend: %.2f", total);
    }
}
