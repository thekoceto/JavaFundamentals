package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class _03_WizardPoker {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        List<String> cards = Arrays.stream(console.nextLine().split(":"))
                .collect(Collectors.toList());
        List<String> deck = new ArrayList<> ();
        String input;

        while (!"Ready".equalsIgnoreCase(input = console.nextLine())){
            String[] command = input.split ("\\s+");
            switch (command[0]){
                case "Add":
                    if (cards.contains (command[1]))
                        deck.add (command[1]);
                    else
                        System.out.println ("Card not found.");
                    break;

                case "Insert":
                    if (cards.contains (command[1]) && Integer.parseInt (command[2]) >= 0 && Integer.parseInt (command[2]) < deck.size ()) {
                        deck.add (Integer.parseInt (command[2]), command[1]);
                    }else
                         System.out.println ("Error!");
                    break;

                case "Remove":
                    if (deck.contains(command[1]))
                        deck.remove(command[1]);
                    else
                        System.out.println ("Card not found.");
                    break;

                case "Swap":
                    Collections.swap (deck, deck.indexOf (command[1]), deck.indexOf (command[2]));
                    break;

                case "Shuffle":
                    Collections.reverse(deck);
                    break;
            }
        }

        System.out.println (String.join(" ", deck));
    }
}
//•	Add {card name}
//•	Adds the card to the end of the deck.
//•	If the card doesn't exist in print "Card not found."

//•	Insert {card name} {index}
//•	Insert the card at the given index of the deck.
//•	If the card doesn't exist or the index is invalid print "Error!"

//•	Remove {card name}
//•	Remove the card from the deck.
//•	If the card doesn't exist in print "Card not found."

//•	Swap {card name 1} {card name 2}
//•	Swap the positions of the cards
//•	Input will always be valid

//•	Shuffle deck
//•	Reverse the deck