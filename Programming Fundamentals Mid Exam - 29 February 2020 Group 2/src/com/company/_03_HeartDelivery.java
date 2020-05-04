package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03_HeartDelivery {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int index = 0, failed = 0;
        String input = console.nextLine();
        int[] houses = Arrays.stream(input.split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (!"Love!".equals(input = console.nextLine())) {
            String[] commands = input.split("\\s+");
            if (commands[0].equals("Jump")){
                index += Integer.parseInt(commands[1]);
                index = index >= houses.length ? 0 : index;
                if (houses[index]== 0){
                    System.out.printf("Place %d already had Valentine's day.%n", index);
                }
                else{
                    houses[index] = houses[index] - 2 < 0 ? 0 : houses[index] - 2;
                    if (houses[index]== 0)
                        System.out.printf("Place %d has Valentine's day.%n", index);
                }
            }
        }
        for (int house : houses)
            if (house != 0)
                failed++;

        System.out.printf("Cupid's last position was %d.%n", index);
        if (failed == 0)
            System.out.println("Mission was successful.");
        else
            System.out.printf("Cupid has failed %d places.", failed);
    }
}
