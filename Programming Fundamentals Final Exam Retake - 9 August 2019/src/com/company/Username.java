package com.company;

import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String message = console.nextLine();
        String input = "";
        while (!"Sign up".equals(input = console.nextLine())){
            String[] commands = input.split(" ");
            switch (commands[0]){
                case "Case":
                    message = changeCase(message, commands[1]);
                    System.out.println(message);
                    break;
                case "Reverse":
                    reverse(message, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case "Cut":
                    message = cut(message, commands[1]);
                    break;
                case "Replace":
                    message = replace(message, commands[1].charAt(0));
                    System.out.println(message);
                    break;
                case "Check":
                    check(message, commands[1].charAt(0));
                    break;
            }
        }
    }

    private static void check(String message, char ch) {
        if (message.contains(ch + ""))
            System.out.println("Valid");
        else
            System.out.printf("Your username must contain %c.%n", ch);

    }

    private static String replace(String message, char ch) {
        return message.replace(ch, '*');
    }

    private static String cut(String message, String substring) {
        if (!message.contains(substring)){
            System.out.printf("The word %s doesn't contain %s.%n", message, substring);
        }
        else{
            message = message.replace(substring, "");
            System.out.println(message);
        }
        return message;
    }

    private static void reverse(String message, int startIndex, int endIndex) {
        if (startIndex >= 0 && endIndex < message.length()){
            System.out.println(new StringBuilder(message.substring(startIndex, endIndex+1)).reverse());
        }
    }

    private static String changeCase(String message, String argument) {
        if (argument.equals("lower"))
            return message.toLowerCase();
        else if (argument.equals("upper"))
            return message.toUpperCase();
        else
            return message;
    }
}
// • "Case {lower/upper}"
// o	Replace all letters with lower case or with upper case, then print the result.

// •	"Reverse {startIndex} {endIndex}"
// o	Reverse the substring from the startIndex until the endIndex, then print it. Do NOT change it in the username.
// Note: Check if the indexes are valid. If they aren’t - skip the command. The indexes are inclusive.

// •	"Cut {substring}"
// o	Check if the string contains  the substring and if yes, cut it out and print the result.
// o	If the string doesn’t contain the given substring, print:
// "The word {string} doesn't contain {substring}."

// •	"Replace {char}"
// o	Replace all occurences of char with astericks (*) and print the result.

// •	"Check {char}"
// o	In order for a username to be valid, it must contain the given char.
// o	If the password is valid, print "Valid". If it is not valid, print: "Your username must contain {char}."