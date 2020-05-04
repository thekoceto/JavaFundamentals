package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _05_TopIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputArrays = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int i = 0; i < inputArrays.length; i++){
            boolean isBigger = false;
            for (int j = i+1; j < inputArrays.length; j++) {
                isBigger = inputArrays[i] > inputArrays[j];
                if (!isBigger)
                    break;
            }
            if (isBigger)
                System.out.printf("%d ", inputArrays[i]);
        }
        System.out.println(inputArrays[inputArrays.length-1]);
    }
}
