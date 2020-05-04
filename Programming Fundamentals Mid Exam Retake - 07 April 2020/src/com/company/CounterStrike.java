package com.company;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scan.nextLine());
        String command;
        int wonBattles = 0;

        while (!("End of battle").equals(command = scan.nextLine())) {
            int distance = Integer.parseInt(command);
            if (initialEnergy >= distance) {
                initialEnergy -= distance;
                wonBattles ++;
                if (wonBattles % 3 == 0) {
                    initialEnergy += wonBattles;
                }
            } else {
                System.out.println(String.format("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, initialEnergy));
                break;
            }

        }
        if ("End of battle".equals(command))
            System.out.println(String.format("Won battles: %d. Energy left: %d", wonBattles, initialEnergy));
    }
}