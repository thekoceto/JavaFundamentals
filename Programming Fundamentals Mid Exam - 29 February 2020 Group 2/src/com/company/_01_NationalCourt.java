package com.company;

import java.util.Scanner;

public class _01_NationalCourt {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int employeeEfficiency = 0, employee = 3, time = 0;
        while (employee-- > 0)
            employeeEfficiency += Integer.parseInt(console.nextLine());
        int peopleCount = Integer.parseInt(console.nextLine());
        while (peopleCount > 0){
            time ++;
            if (time % 4 == 0)
                time++;
            peopleCount -= employeeEfficiency;
        }
        System.out.printf("Time needed: %dh.", time);
    }
}
// All employess can answer 6 people per hour.
// In the first 3 hours they have answered 6 * 3 = 18 people.
// Then they have a break for an hour.
// After the next 3 hours there are
// 18 + 6 * 3 = 36 answered people.
// After the break for an hour, there are only 9 people to answer.
// So in the 10th hour all of the people questions would be answered.