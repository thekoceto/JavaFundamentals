package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _04_Articles2 {
    static class Article {
        private String title;
        private String content;
        private String author;

        Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {  return this.title;  }
        public String getAuthor() {  return this.author; }
        public String getContent() { return this.content; }

        @Override
        public String toString() {
            return String.format("%s - %s: %s",
                    this.title,
                    this.content,
                    this.author
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int steps = Integer.parseInt(sc.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < steps; i++) {
            String[] input = sc.nextLine().split(", ");
            articles.add(new Article(input[0], input[1], input[2]));
        }
        String command = sc.nextLine();
        switch (command){
            case "title":
                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::getAuthor));
                break;
            default:
                break;
        }
        for (Article article : articles)
            System.out.println(article.toString());
    }
}
