package com.company;

import java.util.Scanner;

public class _03_ZigZagArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int steps = Integer.parseInt(sc.nextLine());
        int [] ArrayOne = new int[steps];
        int [] ArrayTwo = new int[steps];

        for (int i = 0; i < steps; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            ArrayOne[i] = i % 2 == 0 ? first : second;
            ArrayTwo[i] = i % 2 == 0 ? second : first;
        }

        for (int element : ArrayOne)
            System.out.print(element + " ");

        System.out.println();

        for (int element : ArrayTwo)
            System.out.print(element + " ");
    }
}
