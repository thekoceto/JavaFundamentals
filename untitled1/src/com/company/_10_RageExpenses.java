package com.company;

import java.util.Scanner;

public class _10_RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;
        int div[] = {2, 3, 6, 12};

        int gamesCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < 4; i++)
            total += (gamesCount/div[i])*Double.parseDouble(sc.nextLine());

        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
