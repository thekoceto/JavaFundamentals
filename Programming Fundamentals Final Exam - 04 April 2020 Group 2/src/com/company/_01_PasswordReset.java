package com.company;

import java.util.Scanner;

public class _01_PasswordReset {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String password = console.nextLine();
        String input;

        while (!"Done".equals(input = console.nextLine())){
            String[] token = input.split("\\s+");
            switch (token[0]){
                case "TakeOdd":
                    password = takeOdd(password);
                    break;
                case "Cut":
                    password = cut(password, Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
                case "Substitute":
                    password = substitute(password, token[1], token[2]);
                    break;

            }
        }
        System.out.println("Your password is: " + password);
    }

    private static String takeOdd(String password) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < password.length(); i=i+2)
            result.append(password.charAt(i)) ;
        System.out.println(result.toString());
        return result.toString();
    }

    private static String cut(String password, int index, int lenght) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < password.length(); i++)
            result.append( i>=index && i< index+lenght ? "" : password.charAt(i)) ;
        System.out.println(result.toString());
        return result.toString();
    }

    private static String substitute(String password, String substring, String substitute) {
        if (password.contains(substring)){
            password = password.replaceAll(substring, substitute);
            System.out.println(password);
        }else {
            System.out.println("Nothing to replace!");
        }
        return password;
    }
}
//•	TakeOdd
//o	 Takes only the characters at odd indices and concatenates them together to
// obtain the new raw password and then prints it.

//•	Cut {index} {length}
//o	Gets the substring with the given length starting from the given index from the password and removes its first occurrence of it, then prints the password on the console.
//o	The given index and length will always be valid.

//•	Substitute {substring} {substitute}
//o	If the raw password contains the given substring, replaces all of its
//occurrences with the substitute text given and prints the result.
//o	If it doesn’t, prints "Nothing to replace!"