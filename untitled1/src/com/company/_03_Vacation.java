package com.company;

import java.util.Scanner;

public class _03_Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int group = Integer.parseInt(sc.nextLine());
        String type = sc.nextLine();
        String day = sc.nextLine();
        double total = 0.0;

        if (type.equals("Business") && group >= 100)
            group -= 10;

        if (day.equals("Friday")) {
            switch (type) {
                case "Students": total = group * 8.45; break;
                case "Business": total = group * 10.9; break;
                case "Regular":  total = group * 15;   break;
            }
        } else if (day.equals("Saturday")) {
            switch (type) {
                case "Students": total = group * 9.8;  break;
                case "Business": total = group * 15.6; break;
                case "Regular":  total = group * 20;   break;
            }
        } else if (day.equals("Sunday")) {
            switch (type) {
                case "Students": total = group * 10.46; break;
                case "Business": total = group * 16;    break;
                case "Regular":  total = group * 22.5;  break;
            }
        }
        if (type.equals("Students") && group >= 30)
            total *= 0.85;
        if (type.equals("Regular") && group >= 10 && group <= 20)
            total *= 0.95;

        System.out.printf("Total price: %.2f", total);
    }
}
//	            Friday	Saturday	Sunday
//  Students	8.45	9.80	    10.46
//  Business	10.90	15.60	    16
//  Regular	    15	    20	        22.50