package com.company;

import java.util.Scanner;

public class _03_ExtractFile {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\\\");
        String[] file = input[input.length-1].split("\\.");

        System.out.println("File name: " + file[0]);
        System.out.println("File extension: " + file[1]);
    }
}
