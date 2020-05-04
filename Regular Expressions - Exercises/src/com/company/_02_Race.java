package com.company;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_Race {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Integer> participants = new LinkedHashMap<>();
        String[] line = console.nextLine().split(", ");
        for (String s : line)
            participants.putIfAbsent(s, 0);

        String input;
        while (!"end of race".equals(input = console.nextLine())) {
            for (Map.Entry<String, Integer> entry : participants.entrySet()) {
                int distance = checkName(entry.getKey(), input);
                if (distance > 0) {
                    participants.put(entry.getKey(), entry.getValue() + distance);
                    break;
                }
            }
        }
        int[] index = {0};
        String[] place = {"1st", "2nd", "3rd"};
        participants.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(r -> System.out.printf("%s place: %s%n", place[index[0]++],  r.getKey()));

    }

    private static int checkName(String name, String text) {
        int index = 0, didistance = 0;
        for (int i = 0; i < text.length(); i++) {
            if (index != name.length() && text.charAt(i) == name.charAt(index))
                index++;
            else if (Character.isDigit(text.charAt(i)))
                didistance += text.charAt(i)-48;
        }
        if (index == name.length())
            return didistance;
        return 0;
    }
}