package com.company;

import java.util.Scanner;

public class _02_Passed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println( Double.parseDouble(sc.nextLine()) >= 3.0 ? "Passed!" : "");
    }
}