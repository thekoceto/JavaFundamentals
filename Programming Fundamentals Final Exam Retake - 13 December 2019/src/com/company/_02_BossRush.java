package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_BossRush {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());
        String regex = "([\\|])(?<boss>[A-Z]{4,})\\1:#(?<title>[A-Za-z]+ [A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);
        while ( steps-- > 0){
            String message = console.nextLine();
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()){
                print (matcher.group("boss"), matcher.group("title") );
            }else
                System.out.println("Access denied!");
        }
    }

    private static void print(String boss, String title) {
        System.out.println(boss + ", The " + title);
        System.out.println(">> Strength: " + boss.length());
        System.out.println(">> Armour: " + title.length());
    }
}
