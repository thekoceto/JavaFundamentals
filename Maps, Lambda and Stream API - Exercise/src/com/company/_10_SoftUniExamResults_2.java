package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class _10_SoftUniExamResults_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String,Integer>[] data = new TreeMap[2];

        String input;
        while (!"exam finished".equalsIgnoreCase(input = console.nextLine())) {
            if (input.isEmpty())
                continue;
            String[] token;
            token = input.split("-");
            String userName = token[0];
            String language = token[1];
            if ("banned".equals(token[1])) {
                data[0].remove(token[1]);
            } else {
                data[0].putIfAbsent(userName, 0);
                int newScore = Integer.parseInt(token[2]);
                int currentScore = data[0].get(userName);
                int points = newScore > currentScore ? newScore : currentScore ;
                data[1].put(userName, points);
                data[1].putIfAbsent(language, 0);
                data[1].put(language, data[1].get(language)+1);
            }
        }
        printMap(data[0], "Results:", '|');
        printMap(data[1], "Submissions:", '-');
    }

    private static void printMap(TreeMap<String, Integer> map, String title, char separator) {
        System.out.println(title);
        map
                .entrySet()
                .stream()
                .sorted((u1, u2) -> u2.getValue() - u1.getValue())
                .forEach(u -> System.out.printf("%s %c %d%n", u.getKey(), separator, u.getValue()));
    }
}