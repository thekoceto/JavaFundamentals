package com.company;

import java.util.Scanner;

public class _01_ActivationKeys {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String activationKey = console.nextLine();
        String input;

        while (!"Generate".equals(input = console.nextLine())) {
            String[] command = input.split (">>>");
            switch (command[0]) {
                case "Contains":
                    if (activationKey.contains (command[1]))
                        System.out.printf ("%s contains %s%n", activationKey, command[1]);
                    else
                        System.out.println ("Substring not found!");
                    break;
                case "Flip":
                    activationKey = flip(activationKey, command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                    break;
                case "Slice":
                    activationKey = slice(activationKey, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
            }
        }
        System.out.println ("Your activation key is: " + activationKey);
    }

    private static String slice(String activationKey, int startIndex, int endIndex) {
        String result = "";
        for (int i = 0; i < activationKey.length (); i++) {
            if (i < startIndex || i >= endIndex)
                result += activationKey.charAt(i);
        }
        System.out.println (result);
        return result;
    }

    private static String flip(String activationKey, String command, int startIndex, int endIndex) {
        String result = "";
        for (int i = 0; i < activationKey.length (); i++) {
            if (i >= startIndex && i < endIndex){
                if ("Upper".equals (command))
                    result += activationKey.toUpperCase().charAt(i);
                else if ("Lower".equals (command))
                    result += activationKey.toLowerCase().charAt(i);
            }else
                result += activationKey.charAt(i);
        }
        System.out.println (result);
        return result;
    }
}
//•	Contains>>>{substring} – checks if the raw activation key contains the given substring.
//o	If it does prints: "{raw activation key} contains {substring}".
//o	If not, prints: "Substring not found!"

//•	Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}
//o	Changes the substring between the given indices (the end index is exclusive) to upper or lower case.
//o	All given indexes will be valid.
//o	Prints the activation key.

//•	Slice>>>{startIndex}>>>{endIndex}
//o	Deletes the characters between the start and end indices (end index is exclusive).
//o	Both indices will be valid.
//o	Prints the activation key.