package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_Student_Academy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int repeat = Integer.parseInt (scanner.nextLine ());
        LinkedHashMap<String, Double> mapStudentsGrade = new LinkedHashMap<> ();
        LinkedHashMap<String, Integer> mapCountGrade = new LinkedHashMap<> ();
        LinkedHashMap<String, Double> mapGrade = new LinkedHashMap<> ();

        for (int i = 0; i < repeat; i++) {

            String name = scanner.nextLine ();
            double grade = Double.parseDouble (scanner.nextLine ());

            if (!mapStudentsGrade.containsKey (name)) {
                mapStudentsGrade.put (name, grade);
                mapCountGrade.put (name, 1);
            } else {
                mapStudentsGrade.put (name, mapStudentsGrade.get (name) + grade);
                mapCountGrade.put (name, mapCountGrade.get (name) + 1);
            }
        }

        for (Map.Entry<String, Double> entry : mapStudentsGrade.entrySet ()) {
            double result = entry.getValue () / mapCountGrade.get (entry.getKey ());
            if (result >= 4.5) {
                mapGrade.put (entry.getKey (), result);
            }

        }
        mapGrade
                .entrySet ()
                .stream ()
                .sorted ((f, l) -> l.getValue ().compareTo (f.getValue ()))
                .forEach (l -> {
                    System.out.printf ("%s -> %.2f%n", l.getKey (), l.getValue ());
                });
    }
}
