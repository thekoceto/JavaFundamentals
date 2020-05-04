package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_EmojiDetector_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        int threshold = 1, countEmoji = 0;
        List<String> emojis = new ArrayList<>();

        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find())
            threshold *= Integer.parseInt(matcher.group());

        pattern = Pattern.compile("([*]{2}|[:]{2})(?<text>[A-Z][a-z]{2,})\\1");
        matcher = pattern.matcher(input);

        while (matcher.find()){
            countEmoji++;
            if (calcCoolness (matcher.group("text")) >= threshold)
                emojis.add(matcher.group());
        }

        System.out.printf("Cool threshold: %s%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countEmoji);

        System.out.println(String.join(System.lineSeparator(), emojis)) ;
    }

    private static int calcCoolness (String emoji) {
        int sum = 0;
        for (char ch : emoji.toCharArray())
            sum += ch;
        return sum;
    }
}