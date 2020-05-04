package com.company;

import java.util.Scanner;

public class _07_TheatrePromotion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = -1, col = -1;
        String dayType = sc.nextLine();
        if (dayType.equals("Weekday"))
            row = 0;
        else if (dayType.equals("Weekend"))
            row = 1;
        else if (dayType.equals("Holiday"))
            row = 2;


        int age = Integer.parseInt(sc.nextLine());
        if (age >= 0 && age <= 18)
            col = 0;
        else if (age > 18 && age <= 64)
            col = 1;
        else if (age > 64 && age <= 122)
            col = 2;

        int matrix[][] = {{12, 18, 12},
                          {15, 20, 15},
                          {5,  12, 10}};

        if (row < 0 || col < 0)
            System.out.println("Error!");
        else
            System.out.printf("%d$", matrix[row][col]);
    }
}