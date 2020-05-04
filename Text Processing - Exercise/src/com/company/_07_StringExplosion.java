package com.company;

import java.util.Scanner;

public class _07_StringExplosion {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        int numberToRemove = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (numberToRemove == 0 || input.charAt(i)  == '>')
                result.append(input.charAt(i));
            else
                numberToRemove--;
            if (input.charAt(i)  == '>'){
                numberToRemove += Character.getNumericValue(input.charAt(i+1));
            }
        }
        System.out.println(result);
    }
}
