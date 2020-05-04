package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        Pattern pattern = Pattern.compile ("([^>]+)>(?<a>[0-9]{3})\\|(?<b>[a-z]{3})\\|(?<c>[A-Z]{3})\\|(?<d>[^<>]{3})<\\1$");

        while (n-- > 0) {
            Matcher matcher = pattern.matcher(console.nextLine());
            if (matcher.find())
                System.out.println("Password: " + matcher.group("a")
                                                + matcher.group("b")
                                                + matcher.group("c")
                                                + matcher.group("d"));
            else
                System.out.println("Try another password!");
        }
    }
}
