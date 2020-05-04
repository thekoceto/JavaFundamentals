package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_Weaponsmith {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        List<String> weapons = Arrays.stream(console.nextLine().split("\\|"))
                .collect(Collectors.toList());
        String input;

        while (!"Done".equals(input = console.nextLine())){
            String[] command = input.split (" ");
            switch (command[0]){
                case "Move":
                    move(weapons, command[1], Integer.parseInt (command[2]));
                    break;
                case "Check":
                    check(weapons, command[1]);
                    break;
            }
        }

        System.out.printf ("You crafted %s!" , String.join("", weapons));

    }

    private static void check(List<String> weapons, String command) {
        for (int i = 0; i < weapons.size (); i++) {
            if ("Even".equals (command) && i%2 ==0)
                System.out.print(weapons.get (i) + " ");
            if ("Odd".equals (command) && i%2 ==1)
                System.out.print(weapons.get (i) + " ");
        }
        System.out.println ();
    }

    private static void move(List<String> weapons, String command, int index) {
        if ("Left".equals (command)) {
            if (index >= 1 && index < weapons.size ())
                Collections.swap (weapons, index, index - 1);
        }else if ("Right".equals (command)) {
            if (index >= 0 && index < weapons.size ()-1)
                Collections.swap (weapons, index, index + 1);
        }
    }
}
//•	"Move Left {index}":
//•	Moves the value at {index} position to the Left, if the index exist and the move is possible.
//•	If movement is not possible, do nothing.
//•	"Move Right {index}":
//•	Moves the value at {index} position to the Right, if the index exists and the move is possible.
//•	If movement is not possible, do nothing.
//•	"Check Even":
//•	Print the elements at even index positions, separated by a single space.
//•	"Check Odd":
//•	Print the elements at odd index positions, separated by a single space.
//  After the "Done" command, the weapon name is considered correct and you should print the particles in their current order joined together in the following format: "You crafted {WeaponName}!"
