package com.company;

import java.util.Scanner;

public class _01_NationalCourt_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int employeeEfficiency = 0, employee = 3;
        while (employee-- > 0)
            employeeEfficiency += Integer.parseInt(console.nextLine());
        double peopleCount = Double.parseDouble(console.nextLine());
        int time = (int)Math.ceil(peopleCount/employeeEfficiency);
        System.out.printf("Time needed: %dh.", time + (int)Math.floor(time/3));
    }
}
