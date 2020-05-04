package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> mapLegendary = new TreeMap<>();
        TreeMap<String, Integer> mapJunk = new TreeMap<>();

        mapLegendary.put("shards", 0);
        mapLegendary.put("fragments", 0);
        mapLegendary.put("motes", 0);

        while (true) {
            String[] input = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int value = Integer.parseInt(input[i]);
                String name = input[i + 1];
                if (mapLegendary.containsKey(name)) {
                    mapLegendary.put(name, mapLegendary.get(name) + value);
                    if (mapLegendary.get(name) >= 250)
                        break;
                } else {
                    if (!mapJunk.containsKey(name)) {
                        mapJunk.put(name, value);
                    } else {
                        mapJunk.put(name, mapJunk.get(name) + value);
                    }
                }
//                if (mapLegendary.get("shards") >= 250 || mapLegendary.get("fragments") >= 250 || mapLegendary.get("motes") >= 250) {
//                    break;
//                }
            }

            if (mapLegendary.get("shards") >= 250) {
                mapLegendary.put("shards", mapLegendary.get("shards") - 250);
                System.out.println("Shadowmourne obtained!");
                break;
            } else if (mapLegendary.get("fragments") >= 250) {
                mapLegendary.put("fragments", mapLegendary.get("fragments") - 250);
                System.out.println("Valanyr obtained!");
                break;
            } else if (mapLegendary.get("motes") >= 250) {
                mapLegendary.put("motes", mapLegendary.get("motes") - 250);
                System.out.println("Dragonwrath obtained!");
                break;
            }
        }
        mapLegendary
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));

        mapJunk
                .forEach((key, value) -> System.out.printf("%s: %d%n", key, value));

//
//        for (Map.Entry<String, Integer> entry : mapJunk.entrySet()) {
//            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
//        }
    }
}
