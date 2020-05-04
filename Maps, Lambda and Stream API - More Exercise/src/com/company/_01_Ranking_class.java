package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class _01_Ranking_class {
    static class Contest{
        private String contest;
        private String name;
        private int points;

        Contest (String contest, String name, int points){
            this.contest = contest;
            this.name = name;
            this.points = points;
        }
        Contest (String contest){
            this.contest = contest;
            this.name = "";
            this.points = 0;
        }

        public String getContest() {
            return contest;
        }

        public String getName() {
            return name;
        }

        public int getPoints() {
            return points;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPoints(int points) {
            this.points = points;
        }
        public int biggerThan (int points){
            if(points > this.points)
                return points;
            return this.points;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap <String, String> passwords  = new TreeMap<>();
        TreeMap <String, Contest> contests  = new TreeMap<>();
        String input;
        while ("end of contests".equals(input = console.nextLine())){
            String[] token = input.split(":");
            passwords.putIfAbsent(token[0], "");
            passwords.put(token[0], token[1]);
        }
        while ("end of submissions".equals(input = console.nextLine())){
            //"{contest}=>{password}=>{username}=>{points}"
            String[] token = input.split("=>");
            if (passwords.containsKey(token[0]) && passwords.get(token[0]).equals(token[1])){
                String contest = token[0];
                String username = token[2];
                int points = Integer.parseInt (token[3]);
                if (contests.containsKey(contest))
                    contests.put(contest, new Contest (contest, username, points));
                else{
                    if (!contests.get(contest).getName().equals (username)){
                        contests.get(contest).setName(username);
                        contests.get(contest).setPoints(points);
                    } else {
                        points = contests.get(contest).getPoints () > points ? contests.get(contest).getPoints () : points;
                        contests.get(contest).setPoints(points);
                    }

                }
            }
        }
        contests
                .entrySet()
                .stream ()
                .sorted ((e1, e2) -> {
                    if (e1.getValue().getName().equals(e2.getValue().getName()))
                        return e2.getValue().getPoints() - e1.getValue().getPoints();
                    else
                        return e1.getValue().getName().compareTo (e2.getValue().getName());
                })
                .forEach (e -> {
                    System.out.println (e.getKey());
                    System.out.println (e.getValue ().getName());
                });
    }
}
