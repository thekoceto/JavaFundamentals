package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class _03_Pirates_class {
    public static class Pair {
        private int first;
        private int second;

        Pair() {
            this.first = 0;
            this.second = 0;
        }
        public int getFirst() {
            return this.first;
        }
        public int getSecond() {
            return this.second;
        }
        public void updateFirst(int first) {
            this.first += first;
        }
        public void updateSecond(int second) {
            this.second += second;
        }

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HashMap<String, Pair> cities = new HashMap<>();

        String input;

        while (!"Sail".equals(input = console.nextLine())) {
            String[] token = input.split("\\|\\|");
            String name = token[0];
            int population = Integer.parseInt(token[1].replaceAll(" ", ""));
            int gold = Integer.parseInt(token[2].replaceAll(" ", ""));

            cities.putIfAbsent(token[0], new Pair()); // Pair (population, gold)
            cities.get(token[0]).first += population;
            cities.get(token[0]).second += gold;
        }

        while (!"End".equals(input = console.nextLine())) {
            String[] token = input.split("=>");
            if ("Plunder".equals(token[0])) {
                String name = token[1];
                int people = Integer.parseInt(token[2].replaceAll(" ", ""));
                int gold = Integer.parseInt(token[3].replaceAll(" ", ""));

                plunder(cities, name, people, gold);
            } else if ("Prosper".equals(token[0])) {
                String town = token[1];
                int gold = Integer.parseInt(token[2].replaceAll(" ", ""));

                prosper(cities, town, gold);
            }
        }
        if (cities.isEmpty())
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.entrySet()
                    .stream()
                    .sorted((t1, t2) -> {
                        if (t2.getValue().getFirst() == t1.getValue().getFirst())
                            return t1.getKey().compareTo(t2.getKey());
                        return t2.getValue().getFirst() - t1.getValue().getFirst();
                    })
                    .forEach((t) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            t.getKey(),
                            t.getValue().getFirst(),
                            t.getValue().getSecond()));
        }
    }

    private static void prosper(Map<String, Pair> cities, String town, int gold) {
        if (gold < 0)
            System.out.println("Gold added cannot be a negative number!");
        else {
            cities.get(town).updateSecond(gold);
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                    gold, town, cities.get(town).getSecond());
        }
    }

    private static void plunder(Map<String, Pair> cities, String town, int people, int gold) {
        cities.get(town).updateFirst(-people);
        cities.get(town).updateSecond(-gold);
        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
        if (cities.get(town).getFirst() <= 0 || cities.get(town).getSecond() <= 0) {
            cities.remove(town);
            System.out.printf("%s has been wiped off the map!%n", town);
        }
    }
}
//•	"Plunder=>{town}=>{people}=>{gold}"
//o	You have successfully attacked and plundered the town, killing the given number of people and stealing the respective amount of gold.
//o	For every town you attack print this message: "{town} plundered! {gold} gold stolen, {people} citizens killed."
//o	If any of those two values (population or gold) reaches zero, the town is disbanded.
//	You need to remove it from your collection of targeted cities and print the following message: "{town} has been wiped off the map!"
//o	There will be no case of receiving more people or gold than there is in the city.

//•	"Prosper=>{town}=>{gold}"
//o	There has been a dramatic economic growth in the given city, increasing its treasury by the given amount of gold.
//o	The gold amount can be a negative number, so be careful. If a negative amount of gold is given print: "Gold added cannot be a negative number!" and ignore the command.
//o	If the given gold is a valid amount, increase the town's gold reserves by the respective amount and print the following message: "{gold added} gold added to the city treasury. {town} now has {total gold} gold."