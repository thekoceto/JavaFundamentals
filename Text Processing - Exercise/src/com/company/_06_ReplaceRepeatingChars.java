package com.company;

import java.util.Scanner;

public class _06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        int index = input.length();
        StringBuilder result = new StringBuilder().append(input.charAt(--index));
        while (index > 0){
            if (input.charAt(index)!=input.charAt(--index))
                result.append(input.charAt(index));
        }
        System.out.println(result.reverse());
    }
}
