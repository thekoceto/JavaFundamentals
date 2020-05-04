package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _07_OrderByAge {
    static class People {
        String name;
        String ID;
        int age;

        People(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public int getAge() { return age; }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.",
                    this.name,
                    this.ID,
                    this.age
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        List<People> listPeoples = new ArrayList<>();

        while (!input[0].equals("End")) {
            listPeoples.add(new People(input[0], input[1], Integer.parseInt(input[2])));
            input = sc.nextLine().split(" ");
        }
        listPeoples.sort(Comparator.comparing(People::getAge));

        for (People people : listPeoples)
            System.out.println(people.toString());
    }
}
