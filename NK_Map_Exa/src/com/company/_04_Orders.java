package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_Orders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        LinkedHashMap<String, Integer> mapQuontity = new LinkedHashMap<> ();
        LinkedHashMap<String, Double> mapPrice = new LinkedHashMap<> ();

        String[] input = scanner.nextLine ().split (" ");

        while (!input[0].equals ("buy")) {
            String name = input[0];
            Double price = Double.parseDouble (input[1]);
            int quantity = Integer.parseInt (input[2]);

            if (!mapQuontity.containsKey (name)) {
                mapQuontity.put (name, quantity);
                mapPrice.put (name, price);
            } else {
                mapQuontity.put (name, mapQuontity.get (name) + quantity);
                mapPrice.put (name, price);
            }
            input = scanner.nextLine ().split (" ");
        }
        for (Map.Entry<String, Integer> entry : mapQuontity.entrySet ()) {
            System.out.printf ("%s -> %.2f%n", entry.getKey (), entry.getValue () * mapPrice.get (entry.getKey ()));
        }
    }
}

