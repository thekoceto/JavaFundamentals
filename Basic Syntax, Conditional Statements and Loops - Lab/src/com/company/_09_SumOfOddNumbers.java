package com.company;

import java.util.Scanner;

public class _09_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int sum = num * num, index = 0;
        while (++index <= num)
            System.out.println(index*2 - 1);

        System.out.printf("Sum: %d", sum);
    }
}
