package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int maxValue = 0, maxRepeat = 0, currCount = 1;
        for (int i = 1; i < input.length; i++){
            if (input[i] == input[i-1]){
                if (++currCount > maxRepeat){
                    maxRepeat = currCount;
                    maxValue = input[i];
                }
            }else
                currCount = 1;
        }
        for (int i = 0; i < maxRepeat; i++)
            System.out.printf("%d ", maxValue);
    }
}
