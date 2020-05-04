package com.company;

import java.util.Scanner;

public class _01_DisneylandJourney {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        double journey = Double.parseDouble(console.nextLine())* 0.25;
        int month = Integer.parseInt(console.nextLine());
        double total = journey;
        for (int i = 2; i <= month; i++) {
            if (i % 2 == 1)
                total -= total*0.16;
            if (i % 4 == 0)
                total += total/4;
            total += journey;
        }
        if (total >= journey*4)
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", total - journey*4);
        else
            System.out.printf("Sorry. You need %.2flv. more.", journey*4 - total);
    }
}
// You need 1000 leva for the journey and you have 4 months to collect them.
// Every month you can save 1000 * 25% => 250 lv. So, to the end of the 1st month you have 250 lv.
// To the end of the 2nd month -  250 + 250 -> 500 lv.
// To the begging of the 3th month (odd month) you spent 80 lv. (500 * 16%)
// for clothes and shoes, then you save 250 lv, so now you have 670 lv.
// Last month is the fourth month and you save 670 + 167.5 (670 * 25%) + 25 = 1087.5 lv.
// You have 1087.5 – 1000 = 87.5 lv., so you can go to the trip.