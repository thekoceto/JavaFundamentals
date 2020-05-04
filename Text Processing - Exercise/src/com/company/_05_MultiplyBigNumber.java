package com.company;

import java.util.Scanner;

public class _05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String big = console.nextLine();
        while (big.charAt(0) == '0' && big.length()>1)
            big = big.substring(1);
        StringBuilder result = new StringBuilder();
        int single = Integer.parseInt(console.nextLine());
        int carry = 0;
        if (single == 0)
            result.append(0);
        else {
            for (int i = big.length() - 1; i >= 0; i--) {
                int num = big.charAt(i) - 48;
                num = num * single + carry;
                result.append(num % 10);
                carry = num / 10;
            }
            if (carry != 0)
                result.append(carry);
            result.reverse();
        }
        System.out.println(result);
    }
}
