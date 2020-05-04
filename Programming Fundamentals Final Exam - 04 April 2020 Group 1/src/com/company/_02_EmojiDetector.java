package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_EmojiDetector {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        int threshold = 1;

        for (char ch : input.toCharArray())
            threshold *= ch >= '0' && ch <= '9' ? ch - 48 : 1;

        String regex = "([*]{2}|[:]{2})(?<emo>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> emojis = new ArrayList<>();

        while (matcher.find())
            emojis.add(matcher.group());

        System.out.printf("Cool threshold: %s%n", threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojis.size());
        for (String emoji : emojis)
            if (calculate(emoji) >= threshold)
                System.out.println(emoji);
    }

    private static int calculate(String emoji) {
        int sum = 0;
        for (char ch : emoji.toCharArray())
            sum += ch != '*' && ch != ':' ? ch : 0;
        return sum;
    }
}