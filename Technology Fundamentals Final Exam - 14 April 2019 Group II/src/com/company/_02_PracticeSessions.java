package com.company;

import java.util.*;


public class _02_PracticeSessions {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, List<String> > roads = new TreeMap<>();
        String input = "";
        while (!"END".equals(input = console.nextLine())) {
            String[] commands = input.split("->");
            switch (commands[0]) {
                case "Add":
                    add(roads, commands[1], commands[2]);
                    break;
                case "Move":
                    move(roads, commands[1], commands[2], commands[3]);
                    break;
                case "Close":
                    close(roads, commands[1]);
                    break;
            }

        }
        System.out.println("Practice sessions:");

        roads
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    if (s.getValue().size() - f.getValue().size() == 0) {
                        return f.getKey().compareTo(s.getKey());
                    } else {
                        return s.getValue().size() - f.getValue().size();
                    }
                })
                .forEach(e-> {
                    System.out.printf("%s%n%s",
                            e.getKey(),
                            printList(e.getValue()));
                });
    }

    private static String printList(List<String> racers) {
        StringBuilder result = new StringBuilder();
        for (String racer : racers) {
            result.append("++" +  racer + "\n");
        }
        return result.toString();
    }

    private static void close(Map<String, List<String>> roads, String road) {
        roads.remove(road);
    }

    private static void move(Map<String, List<String>> roads, String currentRoad, String racer, String nextRoad) {
        if (roads.get(currentRoad).contains(racer)){
            roads.get(currentRoad).remove(racer);
            roads.get(nextRoad).add(racer);
        }
    }

    private static void add(Map<String, List<String>> roads, String road, String racer) {
        roads.putIfAbsent(road, new ArrayList<>());
        roads.get(road).add(racer);
    }
}
// •"Add->{road}->{racer}"
//o	Add the road if it doesn't exist in your collection and add the racer to it.
//•	"Move->{currentRoad}->{racer}->{nextRoad}"
//o	Find the racer on the current road and move him to the next one,
// only if he exists in the current road. Both roads will always be valid and will already exist.
//•	"Close->{road}"
//o	Find the road and remove it from the sessions, along with the racers on it if it exists.