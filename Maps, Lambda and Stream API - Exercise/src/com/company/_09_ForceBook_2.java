package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_ForceBook_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> forceUsers = new TreeMap<>();
        Pattern sideUserPattern = Pattern.compile("(?<forceSide>.+)\\s+\\|\\s+(?<forceUser>.+)");
        Pattern changeSidePattern = Pattern.compile("(?<forceUser>.+)\\s+->\\s+(?<forceSide>.+)");

        String input;
        while (!"Lumpawaroo".equalsIgnoreCase(input = console.nextLine())){
            Matcher sideUserMatcher = sideUserPattern.matcher(input);
            Matcher changeSideMatcher  = changeSidePattern.matcher(input);
            if (sideUserMatcher.find()){
                String forceSide = sideUserMatcher.group("forceSide");
                String forceUser = sideUserMatcher.group("forceUser");;
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
            else if (changeSideMatcher.find()) {
                String forceUser = changeSideMatcher.group("forceUser");
                String forceSide = changeSideMatcher.group("forceSide");
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
                .sorted((l1, l2) -> {
                    if (l2.getValue().size() == l1.getValue().size())
                        return l1.getKey().compareTo(l2.getKey());
                    else
                        return l2.getValue().size() - l1.getValue().size();
                })
                .forEach(l -> {
                    System.out.printf("Side: %s, Members: %d%n", l.getKey(), l.getValue().size());
                    l.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(u -> System.out.printf("! %s%n", u));
                });
    }
}