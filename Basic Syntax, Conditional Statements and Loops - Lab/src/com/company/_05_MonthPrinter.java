package com.company;

import java.util.Scanner;

public class _05_MonthPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        String month[] = {"January", "February", "March",
                            "April", "May", "June",
                            "July", "August", "September",
                            "October", "November", "December"};
        if (input < 1 || input > 12)
            System.out.println("Error!");
        else
            System.out.println(month[input-1]);
    }
}