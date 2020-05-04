package com.company;

import java.util.Scanner;
import javafx.util.Pair;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05_NetherRealms {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(",");
        Map<String, Pair<Integer, Double> > names = new TreeMap<>();
        for ( String name : input) {
            String currentName = name.replaceAll(" ", "");
            names.put(currentName, calcPower(currentName));
        }

        names.forEach((k, v) -> System.out.printf("%s - %d health, %.2f damage%n", k, v.getKey(), v.getValue()));
    }

    private static Pair calcPower(String name) {
        int health = 0;
        double damage = 0.0;

        Matcher matcher = getMatcher(name, "[^0-9+-.+-,*\\/]");
        while (matcher.find())
            health += matcher.group().charAt(0);

        matcher = getMatcher(name, "(\\-?[\\d+\\.]+)");
        while (matcher.find())
            damage += Double.parseDouble(matcher.group());

        matcher = getMatcher(name, "[\\/*]");
        while (matcher.find()){
            if (matcher.group().equals("/"))
                damage /= 2.0;
            else
                damage *= 2.0;
        }

        return new Pair<>(health, damage);
    }

    private static Matcher getMatcher(String name, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(name);
    }
}