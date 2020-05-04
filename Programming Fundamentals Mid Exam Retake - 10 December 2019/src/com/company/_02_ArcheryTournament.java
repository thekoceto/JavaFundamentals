package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ArcheryTournament {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(console.nextLine().split("\\|"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = console.nextLine();
        String[] command = input.split("\\s+");
        int points = 0;

        while (!input.equals("Game over")) {
            if (input.isEmpty()){
                input = console.nextLine();
                command = input.split("\\s+");
                continue;
            }
            if (command[0].equals("Reverse")){
                reverse(targets);
                input = console.nextLine();
                command = input.split("\\s+");;
                continue;
            }

            String[] shoot = command[1].split("@");
            switch (shoot[0]) {
                case "Left":
                    points += left(targets, Integer.parseInt(shoot[1]), Integer.parseInt(shoot[2]));
                    break;
                case "Right":
                    points += right(targets, Integer.parseInt(shoot[1]), Integer.parseInt(shoot[2]));
                    break;
                default:
                    break;
            }
            input = console.nextLine();
            command = input.split("\\s+");
        }

        for (int i = 0; i < targets.size(); i++)
            System.out.printf("%d%s", targets.get(i), i != targets.size() -1 ? " - " : "");
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!", points);

    }

    private static int right(List<Integer> targets, int startIndex, int length) {
        if (startIndex < 0 || startIndex >= targets.size())
            return 0;
        int index = (startIndex + length) % targets.size();
        int points = targets.get(index) >= 5 ? 5 : targets.get(index) ;
        targets.set(index, targets.get(index) - points);
        return points;
    }

    private static int left(List<Integer> targets, int startIndex, int length) {
        if (startIndex < 0 || startIndex >= targets.size())
            return 0;
        int index = ((startIndex - length) % targets.size() + targets.size()) % targets.size();
        int points = targets.get(index) >= 5 ? 5 : targets.get(index) ;
        targets.set(index, targets.get(index) - points);
        return points;
    }

    private static void reverse(List<Integer> targets) {
        int size = targets.size();
        for (int i = 0; i < size/2; i++) {
            int temp = targets.get(i);
            targets.set(i, targets.get(size - i - 1));
            targets.set(size - i - 1, temp);
        }
    }
}