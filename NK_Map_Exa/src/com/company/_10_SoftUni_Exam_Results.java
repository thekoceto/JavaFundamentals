package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _10_SoftUni_Exam_Results {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] input = scanner.nextLine ().split ("-");
        TreeMap<String, Integer> mapScore = new TreeMap<> ();
        TreeMap<String, Integer> mapCourses = new TreeMap<> ();

        while (!input[0].equals ("exam finished")) {

            String username = input[0];
            String language = input[1];


            if (!input[1].equals ("banned")) {

                int points = Integer.parseInt (input[2]);

                if (!mapScore.containsKey (username)) {
                    mapScore.put (username, points);
                } else {
                    if(mapScore.get (username)< points) {
                        mapScore.put (username, points);
                    }
                }
            } else {
                mapScore.remove (username);
                break;
            }
            if(!mapCourses.containsKey (language)){
                mapCourses.put (language,1);
            }else{
                mapCourses.put (language,mapCourses.get (language)+1);
            }
            input = scanner.nextLine ().split ("-");
        }
        System.out.println ("Results:");
        mapScore
                .entrySet ()
                .stream ()
                .sorted ((f,l)-> {
                   int result =  l.getValue ()-f.getValue ();
                   if(result==0){
                       result = f.getValue ().compareTo (l.getValue ());
                   }
                   return  result;
                })
                .forEach (e-> {
                    System.out.printf ("%s | %d%n",e.getKey (),e.getValue ());
                });
        System.out.println ("Submissions:");
        mapCourses
                .entrySet ()
                .stream ()
                .sorted ((f,l)->{
                    int result =  l.getValue ()-f.getValue ();
                    if(result==0){
                        result = f.getValue ().compareTo (l.getValue ());
                    }
                    return  result;
                })
                .forEach (e->{
                    System.out.printf ("%s - %d%n",e.getKey (),e.getValue ());
                });
    }
}
