package com.company;

import java.util.Scanner;

public class _03_Extract_File {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\\\");
        String[] url = input[input.length-1].split("\\.");

        System.out.printf("File name: %s%n",url[0]);
        System.out.printf("File extension: %s%n",url[1]);
    }
}
