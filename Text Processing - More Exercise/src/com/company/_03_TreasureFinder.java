package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03_TreasureFinder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] key = Arrays.stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String cipher;
        while (!"find".equals(cipher = console.nextLine())){
            String plain = "";
            for (int i = 0; i < cipher.length(); i++)
                plain += (char)(cipher.charAt(i) - key[i%key.length]);

            String type = extractStr(plain, '&', '&') ;
            String coordinate = extractStr(plain, '<', '>') ;
            if(type != null && coordinate != null)
                System.out.printf("Found %s at %s%n", type, coordinate);
        }
    }

    private static String extractStr(String plain, char start, char end) {
        boolean flag = false;
        String result = "";
        for (int i = 0; i < plain.length(); i++) {
            if (plain.charAt(i) == start && !flag)
                flag = true;
            else if (plain.charAt(i) == end)
                return result.substring(1);
            if (flag)
                result += plain.charAt(i);
        }
        return null;
    }
}
