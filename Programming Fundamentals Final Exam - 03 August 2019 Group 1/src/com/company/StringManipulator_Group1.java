package com.company;

import java.util.Scanner;

public class StringManipulator_Group1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String str = scanner.nextLine ();
        String input;

        while (!"End".equals (input = scanner.nextLine ())) {
            String[] commands = input.split (" ");

            switch (commands[0]) {
                case "Translate":
                    str = str.replace (commands[1].charAt (0), commands[2].charAt (0));
                    System.out.println (str);
                    break;

                case "Includes":
                    System.out.println (str.contains (commands[1]) ? "True" : "False");
                    break;

                case "Start":
                    System.out.println (str.indexOf (commands[1]) == 0 ? "True" : "False");
                    break;

                case "Lowercase":
                    System.out.println (str = str.toLowerCase ());
                    break;

                case "FindIndex":
                    int index = -1;
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt (i) == commands[1].charAt (0))
                            index = i;
                    }
                    System.out.println (index);
                    break;

                case "Remove":
                    int startIndex = Integer.parseInt (commands[1]);
                    int count = Integer.parseInt (commands[2]);
                    str = str.replace (str.substring (startIndex, startIndex+count ), "");
                    System.out.println (str);
                    break;
            }
        }
    }
}
//•	"Translate {char} {replacement}"
//o	Replace all occurences of {char} with {replacement}, then print the string.

//•	"Includes {string}"
//o	Check if the string includes {string} and print "True/False".

//•	"Start {string}"
//o	Check if the string starts with {string} and print "True/False".

//•	"Lowercase"
//o	Make the whole string lowercased, then print it.

//•	"FindIndex {char}"
//o	Find the last index of {char}, then print it.

//•	"Remove {startIndex} {count}"
//o	Remove {count} characters from the string, starting from {startIndex}, then print it.