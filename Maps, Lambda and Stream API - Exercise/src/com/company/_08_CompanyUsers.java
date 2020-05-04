package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _08_CompanyUsers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, ArrayList<String >> companies = new TreeMap<>();
        String input;
        while (!"End".equals(input = console.nextLine())){
            String[] token = input.split(" -> ");
            String company = token[0];
            String id = token[1];

            companies.putIfAbsent(company, new ArrayList<>());
            if(!companies.get(company).contains(id))
                companies.get(company).add(id);
        }

        companies
                .forEach((key, value) -> {
                    System.out.println(key);
                    value.forEach(i -> System.out.println(String.format("-- %s", i)));
                });
    }
}
