package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class _10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, Integer> nameAndScore = new TreeMap<>();
        TreeMap<String, Integer> nameAndCourse = new TreeMap<>();
        String input;
        while (!"exam finished".equalsIgnoreCase(input = console.nextLine())) {
            if (input.isEmpty())
                continue;
            String[] token;
            token = input.split("-");
            String userName = token[0];
            String language = token[1];

            if ("banned".equals(language)) {
                nameAndScore.remove(userName);
            } else {
                nameAndScore.putIfAbsent(userName, 0);
                int newScore = Integer.parseInt(token[2]);
                int currentScore = nameAndScore.get(userName);
                int points = newScore > currentScore ? newScore : currentScore ;
                nameAndScore.put(userName, points);
                nameAndCourse.putIfAbsent(language, 0);
                nameAndCourse.put(language, nameAndCourse.get(language)+1);
            }
        }

        printMap(nameAndScore, "Results:", '|');
        printMap(nameAndCourse, "Submissions:", '-');
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