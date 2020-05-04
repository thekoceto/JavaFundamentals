package com.company;

import java.util.Scanner;

public class _05_Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int atempt = 4;
        String user = sc.nextLine();
        String pass = "";
        for (int i = user.length()-1; i >=0 ; i--)
            pass += user.charAt(i);

        while (!sc.nextLine().equals(pass) && --atempt>0)
            System.out.println("Incorrect password. Try again.");

        if (atempt==0)
            System.out.printf("User %s blocked!", user);
        else
            System.out.printf("User %s logged in.", user);
    }
}