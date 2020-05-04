package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_MovingTarget {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        List<Integer> targets = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!"End".equals(input = console.nextLine())) {
            String[] token = input.split("\\s+");
            switch (token[0]){
                case "Shoot":
                    shoot(targets, Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
                case "Add":
                    add(targets, Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
                case "Strike":
                    strike(targets, Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
            }
        }
        System.out.println(targets.toString()
                .replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "|"));
    }
    private static void shoot(List<Integer> targets, int index, int power) {
        if (index >= 0 && index < targets.size()){
            targets.set(index, targets.get(index)-power);
            if (targets.get(index) <= 0)
                targets.remove(index);
        }
    }
    private static void add(List<Integer> targets, int index, int value) {
        if (index >= 0 && index < targets.size())
            targets.add(index, value);
        else
            System.out.println("Invalid placement!");
    }
    private static void strike(List<Integer> targets, int index, int radius) {
        if (index-radius >= 0 && index+radius < targets.size()){
            int count = radius*2 + 1;
            while (count-- > 0)
                targets.remove(index-radius);
        }
        else
            System.out.println("Strike missed!");
    }
}
//•	Shoot {index} {power}
//o	Shoot the target at the index, if it exists by reducing its value by the given power (integer value).A target is considered shot when its value reaches 0.
//o	Remove the target, if it is shot.

//•	Add {index} {value}
//o	Insert a target with the received value at the received index, if it exist. If not, print: "Invalid placement!"

//•	Strike {index} {radius}
//o	Remove the target at the given index and the ones before and after it depending on the radius, if such exist. If any of the indices in the range is invalid print:
//"Strike missed!" and skip this command.