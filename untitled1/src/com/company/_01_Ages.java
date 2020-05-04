package com.company;

import java.util.Scanner;

public class _01_Ages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age = Integer.parseInt(sc.nextLine());

        if (age < 0)
            System.out.println("error");
        else if (age <= 2)
            System.out.println("baby");
        else if (age <= 13)
            System.out.println("child");
        else if (age <= 19)
            System.out.println("teenager");
        else if (age <= 65)
            System.out.println("adult");
        else
            System.out.println("elder");
    }
}
//•	0-2 – baby;
//•	3-13 – child;
//•	14-19 – teenager;
//•	20-65 – adult;
//•	>=66 – elder;