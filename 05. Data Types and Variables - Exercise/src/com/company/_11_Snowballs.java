package com.company;

import java.util.Scanner;

public class _11_Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sbNumber = Integer.parseInt(sc.nextLine());

        double snowballValue = 0;
        double maxSnowballValue = 0;
        int[] maxValue = {0, 0, 0};

        while (--sbNumber >= 0) {

            int sbSnow = Integer.parseInt(sc.nextLine());
            int sbTime = Integer.parseInt(sc.nextLine());
            int sbQuality = Integer.parseInt(sc.nextLine());

            snowballValue = Math.pow((sbSnow / sbTime), sbQuality);

            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                maxValue[0] = sbSnow;
                maxValue[1] = sbTime;
                maxValue[2] = sbQuality;
            }

        }
        snowballValue = Math.pow((maxValue[0] / maxValue[1]), maxValue[2]);

        System.out.printf("%d : %d = %.0f (%d)", maxValue[0], maxValue[1], snowballValue, maxValue[2]);
    }
}