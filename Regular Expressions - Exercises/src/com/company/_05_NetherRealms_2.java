package com.company;

import javafx.util.Pair;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05_NetherRealms_2 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(",");
        Map<String, Pair<Integer, Double>> names = new TreeMap<>();
        for ( String name : input) {
            String currentName = name.replaceAll(" ", "");
            names.put(currentName, calcPower(currentName));
        }

        names.forEach((k, v) -> System.out.printf("%s - %d health, %.2f damage%n", k, v.getKey(), v.getValue()));
    }

    private static Pair calcPower(String name) {
        int health = 0;
        double damage = 0.0;

        String regex = "[^0-9+-.+-,*\\/]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
//        Matcher matcher = Pattern.compile("[^0-9+-.+-,*\\/]").matcher(name);
        while (matcher.find())
            health += matcher.group().charAt(0);

        regex = "(\\-?[\\d+\\.]+)";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(name);
//        matcher = Pattern.compile("(\\-?[\\d+\\.]+)").matcher(name);
        while (matcher.find())
            damage += Double.parseDouble(matcher.group());

        regex = "[\\/*]";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(name);
//        matcher = Pattern.compile("[\\/*]").matcher(name);
        while (matcher.find()){
            if (matcher.group().equals("/"))
                damage/=2.0;
            else
                damage *= 2.0;
        }

        return new Pair<>(health, damage);
    }
}