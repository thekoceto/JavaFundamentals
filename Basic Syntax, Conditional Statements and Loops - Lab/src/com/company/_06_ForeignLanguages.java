package com.company;

import java.util.Scanner;

public class _06_ForeignLanguages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()){
            case "England":
            case "USA":
                System.out.println("English");
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}