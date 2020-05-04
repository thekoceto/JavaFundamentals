package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _10_LadyBugs_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeField = Integer.parseInt(scanner.nextLine());
        int[] ladybugsFeild  = new int [sizeField];

        String command = scanner.nextLine();

        int[] ladybugsIndex = Arrays.stream(command.split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        for (int value : ladybugsIndex) {
            if (value >= 0 && value < sizeField) {
                ladybugsFeild[value] = 1;
            }
        }

        while (true){
            command = scanner.nextLine();
            if (command.equals("end")) break;

            else{
                String[] currentCommand  = command.split(" ");

                int index = Integer.parseInt(currentCommand[0]);
                int jump = Integer.parseInt(currentCommand[2]);

                if ( index < 0 || index > sizeField-1 || ladybugsFeild[index] == 0 ){

                }
                else if (currentCommand[1].equals("right")) {
                    ladybugsFeild[index] = 0;
                    index += jump ;

                    if (index >= 0 && index < sizeField){
                        if (ladybugsFeild[index] == 1){
                            while (index < sizeField && ladybugsFeild[index] == 1){
                                index += jump;
                            }
                            if (index >= 0 && index < sizeField) ladybugsFeild[index] = 1;
                        }else{
                            ladybugsFeild[index] = 1;
                        }
                    }

                }else if (currentCommand[1].equals("left")){
                    ladybugsFeild[index] = 0;
                    index -= jump ;

                    if (index >= 0 && index < sizeField) {
                        if (ladybugsFeild[index] == 1) {
                            while (index >= 0 && ladybugsFeild[index] == 1){
                                index -= jump;
                            }
                            if (index >= 0 && index < sizeField) {
                                ladybugsFeild[index] = 1;
                            }
                        }else{
                            ladybugsFeild[index] = 1;
                        }
                    }

                }

            }
        }
        for (int i = 0; i < ladybugsFeild.length; i++) {
            System.out.print(ladybugsFeild[i]);
            System.out.print(i!=ladybugsFeild.length-1?" ":"");
        }
    }
}
