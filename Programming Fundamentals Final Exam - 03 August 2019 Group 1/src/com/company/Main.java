package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int [3];
        for ( int i = 0; i <= 2; i++)
            array[i] = -Integer.parseInt(scanner.nextLine());

        Arrays.sort(array);

        Arrays.stream(array)
                .sorted()
                .map(e -> -e)
                .forEach(System.out::println);

    }

}