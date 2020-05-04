package com.company;

import java.util.Random;
import java.util.Scanner;

public class _01_AdvertisementMessage {

    static class text {
        public String[] phrases = new String[]{"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};
        public String[] events = new String[]{ "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};
        public String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        public String[] cities  = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        public String rand (String[] inputArray) {
            Random rand = new Random();
            return inputArray [rand.nextInt(inputArray.length)];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        text text = new text();
        int steps = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < steps; i++)
            System.out.printf("%s %s %s – %s.%n",text.rand(text.phrases),
                                                 text.rand(text.events),
                                                 text.rand(text.authors),
                                                 text.rand(text.cities));
    }
}