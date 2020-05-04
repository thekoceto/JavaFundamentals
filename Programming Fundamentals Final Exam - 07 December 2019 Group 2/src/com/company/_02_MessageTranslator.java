package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class _02_MessageTranslator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());
        String regex = "!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        while ( steps-- > 0){
            String message = console.nextLine();
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()){
                send (matcher.group("command"), matcher.group("message") );
            }else
                System.out.println("The message is invalid");
        }
    }

    private static void send(String command, String message) {
        System.out.print(command + ": ");
        for (char ch : message.toCharArray())
            System.out.print((int)ch + " ");
        System.out.println();
    }
}
