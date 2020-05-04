package com.company;

import java.util.Scanner;

public class _04_SumOfChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0,number = Integer.parseInt(sc.nextLine());
        while (--number >= 0)
            sum += sc.next().charAt(0);
        System.out.printf("The sum equals: %d", sum);
    }
}
