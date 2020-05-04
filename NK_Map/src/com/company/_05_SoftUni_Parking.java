package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_SoftUni_Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> mapCar = new LinkedHashMap<>();
        int repeat = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < repeat; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String name = input[1];

            if (command.equals("register")) {
                if (!mapCar.containsKey(name)) {
                    mapCar.put(name, input[2]);
                    System.out.printf("%s registered %s successfully%n",name,input[2]);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", input[2]);
                }
            } else if (command.equals("unregister")) {
                if (mapCar.containsKey(name)) {
                    System.out.printf("%s unregistered successfully%n", name);
                    mapCar.remove(name);
                } else {
                    System.out.printf("ERROR: user %s not found%n", name);
                }
            }
        }
        for (Map.Entry<String, String> entry : mapCar.entrySet()) {
            System.out.printf("%s => %s%n",entry.getKey(),entry.getValue());
        }
    }
}
