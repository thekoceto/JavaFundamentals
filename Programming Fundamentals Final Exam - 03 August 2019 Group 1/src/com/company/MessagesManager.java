package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine ());
        String input;

        Map <String, int []> users = new TreeMap<> (); // map < name, [sent, receive]

        while (!"Statistics".equals(input = scanner.nextLine())) {
            String [] commands = input.split("=");

            switch (commands [0]) {
                case "Add":
                    String user = commands [1];
                    int sent = Integer.parseInt(commands [2]);
                    int received = Integer.parseInt(commands[3]);

                    users.putIfAbsent(user, new int[]{sent,received});
                    break;

                case "Message":
                    String sender = commands [1];
                    String receiver = commands [2];
                    if (users.containsKey (sender) && users.containsKey (receiver)) {
                        users.get (sender)[0] += 1;
                        users.get (receiver)[1] += 1;

                        if (users.get(sender)[0] + users.get (sender)[1] >= capacity) {
                            users.remove (sender);
                            System.out.printf ("%s reached the capacity!%n", sender);
                        }
                        if (users.get(receiver)[0] + users.get (receiver)[1] >= capacity) {
                            users.remove (receiver);
                            System.out.printf ("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;

                case "Empty":
                    if ("All".equals(commands[1]))
                        users.clear();
                    else
                        users.remove(commands[1]);
                    break;
            }
        }

        System.out.printf("Users count: %d%n", users.size());

        users.entrySet()
                .stream()
                .sorted((u1,u2) -> u2.getValue()[1] - u1.getValue()[1])
                .forEach(u ->
                    System.out.printf("%s - %d%n", u.getKey (), u.getValue()[0] + u.getValue()[1]));
    }
}