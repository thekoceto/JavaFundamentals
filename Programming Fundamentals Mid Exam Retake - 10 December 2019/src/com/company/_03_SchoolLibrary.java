package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_SchoolLibrary {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<String> books = Arrays.stream(console.nextLine().split("&"))
                .collect(Collectors.toList());

        String input;
        while (!"Done".equals(input = console.nextLine())) {
            if (input.isEmpty())
                continue;
            String[] command = input.split(" \\| ");
            switch (command[0]) {
                case "Add Book":
                    add(books, command[1]);
                    break;
                case "Take Book":
                    take(books, command[1]);
                    break;
                case "Swap Books":
                    swap(books, command[1], command[2]);
                    break;
                case "Insert Book":
                    insert(books, command[1]);
                    break;
                case "Check Book":
                    check(books, Integer.parseInt(command[1]));
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < books.size(); i++)
            System.out.printf("%s%s", books.get(i), i != books.size() -1 ? ", " : "");
    }

    private static void check(List<String> books, int index) {
        if (index >= 0 && index < books.size())
            System.out.println(books.get(index));
    }

    private static void insert(List<String> books, String book) {
        //if (!books.contains(book))
            books.add(book);
    }

    private static void swap(List<String> books, String book1, String book2 ) {
        if (books.contains(book1) && books.contains(book2)){
            Collections.swap(books,  books.indexOf(book1), books.indexOf(book2));
        }
    }

    private static void take(List<String> books, String book) {
        if (books.contains(book))
            books.remove(book);
    }

    private static void add(List<String> books, String book) {
        if (!books.contains(book))
            books.add(0,book);
    }
}
