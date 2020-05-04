package com.company;

import java.util.Scanner;

public class _08_BeerKegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String biggest = null;
        double capacity = 0.0;
        int n = Integer.parseInt(sc.nextLine());
        while (--n >= 0){
            String type = sc.nextLine();
            double radius = Double.parseDouble(sc.nextLine());
            int height  = Integer.parseInt(sc.nextLine());
            if (capacity < Math.PI*radius*radius*height){
                biggest = type;
                capacity = Math.PI*radius*radius*height;
            }
        }
        System.out.println(biggest);
    }
}
