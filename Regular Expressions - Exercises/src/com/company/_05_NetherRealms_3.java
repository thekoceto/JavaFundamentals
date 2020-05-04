package com.company;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05_NetherRealms_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text=scan.nextLine();
        String[] sepparted = text.split(",");

        Pattern pattern=Pattern.compile("[^0-9+-.+-,*\\/]");
        Pattern pattern1=Pattern.compile("(\\-?[\\d+\\.]+)");
        Pattern pattern2=Pattern.compile("\\*");
        Pattern pattern3=Pattern.compile("[\\/]");

        TreeMap<String, Double[]> info = new TreeMap<>();

        for (String s : sepparted) {
            String demon = s.replaceAll(" ", "");
            Matcher matcher=pattern.matcher(demon);
            Matcher matcher1=pattern1.matcher(demon);
            Matcher matcher2=pattern2.matcher(demon);
            Matcher matcher3=pattern3.matcher(demon);

            double health=0.0;
            double damage=0.0;

            while (matcher.find()){
                health += matcher.group().charAt(0);
            }
            while (matcher1.find()){
                damage += Double.parseDouble(matcher1.group());
            }
            while (matcher2.find()){
                damage=damage*2;
            }
            while (matcher3.find()){
                damage=damage/2;
            }

            info.put(demon, new Double[]{health, damage});

        }
        info.forEach((key, value) -> System.out.printf("%s - %.0f health, %.2f damage%n",
                key, value[0], value[1]));

    }
}