package com.company;

import java.util.Scanner;

public class _02_SumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        int sum = 0;
        while (number > 0){
            sum += number%10;
            number /=10;
        }
        System.out.println(sum);
    }
}
