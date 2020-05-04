package com.company;

import java.util.Scanner;

public class _06_WinningTicket_old {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+,\\s+");

        for (String ticket : input ) {
            char result[] = checkTicket(ticket);
            if (result[0] == ' ')
                System.out.println("invalid ticket");
            else if (result[0] >= 0 && result[0] <= 5)
                System.out.printf ("ticket \"%s\" - no match%n", ticket);
            else if (result[0] >= 6 && result[0] <= 9)
                System.out.printf ("ticket \"%s\" - %c%c%n", ticket, (int)(result[0] + 48), result[1]);
            else if (result[0] == 10)
                System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", ticket, result[1]);
        }
    }

    private static char[] checkTicket(String ticket) {
        if (ticket.length() != 20)
            return new char[] {' ', ' '};
        int maxCount = 0; // '@', '#', '$', '^'
        char maxChar = ' ';
        int currCount = 0;
        char currChar = ' ';
        boolean flag = false;

        for (int i = 0; i < ticket.length(); i++) {
            if (!flag){
                if ("@#$^".indexOf(ticket.charAt(i)) != -1){
                    currChar = ticket.charAt(i);
                    currCount = 1;
                    flag = true;
                }
            }else{
                if (currChar == ticket.charAt(i)){
                    ++currCount;
                    if (currCount == 10){
                        return new char[] {10, ticket.charAt(i)};
                    }
                }else if("@#$^".indexOf(ticket.charAt(i)) != -1){
                    maxCount = maxCount > currCount ? maxCount : currCount;
                    maxChar = maxCount > currCount ? maxChar : currChar;
                    currChar = ticket.charAt(i);
                    currCount = 1;
                }else{
                    maxCount = maxCount > currCount ? maxCount : currCount;
                    maxChar = maxCount > currCount ? maxChar : currChar;
                    currChar = ' ';
                    currCount = 0;
                    flag = false;
                }
            }
        }
        return new char[] {(char)maxCount, maxChar}; // maxCount, maxChar
    }
}
