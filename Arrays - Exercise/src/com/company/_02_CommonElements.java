package com.company;

import java.util.Scanner;

public class _02_CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Array1[] = sc.nextLine().split(" ");
        String Array2[] = sc.nextLine().split(" ");
        for (String element1 : Array2) {
            for (String element2 : Array1) {
                if (element1.equals(element2)) {
                    System.out.print(element2 + " ");
                }
            }
        }
    }
}
