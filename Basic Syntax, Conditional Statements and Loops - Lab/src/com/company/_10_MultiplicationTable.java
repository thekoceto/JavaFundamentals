package com.company;

import java.util.Scanner;

public class _10_MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int index = 0;

        while (++index <= 10)
            System.out.printf("%d X %d = %d%n", num, index, num*index);

    }
}
