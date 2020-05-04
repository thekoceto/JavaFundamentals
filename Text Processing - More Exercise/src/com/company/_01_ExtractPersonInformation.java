package com.company;

import java.util.Scanner;

public class _01_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());
        while(steps-->0){
            String[] input = console.nextLine().split("\\s+");
            String name = "";
            int year = 0;
            for (String word : input) {
                if (word.indexOf('@') != -1 && word.indexOf('|') != -1)
                    name = word.substring(word.indexOf('@')+1,word.indexOf('|'));
                if (word.indexOf('#') != -1 && word.indexOf('*') != -1)
                    year = Integer.parseInt(word.substring(word.indexOf('#')+1,word.indexOf('*')));
            }
            System.out.printf("%s is %s years old.%n", name, year);
        }
    }
}
