package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ShoppingList {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        List<String> products = Arrays.stream(input.split("!"))
                .collect(Collectors.toList());

        while (!"Go Shopping!".equals(input = console.nextLine())) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "Urgent":
                    if (!products.contains(commands[1]))
                        products.add(0, commands[1]);
                    break;
                case "Unnecessary":
                    if (products.contains(commands[1]))
                        products.remove(commands[1]);
                    break;
                case "Correct":
                    if (products.contains(commands[1])){
                        products.add(products.indexOf(commands[1]),commands[2]);
                        products.remove(commands[1]);
                    }
                    break;
                case "Rearrange":
                    if(products.contains(commands[1])){
                        products.remove(commands[1]);
                        products.add(commands[1]);
                    }
                    break;
            }
        }
        System.out.println(String.join(", ", products));
    }
}
//•	Urgent {item} - add the item at the start of the list.  If the item already exists, skip this command.
//•	Unnecessary {item} - remove the item with the given name, only if it exists in the list. Otherwise skip this command.
//•	Correct {oldItem} {newItem} – if the item with the given old name exists, change its name with the new one. If it doesn't exist, skip this command.
//•	Rearrange {item} - if the grocery exists in the list, remove it from its current position and add it at the end of the list.