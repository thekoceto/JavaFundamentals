package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i > -12; i--) {
            System.out.printf("%d -> %d : %d -> %d %n", i, (i%5 + 5)%5, -i, -i%5 );
        }
    }
}
