package com.company;

import java.util.Scanner;

public class _08_TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= number; i++)
            for (int j = 0; j < i; j++)
                System.out.printf("%d%s", i, j==i-1 ? "\n" : " ");
    }
}
//•	0-2 – baby;
//•	3-13 – child;
//•	14-19 – teenager;
//•	20-65 – adult;
//•	>=66 – elder;