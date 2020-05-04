package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _08_MagicSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int magicSum = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < input.length; i++)
            for (int j = i+1; j < input.length; j++)
                if (input [i] + input [j] == magicSum )
                    System.out.printf("%d %d%n", input [i], input [j]);
    }
}
