package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_SoftUni_Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int repeat = Integer.parseInt (scanner.nextLine ());
        LinkedHashMap<String, String> mapRegister = new LinkedHashMap<> ();

        for (int i = 0; i < repeat; i++) {
            String[] input = scanner.nextLine ().split (" ");

            String command = input[0];
            String name = input[1];

            if (command.equals ("register")) {
                String licensePlateNumber = input[2];
                if (!mapRegister.containsKey (name)) {
                    mapRegister.put (name, licensePlateNumber);
                    System.out.printf ("%s registered %s successfully%n", name, licensePlateNumber);
                } else {
                    System.out.printf ("ERROR: already registered with plate number %s%n", licensePlateNumber);
                }
            } else if (command.equals ("unregister")) {
                if (!mapRegister.containsKey (name)) {
                    System.out.printf ("ERROR: user %s not found%n", name);
                }else {
                    System.out.printf ("%s unregistered successfully%n", name);
                    mapRegister.remove (name);
                }
            }
        }
        for (Map.Entry<String, String> entry : mapRegister.entrySet ()) {
            System.out.printf ("%s => %s%n", entry.getKey (), entry.getValue ());
        }
    }
}
