package com.company;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _01_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Integer> mapNumbers = new TreeMap<>();

        int[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < input.length; i++) {
            int number = input[i];

            if (!mapNumbers.containsKey(number)){
                mapNumbers.put(number,1);
            }else{
                mapNumbers.put(number,mapNumbers.get(number)+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mapNumbers.entrySet()) {
            System.out.printf("%d -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
