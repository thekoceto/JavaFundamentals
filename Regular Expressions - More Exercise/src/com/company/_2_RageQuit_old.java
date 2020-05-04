package com.company;

import java.util.Scanner;

public class _2_RageQuit_old {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)){
                int steps = Character.getNumericValue(ch);
                while (steps-- > 0)
                    result.append(current);
                current.setLength(0);
            }
            else{
                current.append(Character.toUpperCase(ch));
            }
        }
        System.out.println("Unique symbols used: " + result.chars().distinct().count());
        System.out.println(result);
    }
}
