package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class _03_HeroesOfCodeAndLogicVII {
    public static class Pair {
        private int hit;
        private int mana;

        Pair() {
            this.hit = 0;
            this.mana = 0;
        }
        public int getHit() { return this.hit; }
        public int getMana() {
            return this.mana;
        }
        public void updateHit(int hit) {
            this.hit += hit;
        }
        public void updateMana(int mana) {
            this.mana += mana;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int steps = Integer.parseInt(console.nextLine());
        TreeMap<String,Pair> heroes  = new TreeMap<>(); // Map<car, Pair[HP (hit point) , MP (mana point)]>
        while (steps-- > 0) {
            String[] token = console.nextLine().split (" ");
            heroes.putIfAbsent (token[0], new Pair());
            heroes.get (token[0]).updateHit(Integer.parseInt (token[1]));
            heroes.get (token[0]).updateMana(Integer.parseInt (token[2]));
        }
        String input;
        while (!"End".equals(input = console.nextLine())) {
            String[] token = input.split(" - ");
            switch (token[0]) {
                case "CastSpell":
                    castspell(heroes, token[1], Integer.parseInt(token[2]), token[3]);
                    break;
                case "TakeDamage":
                    takedamage(heroes, token[1], Integer.parseInt(token[2]), token[3]);
                    break;
                case "Recharge":
                    recharge(heroes, token[1], Integer.parseInt(token[2]));
                    break;
                case "Heal":
                    heal(heroes, token[1], Integer.parseInt(token[2]));
                    break;

            }
        }
        heroes.entrySet()
                .stream()
                .sorted((h1, h2) -> h2.getValue().getHit() - h1.getValue().getHit())
                .forEach(h ->
                        System.out.printf("%s%n  HP: %d%n  MP: %d%n",
                                h.getKey(), h.getValue().getHit(), h.getValue().getMana()));
    }

    private static void castspell(TreeMap<String, Pair> heroes, String name, int manaPoint, String spellName) {
        if (heroes.get(name).getMana() >= manaPoint){
            heroes.get(name).updateMana(-manaPoint);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, heroes.get(name).getMana());
        }else
            System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);

    }

    private static void takedamage(TreeMap<String, Pair> heroes, String name, int damage, String attacker) {
        heroes.get(name).updateHit(-damage);
        if (heroes.get(name).getHit()>0)
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                    name, damage, attacker, heroes.get(name).getHit());
        else{
            heroes.remove(name);
            System.out.printf("%s has been killed by %s!%n", name, attacker);
        }
    }

    private static void recharge(TreeMap<String, Pair> heroes, String name, int amount) {
        int current = heroes.get(name).getMana();
        int recharged = current + amount > 200 ? 200 - current : amount;
        heroes.get(name).updateMana(recharged);
        System.out.printf("%s recharged for %d MP!%n", name, recharged);
    }

    private static void heal(TreeMap<String, Pair> heroes, String name, int amount) {
        int current = heroes.get(name).getHit();
        int healed = current + amount > 100 ? 100 - current : amount;
        heroes.get(name).updateHit(healed);
        System.out.printf("%s healed for %d HP!%n", name, healed);
    }
}
//CastSpell – {hero name} – {MP needed} – {spell name}
//•	If the hero has the required MP, he casts the spell, thus reducing his MP. Print this message:
//o	"{hero name} has successfully cast {spell name} and now has {mana points left} MP!"
//•	If the hero is unable to cast the spell print:
//o	"{hero name} does not have enough MP to cast {spell name}!"

//TakeDamage – {hero name} – {damage} – {attacker}
//•	Reduce the hero HP by the given damage amount. If the hero is still alive (his HP is greater than 0) print:
//o	"{hero name} was hit for {damage} HP by {attacker} and now has {current HP} HP left!"
//•	If the hero has died, remove him from your party and print:
//o	"{hero name} has been killed by {attacker}!"

//Recharge – {hero name} – {amount}
//•	The hero increases his MP. If a command is given that would bring the MP of the hero above 200,
// MP is increased so that it reaches the maximum. Print the following message:
//o	"{hero name} recharged for {amount recovered} MP!"

//Heal – {hero name} – {amount}
//•	The hero increases his HP. If a command is given that would bring the HP of the hero above 100,
// HP is increased so that it reaches the maximum. Print the following message:
//o	"{hero name} healed for {amount recovered} HP!"