package com.company;

import java.util.Scanner;

public class _08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            int num = exportDigit(input[i]);
            sum += returnNumber(num, input[i].charAt(0), input[i].charAt(input[i].length()-1));
        }
        System.out.printf("%.2f",sum);
    }

    private static int exportDigit(String str) {
        return Integer.parseInt(str.substring(1, str.length() - 1));
    }

    private static double returnNumber(double num, char first, char second) {
        double sum = 0.0;
        if (Character.isLowerCase(first))
            sum = num*(first - 96);
        else
            sum = num/(first - 64);
        if (Character.isLowerCase(second))
            sum += (second - 96);
        else
            sum -= (second - 64);
        return sum;
    }
}
