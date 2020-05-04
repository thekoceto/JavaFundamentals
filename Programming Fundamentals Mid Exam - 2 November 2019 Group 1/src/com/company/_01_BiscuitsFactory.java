package com.company;

import java.util.Scanner;

public class _01_BiscuitsFactory {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        int a  = Integer.parseInt(console.nextLine());
        int b  = Integer.parseInt(console.nextLine());
        int c  = Integer.parseInt(console.nextLine());
        int d = a*b*20 + (int)(Math.floor(a*b*0.75))*10;

        System.out.printf ("You have produced %d biscuits for the past month.%n", d);
        double dif = (c-d)/(double)c*100.0;
        System.out.printf ("You produce %.2f percent %s biscuits.", dif>=0 ? dif : -dif, dif >= 0 ? "less" : "more");

    }
}
