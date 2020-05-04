package com.company;

import java.util.Scanner;

public class _01_IntegerOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = {0,0,0,0};
        for (int i = 0; i < 4; i++)
            n[i] = Integer.parseInt(sc.nextLine());
        System.out.println(((n[0] + n[1]) / n[2]) * n[3]);
    }
}
