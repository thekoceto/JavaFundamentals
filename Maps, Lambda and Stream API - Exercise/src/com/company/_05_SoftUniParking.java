package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_SoftUniParking {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        int steps = Integer.parseInt(console.nextLine());
        while (--steps>=0){
            String[] command = console.nextLine().split(" ");
            if ("register".equals(command[0])) {
                if (map.containsKey(command[1]))
                    System.out.printf("ERROR: already registered with plate number %s%n", map.get(command[1]));
                else {
                    map.put(command[1], command[2]);
                    System.out.printf("%s registered %s successfully%n", command[1], command[2]);
                }
            }else if ("unregister".equals(command[0])) {
                if (map.containsKey(command[1])) {
                    map.remove(command[1]);
                    System.out.printf("%s unregistered successfully%n", command[1]);
                }
                else{
                    System.out.printf("ERROR: user %s not found%n", command[1]);
                }
            }
        }
        map.forEach((k,v) -> System.out.printf("%s => %s%n",k,v));
    }
}
