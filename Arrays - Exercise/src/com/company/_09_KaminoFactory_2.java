package com.company;

import java.util.Scanner;

public class _09_KaminoFactory_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elements = Integer.parseInt(sc.nextLine());

        int bestLength = 0, bestSum = 0, bestIndex = 0;
        int bestSample = 0, row = 0;
        String oneSequence = "", bestDna = "";
        String input = sc.nextLine();

        while (!input.equals("Clone them!")) {
            row++;
            int maxLength = 0;
            int sum = 0;

            String sequence = input.replaceAll("!", "");
            String[] ones = sequence.split("0+");

            for (int i = 0; i < ones.length; i++) {
                if (ones[i].length() > maxLength) {
                    maxLength = ones[i].length();
                    oneSequence = ones[i];
                }
                sum += ones[i].length();
            }
            int leftmostOne = sequence.indexOf(oneSequence);

            if (maxLength > bestLength || (maxLength == bestLength &&
                    (leftmostOne < bestIndex || sum > bestSum)) || row == 1) {
                bestLength = maxLength;
                bestDna = sequence;
                bestIndex = leftmostOne;
                bestSample = row;
                bestSum = sum;
                bestSum = row == 1 ? sum : bestSum;
            }
            input = sc.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, bestSum);
        System.out.println(String.join(" ", bestDna.split("")));
    }
}
