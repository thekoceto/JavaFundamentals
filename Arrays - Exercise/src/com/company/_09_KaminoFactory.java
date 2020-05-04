package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _09_KaminoFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arrayLenght = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        int[] DNA = new int[arrayLenght];
        int length = 0, index = 0, sum = 0;
        int currentRow = 0, row = 0;

        while (!input.equals("Clone them!")) {
            int[] currentDNA = Arrays.stream(input.split("!"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            currentRow++;
            int currentSum = 0;
            for (int element : currentDNA )
                currentSum += element == 1 ? 1 : 0;

            int currentLenght = 0;
            int currentIndex = 0;
            for (int i = 0; i < currentDNA.length; i++){
                if (currentDNA[i]==1){
                    currentLenght++;
                    if (currentLenght == 1)
                        currentIndex = i;

                    if (currentLenght > length || (currentLenght == length && (currentIndex < index|| currentSum > sum))){
                        length = currentLenght;
                        index = currentIndex;
                        row = currentRow;
                        DNA = currentDNA;
                        sum = currentSum;
                    }
                } else {
                    currentIndex = 0;
                    currentLenght = 0;
                }
            }
            input = sc.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", row==0 ? 1 : row, sum );
        for ( int element : DNA )
            System.out.printf( "%d ", element);
    }
}
