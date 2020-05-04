package com.company;

import java.util.Scanner;

public class _09_PadawanEquipmen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double amount = Double.parseDouble(sc.nextLine());
        int studentsCount = Integer.parseInt(sc.nextLine());
        double sabersPrice = Double.parseDouble(sc.nextLine());
        double robesPrice = Double.parseDouble(sc.nextLine());
        double beltsPrice = Double.parseDouble(sc.nextLine());

        double total = 0.0;

        total += (studentsCount + (int)Math.ceil(studentsCount*0.1))*sabersPrice;
        total += studentsCount*robesPrice;
        total += (studentsCount - (int)(studentsCount/6))*beltsPrice;

        if (total <= amount)
            System.out.printf("The money is enough - it would cost %.2flv.", total);
        else
            System.out.printf("Ivan Cho will need %.2flv more.", total - amount);
    }
}
//	Because the lightsabres sometimes brake, Ivan Cho should buy 10% more,
//	rounded up to the next integer. Also, every sixth belt is free.
//