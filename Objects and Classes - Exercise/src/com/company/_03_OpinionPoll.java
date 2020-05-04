package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _03_OpinionPoll {
    static class Person{
        private String name;
        private int age;

        Person (String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() { return this.name; }
        boolean isOlderThan (int age){ return this.age > age; }

        @Override
        public String toString() {
            return String.format("%s - %s", name, age);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int steps = Integer.parseInt(sc.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < steps; i++) {
            String[] command = sc.nextLine().split(" ");
            persons.add(new Person(command[0], Integer.parseInt(command[1])));
        }

        persons.sort(Comparator.comparing(Person::getName));

        for (Person person : persons)
            if (person.isOlderThan(30))
                System.out.println(person.toString());
    }
}