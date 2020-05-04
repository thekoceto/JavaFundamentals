package com.company;

import java.util.*;

public class _06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String,List<String>> mapPeople = new TreeMap<>();

        String[] input = scanner.nextLine().split(" : ");


        while (!input[0].equals("end")) {
            String coursesName = input[0];
            String studentName = input[1];

            if (!mapPeople.containsKey(coursesName)) {
                List<String> listStudents = new ArrayList<>();
                listStudents.add(studentName);
                mapPeople.put(coursesName,listStudents);
            } else {
                mapPeople.get(coursesName).add(studentName);
                Collections.sort(mapPeople.get(coursesName));
            }
            input = scanner.nextLine().split(" : ");
        }

        mapPeople
                .entrySet()
                .stream()
                .sorted((f, l) -> l.getValue().size() - f.getValue().size())
                .forEach(i -> System.out.printf("%s: %d%n-- %s%n",
                        i.getKey(),
                        i.getValue().size(),
                        String.join("\n-- ", i.getValue())));

    }
}
