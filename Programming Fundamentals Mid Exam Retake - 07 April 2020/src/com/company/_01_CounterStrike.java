package com.company;

import java.util.Scanner;

public class _01_CounterStrike {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int energy = Integer.parseInt(console.nextLine());
        int wonBattles = 0;
        String input;

        while (!"End of battle".contains(input = console.nextLine())) {
            int distance = Integer.parseInt(input);
            if (energy >= distance){
                energy -= distance;
                if (++wonBattles % 3 == 0)
                    energy+=wonBattles;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, energy);
                break;
            }
        }
        if ("End of battle".contains(input))
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, energy);
    }
}
// Write a program that keeps track of every won battle against an enemy. You will receive initial energy.
// Afterwards you will start receiving the distance you need to go to reach an enemy until the "End of battle"
// command is given, or until you run out of energy.

// The energy you need for reaching an enemy is equal to the distance you receive. Each time you reach an enemy,
// your energy is reduced. This is considered a successful battle (win). If you don't have enough energy to
// reach an the enemy, print:
// "Not enough energy! Game ends with {count} won battles and {energy} energy"
// and end the program.
// Every third won battle increases your energy with the value of your current count of won battles.
// Upon receiving the "End of battle" command, print the count of won battles in the following format:
// "Won battles: {count}. Energy left: {energy}"