package com.company;

import java.util.Scanner;

public class _02_Articles {
    static class Article {
    private String title;
    private String content;
    private String author;

    Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setContent(String content) { this.content = content;}
    public void setAuthor(String author) { this.author = author; }
    public void setTitle(String title) { this.title = title; }

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
        String[] input = sc.nextLine().split(", ");

        Article article = new Article(input[0], input[1], input[2]);

        int steps = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < steps; i++) {
            String[] command = sc.nextLine().split(": ");
            switch (command[0]){
                case "Edit": article.setContent(command[1]);
                    break;
                case "ChangeAuthor": article.setAuthor(command[1]);
                    break;
                case "Rename": article.setTitle(command[1]);
                    break;
                default:
                    break;
            }
        }
        System.out.println(article);
    }
}