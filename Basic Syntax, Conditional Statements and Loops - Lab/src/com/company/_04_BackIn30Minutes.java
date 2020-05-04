package com.company;

import java.util.Scanner;

public class _04_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());
        int total = 60*hours + minutes + 30;
        System.out.printf("%d:%02d", (total/60)%24, total%60);
    }
}