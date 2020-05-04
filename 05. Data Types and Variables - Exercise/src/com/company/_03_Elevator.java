package com.company;

import java.util.Scanner;

public class _03_Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double p = Double.parseDouble(sc.nextLine());
        System.out.println((int) Math.ceil(n/p));
    }
}
