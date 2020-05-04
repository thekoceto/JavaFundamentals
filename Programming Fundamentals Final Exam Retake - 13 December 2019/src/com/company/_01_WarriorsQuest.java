package com.company;

import java.util.Scanner;

public class _01_WarriorsQuest {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        String message = console.nextLine();
        String input = "";
        while (!"For Azeroth".equals(input = console.nextLine())){
            String[] commands = input.split("\\s+");
            switch (commands[0]){
                case "GladiatorStance":
                    message = message.toUpperCase();
                    System.out.println(message);
                    break;
                case "DefensiveStance":
                    message = message.toLowerCase();
                    System.out.println(message);
                    break;
                case "Dispel":
                    message = dispel(message, Integer.parseInt(commands[1]), commands[2].charAt(0));
                    break;
                case "Target":
                    if (commands[1].equals("Change"))
                        message = change(message, commands[2], commands[3]);
                    else if (commands[1].equals("Remove"))
                        message = remove(message, commands[2]);
                    else
                        System.out.println("Command doesn't exist!");
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }
        }
    }

    private static String dispel(String message, int index, char letter) {
        String result = "";
        if (index < 0 || index >= message.length())
            System.out.println("Dispel too weak.");
        else{
            for (int i = 0; i < message.length(); i++)
                result += i != index ? message.charAt(i) : letter;
            System.out.println("Success!");
            return result;
        }
        return message;
    }

    private static String change(String message, String substring1, String substring2) {
        message = message.replace(substring1 , substring2);
        System.out.println(message);
        return message;
    }

    private static String remove(String message, String substring) {
        message = message.replace(substring , "");
        System.out.println(message);
        return message;
    }
}
//•	"Dispel {index} {letter}"
//o	Replace the letter at the index with the given one and print "Success!"
//o	If the index is invalid, print: "Dispel too weak."

//•	"Target Change {substring} {second substring}"
//o	Replace the first substring with the second and print the result.

//•	"Target Remove {substring}"
//o	Remove the substring from the string and print the result.
//
//If the input command is not in the list, print "Command doesn't exist!"