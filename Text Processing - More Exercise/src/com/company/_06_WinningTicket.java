package com.company;

import java.util.Scanner;

public class _06_WinningTicket {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine()
                .replace(" ", "")
                .split(",");

        for (String ticket : input ) {
            int index = 0, mach = -1;
            String[] element = {"@", "#", "$", "^"};
            if (ticket.length() == 20) {
                mach = 0;
                String left = ticket.substring(0, 10);
                String right = ticket.substring(10, 20);
                for (int i = 0; i < element.length; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (mach > 0)
                            break;
                        String target = "";
                        for (int k = 10; k > j ; k--)
                            target += element[i];
                        int countLeft = left.length() - left.replace(target, "").length();
                        int countRight = right.length() - right.replace(target, "").length();
                        if (countLeft >= 6 && countRight >= 6) {
                            index = i;
                            mach = countLeft < countRight ? countLeft : countRight;
                        }
                    }
                }
            }
            if (mach == -1)
                System.out.println("invalid ticket");
            else if (mach <= 5)
                System.out.printf ("ticket \"%s\" - no match%n", ticket);
            else if (mach <= 9)
                System.out.printf ("ticket \"%s\" - %d%s%n", ticket, mach, element[index]);
            else if (mach == 10)
                System.out.printf("ticket \"%s\" - 10%s Jackpot!%n", ticket, element[index]);
        }
    }
}