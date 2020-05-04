package com.company;

import java.util.Scanner;

public class _01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int students = Integer.parseInt(console.nextLine());
        double lectures = Double.parseDouble(console.nextLine());
        int additional  = Integer.parseInt(console.nextLine());
        int maxAttendances = 0;
        double maxBonus = 0.0, bonus = 0.0;
        while(students-- > 0){
            int attendances = Integer.parseInt(console.nextLine());
            bonus = attendances/lectures*(5+additional);
            if (bonus > maxBonus){
                maxBonus = bonus;
                maxAttendances = attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
