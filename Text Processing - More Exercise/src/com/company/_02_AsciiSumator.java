package com.company;

import java.util.Scanner;

public class _02_AsciiSumator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        char start = console.nextLine().charAt(0);
        char end = console.nextLine().charAt(0);
        String input = console.nextLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch > start && ch < end)
                sum += input.charAt(i);
        }
        System.out.println(sum);
    }
}
