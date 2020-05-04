package com.company;

import java.util.Scanner;

public class _01_Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        while (--n>=0){
            int w = Integer.parseInt(sc.nextLine());
            System.out.printf("%d ",w);
            sum += w;
        }
        System.out.printf("%n%d",sum);
    }
}
