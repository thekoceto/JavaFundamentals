package com.company;

import java.util.Scanner;

public class _06_StrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int temp = number, sum = 0;

        while (temp > 0){
            sum += factorial(temp % 10);
            temp /= 10;
        }
        System.out.println(sum == number ? "Yes" : "No");
    }

    private static int factorial(int i) {
        if (i == 0)
            return 1;
        else
            return i* factorial(i-1);
    }
}