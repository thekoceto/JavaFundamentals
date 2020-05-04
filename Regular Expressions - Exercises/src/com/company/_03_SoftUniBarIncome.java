package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*\\<(?<product>\\w+)\\>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d+?)\\$";
        String input;
        double total = 0.0;
        while (!"end of shift".equals(input = console.nextLine())){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                System.out.printf("%s : %s - %.2f%n", name, product, count * price);
                total += count * price;
            }
        }
        System.out.printf("Total income: %.2f", total);
    }
}
