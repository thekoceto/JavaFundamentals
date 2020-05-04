package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _03_Pirates {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        Map<String, int[]> cities  = new TreeMap<> (); // Map<name, int[population , gold]>
        String input;

        while (!"Sail".equals(input = console.nextLine())) {
            String[] token = input.split ("\\|\\|");
            cities.putIfAbsent (token[0], new int[]{0, 0 });
            cities.get (token[0])[0] += Integer.parseInt (token[1].replaceAll (" ", ""));
            cities.get (token[0])[1] += Integer.parseInt (token[2].replaceAll (" ", ""));
        }

        while (!"End".equals(input = console.nextLine())) {
            String[] token = input.split ("=>");
            switch (token[0]){
                case "Plunder":
                    plunder (cities, token[1],
                            Integer.parseInt (token[2].replaceAll (" ", "")),
                            Integer.parseInt (token[3].replaceAll (" ", "")));
                    break;

                case "Prosper":
                    prosper (cities, token[1], Integer.parseInt (token[2].replaceAll (" ", "")));
                    break;
            }
        }
        if (cities.isEmpty ())
            System.out.println ("Ahoy, Captain! All targets have been plundered and destroyed!");
        else{
            System.out.printf ("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size ());
            cities.entrySet()
                    .stream()
                    .sorted((t1, t2) -> t2.getValue()[1] - t1.getValue()[1])
                    .forEach((t) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            t.getKey(),
                            t.getValue()[0],
                            t.getValue()[1]));
        }
    }

    private static void prosper(Map<String, int[]> cities, String town, int gold) {
        if (gold<0)
            System.out.println ("Gold added cannot be a negative number!");
        else{
            cities.get (town)[1] += gold;
            System.out.printf ("%d gold added to the city treasury. %s now has %d gold.%n",
                    gold, town, cities.get (town)[1]);
        }
    }

    private static void plunder(Map<String, int[]> cities, String town, int people, int gold) {
        cities.get (town)[0] -= people;
        cities.get (town)[1] -= gold;
        System.out.printf ("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
        if (cities.get (town)[0] <= 0 || cities.get (town)[1] <= 0){
            cities.remove (town);
            System.out.printf ("%s has been wiped off the map!%n", town);
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