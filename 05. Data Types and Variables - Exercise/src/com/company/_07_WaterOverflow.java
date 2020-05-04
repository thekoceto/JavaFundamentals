package com.company;

import java.util.Scanner;

public class _07_WaterOverflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int full = 0;
        while (--n >= 0){
            int curr = Integer.parseInt(sc.nextLine());
            if (full + curr > 255)
                System.out.println("Insufficient capacity!");
            else
                full += curr;
        }
        System.out.println(full);
    }
}
