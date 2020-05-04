package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, int[] > followers = new TreeMap<>();
        String input = "";
        while (!"Log out".equals(input = console.nextLine())) {
            String[] commands = input.split(": ");
            switch (commands[0]) {
                case "New follower":
                    newFollower(followers, commands[1]);
                    break;
                case "Like":
                    like(followers, commands[1], Integer.parseInt(commands[2]));
                    break;
                case "Comment":
                    comment(followers, commands[1] );
                    break;
                case "Blocked":
                    blocked(followers, commands[1] );
                    break;
            }

        }
        System.out.println(followers.size() + " followers");
        followers
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue()[0] - e1.getValue()[0])
                .forEach(e-> System.out.printf("%s: %d%n",e.getKey(), e.getValue()[0] + e.getValue()[1]));
//        followers
//                .entrySet()
//                .stream()
//                .sorted((e1, e2) -> {
//                    if(e2.getValue()[0]-e1.getValue()[0] == 0)
//                        return e1.getKey().compareTo(e2.getKey());
//                    else
//                        return e2.getValue()[0]-e1.getValue()[0];
//                })
//                .forEach(e-> System.out.printf("%s: %d%n",e.getKey(), e.getValue()[0]+e.getValue()[1]));
    }

    private static void blocked(Map<String, int[]> followers, String username) {
        if(followers.containsKey(username))
            followers.remove(username);
        else
            System.out.printf("%s doesn't exist.%n", username);
    }

    private static void comment(Map<String, int[]> followers, String username) {
        followers.putIfAbsent(username, new int[] {0,0});
        followers.put(username, new int[] {followers.get(username)[0], followers.get(username)[1]+1} );
    }

    private static void newFollower(Map<String, int[]> followers, String username){
        followers.putIfAbsent(username, new int[] {0,0});
    }

    private static void like(Map<String, int[]> followers, String username, int count) {
        followers.putIfAbsent(username, new int[] {0,0});
        followers.put(username, new int[] {count + followers.get(username)[0],followers.get(username)[1]} );
    }
}
//•	"New follower: {username}":
//o	Add the username, to your records (with 0 likes and 0 comments).
// If person with the given username already exists ignore the line.

//•	"Like: {username}: {count}":
//o	If the username doesn't exist, add it to your records with the given count of likes.
//o	If the username exist, increase the count of likes with the given count.

//•	"Comment: {username}":
//o	If the username doesn't exist, add it to your records with 1 comment.
//o	If the username exists, increase the count of commens with 1.

//•	"Blocked: {username}":
//o	Delete all records of the given username. If it doesn’t exist, print:
// "{Username} doesn't exist.
