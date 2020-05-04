package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class _06_Courses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> courses = new LinkedHashMap<>();
        String input; //Programming Fundamentals : John Smith

        while (!"end".equals(input = console.nextLine())){
            String[] line = input.split(" : ");
            String course = line[0];
            String student = line[1];

            courses.putIfAbsent(course, new ArrayList());
            courses.get(course).add(student);
        }

        courses
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(i -> {
                    System.out.printf(String.format("%s: %d%n",
                                    i.getKey(),
                                    i.getValue().size()));
                    i.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.println(String.format("-- %s", s)));
                });

    }
}
