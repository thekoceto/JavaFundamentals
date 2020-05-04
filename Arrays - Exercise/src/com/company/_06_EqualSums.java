package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputArrays = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < inputArrays.length; i++){
            int sumLeft = 0;
            int sumRight = 0;

            for (int j = 0; j < i ; j++)
                sumLeft += inputArrays[j];
            for (int j = i + 1; j < inputArrays.length; j++)
                sumRight += inputArrays[j];

            if (sumLeft == sumRight){
                System.out.println(i);
                break;
            }
            else if (i == inputArrays.length-1)
                System.out.println("no");
        }
    }
}
