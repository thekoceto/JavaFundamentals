package com.company;

import java.util.Scanner;

public class _01_ValidUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(", ");

        for (String element : input ) {
            if (isValid(element))
                System.out.println(element);
        }
    }

    private static boolean isValid(String element) {
        return isValidLenght (element) && isValidContains(element);

    }

    private static boolean isValidContains(String element) {
        for (int i = 0; i < element.length(); i++) {
            char ch = element.charAt(i);
            if (ch!='-' && ch!='_' && !Character.isLetterOrDigit(ch))
                return false;
        }
        return true;
    }

    private static boolean isValidLenght(String element) {
        return element.length()>=3 && element.length()<=16;
    }
}

//•	Has length between 3 and 16 characters
//•	Contains only letters, numbers, hyphens and underscores
//•	Has no redundant symbols before, after or in between.