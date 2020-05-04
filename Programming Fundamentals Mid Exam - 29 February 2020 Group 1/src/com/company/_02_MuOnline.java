package com.company;

import java.util.Scanner;

public class _02_MuOnline {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] commands = console.nextLine().split("\\|");
        console.close();
        int health = 100, bitcoins = 0;
        for (int i = 0; i < commands.length; i++) {
            String[] roomCommand = commands[i].split(" ");
            if (roomCommand[0].equals("potion")) {
                health += Integer.parseInt(roomCommand[1]);
                int current = health > 100 ? Integer.parseInt(roomCommand[1])+100-health : Integer.parseInt(roomCommand[1]);
                health = health > 100 ? 100 : health;
                System.out.printf("You healed for %d hp.%n", current);
                System.out.printf("Current health: %d hp.%n", health);
            }else if (roomCommand[0].equals("chest")){
                bitcoins += Integer.parseInt(roomCommand[1]);
                System.out.printf("You found %d bitcoins.%n", Integer.parseInt(roomCommand[1]));
            }else{
                health -= Integer.parseInt(roomCommand[1]);
                if(health <= 0){
                    System.out.printf("You died! Killed by %s.%n", roomCommand[0]);
                    System.out.printf("Best room: %d%n", i+1);
                    break;
                }else
                    System.out.printf("You slayed %s.%n",  roomCommand[0]);
            }
        }
        if (health > 0){
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, health);
        }
    }
}
