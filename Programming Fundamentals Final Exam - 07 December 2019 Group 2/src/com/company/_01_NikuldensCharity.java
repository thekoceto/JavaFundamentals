package com.company;

import java.util.Scanner;

public class _01_NikuldensCharity {
    public static void main(String[] args) throws Throwable {
        Scanner console = new Scanner(System.in);
        String message = console.nextLine();
        String input = "";
        while (!"Finish".equals(input = console.nextLine())){
            String[] commands = input.split(" ");
            switch (commands[0]){
                case "Replace":
                    message = replace(message, commands[1].charAt(0), commands[2].charAt(0));
                    break;
                case "Cut":
                    message = cut(message, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case "Make":
                    message = make(message, commands[1]);
                    break;
                case "Check":
                    check(message, commands[1]);
                    break;
                case "Sum":
                    sum(message, Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
            }
        }
    }

    private static String replace(String message, char currentChar, char newChar) {
        String result = "";
        for (char ch : message.toCharArray())
            result += ch == currentChar ? newChar : ch;
        System.out.println(result);
        return result;
    }

    private static String cut(String message, int startIndex, int endIndex) {
        String result = "";
        if (startIndex < 0 || endIndex >= message.length()){
            System.out.println("Invalid indexes!");
            return message;
        }
        for (int i = 0; i < message.length(); i++)
            if (i < startIndex || i > endIndex)
                result += message.charAt(i);
        System.out.println(result);
        return result;
    }

    private static String make(String message, String command) {
        if (command.equals("Upper"))
            message = message.toUpperCase();
        else if (command.equals("Lower"))
            message = message.toLowerCase();
        System.out.println(message);
        return message;
    }

    private static void check(String message, String command) {
        if (message.contains(command))
            System.out.println("Message contains " + command);
        else
            System.out.println("Message doesn't contain " + command);
    }

    private static void sum(String message, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= message.length())
            System.out.println("Invalid indexes!");
        else{
            int sum = 0;
            for (int i = startIndex; i <= endIndex; i++)
                sum += (int) message.charAt(i);
            System.out.println(sum);
        }
    }
}