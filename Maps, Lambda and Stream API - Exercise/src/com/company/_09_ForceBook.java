package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _09_ForceBook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> forceUsers = new TreeMap<>();
        String input;
        while (!"Lumpawaroo".equalsIgnoreCase(input = console.nextLine())){
            if (input.isEmpty())
                continue;
            String[] token;
            if (input.contains("|")){
                token = input.split(" \\| ");
                String forceSide = token[0];
                String forceUser = token[1];
                boolean isPresent = false;
                for (Map.Entry<String, ArrayList<String>> element : forceUsers.entrySet()) {
                    if (element.getValue().contains(forceUser))
                        isPresent = true;
                }
                if(!isPresent){
                    forceUsers.putIfAbsent(forceSide, new ArrayList<>());
                    if (!forceUsers.get(forceSide).contains(forceUser))
                        forceUsers.get(forceSide).add(forceUser);
                }
            }
            else if (input.contains("->")) {
                token = input.split(" -> ");
                String forceUser = token[0];
                String forceSide = token[1];
                for (Map.Entry<String, ArrayList<String>> element : forceUsers.entrySet()) {
                    if (element.getValue().contains(forceUser))
                        element.getValue().remove(forceUser);
                }
                forceUsers.putIfAbsent(forceSide, new ArrayList<>());
                forceUsers.get(forceSide).add(forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
        }
        forceUsers
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size()>0)
                .sorted((l1, l2) -> l2.getValue().size() - l1.getValue().size())
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted((u1, u2) -> u1.compareTo(u2))
                            .forEach(u -> System.out.printf("! %s%n", u));
                });
    }
}