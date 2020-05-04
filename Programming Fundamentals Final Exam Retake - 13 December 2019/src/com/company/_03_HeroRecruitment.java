package com.company;

import java.util.*;

public class _03_HeroRecruitment {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, List<String>> heroes = new TreeMap<>();
        String input = "";
        while (!"End".equals(input = console.nextLine())) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Enroll":
                    enroll(heroes, commands[1]);
                    break;
                case "Learn":
                    learn(heroes, commands[1], commands[2]);
                    break;
                case "Unlearn":
                    unlearn(heroes, commands[1], commands[2]);
                    break;
            }

        }
        System.out.println("Heroes:");
        heroes
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .forEach(e-> System.out.printf("== %s: %s%n",e.getKey(), String.join(", ", e.getValue())));
    }

    private static void enroll(Map<String, List<String>> heroes, String heroName) {
        if(!heroes.containsKey(heroName))
            heroes.put(heroName, new ArrayList<>());
        else
            System.out.printf("%s is already enrolled.%n", heroName);
    }
    private static void learn(Map<String, List<String>> heroes, String heroName, String spellName) {
        if (heroes.containsKey(heroName)){
            if(!heroes.get(heroName).contains(spellName))
                heroes.get(heroName).add(spellName);
            else
                System.out.printf("%s has already learnt %s.%n", heroName, spellName);
        }
        else
            System.out.printf("%s doesn't exist.%n", heroName);
    }

    private static void unlearn(Map<String, List<String>> heroes, String heroName, String spellName) {
        if (heroes.containsKey(heroName)){
            if(heroes.get(heroName).contains(spellName))
                heroes.get(heroName).remove(spellName);
            else
                System.out.printf("%s doesn't know %s.%n", heroName, spellName);
        }
        else
            System.out.printf("%s doesn't exist.%n", heroName);
    }
}
//"Unlearn {HeroName} {SpellName}":
//•	Remove the {SpellName} from the {HeroName}'s spellbook.
//•	If the {HeroName} doesn’t exist in the collection, print: "{HeroName} doesn't exist."
//•	If the {SpellName} doesn't exist in the hero's spellbook, print: "{HeroName} doesn't know {SpellName}."

//"Enroll {HeroName}":
//•	Adds the hero to your collection of heroes.
//•	If the hero is already present in your collection, print: "{HeroName} is already enrolled."
//"Learn {HeroName} {SpellName}":
//•	Adds the {SpellName} to the {HeroName}'s spellbook.
//•	If the {HeroName} doesn’t exist in the collection, print: "{HeroName} doesn't exist."
//•	If the hero already has the spell in his spellbook print: "{HeroName} has already learnt {SpellName}."

