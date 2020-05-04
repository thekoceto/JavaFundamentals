package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        int count = 0;

        int [] targets = Arrays.stream(console.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        while (!"End".contains(input = console.nextLine())){
            int index = Integer.parseInt(input);
            if (index >= 0 && index < targets.length){
                count++;
                int current = targets[index];
                targets[index] = -1;
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1){
                        if (targets[i] > current)
                            targets[i] -= current;
                        else
                            targets[i] += current;
                    }
                }
            }
        }
        System.out.printf("Shot targets: %d -> %s", count, Arrays.toString(targets).replaceAll("[\\[\\],]", ""));
    }
}
