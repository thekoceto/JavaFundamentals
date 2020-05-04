package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _01_Ranking {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap <String, String> passwords  = new TreeMap<>();
        TreeMap< String, TreeMap<String, Integer>> contests  = new TreeMap<>();
        String input, bestScoreName = "";
        int bestScore = 0;
        while (!"end of contests".equals(input = console.nextLine())){
            String[] token = input.split(":");
            passwords.putIfAbsent(token[0], "");
            passwords.put(token[0], token[1]);
        }
        while (!"end of submissions".equals(input = console.nextLine())){
            //"{contest}=>{password}=>{username}=>{points}
            //  token[0]=>token[1]=>token[2]=>token[3]
            // TreeMap< username, TreeMap<contest, points>>
            String[] token = input.split("=>");
            String contest = token[0];
            String password = token[1];
            String username = token[2];
            int score = Integer.parseInt(token[3]);
            if (passwords.containsKey(contest) && passwords.get(contest).equals(password)){
                contests.putIfAbsent(username, new TreeMap<>());
                contests.get(username).putIfAbsent(contest, 0);
                int newScore = contests.get(username).get(contest);
                contests.get(username).put(contest,  newScore > score ? newScore : score);
            }
        }
        for (Map.Entry<String, TreeMap<String, Integer>> contest : contests.entrySet()) {
            int sum = 0;
            for (Map.Entry<String, Integer> user : contests.get(contest.getKey()).entrySet()) {
                sum += user.getValue();
            }
            if (sum > bestScore){
                bestScore = sum;
                bestScoreName = contest.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestScoreName, bestScore);
        System.out.println("Ranking: ");
        contests
                .entrySet()
                .forEach(c -> {
                    System.out.println(c.getKey());
                    c.getValue()
                            .entrySet()
                            .stream()
                            .sorted((u1, u2) -> u2.getValue() - u1.getValue())
                            .forEach(u -> System.out.printf("#  %s -> %d%n", u.getKey(), u.getValue()));
                });

    }
}
