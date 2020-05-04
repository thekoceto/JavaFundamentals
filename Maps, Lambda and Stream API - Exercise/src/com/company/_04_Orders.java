package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_Orders {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Double> mapOrders = new LinkedHashMap<>();
        Map<String, Integer> rememberProducts  = new LinkedHashMap<>();

        String input; //Beer 2.40 350

        while (!"buy".equals(input = console.nextLine())){
            String[] line = input.split(" ");
            String name = line[0];
            Double price = Double.parseDouble(line[1]);
            int quantity = Integer.parseInt(line[2]);

            if (!mapOrders.containsKey(name)){
                mapOrders.put(name,quantity*price);
                rememberProducts.put(name, quantity);
            }else{
                rememberProducts.put(name, rememberProducts.get(name) + quantity);
                mapOrders.put(name, rememberProducts.get(name) * price);
            }
        }

        mapOrders
                .forEach((k,v) -> System.out.printf("%s -> %.2f%n",k,v));
    }
}
