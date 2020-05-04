package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_Inventory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> items = Arrays.stream (console.nextLine ().split (", "))
                .collect (Collectors.toList ());
        String input;
        console.close ();
        while (!"Craft!".equals(input = console.nextLine())){
            String[] command = input.split(" - ");
            switch (command[0]){
                case "Collect":
                    if (!items.contains(command[1]))
                        items.add(command[1]);
                    break;
                case "Drop":
                    if (items.contains(command[1]))
                        items.remove(command[1]);
                    break;
                case "Combine Items":
                    String[] itemsCombine = command[1].split(":");
                    if (items.contains(itemsCombine[0]))
                        items.add(items.indexOf(itemsCombine[0])+1, itemsCombine[1]);
                    break;
                case"Renew":
                    if (items.contains(command[1])){
                        items.remove(command[1]);
                        items.add(command[1]);
                    }
                    break;
            }
        }
        console.close ();
        System.out.println(String.join(", ", items));
    }
}
