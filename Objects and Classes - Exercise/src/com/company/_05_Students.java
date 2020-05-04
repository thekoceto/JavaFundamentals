package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _05_Students {
    static class Student{
        private String firstName;
        private String lastName;
        private float grade;

        Student (String firstName, String lastName, float grade){
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public float getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f",
                    this.firstName,
                    this.lastName,
                    this.grade
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int steps = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < steps; i++) {
            String[] input = sc.nextLine().split("\\s+");
            students.add(new Student(input[0], input[1], Float.parseFloat(input[2])));
        }
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());

        for (Student student : students)
            System.out.println(student.toString());
    }
}