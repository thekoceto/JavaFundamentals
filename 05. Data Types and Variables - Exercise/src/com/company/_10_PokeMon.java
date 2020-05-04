package com.company;

import java.util.Scanner;

public class _10_PokeMon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pokePower = Integer.parseInt(sc.nextLine()); // N
        int distance = Integer.parseInt(sc.nextLine());  // M
        int exhaustionFactor  = Integer.parseInt(sc.nextLine()); // Y

        int counter = 0;
        double originalValue = pokePower * 0.50;

        while(pokePower >= distance){

            pokePower -= distance;
            counter++;

            if (pokePower == originalValue) {
                if (exhaustionFactor > 0) pokePower = pokePower / exhaustionFactor;
            }
        }
        System.out.println(pokePower);
        System.out.println(counter);
    }
}
//Your task is to start subtracting M from N until N becomes less than M, i.e.
// the Poke Mon does not have enough power to reach the next target.

// Every time you subtract M from N that means you’ve reached a target and poked it successfully.
// COUNT how many targets you’ve poked – you’ll need that count.

//The Poke Mon becomes gradually more exhausted. IF N becomes equal to EXACTLY 50 % of its original
// value, you must divide N by Y, if it is POSSIBLE. This DIVISION is between integers.

//If a division is not possible, you should NOT do it. Instead, you should continue subtracting.

//After dividing, you should continue subtracting from N, until it becomes less than M.
//When N becomes less than M, you must take what has remained of N and the count of
// targets you’ve poked, and print them as output.