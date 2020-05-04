package com.company;

import java.util.Scanner;

public class _07_VendingMachine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double value[] = {2.0, 1.0, 0.5, 0.2, 0.1 };
        double total = 0.0;

        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("Start")){
            double current = Double.parseDouble(input);
            if (contains(value, current))
                total += Double.parseDouble(input);
            else
                System.out.printf("Cannot accept %.2f%n", current);
            input = sc.nextLine();
        }

        input = sc.nextLine();

        while (!input.equalsIgnoreCase("End")){
            switch (input){
                case "Nuts":   total = purchase ("Nuts",total ,2.0);   break;
                case "Water":  total = purchase ("Water",total ,0.7);  break;
                case "Crisps": total = purchase ("Crisps",total ,1.5); break;
                case "Soda":   total = purchase ("Soda",total ,0.8);   break;
                case "Coke":   total = purchase ("Coke",total ,1.0);   break;
                default: System.out.println("Invalid product"); break;
            }
            input = sc.nextLine();
        }
        System.out.printf("Change: %.2f", total);
    }

    private static double purchase(String product, double total, double price) {
        if (total - price >= 0){
            System.out.printf("Purchased %s%n", product );
            return total - price;
        }else{
            System.out.println("Sorry, not enough money" );
            return total;
        }
    }

    private static boolean contains(double[] value, double current) {
        for (double i : value)
            if (i == current)
                return true;

        return false;
    }
}
//"Nuts", "Water", "Crisps", "Soda", "Coke". The prices are: 2.0, 0.7, 1.5, 0.8, 1.0