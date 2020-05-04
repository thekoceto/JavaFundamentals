package com.company;

import java.util.Scanner;

public class _02_Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int div[] = {10, 7, 6, 3, 2};
        boolean flag = false;

        for (int i = 0; i < div.length; i++) {
            if (number % div[i] == 0){
                System.out.printf("The number is divisible by %d", div[i]);
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println("Not divisible");
    }
}
//2,3,6,7,10
//30	The number is divisible by 10
//15	The number is divisible by 3
//12	The number is divisible by 6
//1643	Not divisible