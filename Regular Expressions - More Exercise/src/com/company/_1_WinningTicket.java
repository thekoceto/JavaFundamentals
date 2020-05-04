package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _1_WinningTicket {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] tickets  = console.nextLine()
                .replace(" ", "")
                .split(",");
        for (String ticket : tickets ) {
            if (ticket.length() == 20) {
                String left = ticket.substring(0, 10);
                String right = ticket.substring(10, 20);
                String regex = "@{6,10}|\\${6,}|\\^{6,}|#{6,}";
                Pattern patternLeft = Pattern.compile(regex);
                Pattern patternRight = Pattern.compile(regex);
                Matcher matcherLeft = patternLeft.matcher(left);
                Matcher matcherRight = patternRight.matcher(right);
                if (matcherLeft.find() && matcherRight.find()){
                    if (matcherLeft.group().length() == 10 && matcherRight.group().length() == 10)
                        System.out.printf("ticket \"%s\" - 10%s Jackpot!%n", ticket, matcherLeft.group().charAt(0));
                    else
                        System.out.printf ("ticket \"%s\" - %d%s%n", ticket, Math.min(matcherLeft.group().length(), matcherRight.group().length()), matcherLeft.group().charAt(0));
                }else
                    System.out.printf ("ticket \"%s\" - no match%n", ticket);
            }
            else{
                System.out.println("invalid ticket");
            }
        }
    }
}
