package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _01_CountCharsInString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<Character, Integer> map = new LinkedHashMap<>();
        String input = console.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i)))
                map.replace(input.charAt(i), map.get(input.charAt(i))+1);
            else
                map.put(input.charAt(i), 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey()!=' ')
                System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
