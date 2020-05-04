package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _01_ActivationKeys {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] keys = console.nextLine().split("&");
        List<String> splitKeys = new ArrayList<>();
        for (String key : keys ) {
            boolean isValid = true;
            if (key.length()==16 || key.length()==25){
                String validKey = "";
                for (char ch : key.toCharArray()) {
                    if (!Character.isLetterOrDigit(ch)){
                        isValid = false;
                        break;
                    }else if (Character.isDigit(ch)){
                        ch = (char)(57 - ch + 48);
                    }
                    validKey += ch;
                }
                String splitedKey = String.join("-", Arrays.asList(validKey.toUpperCase()
                                .split("(?<=\\G.{"+ (int)Math.sqrt(key.length())+"})")));
                if (isValid)
                    splitKeys.add(splitedKey);
            }
        }
        System.out.println(String.join(", ", splitKeys));
    }
}
