package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _03_BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, int[]> people = new TreeMap<>();
        String input;

        while (!"Results".equals(input = scanner.nextLine())) {
            String[] command = input.split (":");
            switch (command[0]) {
                case "Add":
                    add(people, command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                    break;
                case "Attack":
                    attack(people, command[1], command[2], Integer.parseInt(command[3]));
                    break;
                case "Delete":
                    if ("All".equals(command[1])) {
                        people.clear();
                    } else {
                        people.remove(command[1]);
                    }
                    break;
            }
        }

        if (people.size() > 0) System.out.println("People count: " + people.size());
        people.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue()[0] - a.getValue()[0])
                .forEach((e) -> System.out.printf("%s - %d - %d%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
    }

    private static void attack(Map<String, int[]> people, String attackerName, String defenderName, int damage) {

        if (people.containsKey(attackerName) && people.containsKey(defenderName)) {
            people.get(defenderName)[0] -= damage;
            if (people.get(defenderName)[0] <= 0) {
                System.out.println(defenderName + " was disqualified!");
                people.remove(defenderName);
            }
            people.get(attackerName)[1] -= 1;
            if (people.get(attackerName)[1] <= 0) {
                System.out.println(attackerName + " was disqualified!");
                people.remove(attackerName);
            }
        }
    }

    private static void add(Map<String, int[]> people, String name, int health, int energy) {
        if (!people.containsKey(name))
            people.put(name, new int[]{health, energy });
        else
            people.put(name, new int[]{ people.get(name)[0] + health,  people.get(name)[1] });
    }
}