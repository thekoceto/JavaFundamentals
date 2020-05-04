package com.company;

import java.util.Scanner;

public class _02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        int minLength = input[0].length() < input[1].length() ? input[0].length() : input[1].length();
        int maxLength = input[0].length() > input[1].length() ? input[0].length() : input[1].length();
        int sum = 0;

        for (int i = 0; i < minLength; i++)
            sum += input[0].charAt(i)*input[1].charAt(i);
        for (int i = minLength; i < maxLength; i++)
            sum += input[0].length() > input[1].length() ? input[0].charAt(i) : input[1].charAt(i);
        System.out.println(sum);
    }
}
