package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _3_PostOffice_2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = "sdsGGasAOTPWEEEdas$AOTP$";
        String regex = "([#$%*&])(?<capital>[A-Z]+)(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String asd = null;
        while (matcher.find())
            asd = matcher.group("capital");
        System.out.println(asd);
    }
}
