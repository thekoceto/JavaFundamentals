package com.company;

import java.util.*;


public class _03_NikuldensMeals {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, List<String> > guests = new TreeMap<>();
        String input = "";
        int unliked = 0;
        while (!"END".equals(input = console.nextLine())) {
            String[] commands = input.split("-");
            switch (commands[0]) {
                case "Like":
                    like(guests, commands[1], commands[2]);
                    break;
                case "Unlike":
                    unliked = unlike(guests, commands[1], commands[2], unliked);
                    break;
            }

        }
        guests
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .forEach(e-> System.out.printf("%s: %s%n",e.getKey(), String.join(", ", e.getValue())));

        System.out.printf("Unliked meals: " + unliked);
    }

    private static int unlike(Map<String, List<String>> guests, String guest, String mea1, int unliked) {
        if (!guests.containsKey(guest))
            System.out.printf("%s is not at the party.%n", guest);
        else{
            if (!guests.get(guest).contains(mea1))
                System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, mea1 );
            else{
                guests.get(guest).remove(mea1);
                unliked++;
                System.out.printf("%s doesn't like the %s.%n", guest, mea1);
            }
        }
        return unliked;
    }

    private static void like(Map<String, List<String>> guests, String guest, String mea1) {
        if (!guests.containsKey(guest))
            guests.put(guest, new ArrayList() {{add(mea1);}});
        else{
            if (!guests.get(guest).contains(mea1))
                guests.get(guest).add(mea1);
        }
    }
}
// •"Like-{guest}-{mea1}":
//o	Add the {mea1} to the {guest}’s collection of meals.
//o	If the guest doesn't exist, add it to your record.
//o	If the guest already has the meal in his collection, don’t add it.

//•	"Unlike-{guest}-{meal}":
//o	Remove  the meal of the given guest’s collection and print:
//"{Guest} doesn't like the {meal}."
//You must keep the count of unliked meals!
//o	If the guest doesn’t exist, print:
// "{Guest} is not at the party."

//o	If the guest doesn’t have the meal at the like list, print:
// "{Guest} doesn't have the {meal} in his/her collection."