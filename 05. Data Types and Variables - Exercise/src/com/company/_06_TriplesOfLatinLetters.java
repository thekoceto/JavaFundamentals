package com.company;

import java.util.Scanner;

public class _06_TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(char ch1 = 'a'; ch1 < 'a'+n; ch1++)
            for(char ch2 = 'a'; ch2 < 'a'+n; ch2++)
                for(char ch3 = 'a'; ch3 < 'a'+n; ch3++)
                    System.out.printf("%c%c%c%n",ch1,ch2,ch3);
    }
}
