package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_Orders_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] input = scanner.nextLine ().split (" ");
        LinkedHashMap<String, Double> mapProductsAndPrice = new LinkedHashMap<> ();
        LinkedHashMap<String, Integer> mapProductsAndQuantity = new LinkedHashMap<> ();

        while (input[0].equals ("buy")) {

            String productName = input[0];
            double price = Double.parseDouble (input[1]);
            int quantity = Integer.parseInt (input[2]);

            if (!mapProductsAndPrice.containsKey (productName)) {
                mapProductsAndPrice.put (productName, price);
                mapProductsAndQuantity.put (productName,quantity);
            }else{
                mapProductsAndPrice.put (productName,price);
                mapProductsAndQuantity.put (productName,mapProductsAndQuantity.get (productName)+quantity);
            }
        }
        for (Map.Entry<String, Integer> entry : mapProductsAndQuantity.entrySet ()) {
            double result = entry.getValue ()*mapProductsAndQuantity.get (entry.getKey ());
            System.out.printf ("%s -> %.2f%n",entry.getKey (),result);
        }
    }
}
