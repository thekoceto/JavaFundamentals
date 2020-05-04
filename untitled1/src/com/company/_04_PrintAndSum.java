package com.company;

import java.util.Scanner;

public class _04_PrintAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = Integer.parseInt(sc.nextLine());
        int num2 = Integer.parseInt(sc.nextLine());
        int sum = 0;
        do {
            System.out.printf("%d ", num1);
            sum += num1++;
        }while (num1 <= num2);
        System.out.printf("%nSum: %d", sum);
    }
}
//•	0-2 – baby;
//•	3-13 – child;
//•	14-19 – teenager;
//•	20-65 – adult;
//•	>=66 – elder;