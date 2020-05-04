package com.company;

import java.util.Scanner;

public class _09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int spicePerDay = Integer.parseInt(sc.nextLine());
        int days = 0,  amount = 0;
        while (spicePerDay >= 100){
            ++days;
            amount += spicePerDay - 26;
            spicePerDay -= 10;
        }
        System.out.println(days);
        System.out.println(amount >= 26  ? amount - 26 : amount);
    }
}
// 111 - 26 = 85
// 101 - 26 = 75