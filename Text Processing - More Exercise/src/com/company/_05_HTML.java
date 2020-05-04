package com.company;

import java.util.Scanner;

public class _05_HTML {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        printHTML (line , "h1");
        line = console.nextLine();
        printHTML (line , "article");
        String input = "";
        while (!"end of comments".equals(input = console.nextLine()))
            printHTML(input, "div");

    }

    private static void printHTML(String text, String h1) {
        System.out.printf("<%s>%n", h1);
        System.out.printf("    %s%n", text);
        System.out.printf("</%s>%n", h1);
    }
}
