package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_StarEnigma {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());
        String regex = "\\@(?<name>[A-Z][a-z]+)[^@\\-!:>]*\\:([0-9]+)[^@\\-!:>]*\\!(?<type>[AD])\\![^@\\-!:>]*\\-\\>[\\d]+";
        //planet ?<name> -> planet population -> attack type -> soldier count
        Set<String> attacked = new TreeSet<>();
        Set<String> destroyed = new TreeSet<String>();
        while (steps-- > 0){
            String cipher = console.nextLine();
            String plain = encript(cipher);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(plain);
            if (matcher.find()){
                Set<String> hash_Set = new HashSet<String>();
                String type = matcher.group("type");
                String name = matcher.group("name");
                if (type.equals("A"))
                    attacked.add(name);
                else
                    destroyed.add(name);
            }
        }
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.forEach(e -> System.out.println("-> " + e));
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.forEach(e -> System.out.println("-> " + e));
    }

    private static String encript(String cipher) {
        String plain = "";
        int key = 0;
        String regex = "[starSTAR]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cipher);
        while (matcher.find())
            key++;
        for (int i = 0; i < cipher.length(); i++)
            plain += (char)(cipher.charAt(i) - key);
        return plain;
    }
}