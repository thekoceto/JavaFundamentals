package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        String input;

        while (!"stop".equals(input = console.nextLine())){
            int value = Integer.parseInt(console.nextLine());
            if (map.containsKey(input))
                map.replace(input, map.get(input)+value);
            else
                map.put(input, value);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
