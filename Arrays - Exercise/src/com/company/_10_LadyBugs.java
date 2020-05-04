package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _10_LadyBugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int [] ladybugs  = new int[size];
        int[] indexes = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        for (int index : indexes)
            if (index >= 0 && index < size)
                ladybugs[index] = 1;

        String input = sc.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[0]);
            int jump = Integer.parseInt(command[2]);

            if (index < 0 || index > size - 1 || ladybugs[index] == 0){
                input = sc.nextLine();
                continue;
            }
            ladybugs[index] = 0;

            index = command[1].equals("right") ? index + jump : index - jump;

            while (index >= 0 && index < size && ladybugs[index] == 1)
                index = command[1].equals("right") ? index + jump : index - jump;

            if (index >= 0 && index < size)
                ladybugs[index] = 1;

            input = sc.nextLine();
        }
        for (int element : ladybugs )
            System.out.printf("%d ", element);
    }
}
