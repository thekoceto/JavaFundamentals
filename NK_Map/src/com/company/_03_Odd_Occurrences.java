package com.company;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class _03_Odd_Occurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]input = scanner.nextLine().toLowerCase().split(" ");
        LinkedHashMap<String, Integer> mapOddRepeat = new LinkedHashMap<>();

        for (String element : input) {
            mapOddRepeat.putIfAbsent(element, 0);
            mapOddRepeat.put(element, mapOddRepeat.get(element) + 1);
        }
        System.out.println(
            mapOddRepeat
                .entrySet()
                .stream()
                .filter(e->e.getValue()%2==1)
                .map(Map.Entry::getKey)
                .collect(joining(", "))
        );
    }
}
