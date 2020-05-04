package com.company;

import java.util.Scanner;

public class _11_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = Integer.parseInt(sc.nextLine());
        int num2 = Integer.parseInt(sc.nextLine());
        int index = num2-1;

        if(num1>10 || num2>10)
            System.out.printf("%d X %d = %d%n",num1,num2,num1*num2);
        while (++index <= 10)
            System.out.printf("%d X %d = %d%n", num1, index, num1*index);

    }
}
