package com.company;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class _07_StudentAcademy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Double[]> students = new LinkedHashMap<>();
        int steps = Integer.parseInt(console.nextLine());
        while (steps-- > 0){
            String student = console.nextLine();
            double grade = Double.parseDouble(console.nextLine());
            students.putIfAbsent(student, new Double[]{0.0,0.0});
            students.get(student)[0] += grade;
            students.get(student)[1] += 1;
        }

        students
                .entrySet()
                .stream()
                .sorted((s1 , s2) -> {
                    Double average1 = s1.getValue()[0]/s1.getValue()[1];
                    Double average2 = s2.getValue()[0]/s2.getValue()[1];
                    return average2.compareTo(average1);
                })
                .forEach(s -> {
                    Double average = s.getValue()[0]/s.getValue()[1];
                    if (average >= 4.5)
                        System.out.printf("%s -> %.2f%n", s.getKey(), average);
                });

    }
}
