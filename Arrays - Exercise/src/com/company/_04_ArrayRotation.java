package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _04_ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputArrays = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int steps = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < inputArrays.length; i++)
            System.out.printf("%d ", inputArrays[(i+steps)%inputArrays.length]);

    }
}
