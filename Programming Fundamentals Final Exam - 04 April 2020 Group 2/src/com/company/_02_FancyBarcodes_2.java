package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_FancyBarcodes_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());

        while (steps-- > 0) {
            Pattern pattern = Pattern.compile("^(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)$");
            Matcher matcher = pattern.matcher(console.nextLine());
            if (matcher.find()) {
                matcher = Pattern.compile("\\d").matcher(matcher.group());
                System.out.print("Product group: ");
                if (matcher.find()){
                    System.out.print(matcher.group());
                    while(matcher.find())
                        System.out.print(matcher.group());
                }
                else
                    System.out.print("00");
                System.out.println();
            } else
                System.out.println("Invalid barcode");
        }
    }
}