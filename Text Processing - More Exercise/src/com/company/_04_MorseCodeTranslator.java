package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, String> key = new TreeMap<String, String>() {{
            put(".-", "A");     put("-...", "B");   put("-.-.", "C");   put("-..", "D");
            put(".", "E");      put("..-.", "F");   put("--.", "G");    put("....", "H");
            put("..", "I");     put(".---", "J");   put("-.-", "K");    put(".-..", "L");
            put("--", "M");     put("-.", "N");     put("---", "O");    put(".--.", "P");
            put("--.-", "Q");   put(".-.", "R");    put("...", "S");    put("-", "T");
            put("..-", "U");    put("...-", "V");   put(".--", "W");    put("-..-", "X");
            put("-.--", "Y");   put("--..", "Z");   put("-----", "0");  put(".----", "1");
            put("..---", "2");  put("...--", "3");  put("....-", "4");  put(".....", "5");
            put("-....", "6");  put("--...", "7");  put("---..", "8");
        }};
        String[] input = console.nextLine().split(" \\| ");
        for ( String word : input){
            String[] current = word.split(" ");
            for ( String letter : current)
                System.out.print(key.get(letter));
            System.out.print(" ");
        }
    }
}
