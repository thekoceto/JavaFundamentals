package com.company;

import javafx.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_Orders_Old {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Pair> map = new LinkedHashMap<>();

        String input;

        while (!"buy".equals(input = console.nextLine())){
            String[] line = input.split(" ");
            String name = line[0];
            Double price = Double.parseDouble(line[1]);
            int quantity = Integer.parseInt(line[2]);
            if (map.containsKey(name)){
                Pair<Double, Integer> currPair = map.get(name);
                map.replace(name, new Pair<>(price < currPair.getKey() ? price : currPair.getKey(),quantity + currPair.getValue()));
            }
            else{
                map.put(name, new Pair<>(price,quantity));
            }
        }

        for (Map.Entry<String, Pair> entry : map.entrySet()) {
            Pair<Double, Integer> currPair = entry.getValue();
            System.out.printf("%s -> %.2f%n", entry.getKey(), currPair.getKey()*currPair.getValue());
        }
    }
}
